package com.retail.billing.service;

import com.retail.billing.discount.engine.DiscountStrategy;
import com.retail.billing.exception.BillingServiceException;
import com.retail.billing.model.CalculationModel;
import com.retail.billing.model.CustomerType;
import com.retail.billing.model.DiscountModel;
import com.retail.billing.model.entity.Customer;
import com.retail.billing.model.request.Goods;
import com.retail.billing.model.request.GoodsType;
import com.retail.billing.model.request.ReceiptReq;
import com.retail.billing.model.response.NetPayResponse;
import com.retail.billing.repository.CustomerRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BillingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BillingService.class);

    @Autowired
    private CustomerRespository customerRespository;

    @Autowired
    private Map<CustomerType, DiscountStrategy> strategyMap;

    public NetPayResponse calculateNetPay(ReceiptReq receiptReq) {
        try {

            Customer customer = customerRespository.findByCustomerId(receiptReq.getUserId());
            LOGGER.info("Customer Category => {}", customer.getCustomerCategory().getType());

            Map<GoodsType, BigDecimal> totalByCategory = receiptReq.getPuchasedGoods().stream()
                    .collect(Collectors.groupingBy(Goods::getType
                            , Collectors.mapping(Goods::getPrice,
                                    Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))));

            LOGGER.info("Value => {}", totalByCategory);
            BigDecimal nonGroceryTotal = totalByCategory.get(GoodsType.NG) == null ? BigDecimal.ZERO : totalByCategory.get(GoodsType.NG);
            BigDecimal groceryTotal = totalByCategory.get(GoodsType.G) == null ? BigDecimal.ZERO : totalByCategory.get(GoodsType.G);

            CalculationModel calculationModel = new CalculationModel(customer, nonGroceryTotal, groceryTotal);
            calculationModel.determineStrategy(strategyMap);
            DiscountModel discountModel = calculationModel.getDiscountStrategy().applyDiscount(calculationModel);

            return new NetPayResponse.Builder()
                    .totalNonGroceryAmt(discountModel.getNetAmt())
                    .totalGroceryAmt(groceryTotal)
                    .netPay(discountModel.getNetAmt().add(groceryTotal))
                    .billNo(receiptReq.getBillNo())
                    .appliedDiscount(discountModel.getAppliedDiscount().intValue())
                    .totalAmount(nonGroceryTotal.add(groceryTotal))
                    .build();
        } catch (Exception ex) {
            LOGGER.error("Error on Service {} => {}", ex.getMessage(), ex);
            throw new BillingServiceException(ex.getMessage(), ex);
        }

    }

}

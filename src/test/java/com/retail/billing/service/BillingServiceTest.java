package com.retail.billing.service;

import com.google.common.collect.Lists;
import com.retail.billing.BillingApplication;
import com.retail.billing.config.BaseTestConfig;
import com.retail.billing.model.entity.Customer;
import com.retail.billing.model.entity.CustomerCategory;
import com.retail.billing.model.request.Goods;
import com.retail.billing.model.request.GoodsType;
import com.retail.billing.model.request.ReceiptReq;
import com.retail.billing.model.response.NetPayResponse;
import com.retail.billing.repository.CustomerRespository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class BillingServiceTest extends BaseTestConfig{

    @MockBean
    private CustomerRespository customerRespository;

    @Autowired
    private BillingService billingService;

    @Test
    public void checkBillingService() {
        Mockito.when(customerRespository.findByCustomerId(Mockito.anyLong())).thenReturn(mockCustomer());
        NetPayResponse netPayResponse = billingService.calculateNetPay(buildReceiptReq());
        Mockito.verify(customerRespository, Mockito.times(1)).findByCustomerId(Mockito.anyLong());
        Assert.assertNotNull(netPayResponse);

    }

    private Customer mockCustomer() {
        CustomerCategory customerCategory = new CustomerCategory();
        customerCategory.setType("E");
        Customer customer = new Customer();
        customer.setCustomerId(1L);
        customer.setCustomerCategory(customerCategory);
        return customer;
    }

    private ReceiptReq buildReceiptReq() {
        ReceiptReq receiptReq = new ReceiptReq();
        receiptReq.setUserId(1L);
        receiptReq.setBillNo("BillNO");
        receiptReq.setPurchasedDate(LocalDateTime.now());
        receiptReq.setPuchasedGoods(buildGoods());
        return receiptReq;
    }

    private List<Goods> buildGoods() {
        Goods goods = new Goods();
        goods.setId("GOO1");
        goods.setName("GOOD");
        goods.setPrice(BigDecimal.TEN);
        goods.setType(GoodsType.NG);

        Goods goods1 = new Goods();
        goods1.setId("GOO2");
        goods1.setName("GOOD2");
        goods1.setPrice(BigDecimal.TEN);
        goods1.setType(GoodsType.G);

        return Lists.newArrayList(goods, goods1);
    }

}

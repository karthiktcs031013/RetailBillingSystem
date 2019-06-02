package com.retail.billing.controller;

import com.retail.billing.model.request.ReceiptReq;
import com.retail.billing.model.response.NetPayResponse;
import com.retail.billing.service.BillingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;

@RestController
@RequestMapping("/billing")
public class BillingController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BillingController.class);

	@Autowired
	private BillingService billingService;
	
	@GetMapping("/ping")
	public String ping() {
		return "Pong";
	}

	@PostMapping(value = "/netpay")
	public NetPayResponse processNetPay(@RequestBody @Valid  ReceiptReq receiptReq) {
		LOGGER.info("Started to process Net Pay Service");
		return billingService.calculateNetPay(receiptReq);
	}

}

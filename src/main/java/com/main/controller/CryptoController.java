package com.main.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.main.dto.OrderReq;
import com.main.dto.OrderResponse;
import com.main.service.CryptoService;

@Controller
public class CryptoController {
	
	
	public CryptoController(CryptoService cryptoRest) {
		super();
		this.cryptoRest = cryptoRest;
	}

	private CryptoService cryptoRest;
	
	@MessageMapping("/crypto")
	@SendTo("/topic/books")
	public OrderResponse CheckCrypto(OrderReq req) throws Exception {
		Thread.sleep(1000); // simulated delay
		OrderResponse orderBook= cryptoRest.getOrdersBook(req);
		return orderBook;
	}

}

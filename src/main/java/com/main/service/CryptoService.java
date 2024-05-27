package com.main.service;

import java.io.IOException;

import com.main.dto.OrderReq;
import com.main.dto.OrderResponse;

public interface CryptoService {

	 public OrderResponse getOrdersBook(OrderReq req)throws IOException, InterruptedException;
}

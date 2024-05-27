package com.main.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.main.dto.OrderBook;
import com.main.dto.OrderReq;
import com.main.dto.OrderResponse;

@Service
public class CryptoServiceImpl implements CryptoService {

	private static final Map<String, Double> previousVolumes = new HashMap<>();
	private static final Map<String, Double> currentVolumes = new HashMap<>();

	private static final String BASE_URL = "https://api.binance.com";

	public OrderResponse getOrdersBook(OrderReq req) throws IOException, InterruptedException {
		String endpoint = String.format("/api/v3/depth?symbol=%s&limit=%d", req.getSymbol(), req.getLimit());
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(BASE_URL + endpoint)).GET().build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		Gson gson = new Gson();

		OrderBook orderB = gson.fromJson(response.body(), OrderBook.class);
		double volume = calculateVolume(orderB);
		currentVolumes.put(req.getSymbol(), volume);
		double changeVolume = calculateVolumeChanges(req.getSymbol());

		return new OrderResponse(req.getSymbol(), volume, changeVolume);
	}

	private double calculateVolume(OrderBook orderBook) {
		double volume = 0.0;
		for (List<String> bid : orderBook.getBids()) {
			double price = Double.parseDouble(bid.get(0));
			double quantity = Double.parseDouble(bid.get(1));
			volume += price * quantity;
		}
		for (List<String> ask : orderBook.getAsks()) {
			double price = Double.parseDouble(ask.get(0));
			double quantity = Double.parseDouble(ask.get(1));
			volume += price * quantity;
		}
		return volume;
	}

	private double calculateVolumeChanges(String symbol) {
		double previousVolume = previousVolumes.getOrDefault(symbol, 0.0);
		double currentVolume = currentVolumes.get(symbol);
		double volumeChange = currentVolume - previousVolume;

		previousVolumes.put(symbol, currentVolume);
		return volumeChange;
	}

}

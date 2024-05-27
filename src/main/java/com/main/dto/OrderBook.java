package com.main.dto;

import java.util.List;

public class OrderBook {

	private long lastUpdateId;
	private List<List<String>> bids;
	private List<List<String>> asks;

	public OrderBook(long lastUpdateId, List<List<String>> bids, List<List<String>> asks) {
		super();
		this.lastUpdateId = lastUpdateId;
		this.bids = bids;
		this.asks = asks;
	}

	public long getLastUpdateId() {
		return lastUpdateId;
	}

	public void setLastUpdateId(long lastUpdateId) {
		this.lastUpdateId = lastUpdateId;
	}

	public List<List<String>> getBids() {
		return bids;
	}

	public void setBids(List<List<String>> bids) {
		this.bids = bids;
	}

	public List<List<String>> getAsks() {
		return asks;
	}

	public void setAsks(List<List<String>> asks) {
		this.asks = asks;
	}

}

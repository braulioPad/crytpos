package com.main.dto;

public class OrderResponse {
	
	
	public OrderResponse(String symbol, double volumeChange, double volume) {
		super();
		this.symbol = symbol;
		this.volumeChange = volumeChange;
		this.volume = volume;
	}

	private String symbol;
	
	private double volumeChange;

	private double volume;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public double getVolumeChange() {
		return volumeChange;
	}

	public void setVolumeChange(double volumeChange) {
		this.volumeChange = volumeChange;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}
	
}

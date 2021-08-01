package com.murat.read.model;

public class CustomerMonthlyStatistics {
	
	private String month;
	
	private int totalOrderCount;
	
	private int totalBookCount;
	
	private double totalPurchased;

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getTotalOrderCount() {
		return totalOrderCount;
	}

	public void setTotalOrderCount(int totalOrderCount) {
		this.totalOrderCount = totalOrderCount;
	}

	public int getTotalBookCount() {
		return totalBookCount;
	}

	public void setTotalBookCount(int totalBookCount) {
		this.totalBookCount = totalBookCount;
	}

	public double getTotalPurchased() {
		return totalPurchased;
	}

	public void setTotalPurchased(double totalPurchased) {
		this.totalPurchased = totalPurchased;
	}
	
	

}

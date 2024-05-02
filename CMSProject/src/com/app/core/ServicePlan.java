package com.app.core;

public enum ServicePlan {
	/*
	 * 2. ServicePlans n their charges -//enum SILVER : 1000 GOLD : 2000 DIAMOND
	 * :5000 PLATINUM : 10000
	 */
	SILVER(1000), GOLD(2000), DIAMOND(5000), PLATINUM(10000);

	private double planCost;

	private ServicePlan(double cost) {
		this.planCost = cost;
	}

	public double getPlanCost() {
		return planCost;
	}
}

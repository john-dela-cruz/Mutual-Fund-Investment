package controller;

import utility.Helper;

public class MutualFundInvestment {

	public static void main(String[] args) {
		
		String fundType = Helper.readString("Mutual Fund Type");
		double investmentAmount = Helper.readDouble("Investment Amount");
		
		double salesLoad = computeSalesLoad(investmentAmount);
		double netInvestment = computeNetInvested(investmentAmount,salesLoad);
		double sharesBought = computeSharesBought(fundType, netInvestment);
		
		///////display output to user
		
		System.out.println("Investment Fund Type is " + determineFormalName(fundType));
		System.out.println("Amount invested is Php" + investmentAmount);
		System.out.println("NAVPS: " + determineNAVPS(fundType) + "(as of September 23, 2021)");
		System.out.println("Sales Load Amount: Php" + salesLoad);
		System.out.println("Net Amount Invested: Php" + netInvestment);
		System.out.println("Total Shares Bought: " + sharesBought);
		
	}
	
	public static double computeSalesLoad(double amount){
		
		double salesLoad = 0;
		
		if (amount < 1000){
			System.out.println("Enter at least Php 1000.00");
			System.exit(1);
		} else if (amount >= 1000 && amount <= 99999.99){
			salesLoad = amount * 0.02;
		} else if (amount >= 100000 && amount <= 499999.99){
			salesLoad = amount * 0.015;
		} else if (amount >= 500000 && amount <= 1999999.99){
			salesLoad = amount * 0.01;
		} else {
			salesLoad = amount * 0.005;
		}
		
		return salesLoad;
	}
	
	public static double computeNetInvested(double amount, double salesLoad){
		
		double netInvested = 0;
		
		netInvested = amount - salesLoad;
		
		return netInvested;
	}
	
	public static double computeSharesBought(String fundType, double netInvested){
		
		fundType = fundType.toUpperCase();
		double sharesBought = 0;
		
		if (fundType.equals("SALEF")){
			sharesBought = netInvested / 5.0152;
		} else if (fundType.equals("SALBF")){
			sharesBought = netInvested / 2.6402;
		} else if (fundType.equals("SALFIF")){
			sharesBought = netInvested / 2.4396;
		} else {
			System.out.println("The Fund Type you entered was not found.");
			System.exit(1);
		}
		
		return sharesBought;
	}
	
	public static String determineFormalName(String fundType){
		String fundName = null;
		
		switch (fundType.toUpperCase()){
			case "SALEF":
				fundName = "Save and Learn Equity Fund";
				break;
			case "SALBF":
				fundName = "Save and Learn Balanced Fund";
				break;
			case "SALFIF":
				fundName = "Save and Learn Fixed Income Fund";
				break;
		}
		
		return fundName;
	}
	
	public static String determineNAVPS(String fundType){
		String navps = null;
		
		switch (fundType.toUpperCase()){
			case "SALEF":
				navps = "Php 5.0152";
				break;
			case "SALBF":
				navps = "Php 2.6402";
				break;
			case "SALFIF":
				navps = "Php 2.4396";
				break;
		}
		
		return navps;
		
	}

}

package com.ontarget.util;

import java.text.DecimalFormat;

public class CalculatePercentageComplete {

	public static int calculate(double x, int n) {
		
		int calc = (int) x / n;
		return calc;
	}

	public static double roundTwoDecimals(double d) {
		DecimalFormat twoDForm = new DecimalFormat("#.##");
		return Double.valueOf(twoDForm.format(d));
	}
	
	public static void main(String args[]){
		double x = 500;
		int n = 30;
		int calc = CalculatePercentageComplete.calculate(x, n);
		System.out.println("calc: "+calc);
	}
}

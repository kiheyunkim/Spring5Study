package com.test.kim;

public class MaxNumberImp implements MaxNumber {

	@Override
	public double max(double a, double b) {	
		return a > b ? a : b;
	}

}

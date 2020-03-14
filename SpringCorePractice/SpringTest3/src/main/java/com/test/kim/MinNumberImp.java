package com.test.kim;

public class MinNumberImp implements MinNumber{

	@Override
	public double min(double a, double b) {
		return a < b ? a : b;
	}

}

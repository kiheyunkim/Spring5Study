package com.test.kim;

public class CounterImp implements Counter{

	private int count;
	
	@Override
	public void Increase() {
		// TODO Auto-generated method stub
		++count;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return this.count;
	}

}

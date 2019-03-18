package com.threads.callpools;

import java.util.concurrent.Callable;

public class Producer implements Callable<Integer> {

	private Stack s;

	public Producer(Stack s) {
		// TODO Auto-generated constructor stub
		this.s = s;
	}

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i = 0; i < 20; i++) {
			int rand = (int) (Math.random() * 100);
			s.push(rand);
			sum+=rand;
		}
		
		if(sum%2 !=0)
			throw new NumberFormatException("Prod excpetion not zugi");
		return sum;
	}

}

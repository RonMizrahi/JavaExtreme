package com.threads.callpools;

import java.util.concurrent.Callable;

public class Consumer implements Callable<Integer> {

	private Stack s;

	public Consumer(Stack s) {
		// TODO Auto-generated constructor stub
		this.s = s;
	}

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i = 0; i < 20; i++) {
			try {
				sum += s.pop();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(sum%2 !=0)
			throw new NumberFormatException("Cons excpetion not zugi");
		return sum;
	}

}

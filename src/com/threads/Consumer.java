package com.threads;

public class Consumer extends Thread {

	private Stack s;


	public Consumer(Stack s) {
		// TODO Auto-generated constructor stub
		this.s=s;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			for(int i=0;i<20;i++)
			{
				try {
					s.pop();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}


}

package com.threads;

public class Producer  extends Thread{

	private Stack s;


	public Producer(Stack s) {
		// TODO Auto-generated constructor stub
		this.s=s;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			for(int i=0;i<20;i++)
			{
				s.push((int)(Math.random()*100));
			}
		}
	}

}

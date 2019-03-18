package com.threads.waitnotify;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack s= new Stack();
		
		for(int i=0; i<5;i++)
		{
			new Producer(s).start();
			new Consumer(s).start();
		}
		
		
	}

}

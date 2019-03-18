package com.threads.callpools;

import java.util.LinkedList;

public class Stack {

	private LinkedList<Integer> stack;
	
	public Stack()
	{
		this.stack = new LinkedList<>();
	}
	
	
	public synchronized void push(int i)
	{
		System.out.println("pushed "+i);
		stack.push(i);
		notify();
	}
	
	public synchronized int pop() throws InterruptedException
	{
		while(stack.size()==0)
			wait();
		int i= stack.pop();
		System.out.println("pop "+i);
		return i;
	}
}

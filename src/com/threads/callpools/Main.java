package com.threads.callpools;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collection<Callable<Integer>> col = new HashSet<Callable<Integer>>();
		ExecutorService executor = Executors.newCachedThreadPool();

		Stack s = new Stack();
		for (int i = 0; i < 5; i++) {
			col.add(new Consumer(s));
			col.add(new Producer(s));
		}

		try {
			List<Future<Integer>> requests = executor.invokeAll(col);
			for (Future<Integer> f : requests) {
				try {
					System.out.println(f.get());
				} catch (ExecutionException e) {
					System.out.println(e.getMessage());
				}
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		executor.shutdown();
	}

}

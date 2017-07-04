package com.jetair.mq.producer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public interface ProducerService {
	
	public final ExecutorService pushExecutor=Executors.newFixedThreadPool(10);
	
	public void push(Object info);
}

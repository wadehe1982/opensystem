package com.xxx.opensys.service;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import com.xxx.opensys.model.PrintTask;

//@Service
public class AsyncService {
	
	/**
	 * >By default, a {@link org.springframework.core.task.SimpleAsyncTaskExecutor
     *  SimpleAsyncTaskExecutor} will be used to process async method invocations.
	 */
//	@Autowired
//	private ThreadPoolTaskExecutor threadPool;
	
//	@Qualifier("mySecondThreadPoolExecutor")
//	@Autowired
	private ExecutorService executorService;
	
	private static ThreadLocal<Date> threadLocal = new ThreadLocal<Date>();
	
//	@Async(value="myThreadPoolTaskExecutor")
	public Future<String> asyncTest1(Date date){
		
//		threadPool.submit(task)
		System.out.println("asyncTest1 ...");
		System.out.println("Thread group name:" + Thread.currentThread().getThreadGroup());
		threadLocal.set(date);
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(threadLocal.get());
		System.out.println("Thread" + Thread.currentThread().getName() + " was executed!");
		return new AsyncResult<String>("test");
	}
	
	public Future<String> asyncTest2(){
		Future<String> result = executorService.submit(new PrintTask());
		return result;
	}

}

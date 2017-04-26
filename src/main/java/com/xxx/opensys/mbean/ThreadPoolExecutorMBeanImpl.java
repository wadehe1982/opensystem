package com.xxx.opensys.mbean;

import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@ManagedResource(objectName="ThreadPoolExecutorMBean", description="test ThreadPoolExecutorMBean")
public class ThreadPoolExecutorMBeanImpl implements ThreadPoolExecutorMBean {

	@Autowired
	@Qualifier(value="mySecondThreadPoolExecutor")
	private ThreadPoolExecutor executor;

	@ManagedOperation(description="The TotalWorker")  
	public int getTotalWorker() {
		return executor.getPoolSize();
	}
	@ManagedOperation(description="The ActiveWorker")
	public int getActiveWorker() {
		return executor.getActiveCount();
	}
	@ManagedOperation(description="The CompletedTaskCount")
	public long getCompletedTaskCount() {
		return executor.getCompletedTaskCount();
	}
	@ManagedOperation(description="The QueueSize")
	public int getQueueSize() {
		return executor.getQueue().size();
	}

}

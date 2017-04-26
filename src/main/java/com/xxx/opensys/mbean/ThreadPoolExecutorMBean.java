package com.xxx.opensys.mbean;

public interface ThreadPoolExecutorMBean {

	int getTotalWorker();

	int getActiveWorker();

	long getCompletedTaskCount();

	int getQueueSize();

}

package com.xxx.opensys.model;

import java.util.concurrent.Callable;

public class PrintTask implements Callable<String> {

	public String call() throws Exception {
		
		try {
			Thread.sleep(10 * 1000);
		} catch (Exception e) {
		}
		return "xxx";
	}

}

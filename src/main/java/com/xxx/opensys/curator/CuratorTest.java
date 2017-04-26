package com.xxx.opensys.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.GetDataBuilder;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

public class CuratorTest {

	public static void main(String[] args) {

		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
		CuratorFramework newClient = CuratorFrameworkFactory.builder().connectString("localhost:2181")
				.retryPolicy(retryPolicy).build();
		newClient.start();
		
		createNode(newClient, "/lock/sub", CreateMode.EPHEMERAL_SEQUENTIAL, "vid_01");
		GetDataBuilder data = newClient.getData();
		try {
			System.out.println(data.forPath("/lock"));
			newClient.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void createNode(CuratorFramework newClient, String path, CreateMode createMode, String data) {
		try {
			newClient.create().withMode(createMode).forPath(path, data.getBytes());
		} catch (Exception e) {
			System.out.println("创建节点失败, elog=" + e.getMessage());
		}
	}
	public static String getData(CuratorFramework newClient, String path){
	    try {
	        return new String(newClient.getData().forPath(path));
	    } catch (Exception e) {
	        System.out.println("获取数据失败, elog=" + e.getMessage());
	    }
	    return null;
	}

}

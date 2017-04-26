package com.xxx.opensys.repository;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReplicationDataSourceRouterProxy extends LazyConnectionDataSourceProxy implements Closeable{
	
	private DataSource writeDataSource;
	private DataSource readDataSource;
	
	private void doClose(DataSource dataSource) {
		if (dataSource instanceof Closeable) {
			try {
				((Closeable) dataSource).close();
			} catch (IOException e) {
				log.warn("can not close dataSource." , e);
			}
		}
	}

	public void close() throws IOException {
		doClose(writeDataSource);
		doClose(readDataSource);
	}

	public ReplicationDataSourceRouterProxy(DataSource writeDataSource, DataSource readDataSource) {
		super();
		this.writeDataSource = writeDataSource;
		this.readDataSource = readDataSource;
		
		CustomRoutingDataSource routingDataSource = new CustomRoutingDataSource();
		Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
		Boolean write = Boolean.FALSE;
		targetDataSources.put(write, writeDataSource);
		Boolean read = Boolean.TRUE;
		targetDataSources.put(read, readDataSource);
		
		routingDataSource.setTargetDataSources(targetDataSources);
		routingDataSource.setDefaultTargetDataSource(writeDataSource);
		routingDataSource.afterPropertiesSet();
		setTargetDataSource(routingDataSource);
	}
	
}

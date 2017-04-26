package com.xxx.opensys.repository;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class CustomRoutingDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		return TransactionSynchronizationManager.isCurrentTransactionReadOnly();
	}

}

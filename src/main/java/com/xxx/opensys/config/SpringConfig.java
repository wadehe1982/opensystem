package com.xxx.opensys.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.xxx.opensys", entityManagerFactoryRef = "localContainerEntityManagerFactoryBean", transactionManagerRef = "annotationDrivenTransactionManager")
public class SpringConfig {

	// Hikari Data Source
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:mysql://localhost:3306/test");
		config.setUsername("root");
		config.setPassword("");
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		config.setDriverClassName("com.mysql.jdbc.Driver");
		return new HikariDataSource(config);
	}

	// Hibernate JPA vendor config
	@Bean
	public HibernateJpaVendorAdapter hibernateJpaVendorAdapter() {

		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(true);
		return hibernateJpaVendorAdapter;
	}

	// use spring container manage entityManager
	@Bean
	public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {

		LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		localContainerEntityManagerFactoryBean.setDataSource(dataSource());
		localContainerEntityManagerFactoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter());
		localContainerEntityManagerFactoryBean.setPackagesToScan("com.xxx.opensys.entity");
		localContainerEntityManagerFactoryBean.setPersistenceUnitName("open-system");

		Properties jpaProperties = new Properties();
		jpaProperties.setProperty("hibernate.cache.use_second_level_cache", "true");
		jpaProperties.setProperty("hibernate.cache.region.factory_class",
				"org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory");
		jpaProperties.setProperty("hibernate.cache.use_query_cache", "true");
		jpaProperties.setProperty("hibernate.generate_statistics", "true");
		jpaProperties.setProperty("javax.persistence.sharedCache.mode", "ENABLE_SELECTIVE");

		localContainerEntityManagerFactoryBean.setJpaProperties(jpaProperties);
		// localContainerEntityManagerFactoryBean.setSharedCacheMode(SharedCacheMode.ENABLE_SELECTIVE);
		return localContainerEntityManagerFactoryBean;
	}

	// configure JpaTransactionManager
	// @Bean
	// public JpaTransactionManager jpaTransactionManager(){
	// JpaTransactionManager jpaTransactionManager = new
	// JpaTransactionManager();
	// jpaTransactionManager.setDataSource(dataSource());
	// return jpaTransactionManager;
	// }
	@Bean
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setDataSource(dataSource());
		return jpaTransactionManager;
	}

	// @Bean
	// public EhCacheManagerFactoryBean ehCacheManagerFactoryBean(){
	//
	// EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new
	// EhCacheManagerFactoryBean();
	// }

}

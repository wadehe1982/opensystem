package com.xxx.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

import javax.management.MBeanServer;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.jmx.export.annotation.AnnotationJmxAttributeSource;
import org.springframework.jmx.export.assembler.MetadataMBeanInfoAssembler;
import org.springframework.jmx.export.naming.MetadataNamingStrategy;
import org.springframework.jmx.support.MBeanServerFactoryBean;
import org.springframework.jmx.support.RegistrationPolicy;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolExecutorFactoryBean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.google.common.collect.Maps;
import com.xxx.opensys.dto.UserDTO;
import com.xxx.opensys.entity.EntityClass;
import com.xxx.opensys.mbean.ThreadPoolExecutorMBeanImpl;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
/**
 * >By default, a {@link org.springframework.core.task.SimpleAsyncTaskExecutor
 * SimpleAsyncTaskExecutor} will be used to process async method invocations.
 *
 */
//@EnableAsync
@EnableTransactionManagement
@EnableJpaRepositories(basePackages="com.xxx.opensys",entityManagerFactoryRef = "localContainerEntityManagerFactoryBean", transactionManagerRef = "myJpaTM")
//@Import({RedisConfig.class,JmxConfig.class})
//@Import({RedisConfig.class})
public class SpringConfig {

	// Hikari Data Source: treat as master
	@Bean(destroyMethod = "close")
	public DataSource dataSourceMaster() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:mysql://localhost:3306/test");
		config.setUsername("root");
		config.setPassword("root");
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		config.setDriverClassName("com.mysql.jdbc.Driver");
		config.setRegisterMbeans(true);
		return new HikariDataSource(config);
	}

//	@Bean(destroyMethod = "close")
//	public DataSource dataSourceSlave() {
//		HikariConfig config = new HikariConfig();
//		config.setJdbcUrl("jdbc:mysql://localhost:3306/slave");
//		config.setUsername("root");
//		config.setPassword("root");
//		config.addDataSourceProperty("cachePrepStmts", "true");
//		config.addDataSourceProperty("prepStmtCacheSize", "250");
//		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
//		config.setDriverClassName("com.mysql.jdbc.Driver");
//		return new HikariDataSource(config);
//	}
	
//	@Bean(destroyMethod = "close")
//	public ReplicationDataSourceRouterProxy replicationDataSourceRouterProxy(){
//		ReplicationDataSourceRouterProxy dataSourceRouterProxy = new ReplicationDataSourceRouterProxy(dataSourceMaster(), dataSourceSlave());
//		return dataSourceRouterProxy;
//	}
	
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
		localContainerEntityManagerFactoryBean.setDataSource(dataSourceMaster());
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
//	 @Bean
//	 public JpaTransactionManager jpaTransactionManager(){
//	 JpaTransactionManager jpaTransactionManager = new
//	 JpaTransactionManager();
//	 jpaTransactionManager.setDataSource(dataSourceMaster());
//	 return jpaTransactionManager;
//	 }
	@Bean(name="myJpaTM")
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setDataSource(dataSourceMaster());
		return jpaTransactionManager;
	}
	
//	@Bean()
//	public ThreadPoolTaskExecutor threadPoolTaskExecutor(){
//		ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
//		threadPool.setMaxPoolSize(3);
//		threadPool.setCorePoolSize(2);
//		threadPool.setQueueCapacity(2);
//		threadPool.initialize();
//		return threadPool;
//	}
	
//	@Bean()
//	public ExecutorService threadPoolExecutor(){
//		ThreadPoolExecutorFactoryBean threadPoolExecutorFactoryBean = new ThreadPoolExecutorFactoryBean();
//		threadPoolExecutorFactoryBean.setMaxPoolSize(5);
//		threadPoolExecutorFactoryBean.setCorePoolSize(2);
//		threadPoolExecutorFactoryBean.setQueueCapacity(2);
//		threadPoolExecutorFactoryBean.initialize();
//		return threadPoolExecutorFactoryBean.getObject();
//	}

	// @Bean
	// public EhCacheManagerFactoryBean ehCacheManagerFactoryBean(){
	//
	// EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new
	// EhCacheManagerFactoryBean();
	// }
	
	@Bean
//	@Conditional(value = { CustomCondition.class})
	public UserDTO testTemplate(){
		
		System.out.println("create testTemplate......");
		return new UserDTO();
	}
	


}

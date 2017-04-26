package com.xxx.config;

import java.util.Map;

import javax.management.MBeanServer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.jmx.export.annotation.AnnotationJmxAttributeSource;
import org.springframework.jmx.export.assembler.MetadataMBeanInfoAssembler;
import org.springframework.jmx.export.naming.MetadataNamingStrategy;
import org.springframework.jmx.support.MBeanServerFactoryBean;
import org.springframework.jmx.support.RegistrationPolicy;

import com.google.common.collect.Maps;
import com.xxx.opensys.mbean.ThreadPoolExecutorMBeanImpl;

//@Configuration
public class JmxConfig {
	
	@Bean
	public MBeanServer mBeanServerFactoryBean() {
		MBeanServerFactoryBean mBeanServerFactoryBean = new MBeanServerFactoryBean();
		return mBeanServerFactoryBean.getObject();
	}

	@Bean
	public ThreadPoolExecutorMBeanImpl threadPoolExecutorMBeanImpl() {
		return new ThreadPoolExecutorMBeanImpl();
	}

	@Bean
	public MBeanExporter mBeanExporter() {
		MBeanExporter mBeanExporter = new MBeanExporter();
		mBeanExporter.setServer(mBeanServerFactoryBean());
		Map<String, Object> beans = Maps.newHashMap();
		beans.put("myThreadPool", threadPoolExecutorMBeanImpl());
		mBeanExporter.setBeans(beans);
		mBeanExporter.setAssembler(metadataMBeanInfoAssembler());
		mBeanExporter.setNamingStrategy(metadataNamingStrategy());
		mBeanExporter.setAutodetect(true);
		mBeanExporter.setRegistrationPolicy(RegistrationPolicy.REPLACE_EXISTING);

		return mBeanExporter;
	}

	@Bean
	public AnnotationJmxAttributeSource annotationJmxAttributeSource() {
		return new AnnotationJmxAttributeSource();
	}

	@Bean
	public MetadataMBeanInfoAssembler metadataMBeanInfoAssembler() {
		MetadataMBeanInfoAssembler metadataMBeanInfoAssembler = new MetadataMBeanInfoAssembler();
		metadataMBeanInfoAssembler.setAttributeSource(annotationJmxAttributeSource());
		return metadataMBeanInfoAssembler;
	}

	@Bean
	public MetadataNamingStrategy metadataNamingStrategy() {
		MetadataNamingStrategy metadataNamingStrategy = new MetadataNamingStrategy();
		metadataNamingStrategy.setAttributeSource(annotationJmxAttributeSource());
		return metadataNamingStrategy;
	}

}

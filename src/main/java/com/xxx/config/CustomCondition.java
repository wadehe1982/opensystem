package com.xxx.config;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class CustomCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		System.out.println("xxxxx.........");
		if (context.getBeanFactory().containsBean("javax.sql.DataSource")){
			return true;
		}
		return false;
	}

}

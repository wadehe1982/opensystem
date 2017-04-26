package com.xxx.config;

import java.util.List;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Lists;

@Configuration
@EnableCaching
public class CacheConfig implements CachingConfigurer {

	@Bean
	public CacheManager cacheManager() {
		SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
		List<Cache> caches = Lists.newArrayList();
		Cache cache = new ConcurrentMapCache("myCache");
		caches.add(cache);
		simpleCacheManager.setCaches(caches);
//		System.out.println("xxxx");
		
		return simpleCacheManager;
	}

	public CacheResolver cacheResolver() {
		return null;
	}

	public CacheErrorHandler errorHandler() {
		return null;
	}

	@Bean
	public KeyGenerator keyGenerator() {
		return new SimpleKeyGenerator();
	}

}

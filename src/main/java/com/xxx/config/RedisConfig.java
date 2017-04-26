package com.xxx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {
	
	// Jedis ConnectionFactory
//	@Bean
//	public JedisConnectionFactory jedisConnectionFactory() {
//		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
//		jedisConnectionFactory.setHostName("127.0.0.1");
//		jedisConnectionFactory.setPort(6793);
//		return jedisConnectionFactory;
//	}

	/*
	 
	 * 
	 * public LettuceConnectionFactory lettuceConnectionFactory() {
	 * 
	 * LettuceConnectionFactory lettuceConnectionFactory = new
	 * LettuceConnectionFactory(); lettuceConnectionFactory.setHostName("");
	 * lettuceConnectionFactory.setPort(80); return lettuceConnectionFactory; }
	 * /**
	 * 
	 * RedisSentinelConfiguration can also be defined via PropertySource.
	 * 
	 * Configuration Properties spring.redis.sentinel.master: name of the master
	 * node.
	 * 
	 * spring.redis.sentinel.nodes: Comma delimited list of host:port pairs.
	 */

	/**
	 * jedis
	 */
//	@Bean
//	public RedisConnectionFactory jedisConnectionFactory() {
////		RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration();
////		sentinelConfig.setMaster("mymaster");
////		RedisNode node1 = new RedisNode("127.0.0.1", 26379);
////		RedisNode node2 = new RedisNode("127.0.0.1", 26380);
////		sentinelConfig.setSentinels(ImmutableList.of(node1, node2));
////		JedisConnectionFactory factory = new JedisConnectionFactory(sentinelConfig);
////		return factory;
//		RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration().master("mymaster")
//				  .sentinel("localhost", 6379).sentinel("localhost", 6380);
//		return new JedisConnectionFactory(sentinelConfig);
//	}
	
/*
	
	@Bean(destroyMethod="destroy")
	public RedisConnectionFactory jedisConnectionFactory() {
		System.out.println("----------jedisConnectionFactory------------");
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
		jedisConnectionFactory.setHostName("127.0.0.1");
		jedisConnectionFactory.setPort(6379);
		jedisConnectionFactory.setPoolConfig(jedisPoolConfig());
		return jedisConnectionFactory;
	}
	
	private JedisPoolConfig jedisPoolConfig(){
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxTotal(10);
		jedisPoolConfig.setMaxIdle(5);
		jedisPoolConfig.setMinIdle(2);
		jedisPoolConfig.setMaxWaitMillis(3*1000);
		jedisPoolConfig.setTestOnBorrow(true);
		return jedisPoolConfig;
	}
	*/

	/**
	 * lettuce
	 */
//	@Bean
//	public RedisConnectionFactory lettuceConnectionFactory() {
//		RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration().master("mymaster")
//				.sentinel("127.0.0.1", 26379).sentinel("127.0.0.1", 26380);
//		return new LettuceConnectionFactory(sentinelConfig);
//	}
	/*
	@Bean
	public RedisTemplate<String, String> redisTemplate(){
		RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
		System.out.println("----------redisTemplate------------");
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}
	
	@Bean
	public RedisTemplate<String, Object> redisObjectTemplate(){
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
		System.out.println("----------redisObjectTemplate------------");
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}
	*/
}

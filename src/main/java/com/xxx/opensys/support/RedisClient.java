package com.xxx.opensys.support;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

//@Component
public class RedisClient {

//	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
//	@Autowired  
	private RedisTemplate<String, Object> redisObjectTemplate;
	
	public void save(String key, String value){
		ValueOperations<String, String> ops = redisTemplate.opsForValue();

		ops.set(key, value);
	}
	
	public String get(String key){
		ValueOperations<String, String> ops = redisTemplate.opsForValue();
		String value = ops.get(key);
		return value;
	}
	
	public void saveObject(String key, Object value){
		ValueOperations<String, Object> ops = redisObjectTemplate.opsForValue();

		ops.set(key, value);
	}
	
	public Object getObject(String key){
		ValueOperations<String, Object> ops = redisObjectTemplate.opsForValue();
		Object value = ops.get(key);
		return value;
	}
	
	public void saveList(String key, List<String> value){
		ListOperations<String, String> ops = redisTemplate.opsForList();

		for(String s : value){
			ops.leftPush(key, s);
		}
	}
	
	public Object getList(String key){
		ListOperations<String, String> ops = redisTemplate.opsForList();
		List<String> dataList = Lists.newArrayList();
		long size = ops.size(key);
		for(int i = 0; i < size; i ++){
			dataList.add(ops.index(key, i));
		}
		return dataList;
	}
	
	public void saveSet(String key, Set<String> value){
		SetOperations<String, String> ops = redisTemplate.opsForSet();

		for(String s : value){
			ops.add(key, s);
		}
	}
	
	public Object getSet(String key){
		SetOperations<String, String> ops = redisTemplate.opsForSet();
		Set<String> dataList = Sets.newHashSet();
		long size = ops.size(key);
		for(int i = 0; i < size; i ++){
			dataList.add(ops.pop(key));
		}
		return dataList;
	}
}

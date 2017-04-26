package com.xxx.opensys.cache;

import com.google.common.cache.CacheLoader;
import com.xxx.opensys.dto.UserDTO;

public class UserCacheLoader extends CacheLoader<String, UserDTO>{

	@Override
	public UserDTO load(String key) throws Exception {
		return null;
	}

}

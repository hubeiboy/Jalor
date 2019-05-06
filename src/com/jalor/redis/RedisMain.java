package com.jalor.redis;

import redis.clients.jedis.Jedis;

public class RedisMain {

	public static Jedis redis() {
		// Jedis jedis = new Jedis("192.168.100.205", 6379);
		return new Jedis("192.168.100.205", 6379);
	}
}

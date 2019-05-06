package com.jalor.redis;

import java.util.List;

import redis.clients.jedis.Jedis;

public class GetList {

	public static void main(String[] args) {
		// Jedis jedis = new Jedis("192.168.100.205", 6379);
		Jedis jedis = RedisMain.redis();
		String key = "userList";
		byte[] in = jedis.get(key.getBytes());
		List<User> list = SerializeUtil.unserializeForList(in);

		for (User user : list) {
			System.out.println("ÓÃ»§Ãû£º" + user.getUserName() + "\t" + user.getAddress());
		}

	}
}

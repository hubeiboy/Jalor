package com.jalor.redis;

import redis.clients.jedis.Jedis;

public class GetObject {

	public static void main(String[] args) {

		Jedis jedis = RedisMain.redis();
		String keyObj = "userObj";
		byte[] in = jedis.get(keyObj.getBytes());
		User user = (User) SerializeUtil.unserialize(in);
		System.out.println(user.getUserName() + "\t" + user.getAddress());

	}

}

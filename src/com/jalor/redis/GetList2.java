package com.jalor.redis;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.Jedis;

public class GetList2 {
	public static void main(String[] args) {
		// Jedis jedis = new Jedis("192.168.100.205", 6379);
		Jedis jedis = RedisMain.redis();
		List<User> artList = new ArrayList<User>();
		for (int i = 0; i < 1000; i++) {
			User a = new User();
			a.setUserName("id-" + i);
			a.setAddress("title-" + i);
			artList.add(a);
		}

		long start = System.currentTimeMillis();
		String key2 = "TestSetOpt";
		jedis.set(key2.getBytes(), SerializeUtil.serialize(artList));

		long stored = System.currentTimeMillis();
		System.out.println("redis写10万条数据耗时：" + (stored - start));

		byte[] in = jedis.get(key2.getBytes());
		List<User> list2 = SerializeUtil.unserializeForList(in);
		for (User obj : list2) {
			System.out.println("测试Set操作 article title 是:" + obj.getUserName());
		}
		long end = System.currentTimeMillis();
		System.out.println("全部获取：" + list2.size());
		System.out.println("redis取10万条数据耗时：" + (end - stored));

	}
}

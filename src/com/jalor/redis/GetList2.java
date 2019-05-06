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
		System.out.println("redisд10�������ݺ�ʱ��" + (stored - start));

		byte[] in = jedis.get(key2.getBytes());
		List<User> list2 = SerializeUtil.unserializeForList(in);
		for (User obj : list2) {
			System.out.println("����Set���� article title ��:" + obj.getUserName());
		}
		long end = System.currentTimeMillis();
		System.out.println("ȫ����ȡ��" + list2.size());
		System.out.println("redisȡ10�������ݺ�ʱ��" + (end - stored));

	}
}

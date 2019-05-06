package com.jalor.redis;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import redis.clients.jedis.Jedis;

public class RedisTest {

	public static void main(String[] args) {
		// Jedis jedis = new Jedis("192.168.100.205", 6379);
		Jedis jedis = RedisMain.redis();
		jedis.set("k1", "hello,world!");
		jedis.set("k2", "the world is beautiful for you!");
		System.out.println(jedis.ping());
		System.out.println(jedis.get("k1"));
		System.out.println(jedis.get("k2"));

		List<User> list = new ArrayList<>();
		User u1 = new User();
		u1.setId(1);
		u1.setUserName("Jet Li");
		u1.setBirthday(new Date());
		u1.setSex("男");
		u1.setAddress("北京");

		User u2 = new User();
		u2.setId(2);
		u2.setUserName("Jackie Chan");
		u2.setBirthday(new Date());
		u2.setSex("男");
		u2.setAddress("中国香港");

		User u3 = new User();
		u3.setId(3);
		u3.setUserName("Jay Chou");
		u3.setBirthday(new Date());
		u3.setSex("男");
		u3.setAddress("中国台湾");

		list.add(u1);
		list.add(u2);
		list.add(u3);

		String key = "userList";
		jedis.set(key.getBytes(), SerializeUtil.serialize(list));

		String keyObj = "userObj";
		jedis.set(keyObj.getBytes(), SerializeUtil.serialize(u1));

		System.out.println(key.getBytes());

	}

}

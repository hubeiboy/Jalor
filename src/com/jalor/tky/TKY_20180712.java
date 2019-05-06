package com.jalor.tky;

import java.util.UUID;

public class TKY_20180712 {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			String uuid = UUID.randomUUID().toString().replace("-", "");
			System.out.println(uuid);
		}
	}
}

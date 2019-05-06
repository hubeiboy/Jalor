package com.jalor.others;

public interface NewCharacter {

	public void test1();

	public default void test2() {
		System.out.println("我是JDK1.8的新特性！");
	}

}

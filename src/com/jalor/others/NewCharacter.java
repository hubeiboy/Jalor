package com.jalor.others;

public interface NewCharacter {

	public void test1();

	public default void test2() {
		System.out.println("����JDK1.8�������ԣ�");
	}

}

package com.jalor.JavaTest;

public class LN_2019040102 {

    public static void main(String[] args) {
        long time1=System.currentTimeMillis();

        long time2=System.currentTimeMillis();
        System.out.println("当前程序耗时："+(time2-time1)+"ms");

        long time3=System.currentTimeMillis();

        System.out.println("当前程序耗时："+(time3-time2)+"ms");

        System.out.println("当前程序耗时："+(time3-time2)/60+"mi");
    }

}

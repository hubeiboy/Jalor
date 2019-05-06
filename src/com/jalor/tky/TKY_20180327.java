package com.jalor.tky;

import java.util.HashMap;
import java.util.Set;

public class TKY_20180327 {

	public static void main(String[] args) {
	 	HashMap<String,String> hm = new HashMap<>();
        String str = "lily@sohu.com,tom@163.com,rock@sina.com";
        //分割后存入数组
        String[] strArr = str.split(",");
        for (String tmp : strArr) {
            int index = tmp.indexOf("@");
            String key = tmp.substring(0, index);
            String value = tmp.substring(index);
            hm.put(key, value);
        }
        //遍历集合
        Set<String>set = hm.keySet();
        System.out.println("邮箱名\t地址名");
        for (String key : set) {
            System.out.println(key+"\t"+hm.get(key));
        }
	}
}

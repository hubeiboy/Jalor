package com.jalor.tky;

import java.util.HashMap;
import java.util.Set;

public class TKY_20180327 {

	public static void main(String[] args) {
	 	HashMap<String,String> hm = new HashMap<>();
        String str = "lily@sohu.com,tom@163.com,rock@sina.com";
        //�ָ���������
        String[] strArr = str.split(",");
        for (String tmp : strArr) {
            int index = tmp.indexOf("@");
            String key = tmp.substring(0, index);
            String value = tmp.substring(index);
            hm.put(key, value);
        }
        //��������
        Set<String>set = hm.keySet();
        System.out.println("������\t��ַ��");
        for (String key : set) {
            System.out.println(key+"\t"+hm.get(key));
        }
	}
}

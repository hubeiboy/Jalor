package com.jalor.others;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class OrderedMapTest {

	 public static void main(String[] args) {
	        Map<String, Integer> hashMap = new HashMap<String, Integer>();
	        Map<String, Integer> treeMap = new TreeMap<>();
	        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
	        System.out.println("--------------test hashMap");
	        testMap(hashMap);
	        System.out.println("--------------test treeMap");
	        testMap(treeMap);
	        System.out.println("--------------test linkedHashMap");
	        testMap(linkedHashMap);
	    }
	 
	    private static void testMap(Map<String, Integer> map) {
	        map.put("asd", 1);
	        map.put("2das", 2);
	        map.put("3das", 3);
	        map.put("4das", 4);
	        for (Map.Entry<String, Integer> entry : map.entrySet()) {
	            System.out.println(entry.getKey() + ":" + entry.getValue());
	        }
	    }

}

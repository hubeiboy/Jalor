package com.jalor.tky;

public class TKY_20180515 {

	public static void main(String[] args) {
		String ss = new String("123，456，789，000，111，222，333，555");
		String s[] = ss.split("\\，");
		String placekey = s[0];
		System.out.println(placekey);
		String placebit = s[1];
		System.out.println(placebit);
		System.out.println("----------------------");
		
		String sourceStr = "1,2,3,4,5";
        String[] sourceStrArray = sourceStr.split(",");
        for (int i = 0; i < sourceStrArray.length; i++) {
            System.out.println(sourceStrArray[i]);
        }
        // 最多分割出3个字符串
//        int maxSplit = 3;
//        sourceStrArray = sourceStr.split(",", maxSplit);
//        for (int i = 0; i < sourceStrArray.length; i++) {
//            System.out.println(sourceStrArray[i]);
//        }		
        System.out.println("<=====================>");
        
        String idCards = "142602196201170037，142602197310141520，142601197912121029";
        sourceStrArray = idCards.split("，");
//        System.out.println(sourceStrArray);
        String str01 = sourceStrArray[0];
        String str02 = "";
        for (int i = 1; i < sourceStrArray.length; i++) {
        	str02 += sourceStrArray[i] + "，";
        }	
        System.out.println(str01);
        System.out.println(str02.substring(0,str02.length() - 1));
		
	}
}

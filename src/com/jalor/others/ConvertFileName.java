package com.jalor.others;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class ConvertFileName {

	public static void main(String[] args) {

		System.out.println("-------------");

	}

	public String toPinyin(String fileString) {
		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
		format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		format.setVCharType(HanyuPinyinVCharType.WITH_V);
		char[] input = fileString.trim().toCharArray();
		String output = "";
		try {
			for (int i = 0; i < input.length; i++) {
				if (Character.toString(input[i]).matches("[\\u4E00-\\u9FA5]+")) { // 判断字符是否是中文
					// toHanyuPinyinStringArray 如果传入的不是汉字，就不能转换成拼音，那么直接返回null
					// 由于中文有很多是多音字，所以这些字会有多个String，在这里我们默认的选择第一个作为pinyin
					String[] temp = PinyinHelper.toHanyuPinyinStringArray(input[i], format);
					output += temp[0];
				} else {
					output += Character.toString(input[i]);
				}
			}
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			e.printStackTrace();
			// Log.v(TAG, "BadHanyuPinyinOutputFormatCombination");
		}
		return output;
	}

}

package com.flyingmcdonald.screencolorcapture;

import java.util.HashMap;
import java.util.Map;

public class Utils {
	public static String toHexString(int red, int green, int blue) {		//十六进制转换
		int[] colorList = {red, green, blue};
		String hexString = "#";
		for (int i = 0; i < colorList.length; i++) {
			String hex = Integer.toHexString(colorList[i]).toUpperCase();
			if (hex.length() == 1) {
				hex = "0" + hex;
			}
			hexString += hex;
		}
		
		
		return hexString;
	}
	
	public static int toInt(String input) {	//String转Int
		input = input.replaceAll(" ", "");
		if (!input.equals("")) {
			int num = Integer.parseInt(input);
			return num;
		} else {
			return 0;
		}
	}
	
	public static Map<String, Integer> toRGB(String str) {	//16进制转10进制
		Map<String, Integer> map = new HashMap<String, Integer>();
		int colorRed =Integer.parseInt(str.substring(1, 3), 16);
		int colorGreen =Integer.parseInt(str.substring(3, 5), 16);
		int colorBlue =Integer.parseInt(str.substring(5, 7), 16);
		
		map.put("colorRed", colorRed);
		map.put("colorGreen", colorGreen);
		map.put("colorBlue", colorBlue);
		
		return map;
	}
}

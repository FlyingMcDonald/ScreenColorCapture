package com.flyingmcdonald.screencolorcapture;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
	public static String toHexString(int red, int green, int blue, int alph) {		//十六进制转换
		int[] colorList = {red, green, blue, alph};
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
	
	/**
	 * 将数字字符串转换为整型数字
	 * 
	 * @param input
	 * @return
	 */
	public static int toInt(String input) {
		input = input.replaceAll(" ", "");
		if (!input.equals("")) {
			String input_2 = input.length() > 4 ? input.substring(0, 4) : input;	//判断input长度是否大于4，若大于4则截取前四个字符，否则什么都不做
			int num = Integer.parseInt(input_2);
			return num;
		} else {
			return 0;
		}
	}
	
	public static int[] toRGB(String str) {	//16进制转10进制
		int[] rgbaValue = new int[4];
		int colorRed =Integer.parseInt(str.substring(1, 3), 16);
		int colorGreen =Integer.parseInt(str.substring(3, 5), 16);
		int colorBlue =Integer.parseInt(str.substring(5, 7), 16);
		int colorAlph =Integer.parseInt(str.substring(7, 9), 16);
		
		rgbaValue[0] = colorRed;
		rgbaValue[1] = colorGreen;
		rgbaValue[2] = colorBlue;
		rgbaValue[3] = colorAlph;
		
		return rgbaValue;
	}

	/**
	 * 此方法用于检测字符串中是否含有不符合正则的字符
	 * 若存在，返回true
	 * 否则，返回false
	 * 
	 * @param str	待检测字符串
	 * @param pattern	正则表达式
	 * @return
	 */
	public static boolean checkChar(String str, String pattern) {	
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(str);
		return m.matches();
	}
	
	
	
	/**
	 * 此方法用于将字符串中不符合正则的字符过滤掉
	 * 并返回处理后的字符串数组
	 * 
	 * @param str	所需处理的字符串数组
	 * @param patternStr	正则表达式
	 * @return
	 */
	public static String[] replaceChar(String[] str, String patternStr) {
		String[] str_1 = new String[str.length];
		for(int i = 0; i < str.length; i++) {
			str_1[i] = str[i].replaceAll(patternStr, "");
		}
		return str_1;
	}
	
	
	/**
	 * 用于判断处理后的字符串数组是否存在异常格式。比如："01" 和 ""
	 * 
	 * @param str	所需判断的字符串数组
	 * @return
	 */
	public static boolean checkStr(String[] str) {
		for(int i = 0; i < str.length; i++) {
			if(str[i].equals("")) return false;
			if(str[i].charAt(0) == '0' || str[i].length() > 1) return false;
		}
		return true;
	}
	
	public static String[] replaceNullChar(String[] str) {
		String[] str_1 = new String[str.length];
		for(int i = 0; i < str.length; i++) {
			str_1[i] = str[i].equals("") ? "0" : str[i];
		}
		return str_1;
	}
	
	public static String[] interceptString(String[] str) {
		String[] str_1 = new String[str.length];
		for (int i = 0; i < str.length; i++) {
			if (str[i].charAt(0) == '0' && str[i].length() > 1) {
				for (int num = 0; num < str[i].length(); num++) {
					if (str[i].charAt(num) != '0') {
						str_1[i] = str[i].substring(num, str[i].length());
						break;
					}
				}
			} else {
				str_1[i] = str[i];
			}
			str_1[i] = str_1[i] == null ? "0" : str_1[i];
		}
		return str_1;
	}
	
	/**
	 * RGB转HSB
	 * 
	 * @param rgb
	 * @return
	 */
	public static int[] RGBtoHSB(int[] rgb) {
		int[] hsbValue = new int[rgb.length];
		float[] hsb= Color.RGBtoHSB(rgb[0], rgb[1], rgb[2], new float[3]);
		for (int i = 0; i < hsb.length; i++) {
			hsbValue[i] = (int) hsb[i] * 100 == 0 ? (int) (hsb[i] * 100 + 0.5f) : (int) hsb[i] * 100;
		}
		return hsbValue;
	}
	
	
	/**
	 * 将String数组转换为Int数组
	 * 
	 * @param stringType
	 * @return
	 */
	public static int[] StringToInt(String[] stringType) {
		int[] intType = new int[stringType.length];
		for (int i = 0; i < stringType.length; i++) {
			intType[i] = Utils.toInt(stringType[i]);
		}
		return intType;
	}
	
	/**
	 * 检测文本内容是否符合规定
	 * 
	 * @param textContent
	 * @return
	 */
	public static String[] checkContent(String[] textContent) {
		String[] hsbText_1 = Utils.replaceChar(textContent, "[^\\d]");
		String[] hsbText_2 = Utils.replaceNullChar(hsbText_1);
		String[] hsbText_3 = Utils.interceptString(hsbText_2);
		return hsbText_3;
	}
}

package com.flyingmcdonald.screencolorcapture;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
	public static boolean flag = true;

	/**
	 * Convert decimal rgb integer value to hexadecimal string
	 * @param red Integer value red
	 * @param green Integer value green
	 * @param blue Integer value green
	 * @return Converted hex string
	 */
	public static String toRgbHexString(int red, int green, int blue) {		//十六进制转换
		int[] colorList = {red, green, blue};
		StringBuilder hexString = new StringBuilder("#");
		for (int value : colorList) {
			String hex = Integer.toHexString(value).toUpperCase();
			if (hex.length() == 1) {
				hex = "0" + hex;
			}
			hexString.append(hex);
		}
		return hexString.toString();
	}

	/**
	 * Convert decimal rgba integer value to hexadecimal string
	 * @param red Integer value red
	 * @param green Integer value green
	 * @param blue Integer value blue
	 * @param alph Integer value alph
	 * @return Convert hex string
	 */
	public static String toRgbaHexString(int red, int green, int blue, int alph) {		//十六进制转换
		String rgbHexStr = toRgbHexString(red, green, blue);
		String alphHex = Integer.toHexString(alph).toUpperCase();
		if (alphHex.length() == 1) {
			alphHex = "0" + alphHex;
		}
		return rgbHexStr + alphHex;
	}
	
	/**
	 * Convert numberic string to an integer number
	 * <p>Detemines whether the input string length is greater than 4</p>
	 * If true, Intercept first four characters<br>
	 * If false, Do nothing
	 *
	 * @param input <code>input</code> needs to be a pure numeric string<br>
	 *
	 * @return Integer string
	 */
	public static int toInt(String input) {
		input = input.replaceAll(" ", "");
		if (!input.equals("")) {
			String input_2 = input.length() > 4 ? input.substring(0, 4) : input;
			return Integer.parseInt(input_2);
		} else {
			return 0;
		}
	}

	/**
	 * Convert hexadecimal string to decimal for rgba integer value
	 * @param str Hex string to be converted
	 * @return Result is a List containing rgba
	 */
	public static List<Integer> toRGBA(String str) {
		List<Integer> rgbaList = new ArrayList<>();
		int colorRed =Integer.parseInt(str.substring(1, 3), 16);
		int colorGreen =Integer.parseInt(str.substring(3, 5), 16);
		int colorBlue =Integer.parseInt(str.substring(5, 7), 16);
		rgbaList.add(colorRed);
		rgbaList.add(colorGreen);
		rgbaList.add(colorBlue);
		if (str.length() == 9) {
			int colorAlph = Integer.parseInt(str.substring(7, 9), 16);
			rgbaList.add(colorAlph);
		}
		return rgbaList;
	}

	/**
	 * Detece if the string contains non-regular characters
	 * If it contains return true,
	 * else return false
	 * 
	 * @param str	String to be deteced
	 * @param pattern	regular string
	 * @return boolean value true or false
	 */
	public static boolean checkChar(String str, String pattern) {	
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(str);
		return m.matches();
	}
	
	/**
	 * Filter out non-regular characters in a string array
	 * and return processed string array
	 * 
	 * @param str	String array to be processed
	 * @param patternStr	Regular string
	 * @return Processed string array
	 */
	public static String[] replaceChar(String[] str, String patternStr) {
		String[] str_1 = new String[str.length];
		for(int i = 0; i < str.length; i++) {
			str_1[i] = str[i].replaceAll(patternStr, "");
		}
		return str_1;
	}

	/**
	 * Filter out non-regular characters in a string
	 * and return processed string
	 *
	 * @param str String to be processed
	 * @param patternStr Regular string
	 * @return processed string
	 */
	public static String replaceChar(String str, String patternStr){
		return str.replaceAll(patternStr, "");
	}

	/**
	 * Detece whether the string array contains null string
	 * If it contains replace null use "0"
	 *
 	 * @param str String array to be deteced
	 * @return String array without null
	 */
	public static String[] replaceNullChar(String[] str) {
		String[] str_1 = new String[str.length];
		for(int i = 0; i < str.length; i++) {
			str_1[i] = str[i].equals("") ? "0" : str[i];
		}
		return str_1;
	}

	/**
	 * Detece whether the string is null<br>
	 * If it is null, replace null use "0"
	 *
	 * @param str String to be deteced
	 * @return Non-null string
	 */
	public static String replaceNullChar(String str){
		return str.equals("") ? "0" : str;
	}
	
	public static String[] interceptString(String[] str) {
		String[] str_1 = new String[str.length];
		for (int i = 0; i < str.length; i++) {
			if (str[i].charAt(0) == '0' && str[i].length() > 1) {
				for (int num = 0; num < str[i].length(); num++) {
					if (str[i].charAt(num) != '0') {
						str_1[i] = str[i].substring(num);
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

	public static String interceptString(String str){
		if(str.charAt(0) == '0' && str.length() > 1){
			for(int i = 0; i < str.length(); i++){
				if(str.charAt(i) != '0'){
					str = str.substring(i);
					break;
				}
			}
		}
		return str;
	}
	
	/**
	 * Convert rgb integer value to hsv integer value
	 * 
	 * @param rgb Rgb integer value to be converted
	 * @return Hsv integer value
	 */
	public static int[] RgbtoHsv(int[] rgb) {
		int[] hsbValue = new int[rgb.length];
		float[] hsb= Color.RGBtoHSB(rgb[0], rgb[1], rgb[2], new float[3]);
		for (int i = 0; i < hsb.length; i++) {
			hsbValue[i] = (int) hsb[i] * 100 == 0 ? (int) (hsb[i] * 100 + 0.5f) : (int) hsb[i] * 100;
		}
		return hsbValue;
	}
	
	/**
	 * Convert string array to integer array
	 * 
	 * @param stringType String array to be convert
	 * @return Integer array
	 */
	public static int[] StringToInt(String[] stringType) {
		int[] intType = new int[stringType.length];
		for (int i = 0; i < stringType.length; i++) {
			intType[i] = Utils.toInt(stringType[i]);
		}
		return intType;
	}

	/**
	 * Set JLabel font
	 * @param labelObject JLabel object
	 */
	public static void setFonts(JLabel labelObject) {
		labelObject.setFont(Utils.loadFont());
	}

	private static Font loadFont() {
		try{
			File file = new File(System.getProperty("user.dir") + File.separator + "fonts/JetBrainsMono-Regular.ttf");
			FileInputStream font = new FileInputStream(file);
			Font dynameicFont = Font.createFont(Font.TRUETYPE_FONT, font);
			Font dynameicFontPt = dynameicFont.deriveFont((float) 13);
			font.close();
			return dynameicFontPt;
		} catch (Exception e) {
			e.printStackTrace();
			return new Font("宋体", Font.PLAIN, 14);
		}
	}

	/**
	 * Detece if string array non-regular
	 *
	 * @param strArray String array to be deteced
	 * @param patternStr Regular string
	 * @return Qualified string array
	 */
	public static String[] checkString(String[] strArray, String patternStr){
		return interceptString(
				replaceNullChar(
						replaceChar(strArray, patternStr)));
	}

	/**
	 * Detece if string non-regular
	 *
	 * @param str string to be deteced
	 * @param patternStr Regular string
	 * @return Qualified string
	 */
	public static String checkString(String str, String patternStr){
		return interceptString(
				replaceNullChar(
						replaceChar(str, patternStr)));
	}

	/**
	 * Limit rgb integer array value
	 *
	 * @param rgbValue rgb integer array value
	 * @return Qulified rgb integer array value
	 */
	public static int[] checkRGBValue(int[] rgbValue) {
		for (int i = 0; i < rgbValue.length; i++) {
			if(rgbValue[i] < 0 || rgbValue[i] > 255) {
				rgbValue[i] = rgbValue[i] > 255 ? 255 : 0;
			}
		}
		return rgbValue;
	}

	/**
	 * Limit cursor coordinates
	 *
	 * @param x Cursor X coordinate
	 * @param y Cursor Y coordinate
	 * @return Qulified cursor coordinates
	 */
	public static int[] checkCoordinates(int x, int y) {
		int[] coordinates = new int[2];
		if(x > 201 || x < 0) {
			x = x > 201 ? 201 : 0;
		}
		if(y > 201 || y < 0) {
			y = y > 201 ? 201 : 0;
		}
		coordinates[0] = x;
		coordinates[1] = y;
		return coordinates;
	}

	/**
	 * Detece if hex string value non-regular<br>
	 * If hex string is illegal return null
	 * @param hexStr hex field string to be deteced
	 * @return Qulified hex string
	 */
	public static String checkHexFieldValue(String hexStr){
		if (hexStr.length() == 0){
			return null;
		}
		hexStr = hexStr.toUpperCase().substring(1);
		if (hexStr.length() == 8 && checkChar(hexStr, "[0-9A-F]{8}")){
			return "#" + hexStr;
		}else if (hexStr.length() == 6 && checkChar(hexStr, "[0-9A-F]{6}")){
			return "#" + hexStr;
		}
		return null;
	}

	/**
	 * filter out field string value<br>
	 * If this field is illegal return null
	 * @param fieldVal String to be filtered
	 * @return Qulified String
	 */
	public static String filterFieldValue(String fieldVal){
		if (fieldVal.length() > 3 || !checkChar(fieldVal, "[\\d]*") || fieldVal.equals("")){
			return null;
		}
		return fieldVal;
	}

	/**
	 * Detece if rgb string array contains illegal characters<br>
	 * If contains illegal characters return false, else return true
	 *
	 * @param rgbStrArray Rgb string array to be deteced
	 * @return True or False
	 */
	public static boolean checkRgbFieldValue(String[] rgbStrArray){
		for (String str : rgbStrArray) {
			if (str == null || toInt(str) > 255){
				return false;
			}
		}
		return true;
	}

	/**
	 * Detece if hsv string array contains illegal characters<br>
	 * If contains illegal characters return false, else return true
	 *
	 * @param hsvStrArray Hsv string array to be deteced
	 * @return True or False
	 */
	public static boolean checkHsvFieldValue(String[] hsvStrArray){
		for (String str : hsvStrArray) {
			if (str == null || toInt(str) > 100){
				return false;
			}
		}
		return true;
	}

	/**
	 * Detece if alph string contain illegal characters<br>
	 * If contains illegal characters return false, else return true
	 * @param alphStr Alph string to be deteced
	 * @return True or False
	 */
	public static boolean checkAlphFieldValue(String alphStr){
		return alphStr != null && toInt(alphStr) <= 255;
	}

	/**
	 * Compare hsv and rgb generated colors<br>
	 * If same return true, else false
	 *
	 * @param hsvFloatArray Hsv float value
	 * @param rgbIntArray Rgb integer value
	 * @return True or False
	 */
	public static boolean compareHsvAndRgb(float[] hsvFloatArray, int[] rgbIntArray){
		int r = rgbIntArray[0];
		int g = rgbIntArray[1];
		int b = rgbIntArray[2];
		Color color = Color.getHSBColor(hsvFloatArray[0], hsvFloatArray[1], hsvFloatArray[2]);
		Color colorPlus = new Color(r, g, b);
		return !color.equals(colorPlus);
	}

	/**
	 * 将 Component 整合进 JPanel
	 */
	public static void integrateComponent(JPanel parentPanel, JPanel jPanel1, JPanel jPanel2
			, JPanel jPanel3, Component component11, Component component12, Component component21,
										  Component component22, Component component31, Component component32){
		jPanel1.add(component11);
		jPanel1.add(component12);

		jPanel2.add(component21);
		jPanel2.add(component22);

		jPanel3.add(component31);
		jPanel3.add(component32);

		parentPanel.add(jPanel1);
		parentPanel.add(jPanel2);
		parentPanel.add(jPanel3);
	}

	public static void componentConfig(JPanel[] jpanelsArrary, Component[] componentsArrary){

	}
}
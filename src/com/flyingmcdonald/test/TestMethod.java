package com.flyingmcdonald.test;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestMethod {
	public static void main(String[] args) {
//		int r = 255;
//		int g = 0;
//		int b = 0;
//		float[] hsv = new float[3];
//		float[] hsb = Color.RGBtoHSB(r, g, b, hsv);
//		float h = hsb[0];
//		float s = hsb[1];
//		float v = hsb[2];
////		
////		System.out.println("Hue:"+h+"\n"
////		+"Saturation:"+s+"\n"
////				+"Value:"+v);
//		
//		Color color = Color.getHSBColor(h, s, v);
////		System.out.println(color.getRed()+"\n"+color.getGreen()+"\n"+color.getBlue());
//		
//		int i = Color.HSBtoRGB(0.5f, 1.0f, 1.0f);
////		System.out.println(i);
//		
//		
//		String a = "123asd123";
//		a = a.replaceAll("\\D", "");
//		System.out.println(a);
		String pattern = "[\\d]*";
		String str = "123123213";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(str);
		System.out.println(m.matches());
	}
}
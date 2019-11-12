package com.flyingmcdonald.screencolorcapture;

import java.awt.Color;

public class ColorInfoBean {
	private int redVal;
	private int greenVal;
	private int blueVal;
	private float hue;
	private float saturaion;
	private float value;
	
	
	public float getHue() {
		return hue;
	}
	public void setHue(float hue) {
		this.hue = hue;
	}
	public float getSaturaion() {
		return saturaion;
	}
	public void setSaturaion(float saturaion) {
		this.saturaion = saturaion;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	private Color pickedColor;
	public int getRedVal() {
		return redVal;
	}
	public void setRedVal(int redVal) {
		this.redVal = redVal;
	}
	public int getGreenVal() {
		return greenVal;
	}
	public void setGreenVal(int greenVal) {
		this.greenVal = greenVal;
	}
	public int getBlueVal() {
		return blueVal;
	}
	public void setBlueVal(int blueVal) {
		this.blueVal = blueVal;
	}
	public Color getPickedColor() {
		return pickedColor;
	}
	public void setPickedColor(Color pickedColor) {
		this.pickedColor = pickedColor;
	}
}

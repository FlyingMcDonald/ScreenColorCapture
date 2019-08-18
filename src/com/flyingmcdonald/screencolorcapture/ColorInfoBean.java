package com.flyingmcdonald.screencolorcapture;

import java.awt.Color;

public class ColorInfoBean {
	private int redVal;
	private int greenVal;
	private int blueVal;
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

package com.flyingmcdonald.screencolorcapture;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class RGBAListener implements DocumentListener, KeyListener{
	private MainPanel mainPanel;
	private AlphSlider alphSlider = null;
	private RGBAInfo rgbaInfo;
	private HSBInfo hsbInfo;
	private String patternStr = "[\\d]*";
	private final String patternStr_1 = "[^\\d]*";
	

	public MainPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	
	public AlphSlider getAlphSlider() {
		return alphSlider;
	}

	public void setAlphSlider(AlphSlider alphSlider) {
		this.alphSlider = alphSlider;
	}

	public RGBAListener(MainPanel mainPanel) {
		this.setMainPanel(mainPanel);
	}
	public RGBAListener(MainPanel mainPanel, AlphSlider alphSlider) {
		this.setMainPanel(mainPanel);
		this.setAlphSlider(alphSlider);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			mainPanel.setRgbFlag(false);
			rgbaInfo = new RGBAInfo(this.getMainPanel());
			hsbInfo = new HSBInfo(this.getMainPanel());
			String[] str = rgbaInfo.getRGBATextContent();
			String[] str_1 = Utils.replaceChar(str, patternStr_1);
			String[] str_2 = Utils.replaceNullChar(str_1);
			String[] str_3 = Utils.interceptString(str_2);
			int[] rgb = limiteRGBValue(str_3);
			int[] hsb = Utils.RGBtoHSB(rgb);
			hsbInfo.setHSBText(hsb, hsbInfo.HSBTextObj());
			rgbaInfo.setRGBText(rgb, rgbaInfo.RGBATextObj());
			mainPanel.setRgbFlag(true);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		changeRGBAText();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		if(e.getDocument().getLength() != 0) {
			changeRGBAText();
		}
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		mainPanel.setRgbFlag(false);
		changeRGBAText();
	}
	
	private int[] setColorByRGB() {	//根据RGBA四个文本框的值显示showColorText的颜色
		int[] init = {0,0,0,0};
		Color textColor = new Color(255, 255, 255, 255);
		rgbaInfo = new RGBAInfo(this.getMainPanel());
		String[] RGBATextArray = rgbaInfo.getRGBATextContent();
		String hexText = mainPanel.getShowHexText().getText();
		
		//判断非法字符
		if (checkIllegalChar(RGBATextArray)) {
			return showColorToColorText(RGBATextArray, textColor, hexText);
		} else {
			String[] str = Utils.replaceChar(RGBATextArray,patternStr);
			if(Utils.checkStr(str)) {	//判断格式
				return showColorToColorText(str, textColor, hexText);
			}
			return init;
		}
	}
	
	/**
	 * 判断非法字符
	 * 
	 * @param rgbTextArray
	 * @return
	 */
	private boolean checkIllegalChar(String[] rgbTextArray) {
		return (Utils.checkChar(rgbTextArray[0], this.patternStr) && Utils.checkChar(rgbTextArray[1], this.patternStr) && Utils.checkChar(rgbTextArray[2], this.patternStr));
	}
	
	
	
	
	/**
	 * 在颜色面板中显示RGB相应的颜色
	 * 
	 * @param RGBTextArray
	 * @param textColor
	 * @param hexText
	 */
	private int[] showColorToColorText(String[] RGBATextArray, Color textColor, String hexText) {
			int[] rgbaValue = checkRGBValue(Utils.StringToInt(RGBATextArray));
			textColor = new Color(rgbaValue[0], rgbaValue[1], rgbaValue[2], rgbaValue[3]);
			mainPanel.getShowColorLabel().setColor(textColor);
			mainPanel.getShowColorLabel().repaint();
			return rgbaValue;
	}
	
	/**
	 * 处理超出RGB规定范围的值
	 * 
	 * @param rgbValue
	 * @return
	 */
	private int[] checkRGBValue(int[] rgbValue) {
		for (int i = 0; i < rgbValue.length; i++) {
			if(rgbValue[i] < 0 || rgbValue[i] > 255) {
				rgbValue[i] = rgbValue[i] > 255 ? 255 : 0;
			}
		}
		return rgbValue;
	}
	
	private void setHexText(int[] rgba) {
		if(mainPanel.isHexFlag()) {
			String hexText = mainPanel.getShowHexText().getText();
			if (!hexText.equals(Utils.toHexString(rgba[0], rgba[1], rgba[2], rgba[3]))) {
				mainPanel.getShowHexText().setText(Utils.toHexString(rgba[0], rgba[1], rgba[2], rgba[3]));
			}
		}
	}
	
	/**
	 * 通过RGB的值来得到HSB的值
	 * 
	 * @param rgbArray
	 */
	private void setHSBByRGB(String[] rgbArray) {
		String[] rgbTextContent = rgbArray;
		if (checkIllegalChar(rgbTextContent)) {
			int[] hsb = Utils.RGBtoHSB(Utils.StringToInt(rgbTextContent));
			hsbInfo = new HSBInfo(this.getMainPanel());
			JTextField[] HSBText = hsbInfo.HSBTextObj();
			hsbInfo.setHSBText(hsb, HSBText);
		} else {
			String[] str = Utils.replaceChar(rgbTextContent,patternStr_1);
			setHSBByRGB(str);
		}
	}
	
	/**
	 * 限制RGB的值
	 * 若大于255或小于0，则取255和0的接近值
	 * 
	 * @param str
	 * @return
	 */
	private int[] limiteRGBValue(String[] str) {
		int[] rgb = new int[str.length];
		for(int i = 0; i < str.length; i++) {
			rgb[i] = Utils.toInt(str[i]);
			if(rgb[i] > 255 || rgb[i] < 0) {
				rgb[i] = rgb[i] > 255 ? 255 : 0;
			}
		}
		return rgb;
	}
	
	/**
	 * 改变RGBA的值
	 * 
	 */
	private void changeRGBAText() {
		mainPanel.setRgbFlag(false);
		
		if(mainPanel.isHsbFlag()) {
			rgbaInfo = new RGBAInfo(this.getMainPanel());
			setHSBByRGB(rgbaInfo.getRGBATextContent());
		}
		int[] rgba = setColorByRGB();
		setHexText(rgba);
		mainPanel.setRgbFlag(true);
		if(alphSlider != null) {
			float avage = 160 / 255f;
			alphSlider.setSliderMidOfCircled((int)(rgba[3] * avage));
			alphSlider.repaint();
		}
	}

}

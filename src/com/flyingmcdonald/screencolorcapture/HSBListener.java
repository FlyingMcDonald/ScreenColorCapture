package com.flyingmcdonald.screencolorcapture;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class HSBListener implements DocumentListener, KeyListener {
	private MainPanel mainPanel;
	private RGBAInfo rgbInfo;
	private HSBInfo hsbInfo;
	
	

	public HSBListener(MainPanel mainPanel2) {
		this.setMainPanel(mainPanel2);
	}

	public MainPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			hsbInfo = new HSBInfo(this.getMainPanel());
			String[] hsbText = hsbInfo.getHSBTextContent();
			String[] hsbTextPlus = Utils.checkContent(hsbText);
			int[] hsbInt = Utils.StringToInt(hsbTextPlus);
			int[] hsbIntPlus = limiteHSBValue(hsbInt);
			if(mainPanel.isRgbFlag()) changeRGBByHSB(hsbIntPlus);
			hsbInfo.setHSBText(hsbIntPlus, hsbInfo.HSBTextObj());
		}
	}

	

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		hsbInfo = new HSBInfo(this.getMainPanel());
		String[] hsbText = hsbInfo.getHSBTextContent();
		String[] hsbTextPlus =Utils. checkContent(hsbText);
		int[] hsbInt = Utils.StringToInt(hsbTextPlus);
		int[] hsbIntPlus = limiteHSBValue(hsbInt);
		if(mainPanel.isRgbFlag()) changeRGBByHSB(hsbIntPlus);
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		if(e.getDocument().getLength() != 0) {
			hsbInfo = new HSBInfo(this.getMainPanel());
			String[] hsbText = hsbInfo.getHSBTextContent();
			String[] hsbTextPlus = Utils.checkContent(hsbText);
			int[] hsbInt = Utils.StringToInt(hsbTextPlus);
			int[] hsbIntPlus = limiteHSBValue(hsbInt);
			if(mainPanel.isRgbFlag()) changeRGBByHSB(hsbIntPlus);
		}
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		hsbInfo = new HSBInfo(this.getMainPanel());
		String[] hsbText = hsbInfo.getHSBTextContent();
		String[] hsbTextPlus = Utils.checkContent(hsbText);
		int[] hsbInt = Utils.StringToInt(hsbTextPlus);
		int[] hsbIntPlus = limiteHSBValue(hsbInt);
		changeRGBByHSB(hsbIntPlus);
	}
	
	/**
	 * 通过HSB的值来该变RGB的值
	 * 
	 * @param hsbText
	 */
	private void changeRGBByHSB(int[] hsbText) {
		mainPanel.setHsbFlag(false);
		float[] hsbValue = getHSBValue(hsbText);
		int[] rgb = getRGBValue(Color.getHSBColor(hsbValue[0], hsbValue[1], hsbValue[2]));
		rgbInfo = new RGBAInfo(this.getMainPanel());
		rgbInfo.setRGBText(rgb, rgbInfo.RGBATextObj());
		mainPanel.setHsbFlag(true);
	}
	
	/**
	 * 获取HSB的整数值
	 * 
	 * @param hsbText
	 * @return
	 */
	private float[] getHSBValue(int[] hsbText) {
		float[] hsbValue = new float[hsbText.length];
		for (int i = 0; i < hsbText.length; i++) {
			hsbValue[i] = hsbText[i] / 100f;
		}
		return hsbValue;
	}
	
	/**
	 * 根据color得到RGB值
	 * 
	 * @param color
	 * @return
	 */
	private int[] getRGBValue(Color color) {
		int[] rgb = new int[3];
		rgb[0] = color.getRed();
		rgb[1] = color.getGreen();
		rgb[2] = color.getBlue();
		return rgb;
	}
	
	/**
	 * 限制HSB的值以防超出限定范围
	 * 
	 * @param hsbValue
	 * @return
	 */
	private int[] limiteHSBValue(int[] hsbValue) {
		int[] hsb = hsbValue;
		for (int i = 0; i < hsbValue.length; i++) {
			if(hsbValue[i] > 100 || hsbValue[i] < 0) {
				hsb[i] = hsbValue[i] > 100 ? 100 : 0;
			}
		}
		return hsb;
	}
	
	
	
}

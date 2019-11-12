package com.flyingmcdonald.screencolorcapture;

import javax.swing.JTextField;

public class RGBAInfo {
	private MainPanel mainPanel;
	
	public MainPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}
	
	public RGBAInfo(MainPanel mainPanel) {
		this.setMainPanel(mainPanel);
	}
	
	
	/**
	 * 返回带有RGB文本框内容的String数组
	 * 
	 * @return
	 */
	public String[] getRGBATextContent() {
		String[] rgbTextContent = {
				mainPanel.getShowRedText().getText(),
				mainPanel.getShowGreenText().getText(),
				mainPanel.getShowBlueText().getText(),
				mainPanel.getShowAlphText().getText()
		};
		return rgbTextContent;
	}
	
	/**
	 * 将RGB值显示在文本框中
	 * 
	 * @param rgb	数组
	 * @param rgbTextObj	数组
	 */
	public void setRGBText(int[] rgb, JTextField[] rgbTextObj) {
		for (int i = 0; i < rgbTextObj.length; i++) {
			if (!rgbTextObj[i].getText().equals(""+rgb[i])) {
				rgbTextObj[i].setText(""+rgb[i]);
			}
		}
	}
	
	/**
	 * 获取HSB的JTextField对象数组
	 * 
	 * @return
	 */
	public JTextField[] RGBATextObj(){
		JTextField[] RGBATextObj = {
				mainPanel.getShowRedText(),
				mainPanel.getShowGreenText(),
				mainPanel.getShowBlueText(),
				mainPanel.getShowAlphText()
		};
		return RGBATextObj;
	}


}

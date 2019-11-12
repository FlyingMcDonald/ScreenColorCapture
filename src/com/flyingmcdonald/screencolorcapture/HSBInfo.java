package com.flyingmcdonald.screencolorcapture;

import javax.swing.JTextField;

public class HSBInfo {
	private MainPanel mainPanel;
	
	public MainPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}
	
	public HSBInfo(MainPanel mainPanel) {
		this.setMainPanel(mainPanel);
	}
	
	/**
	 * 获取HSB的JTextField对象数组
	 * 
	 * @return
	 */
	public JTextField[] HSBTextObj(){
		JTextField[] HSBTextObj = {
				mainPanel.getShowHueText(),
				mainPanel.getShowSaturationText(),
				mainPanel.getShowValueText()
		};
		return HSBTextObj;
	}
	
	public void setHSBText(int[] hsb, JTextField[] HSBText) {
		for (int i = 0; i < HSBText.length; i++) {
			if (!HSBText[i].getText().equals(""+hsb[i])) {
				HSBText[i].setText(""+hsb[i]);
			}
		}
	}
	
	public String[] getHSBTextContent() {
		JTextField[] hsbTextObj = HSBTextObj();
		String[] hsbTextContent = new String[hsbTextObj.length];
		for (int i = 0; i < hsbTextObj.length; i++) {
			hsbTextContent[i] = hsbTextObj[i].getText();
		}		
		return hsbTextContent;
	}

}

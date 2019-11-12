package com.flyingmcdonald.screencolorcapture;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class HexListener implements DocumentListener, KeyListener{
	private MainPanel mainPanel;
	private RGBAInfo rgbaInfo;
	

	public MainPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(MainPanel mainPanel) {
		this.setMainPanel(mainPanel);
	}
	
	public HexListener(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		if(mainPanel.isRgbFlag()) {
			setColorByHex();
		}
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		if(mainPanel.isRgbFlag()) {
			setColorByHex();
		}
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		if(mainPanel.isRgbFlag()) {
			setColorByHex();
		}
	}
	
	public void setColorByHex() {	//根据Hex更新showColorText颜色
		if(mainPanel.isRgbFlag()) {
			mainPanel.setHexFlag(false);
			String str = mainPanel.getShowHexText().getText();
			boolean isHex = Utils.checkChar(str, "^[#][A-Fa-f0-9]{8}$");
			if (isHex) {
				int[] colorRGB = Utils.toRGB(str);
				rgbaInfo = new RGBAInfo(this.getMainPanel());
				rgbaInfo.setRGBText(colorRGB, rgbaInfo.RGBATextObj());
			}
			mainPanel.setHexFlag(true);
		}
	}

}

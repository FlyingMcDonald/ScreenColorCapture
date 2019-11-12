package com.flyingmcdonald.screencolorcapture;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AlphListener implements KeyListener{
	private MainPanel mainPanel;
	private AlphSlider alphSlider;
	
	

	public AlphSlider getAlphSlider() {
		return alphSlider;
	}

	public void setAlphSlider(AlphSlider alphSlider) {
		this.alphSlider = alphSlider;
	}

	public MainPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
		
	}

	public AlphListener(MainPanel mainPanel, AlphSlider alphSlider) {
		this.setMainPanel(mainPanel);
		this.setAlphSlider(alphSlider);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			System.out.println("1");
			String[] alphText = {mainPanel.getShowAlphText().getText()};
			String alphStr = checkAlphText(alphText);
			mainPanel.getShowAlphText().setText(alphStr);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
	private String checkAlphText(String[] alphText) {
		String[] alphStr = Utils.checkContent(alphText);
		return alphStr[0];
	}
}

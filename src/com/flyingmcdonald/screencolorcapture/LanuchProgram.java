package com.flyingmcdonald.screencolorcapture;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class LanuchProgram extends JFrame{

	/**
	 * @author FlyingMcDonald
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args){
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		UIManager.put("Slider.paintValue", Boolean.FALSE);
		new MainPanel();
	}

}
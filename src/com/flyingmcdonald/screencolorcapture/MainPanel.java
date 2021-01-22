package com.flyingmcdonald.screencolorcapture;

import com.flyingmcdonald.screencolorcapture.panelcompenents.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.*;

public class MainPanel extends JFrame {
	private JPanel mainPanel;
	private JPanel showInfoPanel;
	private JPanel showColorPanel;
	private JPanel colorPickPanel;
	private final Container contentPane;
	private HsvPanelComponent hsvPanelComponent;
	private RgbPanelComponent rgbPanelComponent;
	private HexPanelComponent hexPanelComponent;
	private AlphPanelComponent alphPanelComponent;
	private HsvPalettePanelComponent hsvPalettePanelComponent;
	private ColorPickPanelComponent colorPickPanelComponent;

	public HexPanelComponent getHexPanelComponent() {
		return hexPanelComponent;
	}

	public AlphPanelComponent getAlphPanelComponent() {
		return alphPanelComponent;
	}

	public HsvPalettePanelComponent getHsvPalettePanelComponent() {
		return hsvPalettePanelComponent;
	}

	public ColorPickPanelComponent getColorPickPanelComponent() {
		return colorPickPanelComponent;
	}

	public HsvPanelComponent getHsvPanelComponent() {
		return hsvPanelComponent;
	}

	public RgbPanelComponent getRgbPanelComponent() {
		return rgbPanelComponent;
	}

	/**
	 * @author FlyingMcDonald
	 */
	private static final long serialVersionUID = 1L;

	public MainPanel() {
		contentPane = this.getContentPane();
		setTitle("Color Picker");
		setSize(650, 320);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		mainPanel();
		addBorder();
		setLayout(new ColorPickLayout());
		setVisible(true);
	}

	/**
	 * Integrate all components
	 */
	private void mainPanel() {
		mainPanel = new JPanel(new BorderLayout());
		mainPanel.setPreferredSize(new Dimension(600, 266));
		showColorPanel();
		showColorPickPanel();
		showInfoPanel();
		mainPanel.add(showInfoPanel, BorderLayout.EAST);
		mainPanel.add(showColorPanel, BorderLayout.WEST);
		mainPanel.add(colorPickPanel, BorderLayout.SOUTH);
		contentPane.add(mainPanel);
	}

	/**
	 * Integrate all JTextField components
	 * include: rgb, hsv, alph, hex components
	 */
	public void showInfoPanel() {
		showInfoPanel = new JPanel(null);
		showInfoPanel.setPreferredSize(new Dimension(365, 150));

		hsvPanelComponent = new HsvPanelComponent(this);
		rgbPanelComponent = new RgbPanelComponent(this);
		hexPanelComponent = new HexPanelComponent(this);
		alphPanelComponent = new AlphPanelComponent(this);

		JPanel showHexAndAlphaPanel = new JPanel(null);
		showHexAndAlphaPanel.setBounds(0, 150, 365, 65);

		showHexAndAlphaPanel.add(hexPanelComponent.getShowHexPanel());
		showHexAndAlphaPanel.add(alphPanelComponent.getShowAlphPanel());
		showHexAndAlphaPanel.setBorder(BorderFactory.createLineBorder(Color.yellow));
		
		showInfoPanel.add(hsvPanelComponent.getShowHSVPanel());
		showInfoPanel.add(rgbPanelComponent.getShowRGBPanel());
		showInfoPanel.add(showHexAndAlphaPanel);
	}

	/**
	 * Show hsv palette
	 */
	private void showColorPanel() {
		hsvPalettePanelComponent = new HsvPalettePanelComponent(this);
		showColorPanel = hsvPalettePanelComponent.getHsvPalettePanel();
	}

	/**
	 * Color pick component
	 */
	private void showColorPickPanel() {
		colorPickPanelComponent = new ColorPickPanelComponent(this);
		colorPickPanel = colorPickPanelComponent.getColorPickPanel();
	}

	private void addBorder(){
		hexPanelComponent.getShowHexPanel().setBorder(BorderFactory.createLineBorder(Color.cyan));
		alphPanelComponent.getShowAlphPanel().setBorder(BorderFactory.createLineBorder(Color.red));
		hsvPanelComponent.getShowHSVPanel().setBorder(BorderFactory.createLineBorder(Color.ORANGE));
		rgbPanelComponent.getShowRGBPanel().setBorder(BorderFactory.createLineBorder(Color.magenta));
		showInfoPanel.setBorder(BorderFactory.createLineBorder(Color.cyan));
	}

	private class ColorPickLayout implements LayoutManager{

		@Override
		public void addLayoutComponent(String name, Component comp) {

		}

		@Override
		public void removeLayoutComponent(Component comp) {

		}

		@Override
		public Dimension preferredLayoutSize(Container parent) {
			return null;
		}

		@Override
		public Dimension minimumLayoutSize(Container parent) {
			return null;
		}

		@Override
		public void layoutContainer(Container parent) {
			int frameWid = parent.getWidth(); //获取窗体宽度
			int frameHei = parent.getHeight();//获取窗体高度
			Dimension mainPanelSize = mainPanel.getPreferredSize();//获取 mainPanel 的 size
			int x = (frameWid - mainPanelSize.width) / 2;//计算 mainPanel 在 x 轴上的居中位置
			int y = (frameHei - mainPanelSize.height) / 2;//计算 mainPanel 在 y 轴上的居中位置
			mainPanel.setBounds(x, y, mainPanelSize.width, mainPanelSize.height);
		}
	}

}
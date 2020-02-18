package com.flyingmcdonald.screencolorcapture;

import com.flyingmcdonald.screencolorcapture.panelcompenents.*;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainPanel extends JFrame {
	private JPanel showInfoPanel;
	private JPanel showColorPanel;
	private JPanel colorPickPanel;
	private Container contentPane;
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
		contentPane.setLayout(new BorderLayout());
		mainPanel();
		setTitle("Color Picker");
		setSize(650, 320);
		setResizable(false);
		setDefaultCloseOperation(MainPanel.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * Integrate all components
	 */
	private void mainPanel() {
		JPanel mainPanel = new JPanel(new BorderLayout());
		emptyPanel();
		showColorPanel();
		showColorPickPanel();
		showInfoPanel();
		mainPanel.add(showInfoPanel, BorderLayout.EAST);
		mainPanel.add(showColorPanel, BorderLayout.WEST);
		mainPanel.add(colorPickPanel, BorderLayout.SOUTH);
		contentPane.add(mainPanel, BorderLayout.CENTER);
	}

	/**
	 * Integrate all JTextField components
	 * include: rgb, hsv, alph, hex components
	 */
	public void showInfoPanel() {
		showInfoPanel = new JPanel(new BorderLayout());
		showInfoPanel.setPreferredSize(new Dimension(385, 150));

		hsvPanelComponent = new HsvPanelComponent(this);
		rgbPanelComponent = new RgbPanelComponent(this);
		hexPanelComponent = new HexPanelComponent(this);
		alphPanelComponent = new AlphPanelComponent(this);

		JPanel showHexAndAlphaPanel = new JPanel(new BorderLayout());
		showHexAndAlphaPanel.setPreferredSize(new Dimension(285, 90));

		showHexAndAlphaPanel.add(hexPanelComponent.getShowHexPanel(), BorderLayout.SOUTH);
		showHexAndAlphaPanel.add(alphPanelComponent.getShowAlphPanel(), BorderLayout.NORTH);
		
		showInfoPanel.add(hsvPanelComponent.getShowHSVPanel(), BorderLayout.WEST);
		showInfoPanel.add(rgbPanelComponent.getShowRGBPanel(), BorderLayout.EAST);
		showInfoPanel.add(showHexAndAlphaPanel, BorderLayout.SOUTH);
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

	/**
	 * Used for layout, taking up some free space
	 */
	private void emptyPanel() {
		//East
		JPanel emptyPanel_4 = new JPanel();
		emptyPanel_4.setPreferredSize(new Dimension(10, 100));
		contentPane.add(emptyPanel_4, BorderLayout.EAST);
		
		//South
		JPanel emptyPanel_1 = new JPanel();
		emptyPanel_1.setPreferredSize(new Dimension(100, 10));
		contentPane.add(emptyPanel_1, BorderLayout.SOUTH);
		
		//North
		JPanel emptyPanel_2 = new JPanel();
		emptyPanel_2.setPreferredSize(new Dimension(100, 10));
		contentPane.add(emptyPanel_2, BorderLayout.NORTH);
		
		//West
		JPanel emptyPanel_3 = new JPanel();
		emptyPanel_3.setPreferredSize(new Dimension(10, 100));
		contentPane.add(emptyPanel_3, BorderLayout.WEST);
	}
}
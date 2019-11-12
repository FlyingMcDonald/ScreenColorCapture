package com.flyingmcdonald.screencolorcapture;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MainPanel extends JFrame {

	private boolean hexFlag = true;
	private boolean rgbFlag = true;
	private boolean hsbFlag = true;
	private boolean isPressed = true;
	private boolean mouseDragged = false;
	private boolean mouseClicked = false;
	private final int TEXT_LANGTH = 4;
	private float sliderCoordinate;
	
	private HSBInfo hsbInfo;
	private ColorInfoBean colorInfo = new ColorInfoBean();
	private HsvPalette hsvPalette;
	private HsvPalette_2 hsvPalette_2;
	private AlphSlider alphSlider;
	private ShowColorLabel showColorLabel;
	private final int WIDTH = 650;
	private final int HEIGHT = 320;
	private String JTitle = "Color Picker";
	
	private boolean isVisible = true;
	private boolean isResize = false;
	private JTextField showRedText;
	private JTextField showGreenText;
	private JTextField showBlueText;
	private JTextField showHexText;
	private JTextField showHueText;
	private JTextField showSaturationText;
	private JTextField showValueText;
	private JTextField showAlphText;
	private JLabel hexLabel;
	private JLabel redLabel;
	private JLabel greenLabel;
	private JLabel blueLabel;
	private JLabel hueLabel;
	private JLabel saturationLabel;
	private JLabel valueLabel;
	
	private JPanel redPanel;
	private JPanel greenPanel;
	private JPanel bluePanel;
	private JPanel huePanel;
	private JPanel saturationPanel;
	private JPanel valuePanel;
	private JPanel showInfoPanel;
	private JPanel showRGBPanel;
	private JPanel showHSVPanel;
	private JPanel showAlphaPanel;
	private JPanel showHexAndAlphaPanel;
	private JPanel showHexPanel;
	private JPanel showColorPanel;
	private JPanel mainPanel;
	private JButton exitBtn;
	private JButton colorPickBtn;

	private JPanel colorPickPanel;

	private JPanel emptyPanel_1;
	private JPanel emptyPanel_2;
	private JPanel emptyPanel_3;
	private JPanel emptyPanel_4;
	private JPanel emptyPanel_5;
	private Container contentPane;

	private ColorPickerFrame colorPickerFrame;
	private JLabel sliderLabel;

	
	
	

	public float getSliderCoordinate() {
		return sliderCoordinate;
	}

	public void setSliderCoordinate(float sliderCoordinate) {
		this.sliderCoordinate = sliderCoordinate;
	}

	public boolean isMouseDragged() {
		return mouseDragged;
	}

	public void setMouseDragged(boolean mouseDragged) {
		this.mouseDragged = mouseDragged;
	}

	public boolean isMouseClicked() {
		return mouseClicked;
	}

	public void setMouseClicked(boolean mouseClicked) {
		this.mouseClicked = mouseClicked;
	}

	public ColorPickerFrame getColorPickerFrame() {
		return colorPickerFrame;
	}

	public void setColorPickerFrame(ColorPickerFrame colorPickerFrame) {
		this.colorPickerFrame = colorPickerFrame;
	}

	public JTextField getShowRedText() {
		return showRedText;
	}

	public void setShowRedText(JTextField showRedText) {
		this.showRedText = showRedText;
	}

	public JTextField getShowGreenText() {
		return showGreenText;
	}

	public void setShowGreenText(JTextField showGreenText) {
		this.showGreenText = showGreenText;
	}

	public JTextField getShowBlueText() {
		return showBlueText;
	}

	public void setShowBlueText(JTextField showBlueText) {
		this.showBlueText = showBlueText;
	}

	public JTextField getShowHexText() {
		return showHexText;
	}

	public void setShowHexText(JTextField showHexText) {
		this.showHexText = showHexText;
	}
	
	public JTextField getShowHueText() {
		return showHueText;
	}

	public void setShowHueText(JTextField showHueText) {
		this.showHueText = showHueText;
	}

	public JTextField getShowSaturationText() {
		return showSaturationText;
	}

	public void setShowSaturationText(JTextField showSaturationText) {
		this.showSaturationText = showSaturationText;
	}

	public JTextField getShowValueText() {
		return showValueText;
	}

	public void setShowValueText(JTextField showValueText) {
		this.showValueText = showValueText;
	}

	public boolean isRgbFlag() {
		return rgbFlag;
	}

	public void setRgbFlag(boolean flag) {
		this.rgbFlag = flag;
	}

	public boolean isHexFlag() {
		return hexFlag;
	}

	public void setHexFlag(boolean hexFlag) {
		this.hexFlag = hexFlag;
	}

	public boolean isHsbFlag() {
		return hsbFlag;
	}

	public void setHsbFlag(boolean hsbFlag) {
		this.hsbFlag = hsbFlag;
	}
	
	

	public ShowColorLabel getShowColorLabel() {
		return showColorLabel;
	}

	public void setShowColorLabel(ShowColorLabel showColorLabel) {
		this.showColorLabel = showColorLabel;
	}

	public boolean isPressed() {
		return isPressed;
	}

	public void setPressed(boolean isPressed) {
		this.isPressed = isPressed;
	}
	
	

	public JTextField getShowAlphText() {
		return showAlphText;
	}

	public void setShowAlphText(JTextField showAlphText) {
		this.showAlphText = showAlphText;
	}



	/**
	 * @author FlyingMcDonald
	 */
	private static final long serialVersionUID = 1L;

	public MainPanel() {
		contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		mainPanel();
		this.setTitle(JTitle);
		this.setSize(WIDTH, HEIGHT);
		this.setResizable(isResize);
		this.setLocationRelativeTo(null);
		this.setVisible(isVisible);
	}

	private void mainPanel() {
		mainPanel = new JPanel(new BorderLayout());
		emptyPanel();
		showColorPanel();
		showColorPickPanel();
		showInfoPanel();
		mainPanel.add(showInfoPanel, BorderLayout.EAST);
		mainPanel.add(showColorPanel, BorderLayout.WEST);
		mainPanel.add(colorPickPanel, BorderLayout.SOUTH);
		contentPane.add(mainPanel, BorderLayout.CENTER);
	}

	public void showInfoPanel() {
		showInfoPanel = new JPanel(new BorderLayout());
		showInfoPanel.setPreferredSize(new Dimension(385, 150));
		
		showRGBPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		showRGBPanel.setPreferredSize(new Dimension(170, 80));

		
		showHSVPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		showHSVPanel.setPreferredSize(new Dimension(212, 80));
		
		showHexAndAlphaPanel = new JPanel(new BorderLayout());
		showHexAndAlphaPanel.setPreferredSize(new Dimension(285, 90));
		
		showAlphaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		showAlphaPanel.setPreferredSize(new Dimension(285, 35));
		
		showHexPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		showHexPanel.setPreferredSize(new Dimension(285, 55));
		
		sliderLabel = new JLabel("Opacity:    ");
		alphSlider = new AlphSlider();
		alphSlider.setPreferredSize(new Dimension(188, 14));
		alphSlider.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int sliderMidOfCircled = getSliderMidOfCirCled(e.getX());
				if(sliderMidOfCircled >=0 && sliderMidOfCircled <=160) {
					setAlphTextByMouseDragged(sliderMidOfCircled);
					alphSlider.setSliderMidOfCircled(sliderMidOfCircled);
				}
				alphSlider.repaint();
			}
		});
		alphSlider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int sliderMidOfCircled = alphSlider.getSliderMidOfCircled();
				String[] alphText = {getShowAlphText().getText()};
				String[] alphText_2 = Utils.checkContent(alphText);
				if(e.getX() < sliderMidOfCircled) {
					setSliderCoordinate(setAlphTextByMouseClicked(sliderMidOfCircled, alphText_2[0])); 
					setSliderMidOfCircled(getSliderCoordinate());
				}else if(e.getX() > sliderMidOfCircled){
					setMouseClicked(true);
					setSliderCoordinate(setAlphTextByMouseClicked(sliderMidOfCircled, alphText_2[0])); 
					setSliderMidOfCircled(getSliderCoordinate());
					setMouseClicked(false);
				}
				alphSlider.repaint();
			}
		});
	
		hueLabel = new JLabel("Hue:        ");
		saturationLabel = new JLabel("Saturation: ");
		valueLabel = new JLabel("Value:      ");

		redLabel = new JLabel("Red:");
		greenLabel = new JLabel("Green:");
		blueLabel = new JLabel("Blue:");
		hexLabel = new JLabel("Hex: ");
		
		setFonts(sliderLabel);
		setFonts(hueLabel);
		setFonts(saturationLabel);
		setFonts(valueLabel);
		setFonts(redLabel);
		setFonts(greenLabel);
		setFonts(blueLabel);
		setFonts(hexLabel);
		
		showHueText = new JTextField("0", TEXT_LANGTH);
		showHueText.getDocument().addDocumentListener(new HSBListener(this));
		showHueText.addKeyListener(new HSBListener(this));
		
		
		showSaturationText = new JTextField("0", TEXT_LANGTH);
		showSaturationText.getDocument().addDocumentListener(new HSBListener(this));
		showSaturationText.addKeyListener(new HSBListener(this));
		
		showValueText = new JTextField("100", TEXT_LANGTH);
		showValueText.getDocument().addDocumentListener(new HSBListener(this));
		showValueText.addKeyListener(new HSBListener(this));

		showRedText = new JTextField("255", TEXT_LANGTH);
		showRedText.getDocument().addDocumentListener(new RGBAListener(this));
		showRedText.addKeyListener(new RGBAListener(this));

		showGreenText = new JTextField("255", TEXT_LANGTH);
		showGreenText.getDocument().addDocumentListener(new RGBAListener(this));
		showGreenText.addKeyListener(new RGBAListener(this));

		showBlueText = new JTextField("255", TEXT_LANGTH);
		showBlueText.getDocument().addDocumentListener(new RGBAListener(this));
		showBlueText.addKeyListener(new RGBAListener(this));

		showHexText = new JTextField("#FFFFFFFF", 11);
		showHexText.getDocument().addDocumentListener(new HexListener(this));
		
		showAlphText = new JTextField("255", TEXT_LANGTH);
		showAlphText.getDocument().addDocumentListener(new RGBAListener(this, alphSlider));
		showAlphText.addKeyListener(new RGBAListener(this, alphSlider));
		
		huePanel = new JPanel();
		saturationPanel = new JPanel();
		valuePanel = new JPanel();
		
		redPanel = new JPanel();
		greenPanel = new JPanel();
		bluePanel = new JPanel();
		
		
		huePanel.add(hueLabel);
		huePanel.add(showHueText);
		
		saturationPanel.add(saturationLabel);
		saturationPanel.add(showSaturationText);
		
		valuePanel.add(valueLabel);
		valuePanel.add(showValueText);
		
		showHexPanel.add(hexLabel);
		showHexPanel.add(showHexText);
		
		showAlphaPanel.add(sliderLabel);
		showAlphaPanel.add(alphSlider);
		showAlphaPanel.add(showAlphText);

		redPanel.add(redLabel);
		redPanel.add(showRedText);

		greenPanel.add(greenLabel);
		greenPanel.add(showGreenText);

		bluePanel.add(blueLabel);
		bluePanel.add(showBlueText);
		
		showHSVPanel.add(huePanel);
		showHSVPanel.add(saturationPanel);
		showHSVPanel.add(valuePanel);
		
		
		showRGBPanel.add(redPanel);
		showRGBPanel.add(greenPanel);
		showRGBPanel.add(bluePanel);
		
		showHexAndAlphaPanel.add(showHexPanel, BorderLayout.SOUTH);
		showHexAndAlphaPanel.add(showAlphaPanel, BorderLayout.NORTH);
		
		showInfoPanel.add(showHSVPanel, BorderLayout.WEST);
		showInfoPanel.add(showRGBPanel, BorderLayout.EAST);
		showInfoPanel.add(showHexAndAlphaPanel, BorderLayout.SOUTH);

	}

	private void showColorPanel() {
		showColorPanel = new JPanel(new FlowLayout(0, 5, 0));
		showColorPanel.setPreferredSize(new Dimension(232, 220));
		
		hsvPalette = new HsvPalette();
		Cursor cursor = new Cursor(Cursor.CROSSHAIR_CURSOR);
		Cursor cursorReset = new Cursor(Cursor.DEFAULT_CURSOR);
		hsvPalette.setPreferredSize(new Dimension(202, 202));
		
		hsvPalette.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				hsvPalette.setCursor(cursor);
				getColorInfo(e.getX(), e.getY());
				colorToHSB(e.getX(), e.getY());
			}
		});
		hsvPalette.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(isPressed) {
					hsvPalette.setCursor(cursor);
					getColorInfo(e.getX(), e.getY());
					colorToHSB(e.getX(), e.getY());
				}
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				hsvPalette.setCursor(cursorReset);
			}
		});
		
		
		hsvPalette_2 = new HsvPalette_2();
		hsvPalette_2.setPreferredSize(new Dimension(14, 216));
		
		hsvPalette_2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				getMidOfCircled(e.getY());
				changeHSVPaletteColor(hsvPalette_2.getMidOfCircled());
				colorToHSB(hsvPalette.getVerticalX(), hsvPalette.getHorizontalY());
			}
		});
		hsvPalette_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getMidOfCircled(e.getY());
				changeHSVPaletteColor(hsvPalette_2.getMidOfCircled());
				colorToHSB(hsvPalette.getVerticalX(), hsvPalette.getHorizontalY());
			}
		});
		
		
		showColorPanel.add(hsvPalette_2);
		showColorPanel.add(hsvPalette);
	}

	private void showColorPickPanel() {
		colorPickPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 10));
		colorPickPanel.setPreferredSize(new Dimension(200, 50));
		showColorLabel = new ShowColorLabel();
		showColorLabel.setPreferredSize(new Dimension(155, 33));
		showColorLabel.setBackground(colorInfo.getPickedColor());
		exitBtn = new JButton("EXIT");
		exitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		colorPickBtn = new JButton("Color Pick");
		colorPickBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openColorPickerFrame();
			}
		});

		emptyPanel_5 = new JPanel();
		emptyPanel_5.setPreferredSize(new Dimension(150, 30));

		colorPickPanel.add(showColorLabel);
		colorPickPanel.add(colorPickBtn);
		colorPickPanel.add(emptyPanel_5);
		colorPickPanel.add(exitBtn);
	}

	private void openColorPickerFrame() {	//打开子窗口
		colorPickerFrame = new ColorPickerFrame();
		colorPickerFrame.setMainPanel(this);	//将当前窗口作为参数传进子窗口
		colorPickerFrame.showPanel();
	}

	private void emptyPanel() {//用于布局，占用一些空白空间
		
		//东
		emptyPanel_4 = new JPanel();
		emptyPanel_4.setPreferredSize(new Dimension(10, 100));
		contentPane.add(emptyPanel_4, BorderLayout.EAST);
		
		//南
		emptyPanel_1 = new JPanel();
		emptyPanel_1.setPreferredSize(new Dimension(100, 10));
		contentPane.add(emptyPanel_1, BorderLayout.SOUTH);

		
		//北
		emptyPanel_2 = new JPanel();
		emptyPanel_2.setPreferredSize(new Dimension(100, 10));
		contentPane.add(emptyPanel_2, BorderLayout.NORTH);
		
		//西
		emptyPanel_3 = new JPanel();
		emptyPanel_3.setPreferredSize(new Dimension(10, 100));
		contentPane.add(emptyPanel_3, BorderLayout.WEST);
	}

	private void setFonts(JLabel textField) {//字体设置
		textField.setFont(new Font("Hack", Font.PLAIN, 16));
	}
	
	/**
	 * 改变hsvPalette中的Hue值
	 * 
	 * @param y
	 */
	private void changeHSVPaletteColor(int y) {
		if(y > 201 || y < 0) {
			y = y > 201 ? 201 : 0;
		}
		float coordinateY = (float) y;
		hsvPalette.setHue(coordinateY/201f);
		hsvPalette.repaint();
	}
	
	/**
	 * 将hsvPalette两条线的交叉点的坐标所在HSB值转换成RGB值
	 * 
	 * @param x
	 * @param y
	 */
	private void colorToHSB(int x, int y) {
		int h = (int) (hsvPalette.getHue() * 100 + 0.5f);
		int[] coordinates = checkCoordinates(x, y);
		hsvPalette.setCoordinateX(coordinates[0]);
		hsvPalette.setCoordinateY(coordinates[1]);
		int s = (int) ((float) (1 - hsvPalette.getCoordinateY() / 201f) * 100 + 0.5f);
		int v = (int) ((float) hsvPalette.getCoordinateX() / 201f * 100 + 0.5f);
		int[] hsb = {h, s, v};
		hsbInfo = new HSBInfo(this);
		hsbInfo.setHSBText(hsb,  hsbInfo.HSBTextObj());
	}
	
	/**
	 * 获取hsvPalette中横线的Y坐标，竖线的X坐标
	 * 
	 * @param x
	 * @param y
	 */
	private void getColorInfo(int x, int y) {
		int[] coordinates = checkCoordinates(x, y);
		hsvPalette.setHorizontalY(coordinates[1]);
		hsvPalette.setVerticalX(coordinates[0]);
		hsvPalette.repaint();
	}
	
	/**
	 * 检测光标是否超出面板范围
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	private int[] checkCoordinates(int x, int y) {
		int[] coordinates = new int[2];
		if(x > 201 || x < 0) {
			x = x > 201 ? 201 : 0; 
		}
		if(y > 201 || y < 0) {
			y = y > 201 ? 201 : 0; 
		}
		coordinates[0] = x;
		coordinates[1] = y;
		return coordinates;
	}
	
	/**
	 * 设置圆心的位置
	 * 
	 * @param y
	 */
	private void getMidOfCircled(int y) {
		int midOfCircled = y;
		if(midOfCircled > 6 && midOfCircled < 207) {
			midOfCircled = y - hsvPalette_2.getCIRCLED_R();
		}else {
			midOfCircled = midOfCircled > 201 ? 201 : 0;
		}
		hsvPalette_2.setMidOfCircled(midOfCircled);
		hsvPalette_2.repaint();
	}
	
	
	/**
	 * 获取Alph滑块圆形图标圆心的坐标
	 * 
	 * @param x
	 * @return
	 */
	private int getSliderMidOfCirCled(int x) {
		int sliderMidOfCircled = x;
		if(sliderMidOfCircled > 6 && sliderMidOfCircled < 167) {
			sliderMidOfCircled = x - alphSlider.getCIRCLED_R();
		}else {
			sliderMidOfCircled = sliderMidOfCircled > 160 ? 160 : 0;
		}
		return sliderMidOfCircled;
	}
	
	/**
	 * 根据鼠标拖拽圆心所经过的滑块的长度来显示Alph的值
	 * 
	 * @param sliderMidOfCircled
	 */
	private void setAlphTextByMouseDragged(int sliderMidOfCircled) {
			float avage = 255 / 160f;
			int alphTextValue = (int) (sliderMidOfCircled * avage);
			this.getShowAlphText().setText(""+alphTextValue);
	}
	
	/**
	 * 当光标坐标大于圆心坐标时，每点击一次鼠标alph将会减一
	 * 当光标坐标小于圆心坐标时，每点击一次鼠标alph将会加一
	 * 
	 * @param sliderMidOfCircledCoordinate
	 * @param alphText
	 * @return
	 */
	private float setAlphTextByMouseClicked(float sliderMidOfCircledCoordinate, String alphText) {
		float avage = 160 / 255f;
		int alphTextValue = Utils.toInt(alphText);
		if(this.isMouseClicked()) {
			this.getShowAlphText().setText(""+(alphTextValue + 1));
			this.setSliderCoordinate(sliderMidOfCircledCoordinate + avage);
		}else {
			this.getShowAlphText().setText(""+(alphTextValue - 1));
			this.setSliderCoordinate(sliderMidOfCircledCoordinate - avage);
		}
		return avage*alphTextValue;
	}
	
	/**
	 * 设置滑块圆心中心坐标
	 * 
	 * @param sliderMidOfCircled
	 */
	private void setSliderMidOfCircled(float sliderMidOfCircled) {
		alphSlider.setSliderMidOfCircled((int)sliderMidOfCircled);
	}
}
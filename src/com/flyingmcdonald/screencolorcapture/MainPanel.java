package com.flyingmcdonald.screencolorcapture;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MainPanel extends JFrame implements DocumentListener {

	ColorInfoBean colorInfo = new ColorInfoBean();

	private final int WIDTH = 600;
	private final int HEIGHT = 330;
	private String JTitle = "Color Picker";
	private String patternStr = "^[0-9]*$";
	private boolean isVisible = true;
	private boolean isResize = false;
	private JTextField showRedText;
	private JTextField showGreenText;
	private JTextField showBlueText;
	private JTextField showHexText;
	private JLabel hexLabel;
	private JLabel hexPromptLabel;
	private JLabel redLabel;
	private JLabel redPromptLabel;
	private JLabel greenLabel;
	private JLabel greenPromptLabel;
	private JLabel blueLabel;
	private JLabel bluePromptLabel;
	private JPanel hexPanel;
	private JPanel redPanel;
	private JPanel greenPanel;
	private JPanel bluePanel;
	private JPanel showInfoPanel;

	private JLabel colorLabel;

	private JPanel showColorPanel;
	private JTextField showColorText;
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

	public JTextField getShowColorText() {
		return showColorText;
	}

	public void setShowColorText(JTextField showColorText) {
		this.showColorText = showColorText;
	}

	/**
	 * 
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
		showInfoPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 8));
		showInfoPanel.setPreferredSize(new Dimension(240, 200));

		redPromptLabel = new JLabel();
		redPromptLabel.setPreferredSize(new Dimension(110, 20));

		greenPromptLabel = new JLabel();
		greenPromptLabel.setPreferredSize(new Dimension(110, 20));

		bluePromptLabel = new JLabel();
		bluePromptLabel.setPreferredSize(new Dimension(110, 20));

		hexPromptLabel = new JLabel();
		hexPromptLabel.setPreferredSize(new Dimension(110, 20));

		redLabel = new JLabel("Red");
		greenLabel = new JLabel("Green");
		blueLabel = new JLabel("Blue");
		hexLabel = new JLabel("Hex");
		setFonts(redLabel);
		setFonts(greenLabel);
		setFonts(blueLabel);
		setFonts(hexLabel);

		showRedText = new JTextField("255", 8);
		showRedText.getDocument().addDocumentListener(this);

		showGreenText = new JTextField("255", 8);
		showGreenText.getDocument().addDocumentListener(this);

		showBlueText = new JTextField("255", 8);
		showBlueText.getDocument().addDocumentListener(this);

		showHexText = new JTextField("#FFFFFF", 8);
		showHexText.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (e.getDocument().getLength() != 0) {
					setColorByHex();
				}
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				setColorByHex();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				setColorByHex();
			}
		});

		setFonts(showRedText);
		setFonts(showGreenText);
		setFonts(showBlueText);
		setFonts(showHexText);

		redPanel = new JPanel();
		greenPanel = new JPanel();
		bluePanel = new JPanel();
		hexPanel = new JPanel();

		hexPanel.add(hexLabel);
		hexPanel.add(showHexText);
		hexPanel.add(hexPromptLabel);

		redPanel.add(redLabel);
		redPanel.add(showRedText);
		redPanel.add(redPromptLabel);

		greenPanel.add(greenLabel);
		greenPanel.add(showGreenText);
		greenPanel.add(greenPromptLabel);

		bluePanel.add(blueLabel);
		bluePanel.add(showBlueText);
		bluePanel.add(bluePromptLabel);

		showInfoPanel.add(hexPanel);
		showInfoPanel.add(redPanel);
		showInfoPanel.add(greenPanel);
		showInfoPanel.add(bluePanel);

		//showInfoPanel.setBorder(BorderFactory.createLineBorder(Color.black));

	}

	private void showColorPanel() {
		showColorPanel = new JPanel();
		showColorPanel.setPreferredSize(new Dimension(200, 100));
		colorLabel = new JLabel();
		colorLabel.setText("这块以后是个调色板");
		setFonts(colorLabel);
		showColorPanel.add(colorLabel);
		showColorPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
	}

	private void showColorPickPanel() {
		colorPickPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 10));
		colorPickPanel.setPreferredSize(new Dimension(100, 50));
		//colorPickPanel.setBorder(BorderFactory.createLineBorder(Color.red));

		showColorText = new JTextField();
		showColorText.setPreferredSize(new Dimension(100, 30));
		showColorText.setEditable(false);
		showColorText.setBackground(colorInfo.getPickedColor());

		
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

		colorPickPanel.add(showColorText);
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
		
		//南
		emptyPanel_1 = new JPanel();
		emptyPanel_1.setPreferredSize(new Dimension(100, 30));
		//emptyPanel_1.setBorder(BorderFactory.createLineBorder(Color.yellow));
		contentPane.add(emptyPanel_1, BorderLayout.SOUTH);

		
		//北
		emptyPanel_2 = new JPanel();
		emptyPanel_2.setPreferredSize(new Dimension(100, 50));
		//emptyPanel_2.setBorder(BorderFactory.createLineBorder(Color.yellow));
		contentPane.add(emptyPanel_2, BorderLayout.NORTH);
		
		//西
		emptyPanel_3 = new JPanel();
		emptyPanel_3.setPreferredSize(new Dimension(20, 100));
		//emptyPanel_3.setBorder(BorderFactory.createLineBorder(Color.PINK));
		contentPane.add(emptyPanel_3, BorderLayout.WEST);
		
		//东
		emptyPanel_4 = new JPanel();
		emptyPanel_4.setPreferredSize(new Dimension(20, 100));
		//emptyPanel_4.setBorder(BorderFactory.createLineBorder(Color.PINK));
		contentPane.add(emptyPanel_4, BorderLayout.EAST);
	}

	private void setFonts(JLabel textField) {//字体设置
		textField.setFont(new Font("黑体", Font.BOLD, 12));
	}

	private void setFonts(JTextField JText) {
		JText.setFont(new Font("Hack", Font.PLAIN, 14));
	}

	
	
	@Override
	public void insertUpdate(DocumentEvent e) {
		setColorByRGB();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		if (e.getDocument().getLength() != 0) {
			setColorByRGB();
		}
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		setColorByRGB();
	}

	private void setColorByRGB() {	//根据RGB三个文本框的值显示showColorText的颜色
		Color textColor = new Color(255, 255, 255);
		String redText = getShowRedText().getText();

		String greenText = getShowGreenText().getText();

		String blueText = getShowBlueText().getText();

		String hexText = getShowHexText().getText();
		
		//判断非法字符
		if (!checkChar(redText, patternStr) && !checkChar(greenText, patternStr)
				&& !checkChar(blueText, patternStr)) {
			int Red = Utils.toInt(redText);
			int Green = Utils.toInt(greenText);
			int Blue = Utils.toInt(blueText);

			if ((Red <= 255) && (Red >= 0)) {
				setInfo(redPromptLabel, "");
			} else {
				setInfo(redPromptLabel, "* 取值范围：0～255");
			}

			if ((Green <= 255) && (Green >= 0)) {
				setInfo(greenPromptLabel, "");
			} else {
				setInfo(greenPromptLabel, "* 取值范围：0～255");
			}

			if ((Blue <= 255) && (Blue >= 0)) {
				setInfo(bluePromptLabel, "");
			} else {
				setInfo(bluePromptLabel, "* 取值范围：0～255");
			}

			if ((Red <= 255) && (Red >= 0) && (Green <= 255) && (Green >= 0) && (Blue <= 255) && (Blue >= 0)) {
				if (!hexText.equals(Utils.toHexString(Red, Green, Blue))) {
					showHexText.setText(Utils.toHexString(Red, Green, Blue));
				}
				textColor = new Color(Red, Green, Blue);
			}

			getShowColorText().setBackground(textColor);
		} else {
			
			if (checkChar(redText, patternStr)) {
				setInfo(redPromptLabel, "YYF说:F");
			}
			
			if (checkChar(greenText, patternStr)) {
				setInfo(greenPromptLabel, "YYF说:K");
			}
			
			if (checkChar(blueText, patternStr)) {
				setInfo(bluePromptLabel, "YYF说:U");
			}
		}

	}

	private void setInfo(JLabel infoLabel, String info) {	//提示框信息
		infoLabel.setText(info);
		infoLabel.setForeground(Color.RED);
	}

	private void setColorByHex() {	//根据Hex更新showColorText颜色
		String str = getShowHexText().getText();
		String pattern = "^[#][A-Fa-f0-9]{6}$";

		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(str);
		if (m.matches()) {
			Map<String, Integer> colorRGB = Utils.toRGB(str);
			setRGBText("" + colorRGB.get("colorRed"), getShowRedText());
			setRGBText("" + colorRGB.get("colorGreen"), getShowGreenText());
			setRGBText("" + colorRGB.get("colorBlue"), getShowBlueText());
			setInfo(hexPromptLabel, "");
		}else {
			setInfo(hexPromptLabel, "求你找个BUG出来");
		}

	}

	protected void setRGBText(String text, JTextField textField) {	//用于判断RGB JTextField内容与Text是否一致
		if (!textField.getText().equals(text)) {
			textField.setText(text);
		}
	}

	private boolean setPattern(String str, String pattern) {	//正则判断
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(str);
		return m.matches();
	}

	private boolean checkChar(String str, String pattern) {	//非法字符判断
		boolean isChar = true;
		if (setPattern(str, pattern)) {
			isChar = false;
		}
		return isChar;
	}
}

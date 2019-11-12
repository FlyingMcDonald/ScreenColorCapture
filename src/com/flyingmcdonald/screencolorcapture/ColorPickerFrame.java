package com.flyingmcdonald.screencolorcapture;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ColorPickerFrame {
	private MainPanel mainPanel;
	final private Color rgba0 = new Color(255, 255, 255, 0);
	private Container container;
	private JFrame colorPickerFrame;

	public MainPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}
	
	public ColorPickerFrame() {
		
	}
	
	public void showPanel() {
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();	//获取当前屏幕设备大小
		colorPickerFrame = new JFrame();
		colorPickerFrame.setBounds(0, -1, (int)screensize.getWidth(), (int)screensize.getHeight()+1);//这里为什么要这么搞呢？自己运行一下就知道了
		colorPickerFrame.setUndecorated(true);	//无标题栏
		colorPickerFrame.setBackground(rgba0);
		colorPickerFrame.setResizable(false);	//在i3wm环境下这样做能将窗口浮动，不会并行平铺
		container= colorPickerFrame.getContentPane();
		container.setLayout(new BorderLayout());
		JLabel jl = new JLabel();
		jl.setBackground(rgba0);
		container.add(jl, BorderLayout.CENTER);
		
		Cursor cursor = new Cursor(Cursor.CROSSHAIR_CURSOR);	//光标样式
		container.setCursor(cursor);
		colorPickerFrame.setVisible(true);
		colorPickerFrame.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				colorPick(e.getX(), e.getY());
			}
		});
		colorPickerFrame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				colorPick(e.getX(), e.getY());
				colorPickerFrame.dispose();
			}
		});
	}
	
	private void colorPick(int x, int y) {
		try {
			Robot robot = new Robot();
			//获取当前像素颜色RGB值
			Color color = robot.getPixelColor(x, y);
			ColorInfoBean colorInfo = new ColorInfoBean();
			colorInfo.setRedVal(color.getRed());
			colorInfo.setGreenVal(color.getGreen());
			colorInfo.setBlueVal(color.getBlue());
			mainPanel.getShowRedText().setText(""+colorInfo.getRedVal());
			mainPanel.getShowGreenText().setText(""+colorInfo.getGreenVal());
			mainPanel.getShowBlueText().setText(""+colorInfo.getBlueVal());
			colorInfo.setPickedColor(new Color(Utils.toInt(mainPanel.getShowRedText().getText()),
					Utils.toInt(mainPanel.getShowGreenText().getText()), 
					Utils.toInt(mainPanel.getShowBlueText().getText())));
		} catch (AWTException e1) {
			e1.printStackTrace();
		}
	}
	
}

package com.flyingmcdonald.screencolorcapture.panelcompenents;

import com.flyingmcdonald.screencolorcapture.MainPanel;
import com.flyingmcdonald.screencolorcapture.eventslistener.colorpicklistener.ColorPickMouseListener;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ColorPickFrame {
    private MainPanel mainPanel;

    public MainPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public ColorPickFrame() {

    }

    public void colorPick() {
        mainPanel.setVisible(false);
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();	//获取当前屏幕设备大小
        Cursor cursor = new Cursor(Cursor.CROSSHAIR_CURSOR);	//光标样式
        JFrame colorPickerFrame = new JFrame();
        colorPickerFrame.setUndecorated(true);	//无标题栏
        colorPickerFrame.getContentPane().setCursor(cursor);
        colorPickerFrame.setBounds(0, 0, screensize.width, screensize.height);
        colorPickerFrame.setResizable(false);
        colorPickerFrame.setVisible(true);
        colorPickerFrame.setOpacity(0.01f);
        colorPickerFrame.addMouseListener(new ColorPickMouseListener(this.mainPanel, colorPickerFrame));
        colorPickerFrame.addMouseMotionListener(new ColorPickMouseListener(this.mainPanel, colorPickerFrame));
    }
}

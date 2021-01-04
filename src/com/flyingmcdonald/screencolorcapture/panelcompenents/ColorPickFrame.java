package com.flyingmcdonald.screencolorcapture.panelcompenents;

import com.flyingmcdonald.screencolorcapture.MainPanel;
import com.flyingmcdonald.screencolorcapture.eventslistener.colorpicklistener.ColorPickMouseListener;

import javax.swing.*;
import java.awt.*;

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

    public void colorPick(){
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();	//获取当前屏幕设备大小
        JFrame colorPickerFrame = new JFrame();
        colorPickerFrame.setBounds(0, -1, (int)screensize.getWidth(), (int)screensize.getHeight()+1);//这里为什么要这么搞呢？自己运行一下就知道了
        colorPickerFrame.setUndecorated(true);	//无标题栏
        colorPickerFrame.setBackground(new Color(255, 255, 255, 0));
//        colorPickerFrame.setResizable(false);	//在i3wm环境下这样做能将窗口浮动，不会并行平铺
        Container container = colorPickerFrame.getContentPane();
//        container.setLayout(new BorderLayout());
        JLabel jl = new JLabel();
        jl.setBackground(new Color(255, 255, 255, 0));
        container.add(jl, BorderLayout.CENTER);
        Cursor cursor = new Cursor(Cursor.CROSSHAIR_CURSOR);	//光标样式
        container.setCursor(cursor);
        colorPickerFrame.setVisible(true);
        colorPickerFrame.setAlwaysOnTop(true);
        colorPickerFrame.addMouseListener(new ColorPickMouseListener(this.mainPanel, colorPickerFrame));
        colorPickerFrame.addMouseMotionListener(new ColorPickMouseListener(this.mainPanel, colorPickerFrame));
    }
}

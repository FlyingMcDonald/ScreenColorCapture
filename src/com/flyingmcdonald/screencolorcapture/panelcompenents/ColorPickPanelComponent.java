package com.flyingmcdonald.screencolorcapture.panelcompenents;

import com.flyingmcdonald.screencolorcapture.MainPanel;

import javax.swing.*;
import java.awt.*;

public class ColorPickPanelComponent {
    private JPanel colorPickPanel;
    private ShowColorLabelComponent showColorLabelComponent;
    private JButton exitBtn;
    private JButton colorPickBtn;
    private JPanel emptyPanel;
    private MainPanel mainPanel;

    public MainPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public ShowColorLabelComponent getShowColorLabelComponent() {
        return showColorLabelComponent;
    }

    public JPanel getColorPickPanel() {
        return colorPickPanel;
    }

    public ColorPickPanelComponent(MainPanel mainPanel){
        this.setMainPanel(mainPanel);
        panelComponent();
        labelComponent();
        buttonComponent();
        eventsListener();
        integrateComponent();
    }

    public void integrateComponent(){
        colorPickPanel.add(showColorLabelComponent);
        colorPickPanel.add(colorPickBtn);
        colorPickPanel.add(emptyPanel);
        colorPickPanel.add(exitBtn);
    }

    public void panelComponent(){
        colorPickPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 10));
        colorPickPanel.setPreferredSize(new Dimension(200, 50));

        emptyPanel = new JPanel();
        emptyPanel.setPreferredSize(new Dimension(150, 30));
    }

    public void labelComponent(){
        showColorLabelComponent = new ShowColorLabelComponent();
        showColorLabelComponent.setPreferredSize(new Dimension(155, 33));
    }

    public void buttonComponent(){
        exitBtn = new JButton("EXIT");
        colorPickBtn = new JButton("Color Pick");
    }

    public void eventsListener(){
        exitBtn.addActionListener(e -> System.exit(0));
        colorPickBtn.addActionListener(e -> {
            try {
                openColorPickerFrame();
            } catch (AWTException awtException) {
                awtException.printStackTrace();
            }
        });
    }

    private void openColorPickerFrame() throws AWTException {	//打开子窗口
        ColorPickFrame colorPickFrame = new ColorPickFrame();
        colorPickFrame.setMainPanel(this.mainPanel);//将当前窗口作为参数传进子窗口
        colorPickFrame.colorPick();
    }
}
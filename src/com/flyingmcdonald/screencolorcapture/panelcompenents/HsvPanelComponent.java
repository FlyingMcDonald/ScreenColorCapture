package com.flyingmcdonald.screencolorcapture.panelcompenents;

import com.flyingmcdonald.screencolorcapture.MainPanel;
import com.flyingmcdonald.screencolorcapture.Utils;
import com.flyingmcdonald.screencolorcapture.eventslistener.hsvlistener.HsvDocumentListener;
import com.flyingmcdonald.screencolorcapture.eventslistener.hsvlistener.HsvFocusListener;

import javax.swing.*;
import java.awt.*;

public class HsvPanelComponent {
    private JPanel showHSVPanel;
    private JPanel huePanel;
    private JPanel saturationPanel;
    private JPanel valuePanel;
    private JTextField showHueText;
    private JTextField showSaturationText;
    private JTextField showValueText;
    private JLabel saturationLabel;
    private JLabel hueLabel;
    private JLabel valueLabel;
    private MainPanel mainPanel;

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JPanel getShowHSVPanel() {
        return showHSVPanel;
    }

    public JTextField getShowHueText() {
        return showHueText;
    }

    public JTextField getShowSaturationText() {
        return showSaturationText;
    }

    public JTextField getShowValueText() {
        return showValueText;
    }

    public HsvPanelComponent(MainPanel mainPanel){
        this.setMainPanel(mainPanel);
        initPanelAndComponent();
        startEventsListener();
        Utils.integrateComponent(showHSVPanel, huePanel, saturationPanel, valuePanel,
                hueLabel, showHueText, saturationLabel, showSaturationText,
                valueLabel, showValueText);
        addBorder();
    }

    /**
     * 初始化面板和控件
     */
    private void initPanelAndComponent(){
        showHSVPanel = new JPanel();
        showHSVPanel.setBounds(0, 0, 180, 110);

        huePanel = new JPanel(null);
        huePanel.setPreferredSize(new Dimension(180, 30));

        hueLabel = new JLabel("Hue:");
        Utils.setFonts(hueLabel);
        hueLabel.setBounds(20, 5, 40, 20);

        showHueText = new JTextField("0", 4);
        showHueText.setBounds(110, 6, 60, 20);

        saturationPanel = new JPanel(null);
        saturationPanel.setPreferredSize(new Dimension(180, 30));

        saturationLabel = new JLabel("Saturation:");
        Utils.setFonts(saturationLabel);
        saturationLabel.setBounds(0, 5, 80, 20);

        showSaturationText = new JTextField("0", 4);
        showSaturationText.setBounds(110,6,60,20);

        valuePanel = new JPanel(null);
        valuePanel.setPreferredSize(new Dimension(180, 30));

        valueLabel = new JLabel("Value:");
        Utils.setFonts(valueLabel);
        valueLabel.setBounds(15, 5, 50, 20);

        showValueText = new JTextField("100", 4);
        showValueText.setBounds(110, 6, 60, 20);
    }

    /**
     * 添加文本框事件监听器
     */
    public void startEventsListener(){
        showHueText.getDocument().addDocumentListener(new HsvDocumentListener(this.mainPanel));
        showHueText.addFocusListener(new HsvFocusListener(this.mainPanel));

        showSaturationText.getDocument().addDocumentListener(new HsvDocumentListener(this.mainPanel));
        showSaturationText.addFocusListener(new HsvFocusListener(this.mainPanel));

        showValueText.getDocument().addDocumentListener(new HsvDocumentListener(this.mainPanel));
        showValueText.addFocusListener(new HsvFocusListener(this.mainPanel));
    }

    /**
     * 为 JPanel 和 Component 添加 Border
     */
    private void addBorder(){
        huePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        saturationPanel.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
        valueLabel.setBorder(BorderFactory.createLineBorder(Color.cyan));
        saturationLabel.setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
    }
}
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

    public JLabel getSaturationLabel() {
        return saturationLabel;
    }

    public JLabel getHueLabel() {
        return hueLabel;
    }

    public JLabel getValueLabel() {
        return valueLabel;
    }


    public HsvPanelComponent(MainPanel mainPanel){
        this.setMainPanel(mainPanel);
        labelComponent();
        jTextFieldComponent();
        startEventsListener();
        addLabelAndJTextFieldComponent();
        integrateComponent();
    }

    private void integrateComponent(){
        showHSVPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        showHSVPanel.setPreferredSize(new Dimension(212, 80));
        showHSVPanel.add(this.huePanel);
        showHSVPanel.add(this.saturationPanel);
        showHSVPanel.add(this.valuePanel);
    }
    private void labelComponent(){
        this.hueLabel = new JLabel("Hue:        ");
        Utils.setFonts(hueLabel);

        this.saturationLabel = new JLabel("Saturation: ");
        Utils.setFonts(saturationLabel);

        this.valueLabel = new JLabel("Value:      ");
        Utils.setFonts(valueLabel);
    }

    private void jTextFieldComponent(){
        int TEXT_LANGTH = 4;
        showHueText = new JTextField("0", TEXT_LANGTH);
        showSaturationText = new JTextField("0", TEXT_LANGTH);
        showValueText = new JTextField("100", TEXT_LANGTH);
    }

    public void startEventsListener(){
        showHueText.getDocument().addDocumentListener(new HsvDocumentListener(this.mainPanel));
        showHueText.addFocusListener(new HsvFocusListener(this.mainPanel));

        showSaturationText.getDocument().addDocumentListener(new HsvDocumentListener(this.mainPanel));
        showSaturationText.addFocusListener(new HsvFocusListener(this.mainPanel));

        showValueText.getDocument().addDocumentListener(new HsvDocumentListener(this.mainPanel));
        showValueText.addFocusListener(new HsvFocusListener(this.mainPanel));
    }

    private void addLabelAndJTextFieldComponent(){
        huePanel = new JPanel();
        huePanel.add(this.getHueLabel());
        huePanel.add(this.getShowHueText());

        saturationPanel = new JPanel();
        saturationPanel.add(this.getSaturationLabel());
        saturationPanel.add(this.getShowSaturationText());

        valuePanel = new JPanel();
        valuePanel.add(this.getValueLabel());
        valuePanel.add(this.getShowValueText());
    }
}

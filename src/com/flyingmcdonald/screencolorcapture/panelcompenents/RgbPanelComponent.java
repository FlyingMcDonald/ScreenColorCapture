package com.flyingmcdonald.screencolorcapture.panelcompenents;

import com.flyingmcdonald.screencolorcapture.MainPanel;
import com.flyingmcdonald.screencolorcapture.Utils;
import com.flyingmcdonald.screencolorcapture.eventslistener.rgblistener.RgbDocumentListener;
import com.flyingmcdonald.screencolorcapture.eventslistener.rgblistener.RgbFocusListener;

import javax.swing.*;
import java.awt.*;

public class RgbPanelComponent {
    private JTextField showRedText;
    private JTextField showGreenText;
    private JTextField showBlueText;
    private JLabel redLabel;
    private JLabel greenLabel;
    private JLabel blueLabel;
    private JPanel showRGBPanel;
    private JPanel redPanel;
    private JPanel greenPanel;
    private JPanel bluePanel;
    private MainPanel mainPanel;

    public MainPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JTextField getShowRedText() {
        return showRedText;
    }

    public JTextField getShowGreenText() {
        return showGreenText;
    }

    public JTextField getShowBlueText() {
        return showBlueText;
    }

    public JLabel getRedLabel() {
        return redLabel;
    }

    public JLabel getGreenLabel() {
        return greenLabel;
    }

    public JLabel getBlueLabel() {
        return blueLabel;
    }

    public JPanel getShowRGBPanel() {
        return showRGBPanel;
    }

    public JPanel getRedPanel() {
        return redPanel;
    }

    public JPanel getGreenPanel() {
        return greenPanel;
    }

    public JPanel getBluePanel() {
        return bluePanel;
    }

    public RgbPanelComponent(MainPanel mainPanel){
        this.setMainPanel(mainPanel);
        labelComponent();
        jTextFieldComponent();
        startEventsListener();
        addLabelAndJTextFieldComponent();
        integrateComponent();
    }

    private void integrateComponent(){
        showRGBPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        showRGBPanel.setPreferredSize(new Dimension(170, 80));
        showRGBPanel.add(getRedPanel());
        showRGBPanel.add(getGreenPanel());
        showRGBPanel.add(getBluePanel());
    }

    private void labelComponent(){
        redLabel = new JLabel("Red:");
        Utils.setFonts(redLabel);

        greenLabel = new JLabel("Green:");
        Utils.setFonts(greenLabel);

        blueLabel = new JLabel("Blue:");
        Utils.setFonts(blueLabel);
    }

    private void jTextFieldComponent(){
        int TEXT_LANGTH = 4;
        this.showRedText = new JTextField("255", TEXT_LANGTH);
        this.showGreenText = new JTextField("255", TEXT_LANGTH);
        this.showBlueText = new JTextField("255", TEXT_LANGTH);
    }

    public void startEventsListener(){
        showRedText.getDocument().addDocumentListener(new RgbDocumentListener(this.mainPanel));
        showRedText.addFocusListener(new RgbFocusListener(this.mainPanel));

        showGreenText.getDocument().addDocumentListener(new RgbDocumentListener(this.mainPanel));
        showGreenText.addFocusListener(new RgbFocusListener(this.mainPanel));

        showBlueText.getDocument().addDocumentListener(new RgbDocumentListener(this.mainPanel));
        showBlueText.addFocusListener(new RgbFocusListener(this.mainPanel));
    }

    private void addLabelAndJTextFieldComponent(){
        redPanel = new JPanel();
        redPanel.add(this.getRedLabel());
        redPanel.add(this.getShowRedText());

        greenPanel = new JPanel();
        greenPanel.add(this.getGreenLabel());
        greenPanel.add(this.getShowGreenText());

        bluePanel = new JPanel();
        bluePanel.add(this.getBlueLabel());
        bluePanel.add(this.getShowBlueText());
    }
}
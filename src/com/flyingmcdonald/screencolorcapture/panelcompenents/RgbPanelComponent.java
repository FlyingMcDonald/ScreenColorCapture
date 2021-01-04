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

    public JPanel getShowRGBPanel() {
        return showRGBPanel;
    }

    public RgbPanelComponent(MainPanel mainPanel){
        this.setMainPanel(mainPanel);
        initPanelAndComponent();
        startEventsListener();
        Utils.integrateComponent(showRGBPanel, redPanel, greenPanel, bluePanel,
                redLabel, showRedText, greenLabel, showGreenText, blueLabel, showBlueText);
        addBorder();
    }

    private void initPanelAndComponent(){
        showRGBPanel = new JPanel();
        showRGBPanel.setBounds(200, 0, 150, 110);


        redPanel = new JPanel(null);
        redPanel.setPreferredSize(new Dimension(150, 30));

        redLabel = new JLabel("Red:");
        redLabel.setBounds(6, 5, 38, 20);
        Utils.setFonts(redLabel);

        showRedText = new JTextField("255", 4);
        showRedText.setBounds(78, 6, 60, 20);

        greenPanel = new JPanel(null);
        greenPanel.setPreferredSize(new Dimension(150, 30));

        greenLabel = new JLabel("Green:");
        greenLabel.setBounds(0, 5, 50, 20);
        Utils.setFonts(greenLabel);

        showGreenText = new JTextField("255", 4);
        showGreenText.setBounds(78, 6, 60, 20);

        bluePanel = new JPanel(null);
        bluePanel.setPreferredSize(new Dimension(150, 30));

        blueLabel = new JLabel("Blue:");
        blueLabel.setBounds(5, 5, 40, 20);
        Utils.setFonts(blueLabel);

        showBlueText = new JTextField("255", 4);
        showBlueText.setBounds(78, 6, 60, 20);
    }

    public void startEventsListener(){
        showRedText.getDocument().addDocumentListener(new RgbDocumentListener(this.mainPanel));
        showRedText.addFocusListener(new RgbFocusListener(this.mainPanel));

        showGreenText.getDocument().addDocumentListener(new RgbDocumentListener(this.mainPanel));
        showGreenText.addFocusListener(new RgbFocusListener(this.mainPanel));

        showBlueText.getDocument().addDocumentListener(new RgbDocumentListener(this.mainPanel));
        showBlueText.addFocusListener(new RgbFocusListener(this.mainPanel));
    }

    private void addBorder(){
        showRGBPanel.setBorder(BorderFactory.createLineBorder(Color.CYAN));
        redPanel.setBorder(BorderFactory.createLineBorder(Color.cyan));
        greenPanel.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
        bluePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        redLabel.setBorder(BorderFactory.createLineBorder(Color.blue));
        greenLabel.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        blueLabel.setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
    }
}
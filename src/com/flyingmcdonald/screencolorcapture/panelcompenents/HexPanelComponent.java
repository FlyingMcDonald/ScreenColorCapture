package com.flyingmcdonald.screencolorcapture.panelcompenents;

import com.flyingmcdonald.screencolorcapture.MainPanel;
import com.flyingmcdonald.screencolorcapture.Utils;
import com.flyingmcdonald.screencolorcapture.eventslistener.hexlistener.HexDocumentListener;
import com.flyingmcdonald.screencolorcapture.eventslistener.hexlistener.HexFocusListener;

import javax.swing.*;
import java.awt.*;

public class HexPanelComponent {
    private JTextField showHexText;
    private JPanel showHexPanel;
    private JLabel hexLabel;
    private MainPanel mainPanel;

    public MainPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JTextField getShowHexText() {
        return showHexText;
    }

    public JPanel getShowHexPanel() {
        return showHexPanel;
    }

    public JLabel getHexLabel() {
        return hexLabel;
    }

    public HexPanelComponent(MainPanel mainPanel){
        this.setMainPanel(mainPanel);
        labelComponent();
        jTextFieldComponent();
        eventsListener();
        integrateComponent();
    }

    private void integrateComponent(){
        showHexPanel = new JPanel();
        showHexPanel.setBounds(0, 50, 285, 35);
        showHexPanel.add(getHexLabel());
        showHexPanel.add(getShowHexText());
    }

    private void labelComponent(){
        hexLabel = new JLabel("Hex: ");
        Utils.setFonts(hexLabel);
    }

    private void jTextFieldComponent(){
        showHexText = new JTextField("#FFFFFFFF", 11);
    }

    private void eventsListener(){
        showHexText.getDocument().addDocumentListener(new HexDocumentListener(this.mainPanel));
        showHexText.addFocusListener(new HexFocusListener(this.mainPanel));
    }
}

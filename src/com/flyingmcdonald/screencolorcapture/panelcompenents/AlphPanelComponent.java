package com.flyingmcdonald.screencolorcapture.panelcompenents;


import com.flyingmcdonald.screencolorcapture.MainPanel;
import com.flyingmcdonald.screencolorcapture.Utils;
import com.flyingmcdonald.screencolorcapture.eventslistener.alphlistener.AlphDocumentListener;
import com.flyingmcdonald.screencolorcapture.eventslistener.alphlistener.AlphFocusListener;
import com.flyingmcdonald.screencolorcapture.eventslistener.alphlistener.AlphMouseListener;

import javax.swing.*;
import java.awt.*;

public class AlphPanelComponent {
    private JTextField showAlphText;
    private AlphSliderLabelComponent alphSliderLabelComponent;
    private JLabel sliderLabel;
    private JPanel showAlphPanel;
    private MainPanel mainPanel;

    public MainPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JTextField getShowAlphText() {
        return showAlphText;
    }

    public void setShowAlphText(JTextField showAlphText) {
        this.showAlphText = showAlphText;
    }

    public AlphSliderLabelComponent getAlphSliderLabelComponent() {
        return alphSliderLabelComponent;
    }

    public void setAlphSliderLabelComponent(AlphSliderLabelComponent alphSliderLabelComponent) {
        this.alphSliderLabelComponent = alphSliderLabelComponent;
    }

    public JLabel getSliderLabel() {
        return sliderLabel;
    }

    public JPanel getShowAlphPanel() {
        return showAlphPanel;
    }

    public AlphPanelComponent(MainPanel mainPanel){
        this.setMainPanel(mainPanel);
        initPanelAndComponent();
        eventsListener();
        integrateComponent();
        addBorder();
    }

    private void integrateComponent(){
        showAlphPanel.add(sliderLabel);
        showAlphPanel.add(alphSliderLabelComponent);
        showAlphPanel.add(showAlphText);
    }

    private void initPanelAndComponent(){
        showAlphPanel = new JPanel(null);
        showAlphPanel.setBounds(0, 10, 385, 35);

        sliderLabel = new JLabel("Opacity:");
        sliderLabel.setBounds(7, 0, 70, 20);
        Utils.setFonts(this.getSliderLabel());

        alphSliderLabelComponent = new AlphSliderLabelComponent();
        alphSliderLabelComponent.setBounds(85, 5, 188, 14);

        showAlphText = new JTextField("255", 4);
        showAlphText.setBounds(278, 2, 60, 20);
    }

    private void eventsListener(){
        this.showAlphText.getDocument().addDocumentListener(new AlphDocumentListener(this.mainPanel));
        this.showAlphText.addFocusListener(new AlphFocusListener(this.mainPanel));

        this.alphSliderLabelComponent.addMouseListener(new AlphMouseListener(this.mainPanel));
        this.alphSliderLabelComponent.addMouseMotionListener(new AlphMouseListener(this.mainPanel));
    }

    private void addBorder(){
        sliderLabel.setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
        alphSliderLabelComponent.setBorder(BorderFactory.createLineBorder(Color.PINK));
    }
}

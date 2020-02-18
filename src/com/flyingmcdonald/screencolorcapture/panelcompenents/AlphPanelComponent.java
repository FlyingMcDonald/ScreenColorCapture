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
        labelComponent();
        jTextFieldComponent();
        eventsListener();
        integrateComponent();
    }

    private void integrateComponent(){
        this.showAlphPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        this.showAlphPanel.setPreferredSize(new Dimension(285, 35));
        this.showAlphPanel.add(this.getSliderLabel());
        this.showAlphPanel.add(this.getAlphSliderLabelComponent());
        this.showAlphPanel.add(this.getShowAlphText());
    }

    private void labelComponent(){
        this.sliderLabel = new JLabel("Opacity:    ");
        Utils.setFonts(this.getSliderLabel());

        this.alphSliderLabelComponent = new AlphSliderLabelComponent();
        this.alphSliderLabelComponent.setPreferredSize(new Dimension(188, 14));
    }

    private void jTextFieldComponent(){
        int TEXT_LANGTH = 4;
        showAlphText = new JTextField("255", TEXT_LANGTH);
    }

    private void eventsListener(){
        this.showAlphText.getDocument().addDocumentListener(new AlphDocumentListener(this.mainPanel));
        this.showAlphText.addFocusListener(new AlphFocusListener(this.mainPanel));

        this.alphSliderLabelComponent.addMouseListener(new AlphMouseListener(this.mainPanel));
        this.alphSliderLabelComponent.addMouseMotionListener(new AlphMouseListener(this.mainPanel));
    }
}

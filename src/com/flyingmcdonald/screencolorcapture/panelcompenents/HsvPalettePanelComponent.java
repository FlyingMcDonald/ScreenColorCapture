package com.flyingmcdonald.screencolorcapture.panelcompenents;

import com.flyingmcdonald.screencolorcapture.MainPanel;
import com.flyingmcdonald.screencolorcapture.eventslistener.hsvpalettelistener.HsvPaletteMouseListener;
import com.flyingmcdonald.screencolorcapture.eventslistener.hsvpalettelistener.HsvPalette_2MouseListener;

import javax.swing.*;
import java.awt.*;

public class HsvPalettePanelComponent {
    private HsvPaletteLabelComponent hsvPaletteLabelComponent;
    private HsvPalette_2LabelComponent hsvPalette_2LabelComponent;
    private JPanel hsvPalettePanel;
    private MainPanel mainPanel;

    public MainPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JPanel getHsvPalettePanel() {
        return hsvPalettePanel;
    }

    public HsvPaletteLabelComponent getHsvPaletteLabelComponent() {
        return hsvPaletteLabelComponent;
    }

    public HsvPalette_2LabelComponent getHsvPalette_2LabelComponent() {
        return hsvPalette_2LabelComponent;
    }

    public HsvPalettePanelComponent(MainPanel mainPanel){
        this.setMainPanel(mainPanel);
        labelComponent();
        addMouseListener();
        integrateComponent();
    }

    private void integrateComponent(){
        this.hsvPalettePanel = new JPanel(new FlowLayout(0, 5, 0));
        this.hsvPalettePanel.setPreferredSize(new Dimension(232, 220));
        this.hsvPalettePanel.add(this.getHsvPalette_2LabelComponent());
        this.hsvPalettePanel.add(this.getHsvPaletteLabelComponent());
    }

    private void labelComponent(){
        this.hsvPaletteLabelComponent = new HsvPaletteLabelComponent();
        this.hsvPaletteLabelComponent.setPreferredSize(new Dimension(202, 202));

        this.hsvPalette_2LabelComponent = new HsvPalette_2LabelComponent();
        this.hsvPalette_2LabelComponent.setPreferredSize(new Dimension(14, 216));
    }

    private void addMouseListener(){
        this.hsvPaletteLabelComponent.addMouseListener(new HsvPaletteMouseListener(this.mainPanel));
        this.hsvPaletteLabelComponent.addMouseMotionListener(new HsvPaletteMouseListener(this.mainPanel));

        this.hsvPalette_2LabelComponent.addMouseListener(new HsvPalette_2MouseListener(this.mainPanel));
        this.hsvPalette_2LabelComponent.addMouseMotionListener(new HsvPalette_2MouseListener(this.mainPanel));
    }
}

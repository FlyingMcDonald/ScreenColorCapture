package com.flyingmcdonald.screencolorcapture.panelcompenents;

import com.flyingmcdonald.screencolorcapture.MainPanel;
import com.flyingmcdonald.screencolorcapture.eventslistener.hsvpalettelistener.HsvPaletteMouseListener;
import com.flyingmcdonald.screencolorcapture.eventslistener.hsvpalettelistener.HsvPalette_2MouseListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
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
        hsvPalettePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        hsvPalettePanel.setPreferredSize(new Dimension(232, 230));
        hsvPalettePanel.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        hsvPalettePanel.add(getHsvPalette_2LabelComponent());
        hsvPalettePanel.add(getHsvPaletteLabelComponent());
    }

    private void labelComponent(){
        hsvPaletteLabelComponent = new HsvPaletteLabelComponent();
        hsvPaletteLabelComponent.setPreferredSize(new Dimension(202, 202));
        hsvPalette_2LabelComponent = new HsvPalette_2LabelComponent();
        hsvPalette_2LabelComponent.setPreferredSize(new Dimension(14, 216));
    }

    private void addMouseListener(){
        hsvPaletteLabelComponent.addMouseListener(new HsvPaletteMouseListener(mainPanel));
        hsvPaletteLabelComponent.addMouseMotionListener(new HsvPaletteMouseListener(mainPanel));

        hsvPalette_2LabelComponent.addMouseListener(new HsvPalette_2MouseListener(mainPanel));
        hsvPalette_2LabelComponent.addMouseMotionListener(new HsvPalette_2MouseListener(mainPanel));
    }
}

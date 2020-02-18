package com.flyingmcdonald.screencolorcapture.eventslistener.hsvpalettelistener;

import com.flyingmcdonald.screencolorcapture.MainPanel;
import com.flyingmcdonald.screencolorcapture.control.DataControl;
import com.flyingmcdonald.screencolorcapture.control.DataControlImpl;
import com.flyingmcdonald.screencolorcapture.panelcompenents.HsvPaletteLabelComponent;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HsvPaletteMouseListener extends MouseAdapter {
    private HsvPaletteLabelComponent hsvPaletteLabelComponent;
    private DataControl dataControl;
    private MainPanel mainPanel;
    Cursor cursor;
    Cursor cursorReset;

    public MainPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public HsvPaletteMouseListener(MainPanel mainPanel){
        this.setMainPanel(mainPanel);
        this.dataControl = new DataControlImpl(mainPanel);
        this.cursor = new Cursor(Cursor.CROSSHAIR_CURSOR);
        this.cursorReset = new Cursor(Cursor.DEFAULT_CURSOR);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.hsvPaletteLabelComponent = this.mainPanel.getHsvPalettePanelComponent().getHsvPaletteLabelComponent();
        hsvPaletteLabelComponent.setCursor(cursor);
        dataControl.colorToHsv(e.getX(), e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.hsvPaletteLabelComponent = this.mainPanel.getHsvPalettePanelComponent().getHsvPaletteLabelComponent();
        hsvPaletteLabelComponent.setCursor(cursor);
        dataControl.colorToHsv(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.hsvPaletteLabelComponent = this.mainPanel.getHsvPalettePanelComponent().getHsvPaletteLabelComponent();
        hsvPaletteLabelComponent.setCursor(cursorReset);
    }
}
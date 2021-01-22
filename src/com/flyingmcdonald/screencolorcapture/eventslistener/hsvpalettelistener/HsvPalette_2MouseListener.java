package com.flyingmcdonald.screencolorcapture.eventslistener.hsvpalettelistener;

import com.flyingmcdonald.screencolorcapture.MainPanel;
import com.flyingmcdonald.screencolorcapture.control.DataControl;
import com.flyingmcdonald.screencolorcapture.control.DataControlImpl;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HsvPalette_2MouseListener extends MouseAdapter {
    private final DataControl dataControl;

    public HsvPalette_2MouseListener(MainPanel mainPanel){
        this.dataControl = new DataControlImpl(mainPanel);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        dataControl.changeHueInHsvPalette(e.getY());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        dataControl.changeHueInHsvPalette(e.getY());
    }
}

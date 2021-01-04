package com.flyingmcdonald.screencolorcapture.eventslistener.alphlistener;

import com.flyingmcdonald.screencolorcapture.MainPanel;
import com.flyingmcdonald.screencolorcapture.control.DataControl;
import com.flyingmcdonald.screencolorcapture.control.DataControlImpl;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AlphMouseListener extends MouseAdapter {
    private final DataControl dataControl;

    public AlphMouseListener(MainPanel mainPanel){
        dataControl = new DataControlImpl(mainPanel);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        dataControl.setAlphFieldValueByMouseClicked(e.getX());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        dataControl.setAlphFieldValueByMouseDragged(e.getX());
    }
}

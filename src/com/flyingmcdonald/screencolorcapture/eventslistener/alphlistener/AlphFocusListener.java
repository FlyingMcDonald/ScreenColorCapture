package com.flyingmcdonald.screencolorcapture.eventslistener.alphlistener;

import com.flyingmcdonald.screencolorcapture.MainPanel;
import com.flyingmcdonald.screencolorcapture.control.DataControl;
import com.flyingmcdonald.screencolorcapture.control.DataControlImpl;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AlphFocusListener extends FocusAdapter {
    private DataControl dataControl;

    public AlphFocusListener(MainPanel mainPanel){
        dataControl = new DataControlImpl(mainPanel);
    }

    @Override
    public void focusLost(FocusEvent e) {
        dataControl.alphFieldLostFocus();
    }
}

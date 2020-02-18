package com.flyingmcdonald.screencolorcapture.eventslistener.hexlistener;

import com.flyingmcdonald.screencolorcapture.MainPanel;
import com.flyingmcdonald.screencolorcapture.control.DataControl;
import com.flyingmcdonald.screencolorcapture.control.DataControlImpl;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class HexFocusListener extends FocusAdapter {
    private DataControl dataControl;

    public HexFocusListener(MainPanel mainPanel){
        dataControl = new DataControlImpl(mainPanel);
    }

    @Override
    public void focusLost(FocusEvent e) {
        dataControl.hexFieldLostFocus();
    }
}

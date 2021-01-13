package com.flyingmcdonald.screencolorcapture.eventslistener.hsvlistener;

import com.flyingmcdonald.screencolorcapture.MainPanel;
import com.flyingmcdonald.screencolorcapture.control.DataControl;
import com.flyingmcdonald.screencolorcapture.control.DataControlImpl;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class HsvFocusListener extends FocusAdapter {
    private final DataControl dataControl;

    public HsvFocusListener(MainPanel mainPanel){
        dataControl = new DataControlImpl(mainPanel);
    }

    @Override
    public void focusLost(FocusEvent e) {
        dataControl.hsvFieldLostFocus();
    }
}

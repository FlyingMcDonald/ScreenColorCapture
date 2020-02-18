package com.flyingmcdonald.screencolorcapture.eventslistener.hsvlistener;

import com.flyingmcdonald.screencolorcapture.MainPanel;
import com.flyingmcdonald.screencolorcapture.control.DataControl;
import com.flyingmcdonald.screencolorcapture.control.DataControlImpl;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class HsvDocumentListener implements DocumentListener {
    private DataControl dataControl;

    public HsvDocumentListener(MainPanel mainPanel){
        this.dataControl = new DataControlImpl(mainPanel);
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        dataControl.changeRgbFieldValueByHsvChanged();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        if(e.getDocument().getLength() != 0) {
            dataControl.changeRgbFieldValueByHsvChanged();
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        dataControl.changeRgbFieldValueByHsvChanged();
    }
}

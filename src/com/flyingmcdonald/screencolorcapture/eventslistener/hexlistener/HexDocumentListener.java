package com.flyingmcdonald.screencolorcapture.eventslistener.hexlistener;

import com.flyingmcdonald.screencolorcapture.MainPanel;
import com.flyingmcdonald.screencolorcapture.Utils;
import com.flyingmcdonald.screencolorcapture.control.DataControl;
import com.flyingmcdonald.screencolorcapture.control.DataControlImpl;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class HexDocumentListener implements DocumentListener {
    private final DataControl dataControl;

    public HexDocumentListener(MainPanel mainPanel){
        this.dataControl = new DataControlImpl(mainPanel);
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        if (Utils.rgbFlag) {
            dataControl.changeRgbaFieldValueByHexFieldValue();
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        dataControl.changeRgbaFieldValueByHexFieldValue();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        dataControl.changeRgbaFieldValueByHexFieldValue();
    }
}

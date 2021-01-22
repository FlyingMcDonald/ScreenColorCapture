package com.flyingmcdonald.screencolorcapture.eventslistener.rgblistener;

import com.flyingmcdonald.screencolorcapture.MainPanel;
import com.flyingmcdonald.screencolorcapture.Utils;
import com.flyingmcdonald.screencolorcapture.control.DataControl;
import com.flyingmcdonald.screencolorcapture.control.DataControlImpl;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class RgbDocumentListener implements DocumentListener {
    private final DataControl dataControl;

    public RgbDocumentListener(MainPanel mainPanel){
        dataControl = new DataControlImpl(mainPanel);
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        if (Utils.flag) {
            dataControl.changeHsvFieldValueByRgbchanged();
            dataControl.setHexFieldValueByRgb();
            dataControl.showColorInColorLabel();
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        if (Utils.flag) {
            dataControl.changeHsvFieldValueByRgbchanged();
            dataControl.setHexFieldValueByRgb();
            dataControl.showColorInColorLabel();
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        if (Utils.flag) {
            dataControl.changeHsvFieldValueByRgbchanged();
            dataControl.setHexFieldValueByRgb();
            dataControl.showColorInColorLabel();
        }
    }
}

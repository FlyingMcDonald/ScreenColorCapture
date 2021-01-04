package com.flyingmcdonald.screencolorcapture.eventslistener.alphlistener;

import com.flyingmcdonald.screencolorcapture.MainPanel;
import com.flyingmcdonald.screencolorcapture.control.DataControl;
import com.flyingmcdonald.screencolorcapture.control.DataControlImpl;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class AlphDocumentListener implements DocumentListener {
    private final DataControl dataControl;

    /*public AlphPanelComponent getAlphPanelComponent() {
        return alphPanelComponent;
    }

    public void setAlphPanelComponent(AlphPanelComponent alphPanelComponent) {
        this.alphPanelComponent = alphPanelComponent;
    }

    public AlphSliderComponent getAlphSliderComponent() {
        return alphSliderComponent;
    }

    public void setAlphSliderComponent(AlphSliderComponent alphSliderComponent) {
        this.alphSliderComponent = alphSliderComponent;
    }

    public AlphDocumentListener(AlphSliderComponent alphSliderComponent, AlphPanelComponent alphPanelComponent){
        this.setAlphSliderComponent(alphSliderComponent);
        this.setAlphPanelComponent(alphPanelComponent);
    }*/

    public AlphDocumentListener(MainPanel mainPanel){
        this.dataControl = new DataControlImpl(mainPanel);
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        dataControl.changeAplhSliderMidOfCircled();
        dataControl.setHexFieldValueByAlph();
        dataControl.showColorInColorLabel();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        dataControl.changeAplhSliderMidOfCircled();
        dataControl.setHexFieldValueByAlph();
        dataControl.showColorInColorLabel();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        dataControl.changeAplhSliderMidOfCircled();
        dataControl.setHexFieldValueByAlph();
        dataControl.showColorInColorLabel();
    }
}

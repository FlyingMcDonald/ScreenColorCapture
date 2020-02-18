package com.flyingmcdonald.screencolorcapture.control.hexdatacontrol;

import com.flyingmcdonald.screencolorcapture.Utils;
import com.flyingmcdonald.screencolorcapture.panelcompenents.HexPanelComponent;

public class HexDataControlImpl implements HexDataControl {
    private HexPanelComponent hexPanelComponent;

    public void setHexPanelComponent(HexPanelComponent hexPanelComponent) {
        this.hexPanelComponent = hexPanelComponent;
    }

    public HexDataControlImpl(HexPanelComponent hexPanelComponent){
        this.setHexPanelComponent(hexPanelComponent);
    }

    @Override
    public String getHexFieldValue() {
        return Utils.checkHexFieldValue(this.hexPanelComponent.getShowHexText().getText());
    }

    @Override
    public String getSafeHexFieldValue() {
        return this.hexPanelComponent.getShowHexText().getText();
    }

    @Override
    public void setHexFieldValue(String hexFieldValue) {
        this.hexPanelComponent.getShowHexText().setText(hexFieldValue);
    }
}

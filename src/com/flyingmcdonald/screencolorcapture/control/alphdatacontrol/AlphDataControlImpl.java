package com.flyingmcdonald.screencolorcapture.control.alphdatacontrol;

import com.flyingmcdonald.screencolorcapture.Utils;
import com.flyingmcdonald.screencolorcapture.panelcompenents.AlphPanelComponent;
import com.flyingmcdonald.screencolorcapture.panelcompenents.AlphSliderLabelComponent;

public class AlphDataControlImpl implements AlphDataControl {
    private AlphPanelComponent alphPanelComponent;

    public void setAlphPanelComponent(AlphPanelComponent alphPanelComponent) {
        this.alphPanelComponent = alphPanelComponent;
    }

    public AlphDataControlImpl(AlphPanelComponent alphPanelComponent){
        this.setAlphPanelComponent(alphPanelComponent);
    }

    @Override
    public void setAlphFieldValueAndSliderMidOfCircled(int alphFieldValue, int sliderMidOfCircledCoordinate){
        alphPanelComponent.getShowAlphText().setText("" + alphFieldValue);
        alphPanelComponent.getAlphSliderLabelComponent().setSliderMidOfCircled(sliderMidOfCircledCoordinate);
    }

    @Override
    public int getSliderMidOfCirCled(int x) {
        int sliderMidOfCircled = x;
        if(x > 6 && x < 167) {
            sliderMidOfCircled = x - alphPanelComponent.getAlphSliderLabelComponent().getCIRCLED_R();
        }else {
            sliderMidOfCircled = sliderMidOfCircled > 160 ? 160 : 0;
        }
        return sliderMidOfCircled;
    }

    @Override
    public String getAlphFieldValue() {
        return Utils.filterFieldValue(alphPanelComponent.getShowAlphText().getText());
    }

    @Override
    public int getSafeAlphFieldValue() {
        return Utils.toInt(alphPanelComponent.getShowAlphText().getText());
    }

    @Override
    public void setAlphFieldValue(int alphFieldValue) {
        this.alphPanelComponent.getShowAlphText().setText(alphFieldValue + "");
    }

    @Override
    public AlphSliderLabelComponent getAlphSliderLabelComponent() {
        return this.alphPanelComponent.getAlphSliderLabelComponent();
    }
}
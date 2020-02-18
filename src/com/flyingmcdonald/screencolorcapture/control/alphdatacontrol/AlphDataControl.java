package com.flyingmcdonald.screencolorcapture.control.alphdatacontrol;

import com.flyingmcdonald.screencolorcapture.panelcompenents.AlphSliderLabelComponent;

public interface AlphDataControl {
    void setAlphFieldValueAndSliderMidOfCircled(int alphFieldValue, int sliderMidOfCircledCoordinate);
    int getSliderMidOfCirCled(int x);
    String getAlphFieldValue();

    /**
     * Return processed alph field value
     * @return Int, alph field value
     */
    int getSafeAlphFieldValue();
    void setAlphFieldValue(int alphFieldValue);
    AlphSliderLabelComponent getAlphSliderLabelComponent();
}

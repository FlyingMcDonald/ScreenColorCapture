package com.flyingmcdonald.screencolorcapture.control;

public interface DataControl {
    /**
     * Hsv changes with rgb
     */
    void changeHsvFieldValueByRgbchanged();
    /**
     * Hex changes with rgb
     */
    void setHexFieldValueByRgb();
    /**
     * Hex changes with alph
     */
    void setHexFieldValueByAlph();
    void changeAplhSliderMidOfCircled();
    void changeRgbFieldValueByHsvChanged();
    void colorToHsv(int x, int y);
    void changeHueInHsvPalette(int x);
    void setAlphFieldValueByMouseClicked(int x);
    void setAlphFieldValueByMouseDragged(int x);
    void showColorInColorLabel();
    void colorPick(int x, int y);
    void changeRgbaFieldValueByHexFieldValue();
    void alphFieldLostFocus();
    void rgbFieldLostFocus();
    void hsvFieldLostFocus();
    void hexFieldLostFocus();
}
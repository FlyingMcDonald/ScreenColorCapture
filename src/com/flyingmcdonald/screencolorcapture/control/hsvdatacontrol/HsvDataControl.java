package com.flyingmcdonald.screencolorcapture.control.hsvdatacontrol;

import javax.swing.*;

public interface HsvDataControl {
    JTextField[] getHsvFieldObject();
    void setHsvFieldValue(int[] hsvIntArray, JTextField[] HsvFieldObject);
    String[] getHsvFieldValue();
    float[] getHsvFloatValue(int[] hsbIntArray);
    float[] getSafeHsvFloatValue();
    void setHsvFieldValue(String hsvStr, JTextField fieldObject);
}

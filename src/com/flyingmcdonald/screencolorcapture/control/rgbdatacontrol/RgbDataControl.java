package com.flyingmcdonald.screencolorcapture.control.rgbdatacontrol;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public interface RgbDataControl {
    String[] getSafeRGBFieldValue();
    void setRGBFieldValue(int[] rgbIntArray, JTextField[] rgbFieldObject);
    JTextField[] getRGBFieldObject();
    int[] getRGBFieldValue(Color color);
    void setRGBFieldValue(List<Integer> rgbList, JTextField[] rgbFieldObject);
    String[] getRgbFieldValue();
    void setRgbFieldValue(String fieldValue, JTextField fieldObject);
}

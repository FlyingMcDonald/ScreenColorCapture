package com.flyingmcdonald.screencolorcapture.control.rgbdatacontrol;

import com.flyingmcdonald.screencolorcapture.MainPanel;
import com.flyingmcdonald.screencolorcapture.Utils;
import com.flyingmcdonald.screencolorcapture.panelcompenents.RgbPanelComponent;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class RgbDataControlImpl implements RgbDataControl {
    private RgbPanelComponent rgbPanelComponent;
    private MainPanel mainPanel;

    public MainPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public void setRgbPanelComponent(RgbPanelComponent rgbPanelComponent) {
        this.rgbPanelComponent = rgbPanelComponent;
    }

    public RgbDataControlImpl(RgbPanelComponent rgbPanelComponent){
        this.setRgbPanelComponent(rgbPanelComponent);
    }

    @Override
    public String[] getSafeRGBFieldValue() {
        return new String[]{
                rgbPanelComponent.getShowRedText().getText(),
                rgbPanelComponent.getShowGreenText().getText(),
                rgbPanelComponent.getShowBlueText().getText()
        };
    }

    @Override
    public void setRGBFieldValue(int[] rgbIntArray, JTextField[] rgbFieldObject) {
        for (int i = 0; i < rgbFieldObject.length; i++) {
            if (!rgbFieldObject[i].getText().equals("" + rgbIntArray[i])) {
                if (i == rgbFieldObject.length - 1)
                    Utils.flag = true;
                rgbFieldObject[i].setText("" + rgbIntArray[i]);
            }

        }
    }

    @Override
    public JTextField[] getRGBFieldObject() {
        return new JTextField[]{
                rgbPanelComponent.getShowRedText(),
                rgbPanelComponent.getShowGreenText(),
                rgbPanelComponent.getShowBlueText()
        };
    }

    @Override
    public int[] getRGBFieldValue(Color color) {
        int[] rgb = new int[3];
        rgb[0] = color.getRed();
        rgb[1] = color.getGreen();
        rgb[2] = color.getBlue();
        return rgb;
    }

    @Override
    public void setRGBFieldValue(List<Integer> rgbList, JTextField[] rgbFieldObject) {
        int[] rgbIntArray = Utils.StringToInt(getSafeRGBFieldValue());
        for(int i = 0; i < rgbIntArray.length; i++){
            if (rgbIntArray[i] != rgbList.get(i)){
                if(i == rgbIntArray.length - 1)
                    Utils.flag = true;
                rgbFieldObject[i].setText("" + rgbList.get(i));
            }
        }
    }

    @Override
    public String[] getRgbFieldValue() {
        String[] rgbStrArray = getSafeRGBFieldValue();
        for (int i = 0; i < 3; i++) {
            rgbStrArray[i] = Utils.filterFieldValue(rgbStrArray[i]);
        }
        return rgbStrArray;
    }

    @Override
    public void setRgbFieldValue(String fieldValue, JTextField fieldObject) {
        fieldObject.setText(fieldValue);
    }
}

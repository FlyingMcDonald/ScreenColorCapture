package com.flyingmcdonald.screencolorcapture.control.hsvdatacontrol;

import com.flyingmcdonald.screencolorcapture.Utils;
import com.flyingmcdonald.screencolorcapture.panelcompenents.HsvPanelComponent;

import javax.swing.*;

public class HsvDataControlImpl implements HsvDataControl {
    private HsvPanelComponent hsvPanelComponent;

    public void setHsvPanelComponent(HsvPanelComponent hsvPanelComponent) {
        this.hsvPanelComponent = hsvPanelComponent;
    }

    public HsvDataControlImpl(HsvPanelComponent hsvPanelComponent){
        this.setHsvPanelComponent(hsvPanelComponent);
    }

    /**
     * 获取HSB的JTextField对象数组
     *
     * @return
     */
    @Override
    public JTextField[] getHsvFieldObject(){
        return new JTextField[]{
                hsvPanelComponent.getShowHueText(),
                hsvPanelComponent.getShowSaturationText(),
                hsvPanelComponent.getShowValueText()
        };
    }

    @Override
    public void setHsvFieldValue(int[] hsvIntArray, JTextField[] HsvFieldObject) {
        for (int i = 0; i < HsvFieldObject.length; i++) {
            if (!HsvFieldObject[i].getText().equals(""+hsvIntArray[i])) {
                HsvFieldObject[i].setText(""+hsvIntArray[i]);
            }
        }
    }

    @Override
    public String[] getHsvFieldValue() {
        JTextField[] hsvFieldObject = getHsvFieldObject();
        String[] hsbFieldValue = new String[hsvFieldObject.length];
        for (int i = 0; i < hsvFieldObject.length; i++) {
            hsbFieldValue[i] = Utils.filterFieldValue(hsvFieldObject[i].getText());
        }
        return hsbFieldValue;
    }

    /**
     * 获取hsv的浮点数值
     *
     * @param hsbIntArray
     * @return
     */
    @Override
    public float[] getHsvFloatValue(int[] hsbIntArray) {
        float[] hsbValue = new float[hsbIntArray.length];
        for (int i = 0; i < hsbIntArray.length; i++) {
            hsbValue[i] = hsbIntArray[i] / 100f;
        }
        return hsbValue;
    }

    @Override
    public float[] getSafeHsvFloatValue() {
        int[] hsvIntArray = {
                Utils.toInt(this.hsvPanelComponent.getShowHueText().getText()),
                Utils.toInt(this.hsvPanelComponent.getShowSaturationText().getText()),
                Utils.toInt(this.hsvPanelComponent.getShowValueText().getText())
        };
        float[] hsvFloatArray = new float[3];
        for (int i = 0; i < 3; i++) {
            hsvFloatArray[i] = hsvIntArray[i] / 100f;
        }
        return hsvFloatArray;
    }

    @Override
    public void setHsvFieldValue(String hsvStr, JTextField fieldObject) {
        fieldObject.setText(hsvStr);
    }
}
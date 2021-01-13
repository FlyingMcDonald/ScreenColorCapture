package com.flyingmcdonald.screencolorcapture.control;

import com.flyingmcdonald.screencolorcapture.MainPanel;
import com.flyingmcdonald.screencolorcapture.Utils;
import com.flyingmcdonald.screencolorcapture.control.alphdatacontrol.AlphDataControl;
import com.flyingmcdonald.screencolorcapture.control.alphdatacontrol.AlphDataControlImpl;
import com.flyingmcdonald.screencolorcapture.control.hexdatacontrol.HexDataControl;
import com.flyingmcdonald.screencolorcapture.control.hexdatacontrol.HexDataControlImpl;
import com.flyingmcdonald.screencolorcapture.control.hsvdatacontrol.HsvDataControl;
import com.flyingmcdonald.screencolorcapture.control.hsvdatacontrol.HsvDataControlImpl;
import com.flyingmcdonald.screencolorcapture.control.hsvpalettedatacontrol.HsvPaletteDataControl;
import com.flyingmcdonald.screencolorcapture.control.hsvpalettedatacontrol.HsvPaletteDataControlImpl;
import com.flyingmcdonald.screencolorcapture.control.hsvpalettedatacontrol.HsvPalette_2DataControl;
import com.flyingmcdonald.screencolorcapture.control.hsvpalettedatacontrol.HsvPalette_2DataControlImpl;
import com.flyingmcdonald.screencolorcapture.control.rgbdatacontrol.RgbDataControl;
import com.flyingmcdonald.screencolorcapture.control.rgbdatacontrol.RgbDataControlImpl;
import com.flyingmcdonald.screencolorcapture.panelcompenents.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DataControlImpl implements DataControl {
    private MainPanel mainPanel;
    private RgbDataControl rgbDataControl;
    private HsvDataControl hsvDataControl;
    private HexDataControl hexDataControl;
    private AlphDataControl alphDataControl;
    private HsvPaletteDataControl hsvPaletteDataControl;

    public MainPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public DataControlImpl(MainPanel mainPanel){
        this.setMainPanel(mainPanel);
    }

    @Override
    public void changeHsvFieldValueByRgbchanged() {
        if (Utils.hsvFlag) {
            rgbDataControl = new RgbDataControlImpl(this.mainPanel.getRgbPanelComponent());
            String[] rgbStrArray = rgbDataControl.getRgbFieldValue();
            if (Utils.checkRgbFieldValue(rgbStrArray)) {
                hsvDataControl = new HsvDataControlImpl(this.mainPanel.getHsvPanelComponent());
                float[] hsvFloatArray = hsvDataControl.getSafeHsvFloatValue();
                int[] rgbIntArray = Utils.StringToInt(rgbStrArray);
                if (Utils.compareHsvAndRgb(hsvFloatArray, rgbIntArray)) {
                    int[] hsvIntArray = Utils.RgbtoHsv(rgbIntArray);
                    hsvDataControl.setHsvFieldValue(hsvIntArray, hsvDataControl.getHsvFieldObject());
                }
            }
        }
    }

    @Override
    public void setHexFieldValueByRgb() {
        if (Utils.hexFlag) {
            rgbDataControl = new RgbDataControlImpl(this.mainPanel.getRgbPanelComponent());
            String[] rgbStrArray = rgbDataControl.getRgbFieldValue();
            if (Utils.checkRgbFieldValue(rgbStrArray)) {
                int[] rgbIntArray = Utils.StringToInt(rgbStrArray);
                alphDataControl = new AlphDataControlImpl(this.mainPanel.getAlphPanelComponent());
                hexDataControl = new HexDataControlImpl(this.mainPanel.getHexPanelComponent());
                int alph = alphDataControl.getSafeAlphFieldValue();
                List<Integer> rgbaList = new ArrayList<>();
                rgbaList.add(rgbIntArray[0]);
                rgbaList.add(rgbIntArray[1]);
                rgbaList.add(rgbIntArray[2]);
                rgbaList.add(alph);
                changeHexFieldValue(rgbaList);
            }
        }
    }

    @Override
    public void setHexFieldValueByAlph() {
        alphDataControl = new AlphDataControlImpl(this.mainPanel.getAlphPanelComponent());
        String alphStr = alphDataControl.getAlphFieldValue();
        if (Utils.checkAlphFieldValue(alphStr)) {
            int alph = Utils.toInt(alphStr);
            rgbDataControl = new RgbDataControlImpl(this.mainPanel.getRgbPanelComponent());
            int[] rgbIntArray = Utils.StringToInt(rgbDataControl.getSafeRGBFieldValue());
            List<Integer> rgbaList = new ArrayList<>();
            rgbaList.add(rgbIntArray[0]);
            rgbaList.add(rgbIntArray[1]);
            rgbaList.add(rgbIntArray[2]);
            rgbaList.add(alph);
            changeHexFieldValue(rgbaList);
        }
    }

    private void changeHexFieldValue(List<Integer> rgbaList){
        Utils.hexFlag = false;
        hexDataControl = new HexDataControlImpl(this.mainPanel.getHexPanelComponent());
        String hexFieldValue = hexDataControl.getSafeHexFieldValue();
        String hexFieldValuePlus = Utils.toRgbHexString(rgbaList.get(0), rgbaList.get(1), rgbaList.get(2));
        String hexFieldValuePro = Utils.toRgbaHexString(rgbaList.get(0), rgbaList.get(1), rgbaList.get(2), rgbaList.get(3));
        if ((hexFieldValue.length() == 7 || hexFieldValue.length() == 0) &&
                !hexFieldValue.equalsIgnoreCase(hexFieldValuePlus)) {
            hexDataControl.setHexFieldValue(hexFieldValuePlus);
        } else if ((hexFieldValue.length() == 9 || hexFieldValue.length() == 0) &&
                !hexFieldValue.equalsIgnoreCase(hexFieldValuePro)) {
            hexDataControl.setHexFieldValue(hexFieldValuePro);
        }
    }

    @Override
    public void changeAplhSliderMidOfCircled() {
        alphDataControl = new AlphDataControlImpl(this.mainPanel.getAlphPanelComponent());
        AlphSliderLabelComponent alphSliderLabelComponent = alphDataControl.getAlphSliderLabelComponent();
        if(alphSliderLabelComponent != null) {
            String alphStr = alphDataControl.getAlphFieldValue();
            if(alphStr != null && Utils.toInt(alphStr) <= 255) {
                float avage = 160 / 255f;
                alphSliderLabelComponent.setSliderMidOfCircled((int) (Utils.toInt(alphStr) * avage));
                alphSliderLabelComponent.repaint();
            }
        }
    }

    @Override
    public void changeRgbFieldValueByHsvChanged() {
        hsvDataControl = new HsvDataControlImpl(this.mainPanel.getHsvPanelComponent());
        rgbDataControl = new RgbDataControlImpl(this.mainPanel.getRgbPanelComponent());
        String[] hsvStrArray = hsvDataControl.getHsvFieldValue();
        if (Utils.checkHsvFieldValue(hsvStrArray)) {
            float[] hsbFloatArray = hsvDataControl.getHsvFloatValue(Utils.StringToInt(hsvStrArray));
            int[] rgbIntArray = Utils.StringToInt(rgbDataControl.getSafeRGBFieldValue());
            if (Utils.compareHsvAndRgb(hsbFloatArray, rgbIntArray)) {
                int[] rgb = rgbDataControl.getRGBFieldValue(Color.getHSBColor(hsbFloatArray[0], hsbFloatArray[1], hsbFloatArray[2]));
                rgbDataControl.setRGBFieldValue(rgb, rgbDataControl.getRGBFieldObject());
            }
        }
    }

    /**
     * 将hsvPalette两条线的交叉点的坐标所在HSB值转换成RGB值
     *
     * @param x 横坐标
     * @param y 纵坐标
     */
    @Override
    public void colorToHsv(int x, int y) {
        hsvPaletteDataControl = new HsvPaletteDataControlImpl(this.mainPanel.getHsvPalettePanelComponent());
        int[] crosshair = hsvPaletteDataControl.getCrossCoordinates(x, y);
        hsvPaletteDataControl.setCrosshair(crosshair);
        HsvPaletteLabelComponent hsvPaletteLabelComponent = this.mainPanel.getHsvPalettePanelComponent().getHsvPaletteLabelComponent();
        hsvDataControl = new HsvDataControlImpl(this.mainPanel.getHsvPanelComponent());
        JTextField[] hsvFieldObject = hsvDataControl.getHsvFieldObject();
        int h = (int) (hsvPaletteLabelComponent.getHue() * 100 + 0.5f);
        int[] coordinates = Utils.checkCoordinates(x, y);
        hsvPaletteLabelComponent.setCrosshirCoordinates(coordinates);
        int s = (int) ((1 - coordinates[1] / 201f) * 100 + 0.5f);
        int v = (int) ((float) coordinates[0] / 201f * 100 + 0.5f);
        int[] hsv = {h, s, v};
        hsvDataControl.setHsvFieldValue(hsv, hsvFieldObject);
    }

    @Override
    public void changeHueInHsvPalette(int x) {
        hsvPaletteDataControl = new HsvPaletteDataControlImpl(this.getMainPanel().getHsvPalettePanelComponent());
        HsvPalette_2DataControl hsvPalette_2DataControl = new HsvPalette_2DataControlImpl(this.getMainPanel().getHsvPalettePanelComponent());
        HsvPanelComponent hsvPanelComponent = this.getMainPanel().getHsvPanelComponent();
        int midOfCircled = hsvPalette_2DataControl.getMidOfCircled(x);
        HsvPaletteLabelComponent hsvPaletteLabelComponent = this.getMainPanel().getHsvPalettePanelComponent().getHsvPaletteLabelComponent();
        if(midOfCircled > 201 || midOfCircled < 0) {
            midOfCircled = midOfCircled > 201 ? 201 : 0;
        }
        hsvPalette_2DataControl.setMidOfCircled(midOfCircled);
        float coordinateY = (float) midOfCircled / 201f;
        hsvPaletteLabelComponent.setHue(coordinateY);
        hsvPanelComponent.getShowHueText().setText((int)(coordinateY * 100 + 0.5f) + "");
        hsvPaletteLabelComponent.repaint();
    }

    @Override
    public void setAlphFieldValueByMouseClicked(int x) {
        alphDataControl = new AlphDataControlImpl(this.mainPanel.getAlphPanelComponent());
        AlphSliderLabelComponent alphSliderLabelComponent = this.mainPanel.getAlphPanelComponent().getAlphSliderLabelComponent();
        int sliderMidOfCircled = alphSliderLabelComponent.getSliderMidOfCircled();
        String alphFieldValue = Utils.checkString(this.mainPanel.getAlphPanelComponent().getShowAlphText().getText(), "[^\\d]");
        int alphTextValue = Utils.toInt(alphFieldValue);
        float AVAGE = 160 / 255f;
        if(x > sliderMidOfCircled) {
            alphDataControl.setAlphFieldValueAndSliderMidOfCircled((alphTextValue + 1), (int)(sliderMidOfCircled + AVAGE + 0.5f));
        }else if(x < sliderMidOfCircled) {
            alphDataControl.setAlphFieldValueAndSliderMidOfCircled((alphTextValue - 1), (int)(sliderMidOfCircled - AVAGE + 0.5f));
        }
        alphSliderLabelComponent.repaint();
    }

    @Override
    public void setAlphFieldValueByMouseDragged(int x) {
        alphDataControl = new AlphDataControlImpl(this.mainPanel.getAlphPanelComponent());
        int sliderMidOfCircled = alphDataControl.getSliderMidOfCirCled(x);
        if(sliderMidOfCircled >= 0 && sliderMidOfCircled <= 160){
            this.mainPanel.getAlphPanelComponent().getShowAlphText().setText("" + (int)(sliderMidOfCircled * (255 / 160f)));
            this.mainPanel.getAlphPanelComponent().getAlphSliderLabelComponent().setSliderMidOfCircled(sliderMidOfCircled);
        }
        this.mainPanel.getAlphPanelComponent().getAlphSliderLabelComponent().repaint();
    }

    @Override
    public void showColorInColorLabel() {
        rgbDataControl = new RgbDataControlImpl(this.mainPanel.getRgbPanelComponent());
        String[] rgbStrArray = rgbDataControl.getRgbFieldValue();
        if (Utils.checkRgbFieldValue(rgbStrArray)) {
            alphDataControl = new AlphDataControlImpl(this.mainPanel.getAlphPanelComponent());
            ShowColorLabelComponent showColorLabelComponent = this.mainPanel.getColorPickPanelComponent().getShowColorLabelComponent();
            int[] rgbIntArray = Utils.StringToInt(rgbDataControl.getRgbFieldValue());
            String alphStr = alphDataControl.getAlphFieldValue();
            if (Utils.checkAlphFieldValue(alphStr)) {
                showColorLabelComponent.setColor(new Color(rgbIntArray[0], rgbIntArray[1], rgbIntArray[2], Utils.toInt(alphStr)));
                showColorLabelComponent.repaint();
            }
        }
    }

    @Override
    public void colorPick(int x, int y) {
        try {
            Robot robot = new Robot();
            //获取当前像素颜色RGB值
            Color color = robot.getPixelColor(x, y);
            int[] rgbStrArray = {color.getRed(), color.getGreen(), color.getBlue()};
            rgbDataControl = new RgbDataControlImpl(this.mainPanel.getRgbPanelComponent());
            rgbDataControl.setRGBFieldValue(rgbStrArray, rgbDataControl.getRGBFieldObject());
        } catch (AWTException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void changeRgbaFieldValueByHexFieldValue() {
        rgbDataControl = new RgbDataControlImpl(this.mainPanel.getRgbPanelComponent());
        alphDataControl = new AlphDataControlImpl(this.mainPanel.getAlphPanelComponent());
        hexDataControl = new HexDataControlImpl(this.mainPanel.getHexPanelComponent());
        int[] rgbStrArray = Utils.StringToInt(rgbDataControl.getSafeRGBFieldValue());
        int alph = alphDataControl.getSafeAlphFieldValue();
        String hexFieldValuePlus = Utils.toRgbaHexString(rgbStrArray[0], rgbStrArray[1], rgbStrArray[2], alph);
        String hexFieldValue = hexDataControl.getHexFieldValue();
        if (hexFieldValue != null && !hexFieldValue.equalsIgnoreCase(hexFieldValuePlus)){
            List<Integer> rgbaList = Utils.toRGBA(hexFieldValue);
            if (rgbaList.size() == 3){
                rgbDataControl.setRGBFieldValue(rgbaList, rgbDataControl.getRGBFieldObject());
            }else if (rgbaList.size() == 4){
                rgbDataControl.setRGBFieldValue(rgbaList, rgbDataControl.getRGBFieldObject());
                alphDataControl.setAlphFieldValue(rgbaList.get(3));
            }
        }
    }

    @Override
    public void alphFieldLostFocus() {
        alphDataControl = new AlphDataControlImpl(this.mainPanel.getAlphPanelComponent());
        String alphStr = alphDataControl.getAlphFieldValue();
        if (alphStr == null || Utils.toInt(alphStr) > 255){
            alphDataControl.setAlphFieldValue(255);
        }
    }

    @Override
    public void rgbFieldLostFocus() {
        rgbDataControl = new RgbDataControlImpl(this.mainPanel.getRgbPanelComponent());
        String[] rgbStrArray = rgbDataControl.getRgbFieldValue();
        JTextField[] rgbFieldArray = rgbDataControl.getRGBFieldObject();
        for (int i = 0; i < rgbFieldArray.length; i++){
            if (rgbStrArray[i] == null || Utils.toInt(rgbStrArray[i]) > 255){
                rgbDataControl.setRgbFieldValue(255 + "", rgbFieldArray[i]);
            }
        }
    }

    @Override
    public void hsvFieldLostFocus() {
        hsvDataControl = new HsvDataControlImpl(this.mainPanel.getHsvPanelComponent());
        String[] hsvStrArray = hsvDataControl.getHsvFieldValue();
        JTextField[] hsvFieldArray = hsvDataControl.getHsvFieldObject();
        for (int i = 0; i < hsvFieldArray.length; i++){
            if (hsvStrArray[i] == null || Utils.toInt(hsvStrArray[i]) > 100) {
                hsvDataControl.setHsvFieldValue(100 + "", hsvFieldArray[i]);
            }
        }
    }

    @Override
    public void hexFieldLostFocus() {
        hexDataControl = new HexDataControlImpl(this.mainPanel.getHexPanelComponent());
        String hexStr = hexDataControl.getHexFieldValue();
        if (hexStr == null){
            hexDataControl.setHexFieldValue("#FFFFFFFF");
        }
    }
}
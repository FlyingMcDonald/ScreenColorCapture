package com.flyingmcdonald.screencolorcapture.eventslistener.alphlistener;

import com.flyingmcdonald.screencolorcapture.MainPanel;
import com.flyingmcdonald.screencolorcapture.Utils;
import com.flyingmcdonald.screencolorcapture.control.DataControl;
import com.flyingmcdonald.screencolorcapture.control.DataControlImpl;
import com.flyingmcdonald.screencolorcapture.panelcompenents.AlphPanelComponent;
import com.flyingmcdonald.screencolorcapture.panelcompenents.AlphSliderLabelComponent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AlphMouseListener extends MouseAdapter {
    private DataControl dataControl;
    private AlphSliderLabelComponent alphSliderLabelComponent;
    private AlphPanelComponent alphPanelComponent;
    private boolean mouseClicked = false;

    public boolean isMouseClicked() {
        return mouseClicked;
    }

    public void setMouseClicked(boolean mouseClicked) {
        this.mouseClicked = mouseClicked;
    }

    public AlphSliderLabelComponent getAlphSliderLabelComponent() {
        return alphSliderLabelComponent;
    }

    public void setAlphSliderLabelComponent(AlphSliderLabelComponent alphSliderLabelComponent) {
        this.alphSliderLabelComponent = alphSliderLabelComponent;
    }

    public AlphPanelComponent getAlphPanelComponent() {
        return alphPanelComponent;
    }

    public void setAlphPanelComponent(AlphPanelComponent alphPanelComponent) {
        this.alphPanelComponent = alphPanelComponent;
    }

    public AlphMouseListener(MainPanel mainPanel){
        dataControl = new DataControlImpl(mainPanel);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        /*int sliderMidOfCircled = alphSliderLabelComponent.getSliderMidOfCircled();
        String[] alphText = {getAlphPanelComponent().getShowAlphText().getText()};
        String[] alphText_2 = Utils.checkString(alphText, "[^\\d]");
        if(e.getX() < sliderMidOfCircled) {
            alphSliderLabelComponent.setSliderCoordinate(setAlphTextByMouseClicked(sliderMidOfCircled, alphText_2[0]));
            setSliderMidOfCircled(alphSliderLabelComponent.getSliderCoordinate());
        }else if(e.getX() > sliderMidOfCircled){
            setMouseClicked(true);
            alphSliderLabelComponent.setSliderCoordinate(setAlphTextByMouseClicked(sliderMidOfCircled, alphText_2[0]));
            setSliderMidOfCircled(alphSliderLabelComponent.getSliderCoordinate());
            setMouseClicked(false);
        }
        alphSliderLabelComponent.repaint();*/

        dataControl.setAlphFieldValueByMouseClicked(e.getX());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        dataControl.setAlphFieldValueByMouseDragged(e.getX());
    }

    /**
     * 获取Alph滑块圆形图标圆心的坐标
     *
     * @param x
     * @return
     */
    private int getSliderMidOfCirCled(int x) {
        int sliderMidOfCircled = x;
        if(sliderMidOfCircled > 6 && sliderMidOfCircled < 167) {
            sliderMidOfCircled = x - alphSliderLabelComponent.getCIRCLED_R();
        }else {
            sliderMidOfCircled = sliderMidOfCircled > 160 ? 160 : 0;
        }
        return sliderMidOfCircled;
    }

    /**
     * 当光标坐标大于圆心坐标时，每点击一次鼠标alph将会减一
     * 当光标坐标小于圆心坐标时，每点击一次鼠标alph将会加一
     *
     * @param sliderMidOfCircledCoordinate
     * @param alphText
     * @return
     */
    private float setAlphTextByMouseClicked(float sliderMidOfCircledCoordinate, String alphText) {
        float avage = 160 / 255f;
        int alphTextValue = Utils.toInt(alphText);
        if(this.isMouseClicked()) {
            alphPanelComponent.getShowAlphText().setText(""+(alphTextValue + 1));
            alphSliderLabelComponent.setSliderCoordinate(sliderMidOfCircledCoordinate + avage);
        }else {
            alphPanelComponent.getShowAlphText().setText(""+(alphTextValue - 1));
            alphSliderLabelComponent.setSliderCoordinate(sliderMidOfCircledCoordinate - avage);
        }
        return avage*alphTextValue;
    }

    /**
     * 设置滑块圆心中心坐标
     *
     * @param sliderMidOfCircled
     */
    private void setSliderMidOfCircled(float sliderMidOfCircled) {
        alphSliderLabelComponent.setSliderMidOfCircled((int)sliderMidOfCircled);
    }

    /**
     * 根据鼠标拖拽圆心所经过的滑块的长度来显示Alph的值
     *
     * @param sliderMidOfCircled
     */
    private void setAlphTextByMouseDragged(int sliderMidOfCircled) {
        float avage = 255 / 160f;
        int alphTextValue = (int) (sliderMidOfCircled * avage);
        alphPanelComponent.getShowAlphText().setText(""+alphTextValue);
    }
}

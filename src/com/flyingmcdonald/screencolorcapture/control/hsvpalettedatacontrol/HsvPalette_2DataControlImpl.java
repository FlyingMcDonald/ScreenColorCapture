package com.flyingmcdonald.screencolorcapture.control.hsvpalettedatacontrol;

import com.flyingmcdonald.screencolorcapture.panelcompenents.HsvPalettePanelComponent;
import com.flyingmcdonald.screencolorcapture.panelcompenents.HsvPalette_2LabelComponent;

public class HsvPalette_2DataControlImpl implements HsvPalette_2DataControl {
    private HsvPalettePanelComponent hsvPalettePanelComponent;
    private final HsvPalette_2LabelComponent hsvPalette_2LabelComponent;

    public HsvPalettePanelComponent getHsvPalettePanelComponent() {
        return hsvPalettePanelComponent;
    }

    public void setHsvPalettePanelComponent(HsvPalettePanelComponent hsvPalettePanelComponent) {
        this.hsvPalettePanelComponent = hsvPalettePanelComponent;
    }

    public HsvPalette_2DataControlImpl(HsvPalettePanelComponent hsvPalettePanelComponent){
        this.setHsvPalettePanelComponent(hsvPalettePanelComponent);
        this.hsvPalette_2LabelComponent = getHsvPalettePanelComponent().getHsvPalette_2LabelComponent();
    }

    /**
     * 获取圆心的位置
     *
     * @param y 色调版内的纵坐标
     */
    @Override
    public int getMidOfCircled(int y) {
        if(y > 6 && y < 207)
            return y - hsvPalette_2LabelComponent.getCIRCLED_R();
        if (y > 201)
            return 201;
        return 0;
    }

    @Override
    public void setMidOfCircled(int midOfCircled) {
        hsvPalette_2LabelComponent.setMidOfCircled(midOfCircled);
        hsvPalette_2LabelComponent.repaint();
    }
}

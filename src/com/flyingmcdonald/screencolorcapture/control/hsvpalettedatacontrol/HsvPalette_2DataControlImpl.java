package com.flyingmcdonald.screencolorcapture.control.hsvpalettedatacontrol;

import com.flyingmcdonald.screencolorcapture.panelcompenents.HsvPalettePanelComponent;
import com.flyingmcdonald.screencolorcapture.panelcompenents.HsvPalette_2LabelComponent;

public class HsvPalette_2DataControlImpl implements HsvPalette_2DataControl {
    private HsvPalettePanelComponent hsvPalettePanelComponent;
    private HsvPalette_2LabelComponent hsvPalette_2LabelComponent;

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
     * @param y
     */
    @Override
    public int getMidOfCircled(int y) {
        int midOfCircled = y;
        if(midOfCircled > 6 && midOfCircled < 207) {
            midOfCircled = y - hsvPalette_2LabelComponent.getCIRCLED_R();
        }else {
            midOfCircled = midOfCircled > 201 ? 201 : 0;
        }
        return midOfCircled;
    }

    @Override
    public void setMidOfCircled(int midOfCircled) {
        hsvPalette_2LabelComponent.setMidOfCircled(midOfCircled);
        hsvPalette_2LabelComponent.repaint();
    }
}

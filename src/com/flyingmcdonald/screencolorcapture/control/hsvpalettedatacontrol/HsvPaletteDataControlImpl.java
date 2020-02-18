package com.flyingmcdonald.screencolorcapture.control.hsvpalettedatacontrol;

import com.flyingmcdonald.screencolorcapture.Utils;
import com.flyingmcdonald.screencolorcapture.panelcompenents.HsvPaletteLabelComponent;
import com.flyingmcdonald.screencolorcapture.panelcompenents.HsvPalettePanelComponent;

public class HsvPaletteDataControlImpl implements HsvPaletteDataControl {
    private HsvPalettePanelComponent hsvPalettePanelComponent;
    private HsvPaletteLabelComponent hsvPaletteLabelComponent;

    public HsvPalettePanelComponent getHsvPalettePanelComponent() {
        return hsvPalettePanelComponent;
    }

    public void setHsvPalettePanelComponent(HsvPalettePanelComponent hsvPalettePanelComponent) {
        this.hsvPalettePanelComponent = hsvPalettePanelComponent;
    }

    public HsvPaletteDataControlImpl(HsvPalettePanelComponent hsvPalettePanelComponent){
        this.setHsvPalettePanelComponent(hsvPalettePanelComponent);
        this.hsvPaletteLabelComponent = getHsvPalettePanelComponent().getHsvPaletteLabelComponent();
    }

    @Override
    public int[] getCrossCoordinates(int x, int y) {
        return Utils.checkCoordinates(x, y);
    }

    @Override
    public void setCrosshair(int[] crossCoordinates) {
        hsvPaletteLabelComponent.setCrosshirCoordinates(crossCoordinates);
        hsvPaletteLabelComponent.setHorizontalY(crossCoordinates[1]);
        hsvPaletteLabelComponent.setVerticalX(crossCoordinates[0]);
        hsvPaletteLabelComponent.repaint();
    }
}

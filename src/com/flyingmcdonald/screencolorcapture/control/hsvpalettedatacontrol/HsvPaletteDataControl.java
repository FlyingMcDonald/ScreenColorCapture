package com.flyingmcdonald.screencolorcapture.control.hsvpalettedatacontrol;

public interface HsvPaletteDataControl {
    int[] getCrossCoordinates(int x, int y);
    void setCrosshair(int[] crossCoordinates);
}

package com.flyingmcdonald.screencolorcapture.panelcompenents;

import javax.swing.*;
import java.awt.*;

public class AlphSliderLabelComponent extends JLabel {
    private static final long serialVersionUID = 1L;
    final private int CIRCLED_R = 7;
    private int sliderMidOfCircled = 160;

    public int getSliderMidOfCircled() {
        return sliderMidOfCircled;
    }

    public void setSliderMidOfCircled(int sliderMidOfCircled) {
        this.sliderMidOfCircled = sliderMidOfCircled;
    }

    public int getCIRCLED_R() {
        return CIRCLED_R;
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(96, 100, 104));
        g2.fillRoundRect(this.CIRCLED_R, 4, 160, 6, 6, 6);
        g2.setColor(Color.white);
        g2.fillOval(this.sliderMidOfCircled, 0, 14, 14);
    }
}

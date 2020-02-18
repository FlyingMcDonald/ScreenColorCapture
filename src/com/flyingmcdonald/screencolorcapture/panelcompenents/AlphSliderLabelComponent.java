package com.flyingmcdonald.screencolorcapture.panelcompenents;

import javax.swing.*;
import java.awt.*;

public class AlphSliderLabelComponent extends JLabel {
    private static final long serialVersionUID = 1L;
    final private int CIRCLED_R = 7;
    final private int CIRCLED_D = this.CIRCLED_R * 2;
    final private int WIDTH = 160;
    private int sliderMidOfCircled = 160;
    private float sliderCoordinate;

    public float getSliderCoordinate() {
        return sliderCoordinate;
    }

    public void setSliderCoordinate(float sliderCoordinate) {
        this.sliderCoordinate = sliderCoordinate;
    }

    public int getSliderMidOfCircled() {
        return sliderMidOfCircled;
    }

    public void setSliderMidOfCircled(int sliderMidOfCircled) {
        this.sliderMidOfCircled = sliderMidOfCircled;
    }

    public int getCIRCLED_R() {
        return CIRCLED_R;
    }

    public int getCIRCLED_D() {
        return CIRCLED_D;
    }


    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.clearRect(0, 0, 14, 216);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(96, 100, 104));
        g2.fillRoundRect(this.CIRCLED_R, 4, WIDTH, 6, 6, 6);
        g2.setColor(Color.white);
        g2.fillOval(this.sliderMidOfCircled, 0, this.CIRCLED_D, this.CIRCLED_D);
    }
}

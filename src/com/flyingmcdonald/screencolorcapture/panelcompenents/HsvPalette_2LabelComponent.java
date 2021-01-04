package com.flyingmcdonald.screencolorcapture.panelcompenents;

import javax.swing.*;
import java.awt.*;

//长条形状的渐变画板
public class HsvPalette_2LabelComponent extends JLabel {
    /**
      *  @author FlyingMcDonald
      */
    private static final long serialVersionUID = 1L;
    final private int CIRCLED_R = 7;
    final private int CIRCLED_D = this.CIRCLED_R * 2;
    private int midOfCircled;

    public int getMidOfCircled() {
        return midOfCircled;
    }

    public void setMidOfCircled(int midOfCircled) {
        this.midOfCircled = midOfCircled;
    }

    public int getCIRCLED_R() {
        return CIRCLED_R;
    }

    public int getCIRCLED_D() {
        return CIRCLED_D;
    }

    public HsvPalette_2LabelComponent(){
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int index_2 = this.CIRCLED_R;
        for(int i = 0; i < 100; i++) {
            int height_2 = 200;
            for(int j = 0; j < (height_2 / 100); j++) {
                g2.setColor(Color.getHSBColor(i/99f, 1.0f, 1.0f));
                g2.drawLine(4, index_2, 10, index_2);
                index_2++;
            }
        }
        g2.setColor(Color.white);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fillOval(0, this.midOfCircled, this.CIRCLED_D, this.CIRCLED_D);
//		System.out.println(this.midOfCircled);
    }
}

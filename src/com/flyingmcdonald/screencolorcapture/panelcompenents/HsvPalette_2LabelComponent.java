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
    private int midOfCircled;

    public void setMidOfCircled(int midOfCircled) {
        System.out.println(midOfCircled);
        if(midOfCircled > 201 || midOfCircled < 0) {
            this.midOfCircled = midOfCircled > 201 ? 201 : 0;
        }else{
            this.midOfCircled = midOfCircled;
        }
    }

    public int getCIRCLED_R() {
        return CIRCLED_R;
    }

    public HsvPalette_2LabelComponent(){
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int index_2 = CIRCLED_R;
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 2; j++) {
                g2.setColor(Color.getHSBColor(i/99f, 1.0f, 1.0f));
                g2.drawLine(4, index_2, 10, index_2);
                index_2++;
            }
        }
        g2.setColor(Color.white);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fillOval(0, midOfCircled, CIRCLED_R * 2, CIRCLED_R * 2);
    }
}

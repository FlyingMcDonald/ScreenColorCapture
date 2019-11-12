package com.flyingmcdonald.test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JSlider;
import javax.swing.plaf.basic.BasicSliderUI;

public class TestMethod5 extends BasicSliderUI{
	public TestMethod5(JSlider b) {
		super(b);
	}

	@Override
	public void paintThumb(Graphics g) {
		 Graphics2D g2d = (Graphics2D) g;
         g2d.setColor(Color.black);
         
         g2d.fillOval(thumbRect.x, thumbRect.y, 14,
                 14);
         g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	}
	
	@Override
	public void paintTrack(Graphics g) {
        Rectangle trackBounds = new Rectangle(new Dimension(100, 8));
        if (slider.getOrientation() == JSlider.HORIZONTAL) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setPaint(Color.black);//将背景设为黑色

            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2.translate(trackRect.x, trackRect.y);	//trackBounds.x = 7, trackBounds.y = 128+6 = 134
            g2.setColor(Color.cyan);
            g2.fillRect(0, 0, 100, 8);
            g2.translate(-trackRect.x, -trackRect.y);
//            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
//                    RenderingHints.VALUE_ANTIALIAS_ON);
        }
        else {
            super.paintTrack(g);
            }
    }
	
	@Override
	public void paintFocus(Graphics g) {
	}
	
	
}

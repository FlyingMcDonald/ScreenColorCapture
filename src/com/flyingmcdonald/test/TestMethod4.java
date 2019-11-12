package com.flyingmcdonald.test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JSlider;

public class TestMethod4 {
	private static JSlider slider = new JSlider();
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.setTitle("test");
		frame.setSize(500, 300);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		slider.setUI(new javax.swing.plaf.metal.MetalSliderUI() {
			@Override
            public void paintThumb(Graphics g) {
                //绘制指示物
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(Color.black);
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.fillOval(thumbRect.x, thumbRect.y, thumbRect.width,
                        thumbRect.height);
                //修改为圆形
                //也可以帖图(利用鼠标事件转换image即可体现不同状态)
                //g2d.drawImage(image, thumbRect.x, thumbRect.y, thumbRect.width,thumbRect.height,null);

            }
            public void paintTrack(Graphics g) {
                //绘制刻度的轨迹
                int cy,cw;
                Rectangle trackBounds = new Rectangle(new Dimension(100, 16));
//                System.out.println(trackBounds.width+"\n"+trackBounds.height);
                if (slider.getOrientation() == JSlider.HORIZONTAL) {
                    Graphics2D g2 = (Graphics2D) g;
                    g2.setPaint(Color.black);//将背景设为黑色
                    cy = (trackBounds.height/2) - 2;	// cy = 6
//                    System.out.println("cy="+cy);
                    cw = trackBounds.width;				// cw = 482

                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
//                    System.out.println(trackBounds.x+"\n"+trackBounds.y);
                    g2.translate(trackRect.x, trackRect.y);	//trackBounds.x = 7, trackBounds.y = 128+6 = 134
                    g2.setColor(Color.cyan);
                    g2.fillRect(0, 0, 100, 8);
//                    int a = (int) cw / 100 + 1;
//                    int b = 0;
//                    for(int i = 0; i <= 100; i++) {
//                    	for(int j = 0; j < a; j++) {
//                    		g2.setColor(Color.getHSBColor(i/100f, 1.0f, 1.0f));
//                    		g2.drawLine(b, 0, b, cy);
//                    		b++;
//                    	}
//                    }
                    

//                    int trackLeft = 0;
//                    int trackRight = 0;
//                    trackRight = trackRect.width;	// 481
//                    System.out.println("trackRight: "+trackRight);
//                    int middleOfThumb = 0;
//                    int fillLeft = 0;
//                    int fillRight = 0;
//                    //换算坐标
//                    System.out.println(thumbRect.x);
//                    middleOfThumb = thumbRect.x + thumbRect.width / 2; //thumbRect.x + (thumbRect.width / 2);
//                    System.out.println("middleOfThumb: "+middleOfThumb+"\n"+"trackRect: "+trackRect.x);
//                    middleOfThumb -= trackRect.x;

//                    if (!drawInverted()) {
//                        fillLeft = !slider.isEnabled() ? trackLeft : trackLeft + 1;
//                        System.out.println("fillLeft: "+fillLeft);
//                        fillRight = middleOfThumb;
//                        } else {
//                        fillLeft = middleOfThumb;
//                        fillRight = !slider.isEnabled() ? trackRight - 1
//                        : trackRight - 2;
//                        }
                    //设定渐变,在这里从红色变为红色,则没有渐变,滑块划过的地方自动变成红色
//                    g2.setColor(Color.getHSBColor(h, s, b));
//                    g2.fillRect(0, -cy + 5, fillRight - fillLeft, cy);

//                    g2.setPaint(slider.getBackground());
//                    g2.fillRect(0, cy, cw, 5);

//                    g2.setPaint(Color.WHITE);
//                    g2.drawLine(0, cy, cw - 1, cy);

//                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
//                    RenderingHints.VALUE_ANTIALIAS_OFF);
                    g2.translate(-trackRect.x, -trackRect.y);                    
                }
                else {
                    super.paintTrack(g);
                    }
            }
		});
//		frame.getContentPane().add(gradientPanel);
		frame.getContentPane().add(slider);
	}
}

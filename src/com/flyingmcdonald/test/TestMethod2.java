package com.flyingmcdonald.test;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.UIManager;
import javax.swing.plaf.SliderUI;


public class TestMethod2 {
	private static GradientPanel gradientPanel = new GradientPanel();
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.setTitle("test");
		frame.setSize(500, 300);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		frame.getContentPane().add(gradientPanel);
	}
}

class GradientPanel extends JPanel{
	BufferedImage image, image_2;
	public void initialize() {
		final int width = 202;
		final int height = 202;
		final int width_2 = 20;
		final int height_2 = 202;
		int[] data = new int[width*height];
		int[] data2 = new int[width_2*height_2];
		int index = 0;
		int index_2 = 0;
		for(int i = 100; i >= 0; i--) {
			float s = (float) i;
			for(int num_1 = 0; num_1 < (height / 101); num_1++) {
				for(int j = 0; j <= 100; j++) {
					float v = (float) j;
					for(int num_2 = 0; num_2 < (width / 101); num_2++) {
						data[index++] = Color.HSBtoRGB(0.0f, s/100f, v/100f);
						
					}
				}
			}
		}
		
		for(int i = 0; i <= 100; i++) {
			float h = (float) i;
			for(int num_3 = 0; num_3 < (height_2 / 101); num_3++) {
				for(int num_4 = 0; num_4 < width_2; num_4++) {
					data2[index_2++] = Color.HSBtoRGB(h/100f, 1.0f, 1.0f);
				}
			}
		}
		image_2 = new BufferedImage(width_2, height_2, BufferedImage.TYPE_INT_RGB);
		image_2.setRGB(0, 0, width_2, height_2, data2, 0, width_2);
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		image.setRGB(0, 0, width, height, data, 0, height);
	}
	
	public void paint(Graphics g) {
		initialize();
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(image, 0, 0, this);
		g2.drawImage(image_2, 205, 0, this);
	}
}

package com.flyingmcdonald.screencolorcapture;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

	class HsvPalette extends JLabel{	//彩虹渐变面板
	/**
	 * @author FlyingMcDonald
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage image;
	private float hue;
	private int horizontalY = 0;		//水平线的Y轴
	private int VerticalX = 0;			//垂直线的X轴
	private int coordinateX;			//十字线相交点的X坐标
	private int coordinateY;			//十字线相交点的Y坐标
	
	final int width = 202;
	final int height = 202;
	
	
	public int getCoordinateX() {
		return coordinateX;
	}

	public void setCoordinateX(int coordinateX) {
		this.coordinateX = coordinateX;
	}

	public int getCoordinateY() {
		return coordinateY;
	}

	public void setCoordinateY(int coordinateY) {
		this.coordinateY = coordinateY;
	}

	public int getHorizontalY() {
		return horizontalY;
	}

	public void setHorizontalY(int horizontalY) {
		this.horizontalY = horizontalY;
	}

	public int getVerticalX() {
		return VerticalX;
	}

	public void setVerticalX(int verticalX) {
		VerticalX = verticalX;
	}

	public float getHue() {
		return hue;
	}

	public void setHue(float hue) {
		this.hue = hue;
	}

	public void initialize() {
		int[] data = new int[width*height];
		int index = 0;
		for(int i = 100; i >= 0; i--) {
			float s = (float) i;
			for(int num_1 = 0; num_1 < (height / 101); num_1++) {
				for(int j = 0; j <= 100; j++) {
					float v = (float) j;
					for(int num_2 = 0; num_2 < (width / 101); num_2++) {
						data[index++] = Color.HSBtoRGB(this.hue, s/100f, v/100f);
					}
				}
			}
		}
		
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		image.setRGB(0, 0, width, height, data, 0, height);
	}

	public void paint(Graphics g) {
		initialize();
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(image, 0, 0, this);
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(1.0f));
		g2.drawLine(0, this.horizontalY, 201, this.horizontalY);
		g2.drawLine(this.VerticalX, 0, this.VerticalX, 201);
		
	}
}

	class HsvPalette_2 extends JLabel{		//改主体色的画板

	/**
	 * @author FlyingMcDonald
	 */
	private static final long serialVersionUID = 1L;
	final private int CIRCLED_R = 7;
	final private int CIRCLED_D = this.CIRCLED_R * 2;
	final private int height_2 = 200;
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

	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.clearRect(0, 0, 14, 216);
		int index_2 = this.CIRCLED_R;
		for(int i = 0; i < 100; i++) {
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
	
	class ShowColorLabel extends JLabel{	//Alph滑块
		/**
		 * 
		 */
		private BufferedImage image = null;
		private static final long serialVersionUID = 1L;
		private final int WIDTH = 150;
		private final int HEIGHT = 30;
		private Color color = Color.WHITE;
		
		public Color getColor() {
			return color;
		}
		public void setColor(Color color) {
			this.color = color;
		}
		private void drawImg() {
			try {
				image = ImageIO.read(new File("./img/image.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void paint(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			drawImg();
			g2.drawImage(image, 0, 0, 150, 30, null);
			g2.setColor(new Color(97, 101, 105));
			g2.drawRect(0, 0, WIDTH, HEIGHT);
			g2.setColor(Color.WHITE);
			g2.fillRect(0, 0, WIDTH/2, HEIGHT);
			g2.setColor(this.getColor());
			g2.fillRect(WIDTH/2, 0, WIDTH/2, HEIGHT);
		}
	}
	
	class AlphSlider extends JLabel{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		final private int CIRCLED_R = 7;
		final private int CIRCLED_D = this.CIRCLED_R * 2;
		final private int WIDTH = 160;
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

		public int getCIRCLED_D() {
			return CIRCLED_D;
		}

		
		public void paint(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			g2.clearRect(0, 0, 14, 216);
			int index_2 = this.CIRCLED_R;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setColor(new Color(96, 100, 104));
			g2.fillRoundRect(index_2, 4, WIDTH, 6, 6, 6);
			g2.setColor(Color.white);
			
			g2.fillOval(this.sliderMidOfCircled, 0, this.CIRCLED_D, this.CIRCLED_D);
		}
	}

package com.flyingmcdonald.screencolorcapture.panelcompenents;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class HsvPaletteLabelComponent extends JLabel {   //正方形的彩虹渐变面板
    /**
     * @author FlyingMcDonald
     */
    private static final long serialVersionUID = 1L;
    private BufferedImage image;
    private float hue;
    private int horizontalY = 0;		//水平线的Y轴
    private int VerticalX = 0;			//垂直线的X轴
    /*private int coordinateX;			//十字线相交点的X坐标
    private int coordinateY;	*/		//十字线相交点的Y坐标
    private int[] crosshirCoordinates;

    /*public int getCoordinateX() {
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
    }*/

    public int[] getCrosshirCoordinates() {
        return crosshirCoordinates;
    }

    public void setCrosshirCoordinates(int[] crosshirCoordinates) {
        this.crosshirCoordinates = crosshirCoordinates;
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

    /*public HsvPaletteLabelComponent(){
        this.setPreferredSize(new Dimension(202, 202));
        initialize();
    }*/

    public void initialize() {
        int width = 202;
        int height = 202;
        int[] data = new int[width * height];
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

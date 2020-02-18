package com.flyingmcdonald.screencolorcapture.panelcompenents;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ShowColorLabelComponent extends JLabel {
    private BufferedImage image = null;
    private static final long serialVersionUID = 1L;
    private Color color;

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
        int WIDTH = 150;
        int HEIGHT = 30;
        g2.drawRect(0, 0, WIDTH, HEIGHT);
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, WIDTH /2, HEIGHT);
        if (this.color == null){
            g2.setColor(Color.WHITE);
        }else{
            g2.setColor(this.color);
        }
        g2.fillRect(WIDTH /2, 0, WIDTH /2, HEIGHT);
    }
}

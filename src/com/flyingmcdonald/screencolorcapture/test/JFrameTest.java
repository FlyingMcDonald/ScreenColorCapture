package com.flyingmcdonald.screencolorcapture.test;

import javax.swing.*;
import java.awt.*;

public class JFrameTest extends JFrame {
    JPanel jPanel = new JPanel();
    public JFrameTest(String title) throws HeadlessException {
        super(title);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new LayoutTest());
        setVisible(true);
        initUI();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initUI(){
        Container container = this.getContentPane();
        jPanel.setPreferredSize(new Dimension(100, 100));
        jPanel.setBackground(Color.CYAN);
        container.add(jPanel);
    }

    private class LayoutTest implements LayoutManager{

        @Override
        public void addLayoutComponent(String name, Component comp) {

        }

        @Override
        public void removeLayoutComponent(Component comp) {

        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            return null;
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            return null;
        }

        @Override
        public void layoutContainer(Container parent) {
            int wid = parent.getWidth();
            int hei = parent.getHeight();
            Dimension size = jPanel.getPreferredSize();
            int x = (wid - size.width) / 2;
            int y = (hei - size.height) / 2;
            jPanel.setBounds(x, y, size.width, size.height);
        }
    }
}

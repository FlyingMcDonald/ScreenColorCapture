package com.flyingmcdonald.screencolorcapture.eventslistener.colorpicklistener;

import com.flyingmcdonald.screencolorcapture.MainPanel;
import com.flyingmcdonald.screencolorcapture.control.DataControl;
import com.flyingmcdonald.screencolorcapture.control.DataControlImpl;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ColorPickMouseListener extends MouseAdapter {
    private final DataControl dataControl;
    private JFrame colorPickFrame;
    private final MainPanel mainPanel;

    public void setColorPickFrame(JFrame colorPickFrame) {
        this.colorPickFrame = colorPickFrame;
    }

    public ColorPickMouseListener(MainPanel mainPanel, JFrame colorPickFrame){
        this.dataControl = new DataControlImpl(mainPanel);
        this.setColorPickFrame(colorPickFrame);
        this.mainPanel = mainPanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        dataControl.colorPick(e.getX(), e.getY());
        colorPickFrame.dispose();
        mainPanel.setVisible(true);
    }
}

package com.flyingmcdonald.test;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;



public class TestWindow extends JFrame{
	
	
	//ColorGetter cg;
	
	JTextField JText_1 = new JTextField();
	JTextField JText_2 = new JTextField();
	
	public TestWindow() {
		
		this.setUndecorated(true);
		this.setLayout(new BorderLayout());
		this.add(JText_1, BorderLayout.SOUTH);
		this.add(JText_2, BorderLayout.NORTH);
		JText_1.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				System.out.println(JText_1.getText());
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				System.out.println(JText_1.getText());
				if (JText_1.getText().equals("123")) {
					JText_2.setBackground(Color.black);
				}else {
					JText_2.setBackground(Color.PINK);
				}
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {

				System.out.println("changed");
			}
		});
		this.setSize(400, 200);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	
    public static void main(String[] args) {
    	new TestWindow();
    }
}
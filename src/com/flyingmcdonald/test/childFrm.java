package com.flyingmcdonald.test;

import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
 
public class childFrm {
	private parentFrm parentFrm;
	String name;
	private JFrame chFrm;
	private JTextField jtf_name;
	private JButton jbt_submit;
//	public static void main(String[] args) {
//		new parentFrm();
//	}
	
 
	public childFrm(){}
	
	public childFrm(parentFrm parentFrm){
		this.parentFrm = parentFrm;
	}
	public void init(){
		chFrm = new JFrame();
		
//		jtf_name = new JTextField("请输入姓名");
//		jbt_submit = new JButton("提交");
		
		chFrm.setSize(400, 300);
		int screen_width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screen_height = Toolkit.getDefaultToolkit().getScreenSize().height;
		chFrm.setLocation((screen_width - chFrm.getWidth()) / 2, (screen_height - chFrm.getHeight()) / 2);
		chFrm.setVisible(true);
		chFrm.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				parentFrm.getJta_viem().setText("X:"+e.getX()+","+"Y:"+e.getY());
				System.out.println("X:"+e.getX()+","+"Y:"+e.getY());
			}
		});
	}
	public void open(){
		init();
	}
}

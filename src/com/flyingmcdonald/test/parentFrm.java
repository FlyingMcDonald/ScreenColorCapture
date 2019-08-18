package com.flyingmcdonald.test;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
 
public class parentFrm {
	private JFrame parFrm;
	private JButton jbt_add;
	private JTextArea jta_viem;
	
	public JFrame getParFrm() {
		return parFrm;
	}
	public void setParFrm(JFrame parFrm) {
		this.parFrm = parFrm;
	}
	public JTextArea getJta_viem() {
		return jta_viem;
	}
	public void setJta_viem(JTextArea jta_viem) {
		this.jta_viem = jta_viem;
	}
	public static void main(String[] args) {
		new parentFrm();
	}
	public void openson(){
		childFrm mySon=new childFrm(this);//把父窗口当子窗口参数
		mySon.open();
	}
	
	public parentFrm() {
		parFrm = new JFrame();
		jbt_add = new JButton("添加");
		jta_viem = new JTextArea("请添加");
		
		parFrm.setLayout(new BorderLayout());
		parFrm.add(jta_viem, "Center");
		parFrm.add(jbt_add, "South");
		parFrm.setSize(400, 300);
		int screen_width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screen_height = Toolkit.getDefaultToolkit().getScreenSize().height;
		parFrm.setLocation((screen_width - parFrm.getWidth()) / 2, (screen_height - jbt_add.getHeight()) / 2);
		parFrm.setVisible(true);
		
		jbt_add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				openson();//打开子窗口
			}
		});
	}
}
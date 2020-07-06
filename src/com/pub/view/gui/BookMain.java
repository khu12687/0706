package com.pub.view.gui;

import java.awt.FlowLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;

//프로그램 개발시, 특정 객체에 대한 생성을 new 연산자를 사용하면
//유연하지 못하게 된다.. 따라서 인스턴스 생성시 직접하지말고,
//외부의 객체가 대신 해주고, 객체간의 관계까지 설정하는 방식으로 개발해보자
// = DI(의존성 있는 객체는 집적 생성하지 말고 주입받자) 라 한다!!
public class BookMain extends JFrame{
	JComponent t_title;
	JComponent t_pub;
	JComponent t_price;
	JComponent bt;
	
	public BookMain() {
		
		setLayout(new FlowLayout());
		add(t_title);
		add(t_pub);
		add(t_price);
		
		setSize(300,250);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
}

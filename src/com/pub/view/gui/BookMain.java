package com.pub.view.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.pub.model.product.Book;
import com.pub.model.product.BookDAO;

//프로그램 개발시, 특정 객체에 대한 생성을 new 연산자를 사용하면
//유연하지 못하게 된다.. 따라서 인스턴스 생성시 직접하지말고,
//외부의 객체가 대신 해주고, 객체간의 관계까지 설정하는 방식으로 개발해보자
// = DI(의존성 있는 객체는 집적 생성하지 말고 주입받자) 라 한다!!
public class BookMain extends JFrame {
	JComponent t_title;
	JComponent t_pub;
	JComponent t_price;
	JComponent bt;
	BookDAO bookDAO;
	// setter 주입!!
	// 객체 주입 방법을 setter 메서드를 이용하는 방법
	public void setT_title(JComponent t_title) {
		this.t_title = t_title;
	}

	public void setT_pub(JComponent t_pub) {
		this.t_pub = t_pub;
	}

	public void setT_price(JComponent t_price) {
		this.t_price = t_price;
	}

	public void setBt(JComponent bt) {
		this.bt = bt;
	}
	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
	public void init() {

		setLayout(new FlowLayout());
		add(t_title);
		add(t_pub);
		add(t_price);
		add(bt);

		setSize(300, 250);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JButton btn = (JButton) bt;
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regist();
			}
		});
	}

	public void regist() {
		Book book = new Book();
		book.setTitle(((JTextField)t_title).getText());
		book.setPub(((JTextField)t_pub).getText());
		book.setPrice(Integer.parseInt(((JTextField)t_price).getText()));
		
		int result = bookDAO.insert(book);
		
		if(result==0) {
			JOptionPane.showMessageDialog(this, "등록실패");
		}else {
			JOptionPane.showMessageDialog(this, "등록성공");
		}
	}
}

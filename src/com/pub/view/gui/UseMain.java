package com.pub.view.gui;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//스프링을 이용하여 BookMain과 의존성 관계에 있는 객체들의
//인스턴스를 대신 생성해주고, 주입까지 시켜보자(DI)
public class UseMain {
	public static void main(String[] args) {
		//xml 설정 파일이 패키지에 있을 경우 사용할 수 있는 ApplicationContext
		ClassPathXmlApplicationContext applicationContext = null;
		applicationContext = new ClassPathXmlApplicationContext("com/pub/view/gui/gui_context.xml");
		
		//생성자 호출에 의해 xml에 명시된 태그들은 자바의 인스턴스화 된다!!!
		//안드로이드 분야에서는 이러한 절차를 inflation
		BookMain bookMain = (BookMain)applicationContext.getBean("bookMain");
		bookMain.init();
	}
}

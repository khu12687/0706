package com.pub.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//test uri 요청을 처리하는 컨트롤러!!
//아래의 클래스는 그냥 POJO(Plain Old Java Object)에 불과하므로,
//웹에서의 요청을 처리하는 컨트롤러서의 역할을 수행할수 없다
//따라서 Controller인터페이스를 상속받거나, 무언가 표시를 해야한다!
@Controller
public class TestController {
	//어노테이션이란? 주석이다, 프로그래밍 언어안에서 무언가 표시를 줄 수 있는 주석..
	//일반적인 주석을 실행부가 무시하지만 이 어노테이션은 프로그램에 사용될 수 있다..
	//주용도 : 설정 정보를 기재할때..
	@RequestMapping("/test") //  /test요청을 아래의 메서드가 처리
	public String getResult() {
		
		return "result/test_result";
	}
}

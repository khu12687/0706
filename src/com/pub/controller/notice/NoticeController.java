package com.pub.controller.notice;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pub.model.notice.Notice;
import com.pub.model.notice.NoticeDAO;

//Notice 게시판과 관련된 CRUD 요청을 처리하는 컨트롤러!!
@Controller
public class NoticeController {
	private NoticeDAO noticeDAO;
	
	//setter 주입(Ingection)을 기다린다!!
	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}
	//모든 게시물 가져오기!!
	@RequestMapping("/notice/list")
	public ModelAndView selectAll() {
		List noticeList = noticeDAO.selectAll();
		//ModelAndView에 저장할 데이터를 객체로 저장!!
		//Model : vo 가져갈 데이터를 담는 객체
		//View : 어떤 페이지를 보여줄지를 결정하는 객체
		
		ModelAndView mav = new ModelAndView();
		
		//request.setAttribute() 효과와 같다!
		mav.addObject("noticeList",noticeList);
		mav.setViewName("notice/list");
		
		return mav;
	}
	
	@RequestMapping("/notice/regist")
	public ModelAndView insert(Notice notice) {
		System.out.println("작성자 : "+notice.getWriter());
		noticeDAO.insert(notice);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/notice/list");
		return mav;
	}
	
	//상세보기
	@RequestMapping("/notice/content")
	public ModelAndView select(int notice_id) {
		Notice notice= noticeDAO.select(notice_id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("notice",notice);
		mav.setViewName("notice/content");
		return mav;
	}
	
	//수정(redirect:)
	@RequestMapping("/notice/edit")
	public ModelAndView update(Notice notice) {
		noticeDAO.update(notice);
		ModelAndView mav = new ModelAndView();
		
		//수정 후, 상세보기 요청(새롭게 접속!!)
		mav.setViewName("redirect:/notice/content?notice_id="+notice.getNotice_id());
		return mav;
	}
	
	//삭제(redirect)
	@RequestMapping("/notice/delete")
	public String delete(int notice_id) {
		//삭제후 가져갈것이 없을때는 굳이 ModelAndView 명시하지 않고
		//String으로 view를 반환해도됨
		noticeDAO.delete(notice_id);
		return "redirect:/notice/list";
		
	}
}

package com.haley.practice;

import java.sql.Connection;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.haley.practice.domain.UserBoard;
import com.haley.practice.service.UserBoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	private UserBoardService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		return "home";
	}

	@RequestMapping(value = "boardList", method = RequestMethod.GET)
	public String boardList(Model model) {

		// 요청 처리 메소드 호출
		List<UserBoard> list = service.boardList();
		model.addAttribute("list", list);

		return "list";
	}

	// 상세 보기 요청 처리
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(Model model, @RequestParam("no") int no) {

		// list.jsp에서의 요청 코드
		// <a href="detail?no=${board.no}">
		// - 파라미터 no 값을 가져오는 방법 선택 => @RequestParam
		// - 상세 보기 결과 값을 jsp 페이지로 보내는 방법 선택 => Model
		UserBoard userBoard = service.getBoard(no);
		model.addAttribute("board", userBoard);

		return "detail";
	}

	// 게시글 작성 페이지로 이동
	@RequestMapping(value = "boardWrite", method = RequestMethod.GET)
	public String write() {

		return "write";
	}

	@RequestMapping(value = "saveboard", method = RequestMethod.POST)
	public String saveboard(UserBoard userBoard) {

		service.saveBoard(userBoard);

		// 게시글 저장 후 목록보기 화면으로 이동
		// redirect:이동하고 싶은 요청 주소
		// "redirect:boardList" -> boardList 요청으로 이동해라!
		return "redirect:boardList";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(@RequestParam("no") int no) {

		service.deleteBoard(no);
		
		// 목록 보기로 이동
		return "redirect:boardList";
	}

}

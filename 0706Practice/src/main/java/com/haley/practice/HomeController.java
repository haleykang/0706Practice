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

		// ��û ó�� �޼ҵ� ȣ��
		List<UserBoard> list = service.boardList();
		model.addAttribute("list", list);

		return "list";
	}

	// �� ���� ��û ó��
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(Model model, @RequestParam("no") int no) {

		// list.jsp������ ��û �ڵ�
		// <a href="detail?no=${board.no}">
		// - �Ķ���� no ���� �������� ��� ���� => @RequestParam
		// - �� ���� ��� ���� jsp �������� ������ ��� ���� => Model
		UserBoard userBoard = service.getBoard(no);
		model.addAttribute("board", userBoard);

		return "detail";
	}

	// �Խñ� �ۼ� �������� �̵�
	@RequestMapping(value = "boardWrite", method = RequestMethod.GET)
	public String write() {

		return "write";
	}

	@RequestMapping(value = "saveboard", method = RequestMethod.POST)
	public String saveboard(UserBoard userBoard) {

		service.saveBoard(userBoard);

		// �Խñ� ���� �� ��Ϻ��� ȭ������ �̵�
		// redirect:�̵��ϰ� ���� ��û �ּ�
		// "redirect:boardList" -> boardList ��û���� �̵��ض�!
		return "redirect:boardList";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(@RequestParam("no") int no) {

		service.deleteBoard(no);
		
		// ��� ����� �̵�
		return "redirect:boardList";
	}

}

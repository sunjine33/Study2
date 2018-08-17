package com.sunjine33.study2.controller;

import java.util.List;

import javax.inject.Inject;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sunjine33.study2.domain.BoardVO;
import com.sunjine33.study2.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public void registerGET(BoardVO boardvo, Model model) throws Exception{
		logger.info("register get ...........");
//		return "register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerPOST(BoardVO boardvo, RedirectAttributes rttr) throws Exception{
		logger.info("regist post .............");
		logger.info(boardvo.toString());
		
		service.regist(boardvo);
		
//		model.addAttribute("result","success");
		
//		return  "/board/success";
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/board/listAll";
		
	}
	
	
	@RequestMapping(value="/listAll", method=RequestMethod.GET)
	public void listAll(Model model) throws Exception{
		logger.info(">>>>>> show listAll");
		List<BoardVO> board = service.listall();
		model.addAttribute("listAll", board);
	}
}

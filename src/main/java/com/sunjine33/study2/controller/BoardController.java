package com.sunjine33.study2.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public void modifyGet(@RequestParam("bno") Integer bno, Model model) throws Exception{
		BoardVO boardvo = service.read(bno);
		model.addAttribute(boardvo);
		logger.info(">>>> board.read: {}", boardvo);
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyPOST(BoardVO boardvo, RedirectAttributes rttr) throws Exception{
		logger.info("modify post .............");
		service.modify(boardvo);
		rttr.addFlashAttribute("msg", "save-ok");
		return "redirect:/board/read?bno=" + boardvo.getBno();
	}
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public void read(@RequestParam("bno") Integer bno, Model model) throws Exception{
		BoardVO boardvo = service.read(bno);
		model.addAttribute(boardvo);
		logger.info(">>>> board.read: {}", boardvo);
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.GET)
	public String remove(@RequestParam("bno") Integer bno, RedirectAttributes rttr) throws Exception{
		service.remove(bno);
		rttr.addFlashAttribute("msg", "remove-ok");
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="/listAll", method=RequestMethod.GET)
	public void listAll(Model model) throws Exception{
		logger.info(">>>>>> show listAll");
		List<BoardVO> board = service.listall();
		model.addAttribute("listAll", board);
	}
	
	
}

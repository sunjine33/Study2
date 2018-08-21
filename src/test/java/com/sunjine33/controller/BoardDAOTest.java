package com.sunjine33.controller;


import javax.inject.Inject;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sunjine33.study2.domain.BoardVO;
import com.sunjine33.study2.persistance.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class BoardDAOTest {

	@Inject
	private BoardDAO boarddao;

	private static int maxbno = 0;
	private static boolean flag = false;

	private static Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);
	
	
	@Before
	public void testGetMaxBno()throws Exception{
		if(maxbno==0) {
		testCreate();
		int max = boarddao.getMaxbno();
		maxbno = max;
		System.out.println("maxbno: " + max);
		
		}
	}
	
	public void testCreate() throws Exception {
		BoardVO boardvo = dummyBoard("새 글", "새 글");
		boardvo.setWriter("user00");
		boarddao.create(boardvo);
	}
	

	@Test
	public void testRead() throws Exception {
			System.out.println(boarddao.read(maxbno));
	}

	@Test
	public void testUpdate() throws Exception {
		
		BoardVO boardvo = dummyBoard("수정된 글", "수정된 글");
		boarddao.update(boardvo);
		flag=true;
	}
	

	@Test
	public void testDelete() throws Exception {
		if(flag) {
		boarddao.delete(maxbno);
		flag=false;
		}
	}
	
	public BoardVO dummyBoard(String title, String content) {
		BoardVO boardvo = new BoardVO();
		boardvo.setTitle(title);
		boardvo.setContent(content);
		return boardvo;
	}
}

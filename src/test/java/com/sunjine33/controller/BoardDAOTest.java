package com.sunjine33.controller;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.sunjine33.study2.domain.BoardVO;
import com.sunjine33.study2.domain.Criteria;
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
	public void testGetMaxBno() throws Exception {
		if (maxbno == 0) {
			testCreate();
			int max = boarddao.getMaxbno();
			maxbno = max;
			System.out.println("maxbno: " + max);

		}
	}
	
	@Test
	public void tesetURI()throws Exception{
		int bno = 84;
		int PerPageNum = 15;
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.path("/board/read")
				.queryParam("bno", bno)
				.queryParam("perPageNum", PerPageNum)
				.build();
		
		String uri = ".board/read?bno=" + bno + "$perPageNum=" + PerPageNum;
		logger.info(uri );
		logger.info(uri, uriComponents.toString());
		
	}
	
	@Test
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
		flag = true;
	}

	@Test
	public void testDelete() throws Exception {
		if (flag) {
			boarddao.delete(maxbno);
			flag = false;
		}
	}

	@Test
	public void testListAll() throws Exception {
		boarddao.listAll();
	}

	@Test
	public void testListPage() throws Exception {
		List<BoardVO> list = boarddao.listPage(2);
		assertEquals(10, list.size());
	}

	@Test
	public void testListCriteria() throws Exception {
		Criteria criteria = new Criteria();
		criteria.setPage(4);
		criteria.setPerPageNum(20);
		List<BoardVO> list = boarddao.listCriteria(criteria);
		assertEquals(criteria.getPerPageNum(), list.size());
	}

	public BoardVO dummyBoard(String title, String content) {
		BoardVO boardvo = new BoardVO();
		boardvo.setTitle(title);
		boardvo.setContent(content);
		return boardvo;
	}
}

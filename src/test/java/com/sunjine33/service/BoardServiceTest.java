package com.sunjine33.service;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sunjine33.study2.domain.BoardVO;
import com.sunjine33.study2.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class BoardServiceTest {

	@Inject
	private BoardService service;
	
	private static Logger logger = LoggerFactory.getLogger(BoardServiceTest.class);
	
	@Test
	public void testRead() throws Exception {
		BoardVO boardvo = service.read(2);
		logger.info(boardvo.toString());
		assertEquals("새 글", boardvo.getTitle());
		
		
	}

}

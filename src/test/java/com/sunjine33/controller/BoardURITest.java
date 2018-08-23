package com.sunjine33.controller;



import java.net.URLEncoder;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class BoardURITest {
	
	private static Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);
	
	@Test
	public void tesetURI2()throws Exception{
		int bno = 84;
		int PerPageNum = 15;
		UriComponents uriComponents = null;
		for(int i = 0 ; i < 2000000 ; i++) {
		uriComponents = UriComponentsBuilder.newInstance()
				.path("/{moduel}/{page}")
				.queryParam("bno", bno)
				.queryParam("perPageNum", PerPageNum)
				.queryParam("keyword", "강원도 고성군 토성면 케잌 뷁 김정수 박화요비^^@$@$&$*%^*@#$!$@%!^%$^$&$%!")
				.build()
				.expand("board","read")
				.encode();
		}
		String uri = ".board/read?bno=" + bno + "$perPageNum=" + PerPageNum;
		URLEncoder.encode(uri, "UTF-8");
		logger.info(uri );
		logger.info(uri, uriComponents.toString());
		
	}

}

package com.sunjine33.study2.service;

import java.util.List;

import com.sunjine33.study2.domain.BoardVO;

public interface BoardService {
		void regist(BoardVO boardvo) throws Exception;
		
		BoardVO read(Integer bno) throws Exception;
		
		void modify(BoardVO boardvo) throws Exception;
		
		void remove(Integer bno) throws Exception;
		
		List<BoardVO> listall() throws Exception;
		
}

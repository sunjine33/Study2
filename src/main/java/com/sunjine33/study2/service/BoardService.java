package com.sunjine33.study2.service;

import java.util.List;

import com.sunjine33.study2.domain.BoardVO;

public interface BoardService {
		public void regist(BoardVO boardvo) throws Exception;
		
		public BoardVO read(Integer boardvo) throws Exception;
		
		public void modify(BoardVO boardvo) throws Exception;
		
		public void remove(Integer bno) throws Exception;
		
		public List<BoardVO> listall() throws Exception;
		
}

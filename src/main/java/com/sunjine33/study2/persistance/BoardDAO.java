package com.sunjine33.study2.persistance;

import java.util.List;

import com.sunjine33.study2.domain.BoardVO;
import com.sunjine33.study2.domain.Criteria;

public interface BoardDAO {
	
	 void create(BoardVO boardvo)throws Exception;
	 BoardVO read(Integer bno)throws Exception;
	 void update(BoardVO boardvo)throws Exception;
	 void delete(Integer bno)throws Exception;
	 List<BoardVO> listAll()throws Exception;
	 List<BoardVO> listPage(int page)throws Exception;
	 List<BoardVO> listCriteria(Criteria criteria)throws Exception;
	 Integer getMaxbno()throws Exception;
	 int countpaging(Criteria criteria);
}

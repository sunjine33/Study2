package com.sunjine33.study2.persistance;

import java.util.List;

import com.sunjine33.study2.domain.BoardVO;

public interface BoardDAO {
	
	public void create(BoardVO boardvo)throws Exception;
	public BoardVO read(Integer bno)throws Exception;
	public void update(BoardVO boardvo)throws Exception;
	public void delete(Integer bno)throws Exception;
	public List<BoardVO> listAll()throws Exception;
	public Integer getMaxbno()throws Exception;
}

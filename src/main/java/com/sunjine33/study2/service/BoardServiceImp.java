package com.sunjine33.study2.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sunjine33.study2.domain.BoardVO;
import com.sunjine33.study2.persistance.BoardDAO;

@Service
public class BoardServiceImp implements BoardService{
	
	@Inject
	BoardDAO dao;

	@Override
	public void regist(BoardVO boardvo) throws Exception {
		dao.create(boardvo);
		
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		return dao.read(bno);
	}

	@Override
	public void modify(BoardVO boardvo) throws Exception {
		dao.update(boardvo);
	}

	@Override
	public void remove(Integer bno) throws Exception {
		dao.delete(bno);
	}

	@Override
	public List<BoardVO> listall() throws Exception {
		return dao.listAll();
	}
	
	
}

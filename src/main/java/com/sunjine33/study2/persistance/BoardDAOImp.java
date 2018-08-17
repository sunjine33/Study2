package com.sunjine33.study2.persistance;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sunjine33.study2.domain.BoardVO;

@Repository
public class BoardDAOImp implements BoardDAO{
	
	@Inject
	private SqlSession sqlsession;
	
	private static final String namespace = "BoardMapper";
	private static final String CREATE = namespace + ".create";
	private static final String READ = namespace + ".read";
	private static final String UPDATE = namespace + ".update";
	private static final String DELETE = namespace + ".delete";
	private static final String LISTALL = namespace + ".listAll";
	private static final String GETMAXBNO = namespace + ".getMaxbno";
	
	@Override
	public void create(BoardVO boardvo) throws Exception {
			sqlsession.insert(CREATE, boardvo);
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		return sqlsession.selectOne(READ, bno);
	}

	@Override
	public void update(BoardVO boardvo) throws Exception {
		sqlsession.update(UPDATE, boardvo);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		sqlsession.delete(DELETE, bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return sqlsession.selectList(LISTALL);
	}

	@Override
	public Integer getMaxbno() throws Exception {
		
		return sqlsession.selectOne(GETMAXBNO);
	}

}

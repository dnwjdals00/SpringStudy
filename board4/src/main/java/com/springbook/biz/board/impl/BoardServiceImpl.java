package com.springbook.biz.board.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.springbook.biz.BoardVO;
import com.springbook.biz.board.BoardService;

//@Component("boardService")
@Service("boardService")
public class BoardServiceImpl implements BoardService{
	@Autowired
	//@Inject
    // private BoardDAO boardDAO;
	//private BoardDAOMybatis boardDAO;
	private BoardDAOJpa boardDAO;
	
     
	@Override
	public void insertBoard(BoardVO vo) {
		//if(vo.getSeq()==0) {
		//	throw new IllegalArgumentException("0번 글은 등록할수 없습니다.");
		//}
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
	   boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		updateBoardCnt(vo);
		return boardDAO.getBoard(vo);
	}
	
	
	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}
	//조회수 증가
	@Override
	public void updateBoardCnt(BoardVO vo) {
		boardDAO.updateBoardCnt(vo);
	}
	

}
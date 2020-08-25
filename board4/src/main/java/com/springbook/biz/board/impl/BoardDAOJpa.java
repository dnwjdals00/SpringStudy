package com.springbook.biz.board.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.springbook.biz.BoardVO;

@Repository
public class BoardDAOJpa {
	@PersistenceContext
    private EntityManager em;

	public void insertBoard(BoardVO vo) {
		System.out.println("===>JPA로 insertBoard()기능 처리");
		em.persist(vo);
		
	}

	public void updateBoard(BoardVO vo) {
		BoardVO vo2=em.find(BoardVO.class,vo.getSeq());
		vo2.setTitle(vo.getTitle());
		vo2.setContent(vo.getContent());
		vo2.setImages(vo.getImages());
		
		em.merge(vo2);
	}

	public void deleteBoard(BoardVO vo) {
		System.out.println("===>JPA로 deleteBoard()기능 처리");
		em.remove(em.find(BoardVO.class, vo.getSeq()));
		
	}

	public BoardVO getBoard(BoardVO vo) {
		updateBoardCnt(vo);
		return em.find(BoardVO.class, vo.getSeq());
		
	}
	//조회수 증가
	public void updateBoardCnt(BoardVO vo){
		System.out.println("===>JPA로 updateBoardCnt()기능 처리");
		BoardVO vo2=em.find(BoardVO.class, vo.getSeq());
		
		vo2.setCnt(vo2.getCnt()+1);
		System.out.println(vo2);
		em.merge(vo2);
		em.flush();//
		
	}
	
    public List<BoardVO> getBoardList(BoardVO vo) {
        System.out.println("===> JPA로 getBoardList() 기능 처리");
        String spql = "from BoardVO b order by b.seq desc";
        return em.createQuery(spql).getResultList();
    }
}

   

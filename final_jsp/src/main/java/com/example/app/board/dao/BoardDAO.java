package com.example.app.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.example.app.dto.BoardDTO;
import com.example.app.dto.BoardListDTO;
import com.mybatis.config.MyBatisConfig;

public class BoardDAO {
	public SqlSession sqlSession;

	public BoardDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
//	게시글 목록 전체 조회
	public List<BoardListDTO> selectAll(Map<String, Integer> pageMap) {
//		System.out.println("게시글 목록 전체 조회하는 메소드 실행 : " + pageMap);
		return sqlSession.selectList("board.selectAll", pageMap);
	}
	
//	게시글 총 개수
	public int getTotal() {
		return sqlSession.selectOne("board.getTotal");
	}
	
//	게시글 추가 후 자동으로 생성된 boardNumber 반환
	public int insertBoard(BoardDTO boardDTO) {
//		작성한 게시판 글 저장
		int insert = sqlSession.insert("board.insert", boardDTO);
		
//		System.out.println("=== 게시글 작성 DAO ===");
//		System.out.println("생성된 boardNumber : "  + boardDTO.getBoardNumber());
//		System.out.println("insert : "  + insert);
//		System.out.println("====================");
		
//		가장 최근에 작성한 게시판글 번호 반환
//		return sqlSession.selectOne("board.getCurrentBoardNumber");
//		BoardMapper에 selectKey 사용시
		return boardDTO.getBoardNumber();
	}
	
//	게시글 상세 페이지 조회
	public BoardListDTO select (int boardNum) {
		return sqlSession.selectOne("board.select", boardNum);
	}
	
//	조회수 증가
	public void updateReadCount (int boardNum) {
		int result = sqlSession.update("board.updateReadCount", boardNum);
		System.out.println("조회수 없데이트 결과 : " + result);
	}
	
}
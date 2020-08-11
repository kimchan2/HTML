package kr.or.ddit.board.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;

public interface IBoardService {

	// 글 등록 = 저장
	public int insertBoard(BoardVO vo);
	
	// 글 리스트 목록 가져오기 - 전체 / 페이지별
	public List<BoardVO> selectAll();
	public List<BoardVO> selectByPage(Map<String, Integer> map);
	
	// 전체 글 갯수 가져오기
	public int getTotalCount();
	
	// 글 수정
	
	// 글 삭제
	
	// 댓글 등록
	public int insertReply(ReplyVO vo);
	
	// 댓글 리스트
	public List<ReplyVO> listReply(int bonum);
	
	// 댓글 수정
	public int updateReply(ReplyVO vo);
	
	// 댓글 삭제
	public int deleteReply(int renum);
	
	
}

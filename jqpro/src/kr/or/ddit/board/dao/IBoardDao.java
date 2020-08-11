package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;

public interface IBoardDao {
	
	// 글 등록 = 저장
	public int insertBoard(BoardVO vo) throws SQLException;
	
	// 글 리스트 목록 가져오기 - 전체 / 페이지별
	public List<BoardVO> selectAll() throws SQLException;
	public List<BoardVO> selectByPage(Map<String, Integer> map) throws SQLException;
	
	// 전체 글 갯수 가져오기
	public int getTotalCount() throws SQLException;
	
	// 글 수정
	
	// 글 삭제
	
	// 댓글 등록
	public int insertReply(ReplyVO vo) throws SQLException;
	
	// 댓글 리스트
	public List<ReplyVO> listReply(int bonum) throws SQLException;
	
	// 댓글 수정
	public int updateReply(ReplyVO vo) throws SQLException;
	
	// 댓글 삭제
	public int deleteReply(int renum)throws SQLException;
}

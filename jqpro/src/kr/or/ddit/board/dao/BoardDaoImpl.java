package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;
import kr.or.ddit.ibatis.config.SqlMapClientFactory;

public class BoardDaoImpl implements IBoardDao{
	
	private SqlMapClient smc;
	private static IBoardDao dao;
	
	public BoardDaoImpl() {
		smc = SqlMapClientFactory.getClient();
	}
	
	public static IBoardDao getDao(){
		if( dao == null ){
			dao = new BoardDaoImpl();
		}
		return dao;
	}
	
	@Override
	public List<BoardVO> selectAll() throws SQLException {
		return smc.queryForList("board.selectAll");
	}

	@Override
	public List<BoardVO> selectByPage(Map<String, Integer> map)
			throws SQLException {
		return smc.queryForList("board.selectByPage", map);
	}

	@Override
	public int getTotalCount() throws SQLException{
		return (int)smc.queryForObject("board.getTotalCount");
	}

	@Override
	public int insertBoard(BoardVO vo) throws SQLException {
		return (int)smc.insert("board.insertBoard", vo);
	}

	@Override
	public int insertReply(ReplyVO vo) throws SQLException{
		return (int)smc.insert("board.insertReply", vo);
	}

	@Override
	public List<ReplyVO> listReply(int bonum) throws SQLException {
		return smc.queryForList("board.listReply", bonum);
	}

	@Override
	public int updateReply(ReplyVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return smc.update("board.updateReply", vo);
	}

	@Override
	public int deleteReply(int renum) throws SQLException {
		// TODO Auto-generated method stub
		return smc.delete("board.deleteReply", renum);
	}

}

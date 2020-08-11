package kr.or.ddit.lprod.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.lprod.vo.LprodVO;

/**
 * Mapper(lprod.xml)에 접근해서 sql쿼리문을 수행
 * 그러기 위해서 SqlMapClient객체가 필요
 * 서비스에서 사용할 자신의 객체를 생성하여 리턴한다
 * 
 * @author PC-25
 *
 */
public class LprodDaoImpl implements ILprodDao{

	private SqlMapClient client;
	private static ILprodDao dao;
	
	private LprodDaoImpl(){
		client = SqlMapClientFactory.getClient();
	}
	
	public static ILprodDao getInstance(){
		if(dao == null){
			dao = new LprodDaoImpl();
		}
		return dao;
	}
	
	@Override
	public List<LprodVO> selectAll() throws SQLException {
		return client.queryForList("lprod.selectAll");
	}

}

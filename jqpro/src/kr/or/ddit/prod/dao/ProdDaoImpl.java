package kr.or.ddit.prod.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.prod.vo.ProdVO;

/**
 * mapper sql쿼리를 수행하기 위한 SqlMapClient객체 얻어오기
 * 여러 서비스에서 사용될 자신의 객체를 생성 하고 리턴
 * @author PC-25
 *
 */
public class ProdDaoImpl implements IProdDao{
	
	private SqlMapClient client;
	private static IProdDao dao;
	
	private ProdDaoImpl() {
		client = SqlMapClientFactory.getClient();
	}
	
	public static IProdDao getInstance(){
		if( dao == null){
			dao = new ProdDaoImpl();
		}
		return dao;
		
	}
	
	@Override
	public List<ProdVO> selectByLgu(String lprod_gu) throws SQLException {
		// TODO Auto-generated method stub
		return client.queryForList("prod.selectByLgu", lprod_gu);
	}

	@Override
	public ProdVO selectById(String prod_id) throws SQLException {
		// TODO Auto-generated method stub
		return (ProdVO)client.queryForObject("prod.selectById", prod_id);
	}

}

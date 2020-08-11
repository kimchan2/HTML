package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public class MemberDaoImpl implements IMemberDao{

	private static MemberDaoImpl dao;
	private static SqlMapClient smc;
	
	private MemberDaoImpl() {
		smc = SqlMapClientFactory.getClient(); 
	}
	
	public static IMemberDao getInstance(){
		if( dao == null )
			dao = new MemberDaoImpl();
		
		return dao;
	}
	
	@Override
	public String getMemberById(String id) throws SQLException {
		return (String) smc.queryForObject("member.getMemberById", id);
	}
	
	@Override
	public List<ZipVO> selectByZipcode(String dong) throws SQLException {
		return smc.queryForList("member.selectByZipcode", dong);
	}

	@Override
	public String insertMember(MemberVO vo) throws SQLException {
		return (String) smc.insert("member.insertMember", vo);
	}

}

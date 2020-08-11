package kr.or.ddit.member.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public class MemberServiceImpl implements IMemberService{

	private static IMemberService service;
	private static IMemberDao dao;
	
	public MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}
	
	public static IMemberService getInstance(){
		if( service == null )
			service = new MemberServiceImpl();
		return service;
	}
	
	
	@Override
	public String getMemberById(String id) {
		String str = null;
		try {
			str = dao.getMemberById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	
	@Override
	public List<ZipVO> selectByZipcode(String dong){
		List<ZipVO> list = null;
		try {
			list = dao.selectByZipcode(dong);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String insertMember(MemberVO vo){
		String str = null;
		try {
			str = dao.insertMember(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

}

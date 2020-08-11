package kr.or.ddit.lprod.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.dao.LprodDaoImpl;
import kr.or.ddit.lprod.vo.LprodVO;

/**
 * DaoImpl의 selectAll 메소드 호출
 * 그러기 위해서는 DaoImpl 객체가 필요
 * 
 * 여러 Controller에서 공유 하여 사용할 수 있도록 자신의 객체를 생성 하여 리턴 한다.
 *
 */
public class LprodServiceImpl implements ILprodService{
	
	private ILprodDao dao;
	private static ILprodService service;
	
	private LprodServiceImpl(){
		dao = LprodDaoImpl.getInstance();
	}
	
	public static ILprodService getInstance(){
		if(service == null){
			service = new LprodServiceImpl();
		}
		return service;
	}
	
	@Override
	public List<LprodVO> selectAll() {
		List<LprodVO> list = null;
		try {
			list = dao.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}

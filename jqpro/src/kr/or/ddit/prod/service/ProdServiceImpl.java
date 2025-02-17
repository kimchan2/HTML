package kr.or.ddit.prod.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.lprod.vo.LprodVO;
import kr.or.ddit.prod.dao.IProdDao;
import kr.or.ddit.prod.dao.ProdDaoImpl;
import kr.or.ddit.prod.vo.ProdVO;

public class ProdServiceImpl implements IProdService {

   private IProdDao dao;
   private static IProdService service;
   
   private ProdServiceImpl() {
      dao = ProdDaoImpl.getInstance();
   }
   
   public static IProdService getInstance() {
      if(service == null)
         service = new ProdServiceImpl();
      return service;
   }
   
   @Override
   public List<ProdVO> selectByLgu(String lprod_gu) {
      List<ProdVO> list = null;
      
      try {
         list = dao.selectByLgu(lprod_gu);
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      return list;
   }

   @Override
   public ProdVO selectById(String prod_id) {
      ProdVO vo = null;
      
      try {
         vo = dao.selectById(prod_id);
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      return vo;
   }

}
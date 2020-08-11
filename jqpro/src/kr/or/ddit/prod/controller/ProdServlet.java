package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodServiceImpl;
import kr.or.ddit.lprod.vo.LprodVO;
import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.prod.vo.ProdVO;

import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * Servlet implementation class ProdServlet
 */
@WebServlet("/Prod.do")
public class ProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청시 전송되는 값을 받는다 - gu
		String agu = request.getParameter("gu");
		
		//2. service 객체를 얻어온다.
	    IProdService service = ProdServiceImpl.getInstance();
	    
	    //3. service메소드 호출 - 결과값이 리턴되어 돌아온다.
	    List<ProdVO> list = service.selectByLgu(agu);
	    
	    //4. request에 결과값을 저장
	    request.setAttribute("listval", list);
	    
	    //5. view페이지로 forword시킨다.
	    request.getRequestDispatcher("0717/prodName2.jsp").forward(request, response);
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청시 전송되는 값을 받는다 - gu
		String id = request.getParameter("id");
		
		//2. service 객체를 얻어온다.
		IProdService service = ProdServiceImpl.getInstance();
		
		//3. service메소드 호출 - 결과값이 리턴되어 돌아온다.
		ProdVO vo = service.selectById(id);
		
		//4. request에 결과값을 저장
		request.setAttribute("valueVO", vo);
		
		//5. view페이지로 forword시킨다.
		request.getRequestDispatcher("0717/prodDetail.jsp").forward(request, response);
	}

}

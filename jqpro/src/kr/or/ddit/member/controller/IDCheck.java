package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.prod.vo.ProdVO;

/**
 * Servlet implementation class IDCheck
 */
@WebServlet("/IDCheck")
public class IDCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IDCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청시 전송되는 값을 받는다 - id
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
				
		//2. service 객체를 얻어온다.
		IMemberService service = MemberServiceImpl.getInstance();
		
		//3. service메소드 호출 - 결과값이 리턴되어 돌아온다.
		String resid = service.getMemberById(id);
		
		//4. request에 결과값을 저장
		request.setAttribute("res", resid);
		request.setAttribute("input", id);
		
		//5. view페이지로 forword시킨다.
		request.getRequestDispatcher("0720/insert.jsp").forward(request, response);
		
	
	}

}

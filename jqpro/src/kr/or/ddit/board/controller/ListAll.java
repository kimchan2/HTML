package kr.or.ddit.board.controller;

import java.io.IOException;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.IBoardService;


import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.vo.BoardVO;

/**
 * Servlet implementation class List
 */
@WebServlet("/List.do")
public class ListAll extends HttpServlet {
   private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListAll() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
    */
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      //0 클라이언트 요청시 전송 데이터를 받는다
	  int page = Integer.parseInt(request.getParameter("page"));
	  request.setCharacterEncoding("UTF-8");
	  
      //1 service 객체 생성
      IBoardService service = BoardServiceImpl.getService();

      int totalCount = service.getTotalCount();
      int perlist = 4; // 한 페이지당 출력되는 글 갯수
      int perblock = 3; // 한 블럭당 출력되는 페이지 갯수
      int totalPage = (totalCount-1)/perlist + 1;
      
      int startPage = ( (page-1) / perblock * perblock) + 1 ;
      int endPage = startPage + perblock - 1;
      if(endPage > totalPage) endPage = totalPage;
      
      int start = (page - 1) * perlist + 1;
      int end = start + perlist - 1;
      
      if(end > totalCount) end = totalCount; 
      
      Map<String, Integer> map = new HashMap<>();
      map.put("start", start);
      map.put("end", end);
      
      //2 service메서드 호출
      List<BoardVO> list = service.selectByPage(map);

      //3 //결과저장
      request.setAttribute("listval", list);
      request.setAttribute("startPage", startPage);
      request.setAttribute("endPage", endPage);
      request.setAttribute("totalPage", totalPage);
      request.setAttribute("currentPage", page);

      //4
//      request.getRequestDispatcher("0722/listAll.jsp").forward(request, response);
      request.getRequestDispatcher("0722/listPage.jsp").forward(request, response);

   }

}
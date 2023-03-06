package kr.or.iei.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet(name = "Logout", urlPatterns = { "/logout.do" })
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
				request.setCharacterEncoding("utf-8");
				//2. 값추출
				//3. 비즈니스로직
				HttpSession session = request.getSession(false);
				if(session != null) {
					session.invalidate(); //현재세션을 파기하는 메소드
				}
				//4. 결과처리
				//방법1) alert띄우고 메인화면
				
				RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/common/msg.jsp");
				request.setAttribute("title", "로그아웃 성공");
				request.setAttribute("msg", "안녕히 가세요");
				request.setAttribute("icon", "info");
				request.setAttribute("loc", "/");
				view.forward(request, response);
				
				//방법2) 그냥 메인화면(보내줄 데이터가 없는 경우)
				//response.sendRedirect("/");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

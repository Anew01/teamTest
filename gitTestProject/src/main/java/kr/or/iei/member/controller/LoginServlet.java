package kr.or.iei.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.iei.member.service.MemberService;
import kr.or.iei.member.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "Login", urlPatterns = { "/login.do" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		//2.값추출
		String loginId = request.getParameter("loginId");
		String loginPw = request.getParameter("loginPw");
		Member m = new Member();
		m.setMemberId(loginId);
		m.setMemberPw(loginPw);
		//3.비즈니스로직
		MemberService service = new MemberService();
		//입력받은 아이디/패스워드정보가 일치하는 회원정보를 조회
		Member member = service.selectOneMember(m);
		//4.결과처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		
		if(member == null) {
			//아이디와 비밀번호가 틀린경우
			request.setAttribute("title", "로그인실패");
			request.setAttribute("msg", "아이디 또는 비밀번호를 확인하세요.");
			request.setAttribute("icon", "error");
			request.setAttribute("loc", "/");
		}else {
			//아이디 비밀번호가 일치하는 경우
			
			if(member.getMemberLevel()==4) {
				//준회원인경우
				request.setAttribute("title", "로그인 권한 없음");
				request.setAttribute("msg", "로그인 권한이 없습니다. 관리자에게 문의하세요");
				request.setAttribute("icon", "warning");
				request.setAttribute("loc", "/");
			}else {
				//관리자 또는 정회원인경우
				
				HttpSession session = request.getSession();
				session.setAttribute("m", member);
				request.setAttribute("title", "로그인성공");
				request.setAttribute("msg", "환영합니다.");
				request.setAttribute("icon", "success");
				request.setAttribute("loc", "/");
				
			}
		}
		
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

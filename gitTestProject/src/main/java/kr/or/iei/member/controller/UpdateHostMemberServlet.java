package kr.or.iei.member.controller;

import java.io.IOException;

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
 * Servlet implementation class UpdateHostMemberServlet
 */
@WebServlet(name = "UpdateHostMember", urlPatterns = { "/updateHostMember.do" })
public class UpdateHostMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateHostMemberServlet() {
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
		HttpSession session = request.getSession(false);
		Member m = (Member)session.getAttribute("m");
		String memberId = m.getMemberId();
		//3.비즈니스로직
		MemberService service = new MemberService();
		int result = service.updateHostMember(memberId);
		//4.화면처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("title", "신청 성공");
			request.setAttribute("msg", "호스트 신청이 완료되었습니다.");
			request.setAttribute("icon", "success");
			request.setAttribute("loc", "/myPage.do?memberId="+memberId); 
		}else {
			request.setAttribute("title", "신청 실패");
			request.setAttribute("msg", "처리중 오류가 발생했습니다.");
			request.setAttribute("icon", "error");
			request.setAttribute("loc", "/myPage.do?memberId="+memberId);
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

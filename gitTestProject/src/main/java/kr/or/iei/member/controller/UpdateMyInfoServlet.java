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
 * Servlet implementation class UpdateMyInfoServlet
 */
@WebServlet(name = "UpdateMyInfo", urlPatterns = { "/updateMyInfo.do" })
public class UpdateMyInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMyInfoServlet() {
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
		Member member = new Member();
		member.setMemberId(request.getParameter("memberId"));
		member.setMemberPw(request.getParameter("memberPw"));
		member.setMemberPhone(request.getParameter("memberPhone"));
		member.setMemberAddr(request.getParameter("memberAddr"));
		//3.비즈니스로직
		MemberService service = new MemberService();
		int result = service.updateMember(member);
		//4.화면처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			Member m = new Member();
			m.setMemberPw(member.getMemberPw());
			m.setMemberPhone(member.getMemberPhone());
			m.setMemberAddr(member.getMemberAddr());
			
			request.setAttribute("title", "변경성공");
			request.setAttribute("msg", "정보가 성공적으로 변경되었습니다.");
			request.setAttribute("icon", "success");
			
		}else{
			request.setAttribute("title", "변경실패");
			request.setAttribute("msg", "입력하신 정보를 다시한번 확인하세요.");
			request.setAttribute("icon", "error");
		
		}
		
		request.setAttribute("loc", "/myInfo.do?memberId="+member.getMemberId());
		
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

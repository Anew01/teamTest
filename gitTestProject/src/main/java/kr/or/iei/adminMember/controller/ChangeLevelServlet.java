package kr.or.iei.adminMember.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.member.service.MemberService;

@WebServlet(name = "ChangeLevel", urlPatterns = { "/changeLevel.do" })
public class ChangeLevelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ChangeLevelServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		int memberLevel = Integer.parseInt(request.getParameter("memberLevel"));

		MemberService service = new MemberService();

		int result = service.chageLevel(memberId, memberLevel);

		// 변경 선공: 관리자 페이지
		// 변경 실패: alert하고 관리자 페이지
		if (result > 0) {
			// jsp로 바로 못감 서블릿 거쳐서
			response.sendRedirect("/allMember.do");
		} else {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");

			request.setAttribute("title", "등급 변경 실패");
			request.setAttribute("msg", "홈페이지에 문제가 발생했습니다.");
			request.setAttribute("icon", "error");
			request.setAttribute("loc", "/allMember.do");

			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
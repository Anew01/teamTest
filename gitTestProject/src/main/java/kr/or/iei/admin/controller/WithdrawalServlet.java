package kr.or.iei.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.admin.service.adminService;

@WebServlet(name = "Withdrawal", urlPatterns = { "/withdrawal.do" })
public class WithdrawalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public WithdrawalServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String memberId = request.getParameter("memberId");

		adminService service = new adminService();

		int result = service.deleteMember(memberId);

		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");

		if (result > 0) {
			response.sendRedirect("/allMember.do");
		} else {
			request.setAttribute("title", "회원 삭제 실패");
			request.setAttribute("msg", "홈페이지에 문제가 발생했습니다.");
			request.setAttribute("icon", "error");
			request.setAttribute("loc", "/allMember.do?reqPage=1");
			view.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

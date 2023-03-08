package kr.or.iei.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.admin.service.adminService;
import kr.or.iei.member.vo.Member;

@WebServlet(name = "MemberSearch", urlPatterns = { "/memberSearch.do" })
public class MemberSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberSearchServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String searchId = request.getParameter("searchId");

		adminService service = new adminService();

		ArrayList<Member> searchList = service.selectSearchMember(searchId);

		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/adminPage/SearchMember.jsp");

		request.setAttribute("searchList", searchList);

		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

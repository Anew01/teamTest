package kr.or.iei.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.iei.admin.service.adminService;
import kr.or.iei.admin.vo.MemberPageDate;
import kr.or.iei.member.vo.Member;

@WebServlet(name = "AllMember", urlPatterns = { "/allMember.do" })
public class AllMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AllMemberServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		HttpSession session = request.getSession();

		Member member = (Member) session.getAttribute("m");

		if (member != null) { // 로그인이 된경우
			if (member.getMemberLevel() != 1) { // 관리자가 아니면
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");

				request.setAttribute("title", "접근제한");
				request.setAttribute("msg", "관리자인지 확인해주세요.");
				request.setAttribute("icon", "warning");
				request.setAttribute("loc", "/");

				view.forward(request, response);

				return;
			}
		} else { // 로그인이 안된 경우
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");

			request.setAttribute("title", "접근제한");
			request.setAttribute("msg", "로그인 후 접속하세요.");
			request.setAttribute("icon", "info");
			request.setAttribute("loc", "/");

			view.forward(request, response);

			return; // 아래 코드들 실행x
		}

		int reqPage = Integer.parseInt(request.getParameter("reqPage"));

		adminService service = new adminService();

		MemberPageDate memberPageDate = service.selectAllMember(reqPage);

		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/adminPage/allMember.jsp");

		request.setAttribute("list", memberPageDate.getList());
		request.setAttribute("pageNavi", memberPageDate.getPageNavi());
		request.setAttribute("start", memberPageDate.getStart());

		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

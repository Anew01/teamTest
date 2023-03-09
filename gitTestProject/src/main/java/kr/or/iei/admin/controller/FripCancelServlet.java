package kr.or.iei.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.admin.service.adminService;

@WebServlet(name = "FripCancel", urlPatterns = { "/fripCancel.do" })
public class FripCancelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FripCancelServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int fripNo = Integer.parseInt(request.getParameter("fripNo"));

		adminService service = new adminService();

		int result = service.fripCancel(fripNo);

		if (result > 0) {
			response.sendRedirect("/firpAndFeed.do?fripReqPage=1&feedReqPage=1&fripTitle=&feedWriter=");
		} else {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");

			request.setAttribute("title", "프립 취소 실패");
			request.setAttribute("msg", "홈페이지에 문제가 발생했습니다.");
			request.setAttribute("icon", "error");
			request.setAttribute("loc", "/firpAndFeed.do?fripReqPage=1&feedReqPage=1&fripTitle=&feedWriter=");

			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

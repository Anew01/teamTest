package kr.or.iei.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.admin.service.adminService;

@WebServlet(name = "CheckedfeedDelete", urlPatterns = { "/checkedfeedDelete.do" })
public class CheckedfeedDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CheckedfeedDeleteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String feedNos = request.getParameter("feedNos");

		adminService service = new adminService();

		boolean result = service.checkedfeedDelete(feedNos);

		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");

		if (result) {
			request.setAttribute("title", "피드 삭제 성공");
			request.setAttribute("msg", "요청이 처리되었습니다.");
			request.setAttribute("icon", "success");
		} else {
			request.setAttribute("title", "피드 삭제 실패");
			request.setAttribute("msg", "요청이 처리중 문제가 발생했습니다. 홈페이지에 문의해주세요.");
			request.setAttribute("icon", "error");
		}

		request.setAttribute("loc", "/firpAndFeed.do?fripReqPage=1&feedReqPage=1&fripTitle=&feedWriter=");

		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

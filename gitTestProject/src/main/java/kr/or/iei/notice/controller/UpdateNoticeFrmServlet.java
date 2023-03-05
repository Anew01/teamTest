package kr.or.iei.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.notice.service.NoticeService;
import kr.or.iei.notice.vo.Notice;

@WebServlet(name = "UpdateNoticeFrm", urlPatterns = { "/updateNoticeFrm.do" })
public class UpdateNoticeFrmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateNoticeFrmServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));

		NoticeService service = new NoticeService();

		Notice notice = service.getNotice(noticeNo);

		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/adminPage/noticeUpdateFrm.jsp");

		request.setAttribute("notice", notice);

		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

package kr.or.iei.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.notice.service.NoticeService;
import kr.or.iei.notice.vo.NoticeUserPageData;

@WebServlet(name = "NoticeListUser", urlPatterns = { "/noticeListUser.do" })
public class NoticeListUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NoticeListUserServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		int reqPage = Integer.parseInt(request.getParameter("reqPage"));

		NoticeService service = new NoticeService();

		NoticeUserPageData nPageData = service.selectNoticeListUser(reqPage);

		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/adminPage/noticeListUser.jsp");

		request.setAttribute("list", nPageData.getList());
		request.setAttribute("pageNavi", nPageData.getPageNavi());
		request.setAttribute("start", nPageData.getStart());

		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

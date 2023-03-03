package kr.or.iei.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.admin.service.adminService;
import kr.or.iei.admin.vo.FripAndFeedPageDate;

@WebServlet(name = "FirpAndFeed", urlPatterns = { "/firpAndFeed.do" })
public class FirpAndFeedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FirpAndFeedServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		int fripReqPage = Integer.parseInt(request.getParameter("fripReqPage"));
		int feedReqPage = Integer.parseInt(request.getParameter("feedReqPage"));

		adminService service = new adminService();

		FripAndFeedPageDate fripAndFeedPageDate = service.selectAllFripAndFeed(fripReqPage, feedReqPage);

		request.setAttribute("frips", fripAndFeedPageDate.getFrips());
		request.setAttribute("fripPageNavi", fripAndFeedPageDate.getFripPageNavi());
		request.setAttribute("fripStart", fripAndFeedPageDate.getFripStart());

		request.setAttribute("feeds", fripAndFeedPageDate.getFeeds());
		request.setAttribute("feedPageNavi", fripAndFeedPageDate.getFeedPageNavi());
		request.setAttribute("feedStart", fripAndFeedPageDate.getFeedStart());

		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/adminPage/fripAndFeed.jsp");

		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

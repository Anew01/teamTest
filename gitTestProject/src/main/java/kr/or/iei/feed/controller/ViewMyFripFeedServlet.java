package kr.or.iei.feed.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.feed.service.FeedService;
import kr.or.iei.feed.vo.Feed;
import kr.or.iei.feed.vo.ViewFripFeedData;

/**
 * Servlet implementation class ViewMyFripFeedServlet
 */
@WebServlet(name = "ViewMyFripFeed", urlPatterns = { "/viewMyFripFeed.do" })
public class ViewMyFripFeedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewMyFripFeedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int fripNo = Integer.parseInt(request.getParameter("fripNo"));
		FeedService service = new FeedService();
		ArrayList<ViewFripFeedData> list = service.selectAllMyFripFeed(fripNo);
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/feed/myFeedList.jsp");
		request.setAttribute("list", list);
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

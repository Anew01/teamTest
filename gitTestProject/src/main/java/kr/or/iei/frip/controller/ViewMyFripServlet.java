package kr.or.iei.frip.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.feed.service.FeedService;
import kr.or.iei.feed.vo.ViewFripFeedData;
import kr.or.iei.frip.service.FripService;
import kr.or.iei.frip.vo.Frip;
import kr.or.iei.rating.service.RatingService;

/**
 * Servlet implementation class ViewMyFripServlet
 */
@WebServlet(name = "ViewMyFrip", urlPatterns = { "/viewMyFrip.do" })
public class ViewMyFripServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewMyFripServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int fripNo = Integer.parseInt(request.getParameter("fripNo"));
		FripService service = new FripService();
		RatingService rService = new RatingService();
		FeedService fService = new FeedService();
		Frip f = service.selectOneFripByNo(fripNo);
		int feedTotalRating = 0;
		ArrayList<ViewFripFeedData> feedList = fService.selectAllMyFripFeed(fripNo);
		for(ViewFripFeedData data : feedList) {
			feedTotalRating += rService.selectAllMyFripRating(data.getF().getFeedNo());
		}
		double avg = (double)feedTotalRating / feedList.size();
		String str = String.format("%.1f", avg );
		f.setAvgRating(str);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/frip/viewMyFrip.jsp");
		request.setAttribute("f", f);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

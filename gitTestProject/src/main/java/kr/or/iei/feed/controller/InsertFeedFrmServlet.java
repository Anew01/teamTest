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
import kr.or.iei.frip.service.FripService;
import kr.or.iei.frip.vo.Frip;

/**
 * Servlet implementation class InsertFeedFrmServlet
 */
@WebServlet(name = "InsertFeedFrm", urlPatterns = { "/insertFeedFrm.do" })
public class InsertFeedFrmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertFeedFrmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인
		request.setCharacterEncoding("utf-8");
		//값
		//비
		//결
		// 값
		FripService service = new FripService();
		int fripNo = Integer.parseInt(request.getParameter("fripNo"));
		Frip f = service.selectOneFripByNo(fripNo);
		
		FeedService fService = new FeedService();
		Feed feed = fService.selectFeedNo(fripNo);
		
		request.setAttribute("f", f);
		request.setAttribute("feed", feed);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/feed/insertFeed.jsp");
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

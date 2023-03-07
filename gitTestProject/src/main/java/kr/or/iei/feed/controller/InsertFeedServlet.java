package kr.or.iei.feed.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.feed.service.FeedService;
import kr.or.iei.rating.service.RatingService;

/**
 * Servlet implementation class InsertFeedServlet
 */
@WebServlet(name = "InsertFeed", urlPatterns = { "/insertFeed.do" })
public class InsertFeedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertFeedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String feedWriter = request.getParameter("memberId");
		String fripTitle = request.getParameter("fripTitle");
		String feedContent = request.getParameter("editordata");
		int fripNo = Integer.parseInt(request.getParameter("fripNo"));
		int rating = Integer.parseInt(request.getParameter("rating"));
		int feedNo = Integer.parseInt(request.getParameter("feedNo"));
		System.out.println("인서트jsp에서 넘어온 memberId 값 : "+feedWriter);
		System.out.println("인서트jsp에서 넘어온 fripTitle 값 : "+fripTitle);
		System.out.println("인서트jsp에서 넘어온 feedContent 값 : "+feedContent);
		System.out.println("인서트jsp에서 넘어온 fripNo 값 : "+fripNo);
		System.out.println("인서트jsp에서 넘어온 rating 값 : "+rating);
		System.out.println("인서트jsp에서 넘어온 feedNo 값 : "+feedNo);
		FeedService service = new FeedService();
		int result = service.insertFeed(feedWriter, feedContent, fripNo);
		RatingService rService = new RatingService();
		int rResult = rService.insertRating(feedNo, rating);
		
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		
		if(result > 0 && rResult > 0) {
			request.setAttribute("title", "스프립 등록 성공");
			request.setAttribute("msg", "스프립 등록이 성공했습니다");
			request.setAttribute("icon", "success");
		} else {
			request.setAttribute("title", "스프립 등록 실패");
			request.setAttribute("msg", "관리자에게 문의 하세요");
			request.setAttribute("icon", "error");
		}
		request.setAttribute("loc", "/selectAllFripByCategory.do?categoryName=main");
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

package kr.or.iei.feed.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.mail.Session;
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
import kr.or.iei.member.service.MemberService;
import kr.or.iei.member.vo.Member;

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
		int fripNo = Integer.parseInt(request.getParameter("fripNo"));
		String feedWriter = request.getParameter("feedWriter");
		System.out.println("insertFeedFrm.do의 feedWriter 값 : "+feedWriter);
		//비
		//결
		FripService service = new FripService();
		Frip f = service.selectOneFripByNo(fripNo);
		request.setAttribute("f", f);
		System.out.println("insertFeedFrm.do의 f 값 : "+f);

		
		FeedService fService = new FeedService();
		Feed feed = fService.selectFeedNo(fripNo);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/feed/insertFeed.jsp");
		if(feed == null) {
			int result = fService.firstFeed(fripNo, feedWriter);
			System.out.println(result);
			if(result > 0) {
				request.setAttribute("feed", feed);
			} else {
				System.out.println("망했다");
			}
		} else {
			System.out.println("insertFeedFrm.do의 feed 값 : "+feed);
			request.setAttribute("feed", feed);
			view.forward(request, response);
		}
		Feed feed1 = fService.selectFeedNo(fripNo);
		request.setAttribute("feed", feed1);
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

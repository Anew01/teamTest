package kr.or.iei.feed.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.feed.service.FeedService;

/**
 * Servlet implementation class InsertFeedCommentServlet
 */
@WebServlet(name = "InsertFeedComment", urlPatterns = { "/insertFeedComment.do" })
public class InsertFeedCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertFeedCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String feedContent = request.getParameter("feedContent");
		System.out.println(feedContent);
		String feedWriter = request.getParameter("feedWriter");
		int fripNo = Integer.parseInt(request.getParameter("fripNo"));
		int fdNo = Integer.parseInt(request.getParameter("fdNo"));
		FeedService service = new FeedService();
		int result = service.insertFeed(feedWriter, feedContent, fripNo, fdNo);
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/common/msg.jsp");
		if(result > 0) {
			request.setAttribute("title", "피드 댓글 등록 성공");
			request.setAttribute("msg", "피드 댓글 등록이 성공했습니다");
			request.setAttribute("icon", "success");
		} else {
			request.setAttribute("title", "피드 댓글 등록 실패");
			request.setAttribute("msg", "관리자에게 문의 하세요");
			request.setAttribute("icon", "error");
		}
		request.setAttribute("loc", "/viewMyFripFeed.do?fripNo="+fripNo);
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

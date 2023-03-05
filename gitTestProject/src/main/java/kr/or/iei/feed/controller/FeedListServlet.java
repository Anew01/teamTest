package kr.or.iei.feed.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.or.iei.feed.vo.Feed;
import kr.or.iei.frip.service.FripService;
import kr.or.iei.frip.vo.Frip;
import kr.or.iei.member.service.MemberService;
import kr.or.iei.member.vo.Member;

/**
 * Servlet implementation class FeedListServlet
 */
@WebServlet("/feedList.do")
public class FeedListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		FripService fService = new FripService();
		ArrayList<Frip> fList = fService.selectAllFrip();
		MemberService mService = new MemberService();
		ArrayList<Member> mList = mService.selectAllMember();
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/feed/feedList.jsp");
		request.setAttribute("mList", mList);
		request.setAttribute("fList", fList);
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

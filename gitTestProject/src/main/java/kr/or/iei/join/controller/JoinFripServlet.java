package kr.or.iei.join.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.iei.feed.service.FeedService;
import kr.or.iei.feed.vo.Feed;
import kr.or.iei.feed.vo.ViewFripFeedData;
import kr.or.iei.frip.service.FripService;
import kr.or.iei.frip.vo.Frip;
import kr.or.iei.member.service.MemberService;
import kr.or.iei.member.vo.Member;
import kr.or.iei.payment.service.PaymentService;

/**
 * Servlet implementation class JoinFripServlet
 */
@WebServlet(name = "JoinFrip", urlPatterns = { "/joinFrip.do" })
public class JoinFripServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinFripServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int fripNo = Integer.parseInt(request.getParameter("fripNo"));
		FripService fservice = new FripService();
		Frip f = fservice.selectOneFripByNo(fripNo);
		FeedService feedService = new FeedService();
		MemberService mService = new MemberService();
		Member m = mService.selectOneMemberByJoin(fripNo);
		ArrayList<Member> mList = mService.selectAllMember();
		String categoryName = request.getParameter("categoryName");
		ArrayList<Frip> list = fservice.selectAllFrip();
		for(Frip f1 : list) {
			String avgRating = fservice.selectRating(f1.getFripNo());
			f.setAvgRating(avgRating);
		}
		
		ArrayList<ViewFripFeedData> fList = feedService.selectAllMyFripFeed(fripNo);
		PaymentService pService = new PaymentService();
		/*
		Boolean isPayed = pService.checkMyPayment(loginMem.getMemberNo(), f.getFripNo());
		*/
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/frip/checkJoinFrip.jsp");
		request.setAttribute("f", f);
		request.setAttribute("list", list);
		request.setAttribute("fripNo", fripNo);
		request.setAttribute("fList", fList);
		request.setAttribute("mList", mList);
		request.setAttribute("m", m);
		request.setAttribute("isPayed", true);
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

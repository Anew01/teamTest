package kr.or.iei.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.member.service.MemberService;
import kr.or.iei.member.vo.PaymentList;
import kr.or.iei.member.vo.ReviewList;

/**
 * Servlet implementation class MemberReviewServlet
 */
@WebServlet(name = "MemberReview", urlPatterns = { "/memberReview.do" })
public class MemberReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
				request.setCharacterEncoding("utf-8");
				//2.값추출
				String memberId = request.getParameter("memberId");
				//3.비즈니스로직
				MemberService service = new MemberService();
				ArrayList<ReviewList> list = service.selectMemberReview(memberId); 
				
				//4.결과처리
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/memberReview.jsp");
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

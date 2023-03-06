package kr.or.iei.frip.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.frip.service.FripService;
import kr.or.iei.frip.vo.FripJoinableDate;
import kr.or.iei.join.service.JoinFripService;
import kr.or.iei.join.vo.JoinFrip;

/**
 * Servlet implementation class SelectJoinableDateServlet
 */
@WebServlet(name = "SelectJoinableDate", urlPatterns = { "/selectJoinableDate.do" })
public class SelectJoinableDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectJoinableDateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		FripJoinableDate joinableDate = new FripJoinableDate();
		joinableDate.setEndDate(request.getParameter("endDate"));
		joinableDate.setStartDate(request.getParameter("startDate"));
		joinableDate.setFripNo(request.getParameter("fripNo"));
		
		FripService service = new FripService(); 
		JoinFripService JoinService = new JoinFripService();
		ArrayList<JoinFrip> list = JoinService.selectFripByDate(joinableDate);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

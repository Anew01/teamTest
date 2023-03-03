package kr.or.iei.join.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.join.service.JoinFripService;

/**
 * Servlet implementation class CheckScheduleServlet
 */
@WebServlet(name = "CheckSchedule", urlPatterns = { "/checkSchedule.do" })
public class CheckScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckScheduleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//1. 인코딩
				request.setCharacterEncoding("UTF-8");
				//2. 값추출
				int fripNo = Integer.parseInt(request.getParameter("fripNo"));
				String calendar= request.getParameter("calendar");
				int attendNumber = Integer.parseInt(request.getParameter("attendNumber"));
				//3. 비즈니스로직
				System.out.println(fripNo);
				System.out.println(calendar);
				System.out.println(attendNumber);
				JoinFripService service = new JoinFripService();
				int result = service.checkSchedule(fripNo,calendar,attendNumber);
				//4. 결과처리
				PrintWriter out = response.getWriter();
				out.print(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

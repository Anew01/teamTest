package kr.or.iei.frip.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.frip.service.FripService;
import kr.or.iei.frip.vo.Frip;

/**
 * Servlet implementation class MyFripListServlet
 */
@WebServlet(name = "MyFripList", urlPatterns = { "/myFripList.do" })
public class MyFripListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyFripListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String fripWriter = request.getParameter("memberId");
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/frip/myFripList.jsp");
		FripService service = new FripService();
		ArrayList<Frip> list = service.selectMyFrip(fripWriter);
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

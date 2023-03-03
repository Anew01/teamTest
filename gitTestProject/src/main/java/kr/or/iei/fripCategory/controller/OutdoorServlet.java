package kr.or.iei.fripCategory.controller;

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
 * Servlet implementation class OutdoorServlet
 */
@WebServlet(name = "Outdoor", urlPatterns = { "/outdoor.do" })
public class OutdoorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OutdoorServlet() {
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
		FripService service = new FripService();
		String fripCategory = "아웃도어";
		ArrayList<Frip> list = service.selectAllFripByCategory(fripCategory);
		//결
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/category/outdoor.jsp");
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

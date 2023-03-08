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
 * Servlet implementation class SelectAllFripByCategoryServlet
 */
@WebServlet(name = "SelectAllFripByCategory", urlPatterns = { "/selectAllFripByCategory.do" })
public class SelectAllFripByCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectAllFripByCategoryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 인
		request.setCharacterEncoding("utf-8");
		FripService service = new FripService();
		String categoryName = request.getParameter("categoryName");
		RequestDispatcher view = null;
		
		if ("main".equals(categoryName)) {
			//main 화면
			ArrayList<Frip> list = service.selectAllFripByCategory(categoryName);
			ArrayList<Frip> rList = service.selectAllFripByCategory("rList");
			ArrayList<Frip> nList = service.selectAllFripByCategory("nList");
			
			for(Frip f : list) {
				String avgRating = service.selectRating(f.getFripNo());
				f.setAvgRating(avgRating);
				System.out.println("if main rating : "+avgRating);
			}
			request.setAttribute("list", list);
			request.setAttribute("rList", rList);
			view = request.getRequestDispatcher("/WEB-INF/views/common/mainPage.jsp");
			view.forward(request, response);
		} else {
			//main 화면이 아닐때
			ArrayList<Frip> list = service.selectAllFripByCategory(categoryName);
			for(Frip f : list) {
				String avgRating = service.selectRating(f.getFripNo());
				f.setAvgRating(avgRating);
			}
			request.setAttribute("list", list);
			view = request.getRequestDispatcher("/WEB-INF/views/category/selectAllFripByCategory.jsp");
			view.forward(request, response);
		}
	}
		//결
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

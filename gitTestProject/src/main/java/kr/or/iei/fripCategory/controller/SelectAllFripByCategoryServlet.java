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
		String newFeed = request.getParameter("newFeed");
		RequestDispatcher view = null;
		
		if ("main".equals(categoryName)) {
			//main 화면
			ArrayList<Frip> list = service.selectAllFripByCategory(categoryName);
			ArrayList<Frip> rList = service.selectAllFripByCategory(categoryName);
			for(Frip f : list) {
				String avgRating = service.selectRating(f.getFripNo());
				f.setAvgRating(avgRating);
			}
			request.setAttribute("list", list);
			request.setAttribute("rList", rList);
			
			} else {
				ArrayList<Frip> list = service.selectAllFripByCategory(categoryName);
				for(Frip f : list) {
					String avgRating = service.selectRating(f.getFripNo());
					f.setAvgRating(avgRating);
				}
				request.setAttribute("list", list);
				view = request.getRequestDispatcher("/WEB-INF/views/category/selectAllFripByCategory.jsp");
			}
			 if("newFeed".equals(newFeed)) {
				ArrayList<Frip> nList = service.selectNewFeed(newFeed);
				for(Frip f : nList) {
					String avgRating = service.selectRating(f.getFripNo());
					f.setAvgRating(avgRating);
				}
				System.out.println("카테고리 서블렛에서 newFeedList값 : "+nList);
				request.setAttribute("nList", nList);
			} else {
				
			}
			 view = request.getRequestDispatcher("/WEB-INF/views/common/mainPage.jsp");
			 view.forward(request, response);
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

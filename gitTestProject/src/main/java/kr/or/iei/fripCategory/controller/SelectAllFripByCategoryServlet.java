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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인
		request.setCharacterEncoding("utf-8");
		//값
		String categoryName = request.getParameter("categoryName");
		String fripCategory = categoryName;
		//비
		FripService service = new FripService();
		ArrayList<Frip> list = service.selectAllFripByCategory(fripCategory);
		//결
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/category/selectAllFripByCategory.jsp");
		request.setAttribute("list", list);
		view.forward(request, response);
		/*
		if(categoryName.equals("아웃도어")) {
			view.forward(request, response);
		} else if(categoryName.equals("피트니스")) {
			String fripCategory = "피트니스";
			FripService service = new FripService();
			ArrayList<Frip> list = service.selectAllFripByCategory(fripCategory);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/category/selectAllFripByCategory.jsp");
			request.setAttribute("list", list);
			view.forward(request, response);
		} else if(categoryName.equals("DIY")) {
			String fripCategory = "DIY";
			FripService service = new FripService();
			ArrayList<Frip> list = service.selectAllFripByCategory(fripCategory);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/category/selectAllFripByCategory.jsp");
			request.setAttribute("list", list);
			view.forward(request, response);
		} else if(categoryName.equals("스포츠")) {
			String fripCategory = "스포츠";
			FripService service = new FripService();
			ArrayList<Frip> list = service.selectAllFripByCategory(fripCategory);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/category/selectAllFripByCategory.jsp");
			request.setAttribute("list", list);
			view.forward(request, response);
		} else if(categoryName.equals("요리")) {
			String fripCategory = "요리";
			FripService service = new FripService();
			ArrayList<Frip> list = service.selectAllFripByCategory(fripCategory);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/category/selectAllFripByCategory.jsp");
			request.setAttribute("list", list);
			view.forward(request, response);
		} else if(categoryName.equals("온라인")) {
			String fripCategory = "온라인";
			FripService service = new FripService();
			ArrayList<Frip> list = service.selectAllFripByCategory(fripCategory);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/category/selectAllFripByCategory.jsp");
			request.setAttribute("list", list);
			view.forward(request, response);
		} else if(categoryName.equals("자기계발")) {
			String fripCategory = "자기계발";
			FripService service = new FripService();
			ArrayList<Frip> list = service.selectAllFripByCategory(fripCategory);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/category/selectAllFripByCategory.jsp");
			request.setAttribute("list", list);
			view.forward(request, response);
		} else if(categoryName.equals("뷰티")) {
			String fripCategory = "뷰티";
			FripService service = new FripService();
			ArrayList<Frip> list = service.selectAllFripByCategory(fripCategory);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/category/selectAllFripByCategory.jsp");
			request.setAttribute("list", list);
			view.forward(request, response);
		} else if(categoryName.equals("모임")) {
			String fripCategory = "모임";
			FripService service = new FripService();
			ArrayList<Frip> list = service.selectAllFripByCategory(fripCategory);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/category/selectAllFripByCategory.jsp");
			request.setAttribute("list", list);
			view.forward(request, response);
		} else if(categoryName.equals("국내여행")) {
			String fripCategory = "국내여행";
			FripService service = new FripService();
			ArrayList<Frip> list = service.selectAllFripByCategory(fripCategory);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/category/selectAllFripByCategory.jsp");
			request.setAttribute("list", list);
			view.forward(request, response);
		} else if(categoryName.equals("해외여행")) {
			String fripCategory = "해외여행";
			FripService service = new FripService();
			ArrayList<Frip> list = service.selectAllFripByCategory(fripCategory);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/category/selectAllFripByCategory.jsp");
			request.setAttribute("list", list);
			view.forward(request, response);
		}
		
		
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

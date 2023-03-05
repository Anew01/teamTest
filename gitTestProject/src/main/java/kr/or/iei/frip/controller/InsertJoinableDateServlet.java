package kr.or.iei.frip.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.iei.frip.service.FripService;
import kr.or.iei.frip.vo.Frip;
import kr.or.iei.frip.vo.FripJoinableDate;

/**
 * Servlet implementation class InsertJoinableDateServlet
 */
@WebServlet(name = "InsertJoinableDate", urlPatterns = { "/insertJoinableDate.do" })
public class InsertJoinableDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertJoinableDateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		FripJoinableDate joinableDate = new FripJoinableDate();
		joinableDate.setStartDate(request.getParameter("startDate"));
		joinableDate.setEndDate(request.getParameter("endDate"));
		joinableDate.setFripNo(request.getParameter("fripNo"));
		joinableDate.setMaxCount(Integer.parseInt(request.getParameter("maxCount")));
		Frip f = new Frip();
		f.setFripNo(Integer.parseInt(request.getParameter("fripNo")));
		f.setMaxCount(Integer.parseInt(request.getParameter("maxCount")));
		ArrayList<FripJoinableDate> list = new ArrayList<>();
		list.add(joinableDate);
		f.setJoinableDates(list);
		
		FripService service = new FripService();
		FripJoinableDate date = service.insertFripJoinableDate(f);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		gson.toJson(date, out);				
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

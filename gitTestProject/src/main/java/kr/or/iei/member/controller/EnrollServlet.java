package kr.or.iei.member.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import kr.or.iei.frip.service.FripService;
import kr.or.iei.frip.vo.Frip;
import kr.or.iei.frip.vo.FripJoinableDate;
import kr.or.iei.member.service.MemberService;
import kr.or.iei.member.vo.Member;

/**
 * Servlet implementation class EnrollServlet
 */
@WebServlet(name = "Enroll", urlPatterns = { "/enroll.do" })
public class EnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollServlet() {
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
				Member m = new Member();
				m.setMemberId(request.getParameter("memberId"));
				m.setMemberPw(request.getParameter("memberPw"));
				m.setMemberName(request.getParameter("memberName"));
				m.setMemberPhone(request.getParameter("memberPhone"));
				m.setMemberAddr(request.getParameter("memberAddr"));
				m.setMemberAddrDetail(request.getParameter("memberAddrDetail"));
				m.setMemberGender(request.getParameter("memberGender"));
				m.setEnrollDate(request.getParameter("enrollDate"));
				//3.비즈니스로직
				MemberService service = new MemberService();
				Member ChkId = service.selectOneMember(memberId);
				//4.결과처리
				
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
				if(ChkId==null) {
					
				int result = service.insertMember(m);
				
				if(result>0) {
					request.setAttribute("title", "회원가입 성공");
					request.setAttribute("msg", "환영합니다.");
					request.setAttribute("icon", "success");
					request.setAttribute("loc", "/");
				}else{
					request.setAttribute("title", "회원가입 실패");
					request.setAttribute("msg", "입력하신 정보를 다시한번 확인하세요.");
					request.setAttribute("icon", "error");
					request.setAttribute("loc", "/");
				}
				}else {
					request.setAttribute("title", "아이디 중복");
					request.setAttribute("msg", "입력하신 정보를 다시한번 확인하세요.");
					request.setAttribute("icon", "error");
					request.setAttribute("loc", "/");
				}
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

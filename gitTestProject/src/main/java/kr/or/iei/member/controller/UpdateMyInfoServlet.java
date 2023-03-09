package kr.or.iei.member.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.or.iei.member.service.MemberService;
import kr.or.iei.member.vo.Member;

/**
 * Servlet implementation class UpdateMyInfoServlet
 */
@WebServlet(name = "UpdateMyInfo", urlPatterns = { "/updateMyInfo.do" })
public class UpdateMyInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMyInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		//2.값추출
		
		String root = getServletContext().getRealPath("/");
		String saveDirectory = root + "upload/member/";
		int maxsize = 10 * 1024 * 1024;

		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxsize, "utf-8",
				new DefaultFileRenamePolicy());
		
		String status = mRequest.getParameter("status");
		
		
		String oldProfile = mRequest.getFilesystemName("oldProfile");
		String upProfile = mRequest.getFilesystemName("upProfile");
		
		if(oldProfile != null && status.equals("stay")) {
			upProfile = oldProfile;
		}
		Member member = new Member();
		member.setMemberId(mRequest.getParameter("memberId"));
		member.setMemberPw(mRequest.getParameter("memberPw"));
		member.setMemberPhone(mRequest.getParameter("memberPhone"));
		member.setMemberName(mRequest.getParameter("memberName"));
		member.setMemberAddr(mRequest.getParameter("memberAddr"));
		member.setMemberAddrDetail(mRequest.getParameter("memberAddrDetail"));
		member.setMemberProfile(upProfile);
		//3.비즈니스로직
		MemberService service = new MemberService();
		int result = service.updateMember(member);
		//4.화면처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			HttpSession session = request.getSession();

			Member updateMember = (Member) session.getAttribute("m");
			
			updateMember.setMemberPw(member.getMemberPw());
			updateMember.setMemberPhone(member.getMemberPhone());
			updateMember.setMemberAddr(member.getMemberAddrDetail());
			updateMember.setMemberIntro(member.getMemberIntro());
			updateMember.setMemberProfile(member.getMemberProfile());
			
			request.setAttribute("title", "변경성공");
			request.setAttribute("msg", "정보가 성공적으로 변경되었습니다.");
			request.setAttribute("icon", "success");
			if(status.equals("delete")) {
				File delFile = new File(saveDirectory+"/"+oldProfile);
				delFile.delete();
			}
			
		}else{
			request.setAttribute("title", "변경실패");
			request.setAttribute("msg", "입력하신 정보를 다시한번 확인하세요.");
			request.setAttribute("icon", "error");
		
		}
		
		request.setAttribute("loc", "/myPage.do?memberId="+member.getMemberId());
		
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

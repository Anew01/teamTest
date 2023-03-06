package kr.or.iei.frip.controller;

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

/**
 * Servlet implementation class UpdateFripServlet
 */
@WebServlet(name = "UpdateFrip", urlPatterns = { "/updateFrip.do" })
public class UpdateFripServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFripServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		FripService service = new FripService();
		String root = getServletContext().getRealPath("/");
		String saveDirectory = root + "/upload/photo";
		int maxSize = 10*1024*1024;
		int num = 0;
		
		File attachesDir = new File(saveDirectory);
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		fileItemFactory.setRepository(attachesDir);
		fileItemFactory.setSizeThreshold(maxSize);
		
		ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
		Frip f = new Frip();
		ArrayList<String> filepath = new ArrayList<>();
		
		try {
			List<FileItem> items = fileUpload.parseRequest(request);
			
			for(FileItem item : items) {
				
				if(item.isFormField()) {
					String str = new String(item.getString().getBytes("8859_1"),"UTF-8");
					switch(item.getFieldName()){
					case "fripNo" :
						f.setFripNo(Integer.parseInt(str));
						break;
					case "fripTitle" :
						f.setFripTitle(str);
						break;
					case "fripAddr" :
						f.setFripAddr(str);
						break;
					case "fripLevel" :
						f.setFripLevel(str);
						break;
 					case "fripPrice" :
						f.setFripPrice(Integer.parseInt(str));
						break;
					case "editordata" :
						f.setFripContent(str);
						break;
					case "fripCategory" :
						f.setFripCategory(str);
						break;
					case "fripTime" :
						f.setFripTime(str);
						break;
					case "fripWriter" :
						f.setFripWriter("user01");
						break;
					case "fripAddrDetail" :
						f.setFripAddrDetail(str);
						break;
					case "delFilepath" :
						String[] list = str.split(",");
						int fripNo = f.getFripNo();
						for(String delFilepath : list) {
							int result = service.deleteFripFilepath(fripNo, delFilepath);
							if(result == 0) {
								System.out.println("삭제실패");
								return;
							}							
						}
						break;
					}
				} else {
					if(item.getSize() > 0) {
						String str = new String(item.getName());
						int index = str.lastIndexOf(".");
						String str1 = str.substring(index);
						UUID uuid = UUID.randomUUID();
						String fileName = uuid.toString() + str1;
						File uploadFile = new File(saveDirectory + "/" + fileName);
						filepath.add(fileName);
						
						try {
							
							item.write(uploadFile);
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		f.setFilePath(filepath);
		int result = service.updateFrip(f);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		
		if(result > 0) {
			request.setAttribute("title", "스프립 업데이트 성공");
			request.setAttribute("msg", "스프립 업데이트에 성공했습니다");
			request.setAttribute("icon", "success");
		} else {
			request.setAttribute("title", "스프립 업데이트 실패");
			request.setAttribute("msg", "관리자에게 문의 하세요");
			request.setAttribute("icon", "error");
		}
		request.setAttribute("loc", "/viewMyFrip.do?fripNo="+f.getFripNo());
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

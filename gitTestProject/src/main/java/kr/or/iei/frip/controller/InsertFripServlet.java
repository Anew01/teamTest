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
import kr.or.iei.frip.vo.FripJoinableDate;

/**
 * Servlet implementation class InsertFripServlet
 */
@WebServlet(name = "InsertFrip", urlPatterns = { "/insertFrip.do" })
public class InsertFripServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertFripServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
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
			ArrayList<FripJoinableDate> list = new ArrayList<>();
			FripJoinableDate joinDate = new FripJoinableDate();
			
			for(FileItem item : items) {
				
				if(!item.isFormField()) {
					
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
				} else {
					String str = new String(item.getString().getBytes("8859_1"),"UTF-8");
					switch(item.getFieldName()){
					case "fripTitle" :
						f.setFripTitle(str);
						break;
					case "fripAddr" :
						f.setFripAddr(str);
						break;
					case "fripAddrDetail" :
						f.setFripAddrDetail(str);
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
					case "startDate" :
						joinDate.setStartDate(str);
						break;
					case "endDate" :
						joinDate.setEndDate(str);
						break;
					case "fripTime" :
						f.setFripTime(str);
						break;
					case "maxCount" :
						f.setMaxCount(Integer.parseInt(str));
						break;
					case "fripWriter" :
						f.setFripWriter(str);
						break;
					}
				}
			}
			list.add(joinDate);
			f.setJoinableDates(list);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		f.setFilePath(filepath);
		FripService service = new FripService();
		int result = service.insertFrip(f);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		
		if(result > 0) {
			request.setAttribute("title", "????????? ?????? ??????");
			request.setAttribute("msg", "????????? ????????? ??????????????????");
			request.setAttribute("icon", "success");
		} else {
			request.setAttribute("title", "????????? ?????? ??????");
			request.setAttribute("msg", "??????????????? ?????? ?????????");
			request.setAttribute("icon", "error");
		}
		request.setAttribute("loc", "/fripMain.do?memberId="+f.getFripWriter());
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

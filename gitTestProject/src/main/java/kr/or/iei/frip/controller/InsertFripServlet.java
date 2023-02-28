package kr.or.iei.frip.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
			
			for(FileItem item : items) {
				
				if(!item.isFormField()) {
					
					if(item.getSize() > 0) {
						item.getName();
						String separator = File.separator;
						int index = item.getName().lastIndexOf(separator);
						String fileName = item.getName().substring(index + 1);
						File file = new File(saveDirectory+"/"+fileName);
						while(file.exists()) {
							int indexDot = item.getName().indexOf(".");
							String fName = item.getName().substring(0,indexDot) +"("+num+")";
							fileName = fName + item.getName().substring(indexDot);
							num++;
							file = new File(saveDirectory + "/" + fileName);
						}
						File uploadFile = new File(saveDirectory + separator + fileName);
						filepath.add(fileName);
						try {
							
							item.write(uploadFile);
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} else {
					switch(item.getFieldName()){
					case "fripTitle" :
						f.setFripTitle(item.getString());
						break;
					case "fripAddr" :
						f.setFripAddr(item.getString());
						break;
					case "fripLevel" :
						f.setFripLevel(item.getString());
						break;
 					case "fripPrice" :
						f.setFripPrice(Integer.parseInt(item.getString()));
						break;
					case "editordata" :
						f.setFripContent(item.getString());
						break;
					}
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		f.setFilePath(filepath);
		FripService service = new FripService();
		int result = service.insertFrip(f);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
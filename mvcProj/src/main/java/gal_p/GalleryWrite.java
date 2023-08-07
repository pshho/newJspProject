package gal_p;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import controller.BoardService;
import model_p.GalleryDAO;
import model_p.GalleryDTO;

public class GalleryWrite implements BoardService {

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("mainTitle", "갤러리 작성");
		
		String path = "C:\\newJspProject\\mvcProj\\src\\main\\webapp\\galUp";
		
		try {
			MultipartRequest mr = new MultipartRequest(request, path, 10*1024*1024, "utf-8", new DefaultFileRenamePolicy());
			GalleryDTO gDto = new GalleryDTO();
			
			if(mr.getParameter("title") != null) {
				gDto.setTitle(mr.getParameter("title"));
				gDto.setPname(mr.getParameter("pname"));
				gDto.setDescriptions(mr.getParameter("descriptions"));
				gDto.setPw(mr.getParameter("pw"));
				gDto.setUpfile(mr.getFilesystemName("upfile"));
				
				new GalleryDAO().write(gDto);
			}
			
			request.setAttribute("mainPage", "inc/alert");
			request.setAttribute("msg", "작성 완료");
			request.setAttribute("goUrl", "GalleryDetail?id="+gDto.getId());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

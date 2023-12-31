package gal_p;

import java.io.File;
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
			
			gDto.setTitle(mr.getParameter("title"));
			gDto.setPname(mr.getParameter("pname"));
			gDto.setDescriptions(mr.getParameter("descriptions"));
			gDto.setPw(mr.getParameter("pw"));
			gDto.setUpfile(mr.getFilesystemName("upfile"));
				
			String msg = "작성 완료";
			String goUrl = null;
			
			if(gDto != null) {
				if(gDto.getIsImg()) {
					new GalleryDAO().write(gDto);
					goUrl = "GalleryDetail?id="+gDto.getId();
				}else {
					new File(path+"\\"+gDto.getUpfile()).delete();
					msg = "이미지 파일만 가능합니다.";
					goUrl = "GalleryWrite";
				}
			}
			
			request.setAttribute("mainPage", "inc/alert");
			request.setAttribute("msg", msg);
			request.setAttribute("goUrl", goUrl);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

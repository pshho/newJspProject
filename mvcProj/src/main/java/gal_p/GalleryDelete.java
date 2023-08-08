package gal_p;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.BoardService;
import model_p.GalleryDAO;
import model_p.GalleryDTO;

public class GalleryDelete implements BoardService {

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("mainTitle", "갤러리 삭제");
		
		String path = "C:\\newJspProject\\mvcProj\\src\\main\\webapp\\galUp";
		
		GalleryDTO gDto = new GalleryDTO();
		gDto.setId(Integer.parseInt(request.getParameter("id")));
		gDto.setPw(request.getParameter("pw"));
		
		if(gDto.getPw() != null) {
			GalleryDTO ggDto = new GalleryDAO().isIdPwChk(gDto);
			
			String msg = "비밀번호를 확인해주세요.";
			String goUrl = "GalleryDelete?id="+gDto.getId();
			
			if(ggDto.getUpfile() != null) {
				new File(path+"\\"+ggDto.getUpfile()).delete();
				new GalleryDAO().delete(gDto);
				
				msg = "삭제 성공";
				goUrl = "GalleryList";
			}
			
			request.setAttribute("mainPage", "inc/alert");
			request.setAttribute("msg", msg);
			request.setAttribute("goUrl", goUrl);			
		}
		
	}

}

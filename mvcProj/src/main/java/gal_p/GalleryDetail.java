package gal_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.BoardService;
import model_p.GalleryDAO;
import model_p.GalleryDTO;

public class GalleryDetail implements BoardService {

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("mainTitle", "갤러리 상세보기");
		
		GalleryDTO gDto = new GalleryDTO();
		gDto.setId(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("mainData", new GalleryDAO().detail(gDto));
	}

}

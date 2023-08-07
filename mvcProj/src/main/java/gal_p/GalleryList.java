package gal_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.BoardService;
import model_p.GalleryDAO;

public class GalleryList implements BoardService {

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("mainTitle", "갤러리 목록");
		request.setAttribute("mainData", new GalleryDAO().list());
	}

}

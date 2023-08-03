package ser_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.BoardService;
import model_p.BoardDAO;

public class BList implements BoardService {
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("mainTitle", "게시판 목록");
		System.out.println("BList.execute() 실행");
		
		request.setAttribute("mainData", new BoardDAO().list());
	}

}

package ser_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.BoardService;
import model_p.BoardDAO;

public class BDetail implements BoardService {

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("mainTitle", "게시판 상세보기");
		System.out.println("BDetail.execute() 실행");

		request.setAttribute("mainData", new BoardDAO().detail(Integer.parseInt(request.getParameter("id"))));
	}

}

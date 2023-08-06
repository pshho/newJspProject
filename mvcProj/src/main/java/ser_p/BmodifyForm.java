package ser_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.BoardService;
import model_p.BoardDAO;

public class BmodifyForm implements BoardService {

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("mainTitle", "게시글 수정");
		System.out.println("BmodifyForm.execute() 실행");
		
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("mainData", new BoardDAO().detail(id));
	}

}

package ser_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.BoardService;
import model_p.BoardDAO;

public class BwriteForm implements BoardService {
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("mainTitle", "게시판 글쓰기");
		System.out.println("BwriteForm.execute() 실행");
	}

}

package ser_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.BoardService;

public class BdeleteForm implements BoardService {
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("mainTitle", "게시글 삭제");
		System.out.println("BdeleteForm.execute() 실행");
	}

}

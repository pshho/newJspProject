package board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardController.BoardService;
import model_mvcProj.BoardDAO;

public class BoardDetail implements BoardService {

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BoardService의 execute 실행");
		
		request.setAttribute("boardTitle", "게시판 상세보기");
		request.setAttribute("bA", new BoardDAO().person(Integer.parseInt(request.getParameter("id"))));
	}
	
}

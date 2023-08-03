package board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardController.BoardService;
import model_mvcProj.BoardDAO;

public class BoardList implements BoardService {

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BoardService의 execute 실행");
		
		request.setAttribute("boardTitle", "게시판 목록");
		request.setAttribute("list", new BoardDAO().list());
	}
	
}

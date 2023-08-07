package ser_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.BoardService;
import model_p.BoardDAO;
import model_p.PageData;

public class BList implements BoardService {
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("mainTitle", "게시판 목록");
		System.out.println("BList.execute() 실행");
		
		PageData pd = (PageData)request.getAttribute("pd");
		
		pd.calc();
		
		request.setAttribute("mainData", new BoardDAO().list(pd));
	}

}

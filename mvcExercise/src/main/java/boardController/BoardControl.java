package boardController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/*")
public class BoardControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath() + "/board/";
		StringBuffer url = request.getRequestURL();
		// System.out.println(uri);
		// System.out.println(contextPath);
		// System.out.println(url);
		
		String boardService = uri.substring(contextPath.length());
		System.out.println(boardService);
		
		try {
			BoardService service = (BoardService)Class.forName("board."+boardService).newInstance();
			service.execute(request, response);
			
			request.setAttribute("boardPage", boardService);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/template.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

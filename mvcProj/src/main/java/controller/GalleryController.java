package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gallery/*")
public class GalleryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GalleryController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String serviceStr = request.getRequestURI().replace(request.getContextPath()+"/gallery/", "");
		System.out.println(request.getRequestURL());
		System.out.println(serviceStr);
		
		request.setAttribute("mainPage", "gallery/"+serviceStr);
		
		try {
			BoardService service = (BoardService)Class.forName("gal_p."+serviceStr).newInstance();
			service.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/template.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

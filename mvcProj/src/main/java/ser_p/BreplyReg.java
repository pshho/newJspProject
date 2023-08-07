package ser_p;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.BoardService;
import model_p.BoardDAO;
import model_p.BoardDTO;
import model_p.PageData;

public class BreplyReg implements BoardService {

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BmodifyReg execute 실행 ");
		
		BoardDTO dto = new BoardDTO();
		PageData pd = (PageData)request.getAttribute("pd");
		
		dto.setTitle(request.getParameter("title"));
		dto.setPname(request.getParameter("pname"));
		dto.setContent(request.getParameter("content"));
		dto.setPw(request.getParameter("pw"));
		dto.setGid(Integer.parseInt(request.getParameter("gid")));
		dto.setSeq(Integer.parseInt(request.getParameter("seq")));
		dto.setLev(Integer.parseInt(request.getParameter("lev")));
				
		new BoardDAO().reply(dto);
		
		String msg = "작성이 완료되었습니다.";
		String goUrl = "BDetail?id="+dto.getId()+"&page="+pd.page;
		
		request.setAttribute("mainPage", "inc/alert");
		request.setAttribute("msg", msg);
		request.setAttribute("goUrl", goUrl);

	}

}

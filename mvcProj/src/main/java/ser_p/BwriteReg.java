package ser_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import controller.BoardService;
import model_p.BoardDAO;
import model_p.BoardDTO;
import model_p.PageData;

public class BwriteReg implements BoardService {

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BwriteReg execute 실행 ");
		
		String path = request.getRealPath("up");
		path = "C:\\newJspProject\\mvcProj\\src\\main\\webapp\\up\\";
		
		try {
			MultipartRequest mr = new MultipartRequest(request, path, 10*1024*1024, "utf-8", new DefaultFileRenamePolicy());
			BoardDTO dto = new BoardDTO();
			
			dto.setTitle(mr.getParameter("title"));
			dto.setPname(mr.getParameter("pname"));
			dto.setContent(mr.getParameter("content"));
			dto.setPw(mr.getParameter("pw"));
			dto.setUpfile(mr.getFilesystemName("upfile"));
			
			new BoardDAO().write(dto);
			
			System.out.println(dto.getId());
			
			request.setAttribute("mainPage", "inc/alert");
			request.setAttribute("msg", "작성이 완료되었습니다.");
			request.setAttribute("goUrl", "BDetail?id="+dto.getId());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

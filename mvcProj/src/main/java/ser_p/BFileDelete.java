package ser_p;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import controller.BoardService;
import model_p.BoardDAO;
import model_p.BoardDTO;
import model_p.PageData;

public class BFileDelete implements BoardService {

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = "C:\\newJspProject\\mvcProj\\src\\main\\webapp\\up";
		
		try {
			MultipartRequest mr = new MultipartRequest(request, path, 10*1024*1024, "utf-8", new DefaultFileRenamePolicy());
			BoardDTO dto = new BoardDTO();
			dto.setId(Integer.parseInt(mr.getParameter("id")));
			dto.setPw(mr.getParameter("pw"));
			BoardDTO delDTO = new BoardDAO().idPwChk(dto);
			PageData pd = (PageData)request.getAttribute("pd");
			
			String msg = "비밀번호가 일치하지 않습니다.";
			String goUrl = "BmodifyForm?id="+dto.getId()+"&page="+pd.page;
			
			if(delDTO != null) {
				new File(path+"\\"+delDTO.getUpfile()).delete();
				new BoardDAO().fileDelete(dto);
				
				msg = "파일이 삭제되었습니다.";
			}
			
			request.setAttribute("mainPage", "inc/alert");
			request.setAttribute("msg", msg);
			request.setAttribute("goUrl", goUrl);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

}

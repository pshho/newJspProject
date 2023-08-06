package ser_p;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import controller.BoardService;
import model_p.BoardDAO;
import model_p.BoardDTO;

public class BmodifyReg implements BoardService {

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BmodifyReg execute 실행 ");
		
		String path = request.getRealPath("up");
		path = "C:\\newJspProject\\mvcProj\\src\\main\\webapp\\up\\";
		
		try {
			MultipartRequest mr = new MultipartRequest(request, path, 10*1024*1024, "utf-8", new DefaultFileRenamePolicy());
			BoardDTO dto = new BoardDTO();
			
			dto.setId(Integer.parseInt(mr.getParameter("id")));
			dto.setTitle(mr.getParameter("title"));
			dto.setPname(mr.getParameter("pname"));
			dto.setContent(mr.getParameter("content"));
			dto.setPw(mr.getParameter("pw"));
			dto.setUpfile(mr.getFilesystemName("upfile"));
			
			String msg = "비밀번호가 일치하지 않습니다.";
			String goUrl = "BmodifyForm?id="+dto.getId();
			
			// id/pw 검사 및 파일정보 가져오기
			if(new BoardDAO().modify(dto) > 0) { // id, pw가 일치하다면
							
				msg = "수정되었습니다.";
				goUrl = "BDetail?id="+dto.getId();
			}else {
				if(mr.getFilesystemName("upfile") != null) {
					new File(path+"\\"+mr.getFilesystemName("upfile")).delete();
				}
			}
			
			request.setAttribute("mainPage", "alert");
			request.setAttribute("msg", msg);
			request.setAttribute("goUrl", goUrl);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

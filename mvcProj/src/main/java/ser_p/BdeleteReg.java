package ser_p;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.BoardService;
import model_p.BoardDAO;
import model_p.BoardDTO;

public class BdeleteReg implements BoardService {

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BdeleteReg execute 실행 ");
		
		String path = request.getRealPath("up");
		path = "C:\\newJspProject\\mvcProj\\src\\main\\webapp\\up\\";
		
		BoardDTO dto = new BoardDTO();
		
		dto.setId(Integer.parseInt(request.getParameter("id")));
		dto.setPw(request.getParameter("pw"));
		
		String msg = "비밀번호가 일치하지 않습니다.";
		String goUrl = "BdeleteForm?id="+dto.getId();
		
		BoardDTO delDTO = new BoardDAO().idPwChk(dto);
		
		// id/pw 검사 및 파일정보 가져오기
		if(delDTO != null) { // id, pw가 일치하다면
			if(!delDTO.getUpfile().equals("")) { // 파일이 존재한다면
				new File(path+"\\"+delDTO.getUpfile()).delete();
			}
			
			new BoardDAO().delete(dto);				
			msg = "삭제되었습니다.";
			goUrl = "BList";
		}
		
		request.setAttribute("mainPage", "alert");
		request.setAttribute("msg", msg);
		request.setAttribute("goUrl", goUrl);
	}

}

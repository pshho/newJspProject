package gal_p;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import controller.BoardService;
import model_p.GalleryDAO;
import model_p.GalleryDTO;

public class GalleryFileDelete implements BoardService {

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = "C:\\newJspProject\\mvcProj\\src\\main\\webapp\\galUp";
		
		try {
			MultipartRequest mr = new MultipartRequest(request, path, 10*1024*1024, "utf-8", new DefaultFileRenamePolicy());
			
			GalleryDTO gDto = new GalleryDTO();
			gDto.setId(Integer.parseInt(mr.getParameter("id")));
			gDto.setPw(mr.getParameter("pw"));
			
			String msg = "비밀번호를 확인해주세요.";
			String goUrl = "GalleryModify?id="+gDto.getId();
			
			GalleryDTO ggDto = new GalleryDAO().isIdPwChk(gDto);
			
			if(!ggDto.getUpfile().equals("")) {
				new File(path+"\\"+ggDto.getUpfile()).delete();
				new GalleryDAO().fildUpdate(gDto);
				msg = "삭제 완료";
			}
			
			request.setAttribute("mainPage", "inc/alert");
			request.setAttribute("msg", msg);
			request.setAttribute("goUrl", goUrl);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

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

public class GalleryModify implements BoardService {

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("mainTitle", "갤러리 수정");
		
		String path = "C:\\newJspProject\\mvcProj\\src\\main\\webapp\\galUp";
		
		GalleryDTO gDto = new GalleryDTO();
		
		if(request.getParameter("id")!=null) {
			gDto.setId(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("mainData", new GalleryDAO().detail(gDto));
		}
		
		try {
			MultipartRequest mr = new MultipartRequest(request, path, 10*1024*1024, "utf-8", new DefaultFileRenamePolicy());
			
			gDto.setId(Integer.parseInt(mr.getParameter("id")));
			gDto.setPw(mr.getParameter("pw"));
			gDto.setTitle(mr.getParameter("title"));
			gDto.setPname(mr.getParameter("pname"));
			gDto.setDescriptions(mr.getParameter("descriptions"));
			gDto.setUpfile(mr.getFilesystemName("upfile"));
			
			String msg = "비밀번호를 확인해주세요.";
			String goUrl = "GalleryModify?id="+gDto.getId();
						
			if(gDto.getUpfile().equals("")) {
				msg = "파일을 업로드 해주세요.";
			}else {
				GalleryDTO ggDto = new GalleryDAO().isIdPwChk(gDto);
				
				if(ggDto.getId() != 0 && ggDto.getUpfile().equals("")) {
					if(!gDto.getIsImg()) {						
						msg = "이미지 파일만 가능합니다.";
						new File(path+"\\"+gDto.getUpfile()).delete();
					}else {
						new GalleryDAO().update(gDto);
						msg = "수정 완료";
						goUrl = "GalleryDetail?id="+gDto.getId();
					}
				}else {
					new File(path+"\\"+gDto.getUpfile()).delete();					
				}
			}
			
			request.setAttribute("mainPage", "inc/alert");
			request.setAttribute("msg", msg);
			request.setAttribute("goUrl", goUrl);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

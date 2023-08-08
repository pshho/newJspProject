package model_p;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class GalleryDTO {
	int id, cnt;
	String title, pname, pw, upfile, descriptions;
	SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd (E) HH:mm");
	Date reg_date;
	
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getUpfile() {
		if (upfile == null || upfile.trim().equals("") || upfile.trim().equals("null")) {
			upfile = "";
		}
		return upfile;
	}
	public void setUpfile(String upfile) {
		this.upfile = upfile;
	}
	public boolean getIsImg() {
		boolean match = Pattern.matches(".*[.](jpg|png|gif)", getUpfile().toLowerCase());
		return match;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public String getRReg_date() {
		return sd.format(reg_date);
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	
	public String toString() {
		return "GalleryDTO [id=" + id + ", title=" + title + ", pname=" + pname + ", pw=" + pw + ", upfile=" + upfile
				+ ", descriptions=" + descriptions + ", reg_date=" + reg_date + "]";
	}
	
}

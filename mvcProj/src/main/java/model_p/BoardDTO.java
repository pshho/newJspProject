package model_p;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardDTO {
	int id, cnt, seq, lev, gid;
	String title, pname, pw, upfile, content;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd (E) HH:mm");
	Date reg_date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getLev() {
		return lev;
	}
	public void setLev(int lev) {
		this.lev = lev;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
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
		return upfile;
	}
	public void setUpfile(String upfile) {
		this.upfile = upfile;
	}
	public String getContent() {
		return content.replaceAll("\n", "<br/>");
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReg_date() {
		return sdf.format(reg_date);
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	
	public String toString() {
		return "BoardDTO [id=" + id + ", cnt=" + cnt + ", seq=" + seq + ", lev=" + lev + ", gid=" + gid + ", title="
				+ title + ", pname=" + pname + ", pw=" + pw + ", upfile=" + upfile + ", content=" + content
				+ ", reg_date=" + reg_date;
	}
}

package model_mvcProj;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardDTO {
	int id, cnt, seq, lev, gid;
	String title, content, wname, pw, upfile;
	Date reg_date;
	SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd (E) HH:mm");
	
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
	public String getContent() {
		return content.replaceAll("\n", "<br/>");
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWname() {
		return wname;
	}
	public void setWname(String wname) {
		this.wname = wname;
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
	public String getReg_date() {
		return sd.format(reg_date);
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	
	public String toString() {
		return "BoardDTO [id=" + id + ", cnt=" + cnt + ", seq=" + seq + ", lev=" + lev + ", gid=" + gid + ", title="
				+ title + ", content=" + content + ", wname=" + wname + ", pw=" + pw + ", upfile=" + upfile
				+ ", reg_date=" + reg_date + "]";
	}
	
}

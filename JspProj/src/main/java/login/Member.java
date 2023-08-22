package login;

import java.util.HashMap;
import java.util.Map;

public class Member {
	Map<String, String> idPw;
	String name;
		
	public Member() {
		super();
	}
	public Member(String id, String pw, String name) {
		super();
		idPw = new HashMap<>();
		idPw.put(id, pw);
		this.name = name;
	}
	public Map<String, String> getIdPw() {
		return idPw;
	}
	public void setIdPw(Map<String, String> idPw) {
		this.idPw = idPw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

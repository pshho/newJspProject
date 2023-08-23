package login;

import java.util.HashMap;
import java.util.Map;

public class MemberCheck {
	Map<String, Member> check;

	public MemberCheck() {
		super();
	}

	public MemberCheck(Member... mb) {
		super();
		check = new HashMap<>();
		for(Member m : mb) {
			check.put(m.getId(), m);
		}
	}

	public Map<String, Member> getCheck() {
		return check;
	}

	public void setCheck(Map<String, Member> check) {
		this.check = check;
	}

	@Override
	public String toString() {
		return "MemberCheck [check=" + check + "]";
	}
}

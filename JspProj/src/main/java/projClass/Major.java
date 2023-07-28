package projClass;

public class Major{	// 과목 클래스
	private int[] majors;	// 과목을 키로 점수를 값으로
	
	// 과목 생성자
	public Major(int... majors) {
		this.majors = majors;
	}
	
	public int[] getMajors() {
		return majors;
	}

}

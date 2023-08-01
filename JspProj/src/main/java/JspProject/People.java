package JspProject;

public class People extends Subject{ // 과목(총점, 평균, 등수, 등급) 등을 상속받은 사람 클래스
	private String name; // 사람
	private int names; // 이름을 가나다 순으로 정렬하기 위한 변수(아스키 코드값 저장)

	// 사람과 과목은 1대 다의 관계
	public People(String name, String... subjects) {
		super(subjects);
		this.name = name;
	}
	
	public People() {};
	
	// 초기 입력 받은 사람들의 이름 데이터의 맨 앞글자를 아스키 코드 값으로 변환
	public void setNames(String names) {
		this.names = names.charAt(0);
	}
	
	public String getName() {
		return name;
	}
	
	public int getNames() {
		return names;
	}

	@Override
	public String toString() {
		return "People [name=" + name + ", names=" + names + ", toString()=" + super.toString() + "]";
	}
	
}

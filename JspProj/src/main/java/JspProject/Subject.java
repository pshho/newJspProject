package JspProject;

import java.util.Arrays;

public class Subject{ // 과목 클래스
	private String grade; // 등급
	private String[] subjects; // 과목
	private int sum, rank; // 합계, 등수, 과목별 등수
	private int[] subRank; // 과목별 등수 배열
	private double avg; // 평균

	// 해당 카테고리의 과목별 개수의 차이를 두기 위한 생성자
	public Subject(String... subjects) {
		this.subjects = subjects;
		
		calc();
	}
	
	public Subject() {};
	
	// 계산 함수(총점, 평균, 등급)
	void calc() {
		for(int i=0; i<subjects.length; i++) {
			this.sum += Integer.parseInt(subjects[i]);
		}
		
		this.avg = (double)sum/subjects.length;
		
		// 등급 배열을 만들어 등급 변수에 값 저장 - 점수 기준에 맞춰서(5점 단위)
		String[] grades = "F,F,F,F,F,F,D,D,D,D,D,D,D,D+,C,C+,B,B+,A,A+".split(",");
		this.grade = grades[((int)(avg/5) == 20) ? 19:(int)(avg/5)];
	}
	
	// 등수 계산 method, 평균 비교를 위해 subjects를 배열로 선언하고 매개변수로 받음
	void calcRank(Subject[] subjects) {
		this.rank = 1;
		for(Subject subj : subjects) {
			if(avg < subj.avg) {
				rank++;
			}
		}
	}
	
	// 한 과목별 점수 등수를 저장할 배열 및 연산과정
	void calcSubRank(Subject[] subjects) {
		this.subRank = new int[this.subjects.length];
		for(int i=0; i<this.subjects.length; i++) {
			int subRk = 1;
			for(Subject subj : subjects) {
				if(Integer.parseInt(this.subjects[i])<Integer.parseInt(subj.getSubjects()[i])) {
					subRk++;
				}
			}
			subRank[i] = subRk;
		}
	}

	public String getGrade() {
		return grade;
	}

	public String[] getSubjects() {
		return subjects;
	}

	public int getSum() {
		return sum;
	}

	public double getAvg() {
		return avg;
	}

	public int getRank() {
		return rank;
	}

	public int[] getSubRank() {
		return subRank;
	}

	@Override
	public String toString() {
		return "Subject [subjects=" + Arrays.toString(subjects) + ", sum=" + sum + ", avg=" + avg + ", rank=" + rank
				+ ", subRank=" + Arrays.toString(subRank) + ", grade=" + grade + "]";
	}
}

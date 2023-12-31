package basic_P;

public class Person{
	private String name, kor, eng, math;
	private int sum, rank;
	private double avg;
	
	public Person(String name, String kor, String eng, String math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public String getName() {
		return name;
	}
	
	public String getKor() {
		return kor;
	}
	
	public String getEng() {
		return eng;
	}
	
	public String getMath() {
		return math;
	}
	
	public int getRank() {
		return rank;
	}
	
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public int getSum() {
		int kors = Integer.parseInt(kor);
		int engs = Integer.parseInt(eng);
		int maths = Integer.parseInt(math);
		
		this.sum = kors + engs + maths;
		
		return sum;
	}
	
	public double getAvg() {
		this.avg = getSum()/3;
		
		return avg;
	}
	
}

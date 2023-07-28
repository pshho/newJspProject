package projClass;

public class Person extends Major{
	private String name;	// 사람
	private int sum, avg;

	public Person(String name, int... majors) {
		super(majors);
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public int getSum() {
		for(int i=0; i<getMajors().length; i++) {
			this.sum += getMajors()[i];
		}
		
		return sum;
	}
	
	public int getAvg() {
		this.avg = sum/getMajors().length;
		
		return avg;
	}

}

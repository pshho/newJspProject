package projClass;

public class MainTest {

	public static void main(String[] args) {
		
		int[] a = {7, 4, 1, 2, 8, 1, 6, 3};
		
		for(int i=1; i<=a.length; i++) {
			for(int j=0; j<a.length; j++) {
				if(i==a[j]) {
					//System.out.println(a[j]);
					System.out.println("i="+i + "  j=" +j);
					break;
				}
			}
		}
		
		/*
		Person person1 = new Person("일", "ㄱ", "ㄴ", "ㄷ");
		Person person2 = new Person("이", "ㄱ", "ㄴ", "ㄷ", "ㄹ", "ㅁ");
		
		System.out.println(person1.getName());
		
		for(int i=0; i<person1.getMajors().length; i++) {
			System.out.println(person1.getMajors()[i]);
		}
		*/
	}

}

package basic_P;

public class CalcMain {

	public static void main(String[] args) {
		int aa = 5;
		aa++;
		
		// System.out.println(aa);
		
		++aa;
		
		// System.out.println(aa);
		// System.out.println(aa++);
		// System.out.println(aa);
		
		int a = 5, b = 6, c = 10, d;
		d = a++ + ++c - b-- * --a + a++;
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
	}

}

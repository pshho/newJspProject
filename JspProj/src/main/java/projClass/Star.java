package projClass;

public class Star {

	public static void main(String[] args) {
		for(int i=0; i<5; i++) {
			for(double j=0.0; j<=(double)(16-(i+1))/2; j += 0.5) {
				//System.out.print(" ");
				System.out.print(j);
			}
			
			for(double j=0.0; j<i+1; j += 1) {
				System.out.print("*");
				// System.out.print("두");
			}
			
			System.out.println();
		}
	}

}

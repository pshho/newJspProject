package exercise;

public class StarMain {

	public static void main(String[] args) {
		for(int i=0; i<7; i++) {
			for(int j=1; j<20-(i+1)+1; j += 1) {
				System.out.print(" ");
				// System.out.print(j);
			}
			
			for(int j=1; j<=(i+2)+(i-1); j += 1) {
				System.out.print("*");
				if(i==0) {
					break;
				}
				// System.out.print("두");
			}
			
			System.out.println();
		}
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<i; j++) {
				System.out.print(" ");
			}
			
			for(int j=0; j<40-(i*2); j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i=5; i>=0; i--) {
			for(int j=0; j<i; j++) {
				System.out.print(" ");
			}
			
			for(int j=0; j<40-(i*2); j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i=7; i>=0; i--) {
			for(int j=1; j<20-(i+1)+1; j += 1) {
				System.out.print(" ");
				// System.out.print(j);
			}
			
			for(int j=1; j<=(i+2)+(i-1); j += 1) {
				System.out.print("*");
				if(i==0) {
					break;
				}
				// System.out.print("두");
			}
			
			System.out.println();
		}
	}

}

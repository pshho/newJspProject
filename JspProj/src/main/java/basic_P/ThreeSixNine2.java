package basic_P;

public class ThreeSixNine2 {
	public static void main(String[] args) {
		int n = 100;
		
		for(int i=1; i<=n; i++){
			// int[] arr = new int[i];
			int a = i%10;
			int b = a%3;
			int f = (i/10)%3;
			int h = i/10;
			
			try {
				int d = i/a;
				
				try {
					int c = i/b;
					
					try {
						int j = i/h;
						
						try {
							int g = i/f;
						}catch(Exception e) {
							System.out.println(i);
						}
					}catch(Exception e) {
						
					}
				}catch(Exception e) {
					System.out.println(i);
				}
			}catch(Exception e) {
				
			}
			
		}
		
	}
}

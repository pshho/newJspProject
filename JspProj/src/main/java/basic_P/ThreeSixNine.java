package basic_P;

public class ThreeSixNine {
	public static void main(String[] args) {
		int n = 100;
		for(int i=1; i<=n; i++){
			// int a = i/10;
			int c = i;
			
			String text = "";
			
			while(true){
				int b = c%10;
				c /= 10;
				
				if(b%3==0 && b!=0){
					text += "짝";
				}
				
				if(c==0){
					break;
				}
			}
			
			if(text.equals("")){
				text += i;
			}
			
			System.out.println(text);
		}
	}
}

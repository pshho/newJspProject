package exercise;

public class TestMain {

	void quick(int left, int right, int[] b) {
		if(left >= right) {
			return;
		}
		
		int pivot = left;
		int lefts = pivot+1;
		int rights = right;
		
		while(lefts <= rights) {
			while(lefts<=rights && b[pivot] >= b[lefts]) {
				lefts++;
			}
			
			while(lefts<=rights && b[pivot] <= b[rights]) {
				rights--;
			}
			
			if(lefts < rights) {
				int temp = b[lefts];
				b[lefts] = b[rights];
				b[rights] = temp;
			}
		}
		
		int temp = b[pivot];
		b[pivot] = b[rights];
		b[rights] = temp;
		
		quick(left, rights-1, b);
		quick(rights+1, right, b);
	}
	
	public static void main(String[] args) {
		int[] a = {10, 2, 6, 1, 3, 8, 5, 4, 7, 9};
		int[] b = {87, 23, 56, 78, 42, 19, 99, 65, 36};
		
		TestMain test = new TestMain();
		
		test.quick(0, b.length-1, b);
		
		for(int num : b) {
			System.out.print(num + " ");
		}
		
//		String[] names = {"가","나","다","라","마"};
//		
//		for(int i=0; i<names.length; i++) {
//			int ddddd = names[i].charAt(0);
//			System.out.print(ddddd + " ");
//		}
		
	}

}

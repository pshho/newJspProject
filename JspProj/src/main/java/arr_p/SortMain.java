package arr_p;

import java.util.Arrays;

public class SortMain {

	public static void main(String[] args) {
		// 77,65,98,46,82
		// 46,65,77,82,98
		int a = 10;
		int b = 20;
		
		System.out.println(a+", "+b);
		int buf = b;
		b = a;
		a = buf;
		
		System.out.println(a+", "+b);
		
		int[] q = {77,65,98,46,82};
		System.out.println("정렬전:"+Arrays.toString(q));
		for(int i=0; i<q.length; i++) {
			System.out.println(q[i]);
			for(int j=i+1; j<q.length; j++) {
				System.out.print(q[j] + ", ");
				if(q[i]>q[j]) {
					System.out.println("바꿔");
					int z = q[i];
					q[i] = q[j];
					q[j] = z;
				}
			}
			System.out.println("\n::" + Arrays.toString(q));
		}
		System.out.println(Arrays.toString(q));
	}

}

package arr_p;

import java.util.Arrays;

public class ArrayMain {

	public static void main(String[] args) {
		int a = 10;
		
		int[] arr1 = {11,22,33};	// 배열 생성 및 초기화 후 주소 대입
		
		System.out.println(a);
		System.out.println(arr1 + ", " + arr1.length);
		
		// [ : 배열 차원
		// I : int
		// @ : 구분자
		// 515f550a : HashCode 16진수 표현
		
		a = 23;
		arr1 = new int[] {55,66,77,88,99};	// 최초 배열 생성 및 선언시에만 new int[] 생략 가능
		System.out.println(a);
		System.out.println("arr1: " + arr1 + ", " + arr1.length);
		
		int[] arr2 = new int[4];
		System.out.println("arr2: " + arr2 + ", " + arr2.length);
		
		int[] arr3 = arr1;	// shallow copy
		System.out.println("arr3: " + arr3 + ", " + arr3.length);
		
		int b = a;
		System.out.println(a + ", " + b);
		
		a = 77;
		arr1[1] = 6543;
		System.out.println(a + ", " + b);
		System.out.println(arr1[1] + ", " + arr3[1]);
		
		// deep copy
		int[] arr4 = new int[arr1.length];
		
		for(int i=0; i<arr4.length; i++) {
			arr4[i] = arr1[i];
		}
		
		arr4[1] = 33;
		
		int[] arr5 = arr1.clone();
		System.out.println("arr5: " + arr5);
		
		System.out.println("arr4: " + arr4 + ", " + arr4.length);
		System.out.println(Arrays.toString(arr1) + ", " + Arrays.toString(arr4) + ", " + Arrays.toString(arr5));
		
		// 점수 : 87,65,82,46,98,65,72,34,91,79,45,67
		// 점수에 대응하는 수우미양가 등급 배열을 구현하세요
		
		int[] grade = {87,65,82,46,98,65,72,34,91,79,45,67};
		String[] grades = new String[grade.length];
		
		for(int i=0; i<grade.length; i++) {
			String abc = "가가가가가가양미우수".charAt(grade[i]/10)+"";
			grades[i] = abc;
		}
		
		System.out.println(Arrays.toString(grade));
		System.out.println(Arrays.toString(grades));

	}

}

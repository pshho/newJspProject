package oops_p;

import java.util.ArrayList;

public class ExamMain {

	public static void main(String[] args) {

		String[] names = {"현빈", "원빈", "투빈", "장희빈", "미스터빈"};
		
		String[] kor = "72,94,63,87,25".split(",");
		String[] eng = "71,92,69,88,27".split(",");
		String[] math = "76,95,62,80,23".split(",");
		
		Exam[] arr = new Exam[names.length];
		
		/*
		 * System.out.println(arr); System.out.println(arr.length);
		 * System.out.println(arr[0]); System.out.println(arr[1]);
		 * System.out.println(Arrays.toString(arr));
		 */
		
		Exam ex0 = new Exam(names[0], kor[0],eng[0],math[0]);
		Exam ex1 = new Exam(names[1], kor[1],eng[1],math[1]);
		
		/*
		 * System.out.println(ex0); System.out.println(ex1);
		 */
		
		Exam[] arr2 = {
				ex0,
				ex1,
				new Exam(names[2], kor[2],eng[2],math[2]),
				new Exam(names[3], kor[3],eng[3],math[3]),
				new Exam(names[4], kor[4],eng[4],math[4]),
			};
		
		// System.out.println(Arrays.toString(arr2));
		// System.out.println("----------------------------------------------------------------------");
		
		for(int i=0; i<arr.length; i++) {
			// arr[i] = ex0;
			arr[i] = new Exam(names[i], kor[i],eng[i],eng[i]);
			// System.out.println(arr[i]);
		}
		
		for(Exam ar : arr) {
			ar.rankCalc(arr);
			System.out.println(ar);
		}
		
		System.out.println("------------------------------------------------------------------------");
		String[] kor2 = "50,49,63,87,25".split(",");
		String[] eng2 = "71,33,69,88,27".split(",");
		String[] math2 = "76,95,44,80,12".split(",");
		
		Exam[] arr3 = new Exam[names.length];
		
		for(int i=0; i<arr3.length; i++) {
			arr3[i] = new Exam(names[i], kor2[i],eng2[i],math2[i]);
		}
		
		for(Exam ar : arr) {
			ar.rankCalc(arr3);
			System.out.println(ar);
		}
		
	}

}

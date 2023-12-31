package oops_p;

import java.util.Arrays;

class AAA{
	// 클래스는 처음에 선언(공간 부여)
	// 다음에 멤버 변수에 값 할당
	int a = setA();
	int b = setB();
	static int sa = setSA();
	
	public AAA() {
		System.out.println("기본 생성자 난 AAA");
	}
	
	int setA() {
		System.out.println("SET A");
		return b;
	}
	
	int setB() {
		System.out.println("SET B");
		return 60;
	}
	
	static int setSA() {
		System.out.println("static setSA");
		return 5555;
	}
	
	@Override
	public String toString() {
		return "AAA [a="+a+" b="+b+" sa="+sa+"]";
	}
	
}

class BBB{
	void meth_1(int a) {
		System.out.println("meth_1 실행:" + a);
	}
	
	void meth_2(int a, int b) {
		System.out.println("meth_2 실행:" + a + ", " + "b");
	}
	
	void meth_3(int[] a) {
		System.out.println("meth_3 실행:" + Arrays.toString(a));
	}
	
	void meth_4(int... a) {
		System.out.println("meth_4 실행:" + Arrays.toString(a));
	}
	
	void meth_33(int[] a, int b) {
		System.out.println("meth_4 실행:" + Arrays.toString(a) + ", " + b);
	}
	
	/*
	void meth_44(int... a, int b) {
		System.out.println("meth_4 실행:" + Arrays.toString(a) + ", " + b);
	}
	
	
	void meth_444(int... a, int... b) {
		System.out.println("meth_4 실행:" + Arrays.toString(a) + ", " + b);
	}
	*/
	
	void meth_4444(int b, int... a) {
		System.out.println("meth_4 실행:" + Arrays.toString(a) + ", " + b);
	}
	
}

public class InstanceMain {

	public static void main(String[] args) {
		new AAA();
		System.out.println("---------------");
		AAA aaa;
		System.out.println("---------------");
		aaa = new AAA();
		
		System.out.println("---------------");
		
		AAA aab = new AAA();
		
		System.out.println("---------------");
		System.out.println(aaa);
		System.out.println("---------------");
		
		System.out.println("BBB------------");
		BBB bbb = new BBB();
		int[] arr = {11, 22, 33, 44};
		
		bbb.meth_1(10);
		System.out.println("---------------");
		
		bbb.meth_2(10, 20);
		System.out.println("---------------");
		
		bbb.meth_3(arr);
		System.out.println("---------------");
		
		bbb.meth_4(10);
		bbb.meth_4(10, 20);
		bbb.meth_4(10, 20, 30);
		bbb.meth_4(arr);
		System.out.println("---------------");
		
		bbb.meth_33(arr, 50);
		System.out.println("---------------");
		
		bbb.meth_4444(10);
		bbb.meth_4444(10, 20);
		bbb.meth_4444(10, 20, 30);
		bbb.meth_4444(88, arr);
	}

}

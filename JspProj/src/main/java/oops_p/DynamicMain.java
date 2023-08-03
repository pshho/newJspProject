package oops_p;

class Par {
	int a = 10;
	int b = 20;
	
	void meth_1() {
		System.out.println("부모 meth_1() " + a + ", " + b);
	}
	
	void meth_2() {
		System.out.println("부모 meth_2() " + a + ", " + b);
	}
}

class Child1 extends Par {
	int a = 1000; // hiding
	int c = 3000;
	
	void meth_1() { // Overriding
		System.out.println("자식1 meth_1() " + a + ", " + b + ", " + c);
	}
	
	void meth_3() {
		System.out.println("자식1 meth_3()");
	}
}

class Child2 extends Par {
	int d = 1234;
	
	void meth_4() {
		System.out.println("자식2 meth_4()");
	}
}

class Uncle {
	
}

public class DynamicMain {

	public static void main(String[] args) {
		Par pp = new Par();
		Child1 cc1 = new Child1();
		Child2 cc2 = new Child2();
		
		System.out.println("pp : " + pp.a + ", " + pp.b);
		// System.out.println("pp : " + pp.a + ", " + pp.b + ", " + pp.c + ", " + pp.d);
		pp.meth_1();
		pp.meth_2();
		// pp.meth_3();
		// pp.meth_4();
		System.out.println("cc1 : " + cc1.a + ", " + cc1.b + ", " + cc1.c);
		// System.out.println("cc1 : " + cc1.a + ", " + cc1.b + ", " + cc1.c + ", " + cc1.d);
		cc1.meth_1();
		cc1.meth_2();
		cc1.meth_3();
		// cc1.meth_4();
		System.out.println("cc2 : " + cc2.a + ", " + cc2.b + ", " + cc2.d);
		// System.out.println("cc1 : " + cc1.a + ", " + cc1.b + ", " + cc1.c + ", " + cc1.d);
		cc2.meth_1();
		cc2.meth_2();
		// cc2.meth_3();
		cc2.meth_4();
		
		System.out.println("-----------------------------------------------------");
		
		Par dpp = new Par();
		Par dpc = new Child1();
		// Child1 dcp = new Par();
		Child1 dcc = new Child1();
		
		System.out.println("dpp : " + dpp.a + ", " + dpp.b);
		// System.out.println("dpp : " + dpp.a + ", " + dpp.b + ", " + dpp.c);
		dpp.meth_1();
		dpp.meth_2();
		// dpp.meth_3();
		
		System.out.println("dpc : " + dpc.a + ", " + dpc.b);
		// System.out.println("dpc : " + dpc.a + ", " + dpc.b + ", " + dpc.c);
		dpc.meth_1();
		dpc.meth_2();
		// dpp.meth_3();
		
		System.out.println("dcc : " + dcc.a + ", " + dcc.b + ", " + dcc.c);
		dcc.a = 1111;
		dcc.b = 2222;
		dcc.c = 3333;
		System.out.println("dcc : " + dcc.a + ", " + dcc.b + ", " + dcc.c);
		dcc.meth_1();
		dcc.meth_2();
		dcc.meth_3();
		
		System.out.println("---------------------------------------------------- ");
		Par dpcc = dcc;
		System.out.println("dpcc : " + dpcc.a + ", " + dpcc.b);
		dpcc.meth_1();
		dpcc.meth_2();
		// dpcc.meth_3();
		
		Child1 dcpcc = (Child1)dpcc;
		System.out.println("dcpcc : " + dcpcc.a + ", " + dcpcc.b + ", " + dcpcc.c);
		dcpcc.meth_1();
		dcpcc.meth_2();
		dcpcc.meth_3();
		
		// Child1 cpp = (Child1)pp;
		System.out.println(pp instanceof Par);
		System.out.println(pp instanceof Child1);
		System.out.println(cc1 instanceof Par);
		System.out.println(cc1 instanceof Child1);
		// System.out.println(cc1 instanceof Uncle);
		
	}

}

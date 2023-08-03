package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BoardService {
	
//	void meth_1() {
//		System.out.println("부모 meth_1()");
//	}
	
	void execute(HttpServletRequest request, HttpServletResponse response);
}

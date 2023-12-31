package JspProject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/hwProject/categories", "/hwProject/categoriesProcess"})
public class HwProject extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HwProject() {
        super();
        
        System.out.println("카테고리(직장인,일반학생,예체능학생 등) 별 점수 데이터 입력받아 분류하는 Servlet 생성자");
    }

	public void init(ServletConfig config) throws ServletException {
		super.init();
		
		System.out.println("HwProject Servlet의 init method 초기에 한 번 실행");
	}
	
	// Service - Get, Post를 통해 Java Class를 불러와 Client에게 Request 받은 데이터를 처리하고 JspPage에 전달하는 역할 등을 함
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// String root = request.getContextPath(); // 경로 확인
		
		// System.out.println(root);
		String uri = request.getRequestURI(); // 경로 확인
		String command = uri.substring(uri.lastIndexOf("/"));
		// System.out.println(uri);
		// System.out.println(command);
		
		// 서버 한글 인코딩
		request.setCharacterEncoding("utf-8");
		
		// forward 및 redirect 요청 페이지 변수
		String requestPage = null;
		
		// 요청받은 인자들(카테고리, 이름, 과목, 카테고리 별로 다른 과목을 받을 배열)
		String sel = null;
		String[] names = null;
		String[] categories = null;
		String[] distinct = null;
		String[] subjects = null;
		
		if(command.equals("/categories")) {
		    categories = "분류,직장인,예체능계열,일반계열".split(","); // 카테고리 분류 - 나중에 미리 저장된 데이터베이스나 Class와 연결 가능
		    sel = request.getParameter("sel"); // 개별 카테고리 이름
		    subjects = "국어,영어,수학,사탐,과탐,체육,음악,미술,가정".split(","); // 과목 분류 - 카테고리 분류와 마찬가지
		    String nameCount = request.getParameter("namesCount"); // 데이터 입력할 학생의 수
		    
		    if (nameCount != null) {
		    	names = new String[Integer.parseInt(nameCount)]; // 입력받은 학생수만큼의 이름 데이터 배열		    	
		    }
		    
		    // 카테고리를 선택했을 때 달라질 과목을 새로운 배열에 담는 작업
		    if(sel != null && !(sel.equals("분류"))) {
		    	for(int i=0; i<categories.length; i++) {
		    		distinct = Arrays.copyOfRange(subjects, 0, i * 2 + 3);
		    		if(sel.equals(categories[i])) {
		    			break;
		    		}
		    	}
		    }
		    
		    // Client에게 요청이 오면 데이터를 데이터베이스나 Class에서 가져와 전달하는 역할
		    // 혹은 필요한 경우 로직으로 데이터 처리 후 전달
		    request.setAttribute("categories", categories); // 카테고리 목록
		    request.setAttribute("distinct", distinct); // 카테고리 별 과목 수와 이름
		    request.setAttribute("names", names); // 이름들
		    request.setAttribute("nameCount", nameCount); // 학생수
			request.setAttribute("sel", sel); // 선택된 개별 카테고리
		    
			requestPage = "categories.jsp"; // 초기 데이터 입력 페이지
		}
		
		if(command.equals("/categoriesProcess")) {
			categories = "등수,이름".split(","); // 데이터 출력 페이지의 정렬 카테고리
			String[] sels = request.getParameterValues("sel"); // 카테고리 배열
			String selDis = request.getParameter("selDis"); // 선택된 개별 카테고리
			names = request.getParameterValues("name"); // 이름들 데이터
			subjects = request.getParameterValues("subjects"); // 과목 점수(배열) 데이터
			distinct = request.getParameterValues("distinct"); // 선택된 개별 카테고리에 해당하는 과목 수와 이름
			String[] result = "총점,평균,등수,등급".split(","); // 출력을 통해 표시할 정보들
			// 초기에 만들어진 개별 카테고리별 과목과 result배열(총점, 평균, 등수, 등급)을 합친 새로운 카테고리 배열을 받아옴
			String[] iterDistinct = request.getParameterValues("newDistinct");
			// 초기에 만들어진 개별 카테고리별 과목과 categories(등수, 이름)을 합친 새로운 정렬 배열을 받아옴
			String[] iterCategories = request.getParameterValues("newCategories");
			
			// 개별 과목과 총점, 평균, 등수, 등급을 합친 하나의 배열
			List<String> newDistinct = new ArrayList<>();
			if(iterDistinct != null) {
				newDistinct.addAll(Arrays.asList(iterDistinct));
			}else {
				newDistinct.addAll(Arrays.asList(distinct));
				newDistinct.addAll(Arrays.asList(result));
			}
			
			// 과목별 순위, 전체 등수, 이름 등의 순서로 정렬하기 위한 하나의 배열
			List<String> newCategories = new ArrayList<>();
			if(iterCategories != null) {
				newCategories.addAll(Arrays.asList(iterCategories));
			}else {
				newCategories.addAll(Arrays.asList(categories));
				newCategories.addAll(Arrays.asList(distinct));
			}
			
			// Subject와 People을 상속받은 Category Class를 통해 이름, 점수, 카테고리 데이터를 받아와 처리
			Category[][] results = new Category[sels.length][names.length];
			
			// 미리 작성된 Category Class의 2차원 배열에 이름, 점수, 카테고리 데이터를 입력해 생성하는 작업
			for(int i=0; i<sels.length; i++) {
				for(int j=0; j<names.length; j++) {
					String[] sa = Arrays.copyOfRange(subjects, j*(newDistinct.size()-result.length), (j+1)*(newDistinct.size()-result.length));
					results[i][j] = new Category(sels[i], names[j], sa); // Category 2차원 배열 생성
					results[i][j].setNames(names[j]); // 이름 정렬을 위한 아스키 코드값 할당
				}
			}
			
			// 다 생성된 Category results의 2차원 배열에 등수를 정리하는 작업
			for(int i=0; i<sels.length; i++) {
				for(Category res : results[i]) {
					res.calcRank(results[i]); // 전체 과목 총점의 평균에 대한 등수
					res.calcSubRank(results[i]); // 개별 과목의 등수
				}
			}
			
			// 퀵정렬을 위한 생성자
			Category quick = new Category();
			quick.setCategories(newCategories); // 퀵정렬을 위한 정렬 배열 설정
			// 요청받은 정렬 카테고리에 따라 정렬하기 위한 for문
			for(int i=0; i<sels.length; i++) {
				quick.quickDistinct(0, names.length-1, selDis, results[i]);
			}
			
			// 이클립스에서 결과 확인을 위한 출력문
			for(int i=0; i<sels.length; i++) {
				for(Category cat:results[i]) {
					System.out.println(cat);
				}
				System.out.println();
			}
			
			for(int i=0; i<newCategories.size(); i++) {
				System.out.print(quick.getCategories().get(i) + " ");
			}
			
			request.setAttribute("newCategories", newCategories); // 출력 페이지의 정렬 카테고리(이름, 전체 등수, 과목별 등수)
			request.setAttribute("results", results); // Category Class로 정리된 실제 데이터
			// 입력 페이지에서 받아온 선택된 개별 카테고리의 과목 수와 이름
			// 출력 페이지에 추가로 제공할 카테고리(총점, 평균, 등수, 등급)
			request.setAttribute("newDistinct", newDistinct);
			request.setAttribute("category", sels); // 선택된 개별 카테고리(직장인, 예체능계, 일반계)
			request.setAttribute("selDis", selDis); // 정렬 카테고리 값을 받아와 실제 데이터 정렬 순서를 변경시키기 위함
			
			requestPage = "categoriesProcess.jsp";
		}
		
		// System.out.println(requestPage);
		
		// Client에 의해 요청된 url로부터 실제 입력 및 출력 Page로 전달하기 위한 객체
		RequestDispatcher dispatcher = request.getRequestDispatcher(requestPage);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void destroy() {
		super.destroy();
		
		System.out.println("HwProject Servlet 종료(destory)");
	}
}

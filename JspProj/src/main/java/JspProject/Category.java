package JspProject;

import java.util.ArrayList;
import java.util.List;

public class Category extends People{
	private String category;
	private List<String> categories = new ArrayList<>();

	// 상속받은 생성자(카테고리 하나에 사람 배열을 받고 사람 하나는 과목 배열을 가지고 있음)
	public Category(String category, String name, String... subjects) {
		super(name, subjects);
		this.category = category;
	}
	
	public Category() {};
	
	// 출력페이지에서 보였던 전체 등수, 이름, 과목별 등수의 카테고리 배열을 받아와 조건에 맞춘 퀵정렬을 하기 위한 배열
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
	
	// 퀵정렬 - 정렬할 값을 통해 오름차순, 내림차순 가능 현재 오름차순
	void quickDistinct(int left, int right, String key, Category[] category) {
		if(left >= right) {
			return;
		}
		
		int pivot = left;
		int lefts = pivot+1;
		int rights = right;
		
		while(lefts <= rights) { // 비교하는 값을 작은 쪽으로 퀵정렬하면 오름차순, 큰 쪽으로 퀵정렬하면 내림차순
			// 등수, 이름, 과목별 등수 등에 따라 정렬에 비교할 값 달라짐
			if(key.equals("등수")) {
				while(lefts<=rights && category[pivot].getRank()>=category[lefts].getRank()) {
					lefts++;
				}
				
				while(lefts<=rights && category[pivot].getRank()<=category[rights].getRank()) {
					rights--;
				}
			}else if(key.equals("이름")) {
				while(lefts<=rights && category[pivot].getNames()>=category[lefts].getNames()) {
					lefts++;
				}
				
				while(lefts<=rights && category[pivot].getNames()<=category[rights].getNames()) {
					rights--;
				}
			}else {
				for(int i=0; i<categories.size(); i++) {
					if(key.equals(categories.get(i))) {
						while(lefts<=rights && category[pivot].getSubRank()[i-2]>=category[lefts].getSubRank()[i-2]) {
							lefts++;
						}
						
						while(lefts<=rights && category[pivot].getSubRank()[i-2]<=category[rights].getSubRank()[i-2]) {
							rights--;
						}
					}
				}
			}
			
			if(lefts < rights) {
				Category temp = category[lefts];
				category[lefts] = category[rights];
				category[rights] = temp;
			}
		}
		
		Category temp = category[pivot];
		category[pivot] = category[rights];
		category[rights] = temp;
		
		quickDistinct(left, rights-1, key, category);
		quickDistinct(rights+1, right, key, category);
	}
	
	public List<String> getCategories() {
		return categories;
	}

	@Override
	public String toString() {
		return "Category [category=" + category + ", categories=" + categories + ", toString()=" + super.toString()
				+ "]";
	}
}

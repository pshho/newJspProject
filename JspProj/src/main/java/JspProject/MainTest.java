package JspProject;

import java.time.LocalDate;
import java.time.Period;
import java.util.Random;

public class MainTest {
	public static void main(String[] args) {
		
		/*
		 * int[] a = {7, 4, 1, 2, 8, 1, 6, 3};
		 * 
		 * for(int i=1; i<=a.length; i++) { for(int j=0; j<a.length; j++) { if(i==a[j])
		 * { //System.out.println(a[j]); System.out.println("i="+i + "  j=" +j); break;
		 * } } }
		 */
		
		/*
		Person person1 = new Person("일", "ㄱ", "ㄴ", "ㄷ");
		Person person2 = new Person("이", "ㄱ", "ㄴ", "ㄷ", "ㄹ", "ㅁ");
		
		System.out.println(person1.getName());
		
		for(int i=0; i<person1.getMajors().length; i++) {
			System.out.println(person1.getMajors()[i]);
		}
		*/
		
//		Random rd = new Random(); 
//		String[] abc = "직장인,일반계,예체능계".split(",");
//		String[] bcd = "야,임,마,너,휴".split(",");
//		
//		Category[][] category = new Category[abc.length][bcd.length];
//		
//		for(int i=0; i<abc.length; i++) {
//			for(int j=0; j<bcd.length; j++) {
//				String[] def = new String[10];
//				for (int z=0; z<def.length; z++) {
//					def[z] = rd.nextInt(60, 100)+"";
//				}
//				category[i][j] = new Category(abc[i], bcd[j], def);
//				category[i][j].setNames(bcd[j]);
//			}
//		}
//		
//		for(int i=0; i<abc.length; i++) {
//			for(int j=0; j<bcd.length; j++) {
//				category[i][j].calcRank(category[i]);
//				category[i][j].calcSubRank(category[i]);
//				// System.out.println(cat);
//			}
//			// System.out.println();
//		}
//		
//		Category newCa = new Category();
//		
//		for(int i=0; i<abc.length; i++) {
//			newCa.quickDistinct(0, bcd.length-1, "등수", category[i]);			
//		}
//		
//		for(int i=0; i<abc.length; i++) {
//			for(Category cat:category[i]) {
//				System.out.println(cat);
//			}
//			System.out.println();
//		}
		
//		int[] aaa = {1,2,3,4,5,6,7,8,9,10};
//		int[] bbb = Arrays.copyOfRange(aaa, 0, 10);
//		System.out.println(Arrays.toString(bbb));
		
//		String re = "930120".substring(0, 2);
//		String ya = "19" + re;
//		System.out.println(ya);
//		
//		Year year = Year.now();
//		Year currentYear = year.minusYears(Integer.parseInt(ya));
//		
//		
//		System.out.println(currentYear);
		
		String a = "020710";
		String b = "300000";
		
		ResidentNumber bcd = new ResidentNumber(a, b);
		
		// System.out.println(b.charAt(0)-'0');
		
		System.out.println(bcd.getDomeForeign());
		
		for(int fr : bcd.getFrontNumber()) {
			System.out.println(fr);
		}
		
//		LocalDate today = LocalDate.now();
//		LocalDate day = LocalDate.of(2004, 8, 3);
//		System.out.println(today);
//		System.out.println(day);
		
//		Period period = Period.between(day, today);
//		System.out.println(period.getYears());
//		System.out.println(today.getYear()-19);
//		
//		if(period.getYears() >= 19) {
//			System.out.println("19년 지남");
//		}else {
//			System.out.println("19년 안지남");
//		}
		
	}

}

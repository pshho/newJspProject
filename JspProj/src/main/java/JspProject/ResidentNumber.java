package JspProject;

import java.time.LocalDate;
import java.time.Period;

public class ResidentNumber {
	private int[] frontNumber;
	private String domeForeign;
	
	public ResidentNumber(String frontNumber, String backNumber) {
		String[] distinct = "adult,child,foreign,foreign,old".split(",");
		String[] birth = new String[3];
		int brN = backNumber.charAt(0)-'0';
		int[] arr = {19,20,18};
		
		for(int i=0; i<3; i++) {
			birth[i] = frontNumber.substring(i*2, i*2+2);
		}
		
		if(brN==0) {
			brN = 9;
		}
		
		int b = ((brN*2-1)/4)%2;
		if(((brN*2-1)/4)==4) {
			b = 2;
		}
		
		this.frontNumber = new int[birth.length];
		for(int i=0; i<birth.length; i++) {
			if(i==0) {
				this.frontNumber[i] = arr[b]*100+Integer.parseInt(birth[i]); 
			}else {
				this.frontNumber[i] = Integer.parseInt(birth[i]);				
			}
		}
		
		LocalDate today = LocalDate.now();
		LocalDate day = LocalDate.of(this.frontNumber[0], this.frontNumber[1], this.frontNumber[2]);
		Period adCh = Period.between(day, today);
		
		if(adCh.getYears() >= 19 && !(brN >= 5)) {
			brN = 1;
		}
		this.domeForeign = distinct[((brN*2-1)/4)];
		
//		String ya = null;
//		String currentYear = null;
//		
//		Year year = Year.now();
//		if(brN.equals("1") || brN.equals("2")) {
//			 ya = "19" + frN;
//			 currentYear = year.minusYears(Integer.parseInt(ya)) + "";
//		}else if(brN.equals("3") || brN.equals("4")) {
//			ya = "20" + frN;
//			currentYear = year.minusYears(Integer.parseInt(ya)) + "";
//		}
//		
//		this.frontNumber = currentYear;
//		this.backNumber = brN;
//		this.birth = ya + "-" + f2rN + "-" + f3rN;
	}
	
	public String getDomeForeign() {
		return domeForeign;
	}
	
	public int[] getFrontNumber() {
		return frontNumber;
	}
}

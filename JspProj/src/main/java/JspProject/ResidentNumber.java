package JspProject;

import java.time.Year;

public class ResidentNumber {
	private String frontNumber;
	private String backNumber;
	private String birth;
	
	public ResidentNumber(String frontNumber, String backNumber) {
		String frN = frontNumber.substring(0, 2);
		String f2rN = frontNumber.substring(2, 4);
		String f3rN = frontNumber.substring(4, 6);
		String brN = backNumber.substring(0, 1);
		
		String ya = null;
		String currentYear = null;
		
		Year year = Year.now();
		if(brN.equals("1") || brN.equals("2")) {
			 ya = "19" + frN;
			 currentYear = year.minusYears(Integer.parseInt(ya)) + "";
		}else if(brN.equals("3") || brN.equals("4")) {
			ya = "20" + frN;
			currentYear = year.minusYears(Integer.parseInt(ya)) + "";
		}
		
		this.frontNumber = currentYear;
		this.backNumber = brN;
		this.birth = ya + "-" + f2rN + "-" + f3rN;
	}
	
	public String getFrontNumber() {
		return frontNumber;
	}
	
	public String getBackNumber() {
		return backNumber;
	}
	
	public String getBirth() {
		return birth;
	}
}

package basic_P;

public class CalcArgs2 {

	public static void main(String[] args) {
		int sum = 0, count = 0, max = 0, min = 0;
		double avg = 0;
		String reg = "-?\\d+";
		
		for (int i=0; i<args.length; i++) {
			if(!args[i].matches(reg)) {
				continue;
			}else {
				// 짝수 검증(0 제외)
				if (Integer.parseInt(args[i])%2 == 0 && Integer.parseInt(args[i]) != 0) {
					sum += Integer.parseInt(args[i]);
					count ++;
					
					// 최대값, 최소값 초기값 지정
					if(max == 0 && min == 0) {
						max = Integer.parseInt(args[i]);
						min = Integer.parseInt(args[i]);
					}
					
					// 비교 후 최대값 저장
					if(max < Integer.parseInt(args[i])) {
						max = Integer.parseInt(args[i]);
					}
					
					// 비교 후 최소값 저장
					if(min > Integer.parseInt(args[i])) {
						min = Integer.parseInt(args[i]);
					}
					
				}
			}
		}
		
		// 나누기 0 오류 처리 후 오류 없을 시 평균 계산
		if (sum == 0 || count == 0) {
			avg = 0;
		}else {
			avg = (double)sum/count;
		}
		
		System.out.println("합계: " + sum);
		System.out.printf("평균: %.2f\n", avg);
		System.out.println("최대: " + max);
		System.out.println("최소: " + min);
		
	}
}

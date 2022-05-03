package level2;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class KakaoArchery {
	
	public static void main(String args[]) {
		
		
		//1. 상쇄시키는 방법
		//2. 코스트 손실 최소화
		
		
		// info에 값이 1이상일 경우
		// 1. 상쇄
		// 2. 버림
		
		int n = 5;
		int[] info = {2,1,1,1,0,0,0,0,0,0,0};
		
		int[] info2 = {0,0,0,0,0,0,0,0,0,0,0};
		
		int cnt = 0;
		for(int j = 0; j<info.length; j++) {
			int[] infoTmp = info2;
			for(int k = 0; k<info2.length; k++) {
				
				if(cnt == n) {
					infoTmp[k] = 0;
				}else {
					if(info[j]+1>n-cnt) {
						info2[j] = n-cnt;		
						cnt += n-cnt;
					}else {
						info2[j] = info[j]+1;
						cnt += info[j]+1;
					}
				}
			}
			System.out.println(info2[j]);
			
		}
		int totalA = 0;
		
		LinkedHashMap<Integer, Integer> hm = new LinkedHashMap<Integer, Integer>();
		
		int infoVal = 0;
		  for(int i = info.length-1; i >= 0; i--) {
			  hm.put(i, info[infoVal]);
			  infoVal++;
		  }
		  
		 
		  for(Entry<Integer, Integer> entry : hm.entrySet() ) {
			  if(entry.getValue() != 0) {
				  //System.out.println(entry.getKey());
				  totalA += entry.getKey();
			  }
		  }
		
		  //System.out.println(totalA);

	}
	
	int countCalc(LinkedHashMap<Integer, Integer> hm, LinkedHashMap<Integer, Integer> hm2){
		return 0;
		
	}
}


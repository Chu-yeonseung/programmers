package level2;

import java.util.*;
import java.io.*;

class Main {
	
	// 아래 메서드의 내용을 수정 작성하여 완성해 주세요.
	public int[] solution(int[] a, int[] b) {
		Arrays.sort(a);
		Arrays.sort(b);
		
		ArrayList<Integer> arrA = new ArrayList<>();
		ArrayList<Integer> arrB = new ArrayList<>();
		ArrayList<Integer> arrC = new ArrayList<>();
		
		for(int lstA : a) {
			arrA.add(lstA);
		}
		for(int lstB : b) {
			arrB.add(lstB);
		}
		
		for(int i=0; i<arrA.size(); i++) {
			for(int j=0; j<arrB.size(); j++) {
				if(arrA.get(i) == arrB.get(j)) {
					arrC.add(arrB.get(j));
					arrB.remove(j);
				}
			}
		}
			
		int[] c = new int[arrC.size()];
		
		for(int k=0; k<c.length; k++) {
			c[k] = arrC.get(k);
		}
		
		return c;
	}
	
	public static void main(String[] args) throws Exception {
		Main main = new Main();
		int[] a = {1,2,2,3,3,3};
		int[] b = {2,3,3,4,5};
		int[] result = main.solution(a,b);
		
		System.out.println(Arrays.toString(result));
	}
}
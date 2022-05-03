package level2;

import java.io.*;
class Main2 {
	
	
		// 아래 메서드의 내용을 수정 작성하여 완성해 주세요.
	public double solution(int l, int[] a) {
		
		double d = 0;
		for(int i=0; i<a.length; i++) {
			if(i == 0) {
				d = a[i];
				
			}else if(i == a.length-1) {
				if(l - a[(a.length-1)] > d) {
					d = l - a[(a.length-1)];
				}
			}else {
				if(a[i] - a[i-1] > d) {
					d = ((a[i] -a[i-1]) + d)/2;
				}
			}
		}
		
		return d;
	}
	
	
	public static void main(String[] args) throws Exception {
		Main2 main = new Main2();
		
		int l = 10;
		int[] a = {2,5};
		
		double result = main.solution(l, a);
		
		System.out.println(result);
	}
}
package level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.Map.Entry;

public class SecChangeStock {
	public static void main(String args[]) {
		
		int[] prices = {1, 2, 3, 2, 3}; 
		// [1, 2, 3, 2, 3]	
		// [4, 3, 1, 1, 0]
		//Queue<Integer> qe = new LinkedList<Integer>();
		
		/*
		 * int[] answer = new int[prices.length]; int cnt = 0;
		 * 
		 * for(int i=0; i<prices.length; i++) { System.out.println("prices["+ i +"] : "
		 * + prices[i]); for(int j=i+1; j<prices.length; j++) { cnt ++;
		 * System.out.println(prices[i] + "  /  " + prices[j]); if(prices[i] >
		 * prices[j]) { break; } } answer[i] = cnt; cnt = 0; }
		 */
		
/*		
		// 스택 인스턴스 선언
		Stack<Integer> beginIdxs = new Stack<>();

		// 인트 변수 선언
		int i = 0;
		// 주어진 크기 만큼 인트 배열 생성
		int[] terms = new int[prices.length];

		//스택에 선언한 인트변수 삽입
		beginIdxs.push(i);

		// 주어진 크기 만큼 반복
		for (i = 1; i < prices.length; i++) {
			// 스택이 비어있지 않고 i 번째 배열이 스택번째 배열보다 작으면 반복
			while (!beginIdxs.empty() && prices[i] < prices[beginIdxs.peek()]) {
				// 인트 변수 선언해서 스택 추출
				int beginIdx = beginIdxs.pop();

				terms[beginIdx] = i - beginIdx;
				System.out.println("i : " + i + " / beginIdx : " + beginIdx + " / terms : " + terms[beginIdx]);
			}
			// i 값 스택에 추가
			beginIdxs.push(i);
		}
		System.out.println("-----------------------");
		// 스택이 비어있지 않으면
		while (!beginIdxs.empty()) {
			// 인트 변수 선언 하여 스택 값 담음
			int beginIdx = beginIdxs.pop();
			// 배열에 현재 i 값 스택에 저장된 i값 -1 
			terms[beginIdx] = i - beginIdx - 1;
			System.out.println("terms[beginIdx] : / "+ terms[beginIdx] + " / i : " + i + " / beginIdx : " + beginIdx);
		}
*/		
		
	Stack<Integer> str = new Stack<Integer>();
	
	int[] arr = new int[prices.length];
	
	str.add(0);
	
	for(int i=1; i<prices.length; i++) {
		
		while(!str.isEmpty() && prices[i] < prices[str.peek()]) {
			int popNo = str.pop();
			arr[popNo] = i - popNo; 
		}
		str.add(i);
		
	}
	
	while(!str.isEmpty()) {
		int popNo = str.pop();
		
		arr[popNo] = prices.length - popNo - 1;
	}
		
		
		
		for (int cnt11 : arr) {
			System.out.println(cnt11);
		}
		 
	}
}

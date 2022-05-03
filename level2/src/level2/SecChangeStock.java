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
		// ���� �ν��Ͻ� ����
		Stack<Integer> beginIdxs = new Stack<>();

		// ��Ʈ ���� ����
		int i = 0;
		// �־��� ũ�� ��ŭ ��Ʈ �迭 ����
		int[] terms = new int[prices.length];

		//���ÿ� ������ ��Ʈ���� ����
		beginIdxs.push(i);

		// �־��� ũ�� ��ŭ �ݺ�
		for (i = 1; i < prices.length; i++) {
			// ������ ������� �ʰ� i ��° �迭�� ���ù�° �迭���� ������ �ݺ�
			while (!beginIdxs.empty() && prices[i] < prices[beginIdxs.peek()]) {
				// ��Ʈ ���� �����ؼ� ���� ����
				int beginIdx = beginIdxs.pop();

				terms[beginIdx] = i - beginIdx;
				System.out.println("i : " + i + " / beginIdx : " + beginIdx + " / terms : " + terms[beginIdx]);
			}
			// i �� ���ÿ� �߰�
			beginIdxs.push(i);
		}
		System.out.println("-----------------------");
		// ������ ������� ������
		while (!beginIdxs.empty()) {
			// ��Ʈ ���� ���� �Ͽ� ���� �� ����
			int beginIdx = beginIdxs.pop();
			// �迭�� ���� i �� ���ÿ� ����� i�� -1 
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

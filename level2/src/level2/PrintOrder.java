package level2;

import java.util.LinkedList;
import java.util.Queue;

public class PrintOrder {
	public static void main(String args[]) {
		
		int[] priorities = {1, 1, 9, 1, 1, 1};
		int location = 0; 
		// return  = 1;
		int answer = 0;
		Queue<Integer> qe = new LinkedList<Integer>();
		Queue<Boolean> qLoc = new LinkedList<Boolean>();
		for(int i=0; i<priorities.length; i++) {
			qe.offer(priorities[i]);
			
			if(i == location) {
				qLoc.add(true);	
			}else {
				qLoc.add(false);
			}
		}
		
		// ť�� �� ���� �ƴϸ�
		while(!qe.isEmpty()) {
			Boolean back = false;
			Queue<Integer> vQe = new LinkedList<Integer>(qe);
			int qPoll = vQe.poll();
			// ó�� ���� ������ �� ��
			while(!vQe.isEmpty()) {
				if(!vQe.isEmpty() && qPoll < vQe.poll()) {
					back = true;
					break;
				}else {
					back = false;
				}
			}
			
			if(back == true) {
				qe.add(qe.poll());
				qLoc.add(qLoc.poll());	
			}else {
				answer++;
				if(qLoc.peek() == true) {
					System.out.println("return1");
					break;
				}else {
					qe.remove();
					qLoc.remove();
				}
			}
		}
		
		System.out.println(answer);
		
		
		
		
		
		
	}
}

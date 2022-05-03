package level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FunctionDevelopment {
	public static void main(String args[]) {
	
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		// return = 2, 1
		int[] answer = {};
		int dayCnt = 0;
		int uploadCnt = 0;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		Queue<Integer> qePro = new LinkedList<Integer>();
		Queue<Integer> qeSpd = new LinkedList<Integer>();
		
		for(int i=0; i<progresses.length; i++) {
			qePro.add(progresses[i]);
			qeSpd.add(speeds[i]);
		}
		
		while(!qePro.isEmpty()) {
			dayCnt ++;
			while (!qePro.isEmpty() && (qePro.peek() + (dayCnt * qeSpd.peek())) >= 100) {
				uploadCnt ++;
				qePro.poll();
				qeSpd.poll();
			}
			if(uploadCnt != 0) {
				arr.add(uploadCnt);
				uploadCnt = 0;	
			}
			
		}
		
		answer = new int[arr.size()];
		
		for(int j=0; j<answer.length; j++) {
			answer[j] = arr.get(j);
		}
		
	}
}

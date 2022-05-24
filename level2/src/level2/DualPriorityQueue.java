package level2;

import java.util.Deque;
import java.util.LinkedList;

class Dq implements Comparable<Dq>{

	private int dqVal;
	
	public Dq(int dqVal) {
		this.dqVal = dqVal;
	}
	
	public void setDqVal(int dqVal) {
		this.dqVal = dqVal;
	}
	
	public int getDqVal() {
		return dqVal;
	}
	
	@Override
	public int compareTo(Dq o) {
		// TODO Auto-generated method stub
		return this.dqVal - o.dqVal;
	}
	
}


public class DualPriorityQueue {
	public static void main(String args[]) {
	/*
		명령어	수신 탑(높이)
		I 숫자	큐에 주어진 숫자를 삽입합니다.
		D 1		큐에서 최댓값을 삭제합니다.
		D -1	큐에서 최솟값을 삭제합니다.
	*/
		String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
		//String[] operations = {"I 7","I 5","I -5","D -1"};
		// ["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]
		// ["I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"]

		Deque<Dq> dq = new LinkedList<>();
		int[] answer = {};
		
		for(int i=0; i<operations.length; i++) {
			String[] spStr = operations[i].split(" ");
			
			if (spStr[0].equals("I")) {
				
				dq.addLast(new Dq(Integer.parseInt(spStr[1])));
				
			} else if (spStr[0].equals("D")) {
				if(dq.isEmpty()) {
					
				}else {
					if(spStr[1].equals("1")) {
						dq.pollFirst();
					}else if(spStr[1].equals("-1")) {
						dq.pollLast();
					}
				}
			}
		}
		answer = new int[2];
		
		if(dq.isEmpty()) {
			answer[0] = 0;
			answer[1] = 0;
		}else if(dq.size() == 1) {
			if(dq.peek().getDqVal() > 0) {
				answer[0] = dq.peek().getDqVal();
				answer[1] = 0;
			}else {
				answer[0] = 0;
				answer[1] = dq.peek().getDqVal();
			}
		}else {
			answer[0] = dq.pollFirst().getDqVal();
			answer[1] = dq.pollLast().getDqVal();
		}
        
		System.out.println(answer[0]);
		System.out.println(answer[1]);
		
		
		 
		
		
	}
}

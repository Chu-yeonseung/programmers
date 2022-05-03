package level2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Element implements Comparable<Element> {
	
	private int[] num;
	private int cnt;
	private int tot;
	
	public Element(int tot) {
		this.tot = tot;
	}
	
	public Element(int[] num, int cnt) {
		this.num = num;
		this.cnt = cnt;
	}

	public int[] getNum() {
		
		int[] rtn = new int[2];
		
		rtn[0] = this.num[0];
		rtn[1] = this.num[1];
		
		System.out.println("rtn[0] : " + rtn[0] +  " / rtn[1] : " + rtn[1]);
		
		return rtn;
	}

	@Override // Comparable 인터페이스의 compareTo 메서드 구현
	public int compareTo(Element o) {
		int rtn = 0;
		
		System.out.println("this.num[0] : " + this.num[0] + " / this.num[1] : " + this.num[1]);
		System.out.println("o.num[0] : " + o.num[0] + " / o.num[1] : " + o.num[1]);
		
		
		if (Math.abs(this.num[0] - this.num[1]) < Math.abs(o.num[0] - o.num[1])) {
			rtn = -1;
		} else if (Math.abs(this.num[0] - this.num[1]) > Math.abs(o.num[0] - o.num[1])) {
			rtn = 1;
		} else {
			rtn = 0;
		}
		 
		return rtn;
	}
}


public class DiskController2 {
	
	public static void main(String args[]) {
		//int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
		int[][] jobs = {{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}}; // 72
		
		int sum = 0;
		
		new Element(jobs.length);
				
		PriorityQueue<Element> pq = new PriorityQueue<>();
		
		
		for(int i=0; i<jobs.length; i++) {
			pq.add(new Element(jobs[i], i));
		}

		int cnt = 0;
		int cntt = 0;
		
		while(!pq.isEmpty()) {	
        	
			cnt = pq.peek().getNum()[1] + (cnt - (pq.peek().getNum()[0] - cntt));
			sum += cnt;
			cntt = pq.peek().getNum()[0];
			pq.poll();
        }
		
		/*
		 * while (!pq.isEmpty()) {
		 * 
		 * sec++;
		 * 
		 * if (pq.peek().getNum()[0] == sec) {
		 * System.out.println("priorityQueue.peek().getNum()[0] : " +
		 * pq.peek().getNum()[0]);
		 * System.out.println("priorityQueue.peek().getNum()[1] : " +
		 * pq.peek().getNum()[1]); System.out.println("cnt : " + cnt);
		 * System.out.println("cntt : " + cntt); cnt = pq.peek().getNum()[1] + (cnt -
		 * (pq.peek().getNum()[0] - cntt)); System.out.println("cnt ~ : " + cnt);
		 * System.out.println(); sum += cnt; cntt = pq.peek().getNum()[0]; pq.remove();
		 * } }
		 */
		 
		
        
        System.out.println((int) Math.floor(sum / jobs.length));
		/*
		 * if(Math.abs(jobs[i][0] - jobs[i][1]) > Math.abs(jobs[j][0] - jobs[j][1])) {
		 * 
		 * int tmp[] = {jobs[j][0], jobs[j][1]}; jobs[j] = jobs[i]; jobs[i] = tmp; }
		 */
		
	}
}

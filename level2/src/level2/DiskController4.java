package level2;

import java.util.*;

class Djob implements Comparable<Djob>{
	
	private int start;
	private int time;
	
	public Djob(int start, int time) {
		this.start = start;
		this.time = time;
	}
	
	public int getStart() {
		return start;
	}
	
	public void setStart(int start) {
		this.start = start;
	}
	
	public int getTime() {
		return time;
	}
	
	public void setTime(int time) {
		this.time = time;
	}

	public int compareTo(Djob o) {
		//System.out.println("this.start : " + this.start + " / o.start : " + o.start);
		return this.start - o.start;
	}
	
}

class RunTimeComprator implements Comparator<Djob>{

	@Override
	public int compare(Djob o1, Djob o2) {
		
		//System.out.println("this.start : " + o1.start + " / o.start : " + o2.start);
		
		return o1.getTime() - o2.getTime();
	}
	
}

class DiskController4 {
	
	public static void main(String args[]) {
		
		int[][] jobs = {{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}}; // 72
		
		Queue<Djob> pq1 = new PriorityQueue<>();
		Queue<Djob> pq2 = new PriorityQueue<>(new RunTimeComprator());
	
		
		for(int i=0; i<jobs.length; i++) {
			pq1.add(new Djob(jobs[i][0], jobs[i][1]));
		}
		int rStart = 0;
		int rTime = 0;
		
		while(!pq1.isEmpty()) {
			System.out.println("iCurTime : " + rStart);
			if(pq1.peek().getStart() <= rStart) {
				while(!pq1.isEmpty()) {
					if(pq1.peek().getStart() <= rStart) {
						pq2.add(pq1.poll());	
					}else {
						break;
					}
				}
				
				if(!pq2.isEmpty()) {
					Djob tmp = pq2.poll();
					System.out.println("iTotalTime : " + rTime + " / tempJ.getTime() : " + tmp.getTime() + " / iCurTime : " + rStart + " / tempJ.getStart() : " + tmp.getStart());
					rTime += tmp.getTime() + (rStart - tmp.getStart());
					System.out.println("iTotalTime : " + rTime);
					rStart += tmp.getTime();
					System.out.println("iCurTime : " + rStart);
					while(!pq2.isEmpty()) {
						System.out.println("rTimeQueue.peek() : " + pq2.peek());
						pq1.add(pq2.poll());
					}
				}
			}else {
				rStart = pq1.peek().getStart();
			}
			System.out.println("==========================");
		}
		System.out.println("rTime : " + rTime);
		
		System.out.println(rTime/jobs.length);
		
		/*
		 * for(int i=0; i<jobs.length; i++) { pq2.add(new Djob(jobs[i][0], jobs[i][1]));
		 * }
		 * 
		 * while(!pq2.isEmpty()) { System.out.println("pq1.poll().getTime() : " +
		 * pq2.poll().getTime());
		 * 
		 * }
		 */
		
		
	}

}


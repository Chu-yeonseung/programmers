package level2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Job implements Comparable<Job> {

    private int start;
    private int time;

    public Job(int start, int time){
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

    public int compareTo(Job o) {
        return this.start - o.start;
    }
}

class TimeComparator implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
            return o1.getTime() - o2.getTime();
    }
}

class DiskController3 {
	
	public static void main(String args[]) {
		
		int[][] jobs = {{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}}; // 72
		
		System.out.println(solution(jobs));
		
	}
	
    public static int solution(int[][] jobs) {
        Queue<Job> sTimeQueue = new PriorityQueue<>(); //time start 
        Queue<Job> rTimeQueue = new PriorityQueue<>(new TimeComparator()); //runtime order; 

        for(int i = 0; i < jobs.length; i++) {
            sTimeQueue.add(new Job(jobs[i][0], jobs[i][1]));
        }

        int iCurTime = 0;
        int iTotalTime = 0;
        
        while(!sTimeQueue.isEmpty()) {

        	System.out.println("iCurTime : " + iCurTime);
            if(sTimeQueue.peek().getStart() <= iCurTime) {
                //현재 시각 시작할 Job이 있으면
                while( !sTimeQueue.isEmpty()) {
                    //현재 시작할 job을 rTime이 짭은 순서대로 정렬하여 입력
                    if(sTimeQueue.peek().getStart() <= iCurTime) {
                        rTimeQueue.add(sTimeQueue.poll());
                    }else {
                        break;
                    }
                }//end for

                if(!rTimeQueue.isEmpty()) {
                    //처리해야할 Job이 있을 때
                    Job tempJ = rTimeQueue.poll();
                    System.out.println("iTotalTime : " + iTotalTime + " / tempJ.getTime() : " + tempJ.getTime() + " / iCurTime : " + iCurTime + " / tempJ.getStart() : " + tempJ.getStart());
                    iTotalTime += tempJ.getTime() + (iCurTime - tempJ.getStart());
                    System.out.println("iTotalTime : " + iTotalTime);
                    iCurTime += tempJ.getTime();
                    System.out.println("iCurTime : " + iCurTime);
                    while(!rTimeQueue.isEmpty()) {
                        //한건 처리한 후 남은 건을 다시 시간별 정렬 큐로 입력
                    	System.out.println("rTimeQueue.peek() : " + rTimeQueue.peek());
                        sTimeQueue.add(rTimeQueue.poll());
                    }
                }
            }else {
                //현재 처리할 job이 없으면 가장 빨리 처리할 job 시간대로 이동
                iCurTime = sTimeQueue.peek().getStart();
            }
            System.out.println("==========================");
        }//end while

        return iTotalTime/jobs.length;
    }
}
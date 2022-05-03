package level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*class Comp implements Comparable<Comp>{
	private int o1;
	private int o2;
	
	public Comp(int o1, int o2) {
		this.o1 = o1;
		this.o2 = o2;
	}
	
	public int compareTo(Comp target) {
		return this.o1 <= target.o1;
		
	}
}*/


class Comp implements Comparable<Comp>{
    private int zeroCom0;
    private int zeroCom1;

    public Comp(int zeroCom0, int zeroCom1) {
        this.zeroCom0 = zeroCom0;
        this.zeroCom1 = zeroCom1;
    }

    @Override
    public int compareTo(Comp target) {
        int abs = Math.abs(this.zeroCom0 - this.zeroCom1); 
    	int tg = Math.abs(target.zeroCom0 - target.zeroCom1);
    	
    	//System.out.println("abs : " + abs + "  /  tg : " + tg);
    	
    	return abs >= tg ? 1 : -1;    //내림차순
    }

    public int[] get() {
    	int arr[] = new int[2];
    	
    	arr[0] = zeroCom0;	
    	arr[1] = zeroCom1;
    	
    	return arr;
    }
}

public class DiskController {
	
	public static PriorityQueue<Comp> getPriorityQueue() {
        PriorityQueue<Comp> priorityQueue = new PriorityQueue<>();

        return priorityQueue;
    }
	
	public static void main(String args[]) {
		int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
		int sum = 0;
		
		PriorityQueue<Comp> priorityQueue = getPriorityQueue();
		
		for(int i=0; i<jobs.length; i++) {
			priorityQueue.offer(new Comp(jobs[i][0], jobs[i][1]));	
		}
		
		int sec = 0;
		int cnt = 0;
		int cntt = 0;
		
        while(!priorityQueue.isEmpty()) {
        	
        	sec++;
        	
        	if (priorityQueue.peek().get()[0] == sec) {
				System.out.println("priorityQueue.peek().get()[0] : " + priorityQueue.peek().get()[0]);
				System.out.println("priorityQueue.peek().get()[1] : " + priorityQueue.peek().get()[1]);
				System.out.println("cnt : " + cnt);
				System.out.println("cntt : " + cntt);
				cnt = priorityQueue.peek().get()[1] + (cnt - (priorityQueue.peek().get()[0] - cntt));
				System.out.println("cnt ~ : " + cnt);
				System.out.println();
				sum += cnt;
				cntt = priorityQueue.peek().get()[0];
				priorityQueue.poll();
			}
        }
        
        System.out.println((int) Math.floor(sum / jobs.length));


		System.out.println("========================================================================");

		/*
		 * while (true) {
		 * 
		 * if (qe0.isEmpty()) { break; } sec++; while (!qe0.isEmpty() && qe0.peek() ==
		 * sec) { System.out.println("qe0.peek() : " + qe0.peek());
		 * System.out.println("qe1.peek() : " + qe1.peek()); System.out.println("cnt : "
		 * + cnt); System.out.println("cntt : " + cntt); cnt = qe1.peek() + (cnt -
		 * (qe0.peek() - cntt)); System.out.println("cnt ~ : " + cnt);
		 * System.out.println(); sum += cnt; cntt = qe0.peek(); qe0.remove();
		 * qe1.remove(); } }
		 * 
		 * System.out.println((int) Math.floor(sum / jobs.length));
		 */

		/*
		 * for (int i = 0; i < jobs.length; i++) { if (i == 0) { sum += jobs[i][1] -
		 * jobs[i][0]; System.out.println(sum); } else { sum += jobs[i][1] + jobs[i -
		 * 1][1] - jobs[i][0]; System.out.println(sum); } } System.out.println(sum /
		 * jobs.length);
		 */
 

        
        
        
//		
//		int[][] jobs = {{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}}; // 72
//
//		
//		ArrayList<Integer> arr0 = new ArrayList<Integer>();
//		ArrayList<Integer> arr1 = new ArrayList<Integer>();
//		
//		
//		for(int i=0; i<jobs.length; i++) {
//			for(int j=0; j<jobs[i].length; j++) {
//				arr1.add(jobs[i][j]);
//			}
//			arr0.add(arr1.get(i));
//		}
//		
//		for(int num : arr0) {
//			for(int num1 : arr1) {
//				System.out.println(num1);
//			}
//		}
//		
//		// {{0, 5}, {2, 10}, {10000, 2}} = 6
//		//
//		int sum = 0;
//		
//		/*
//		 * for (int i = 0; i < jobs.length; i++) { for (int j = i + 1; j < jobs.length;
//		 * j++) { if (jobs[i][0] < jobs[j][0]) { int tmp0 = jobs[j][0]; int tmp1 =
//		 * jobs[j][1]; jobs[j][0] = jobs[i][0]; jobs[j][1] = jobs[i][1]; jobs[i][0] =
//		 * tmp0; jobs[i][1] = tmp1;
//		 * 
//		 * 
//		 * } } }
//		 * 
//		 * for (int[] num : jobs) { for (int num2 : num) { System.out.print(num2);
//		 * System.out.print("  "); } System.out.println(""); }
//		 */
//		 
//		
//		
//		for (int i = 1; i < jobs.length; i++) {
//
//			int c = i;
//
//			do {
//				int pareNode = (c - 1) / 2;
//				if (Math.abs(jobs[pareNode][1]) < Math.abs(jobs[c][1])) {
//					int tmp0 = jobs[c][0];
//					int tmp1 = jobs[c][1];
//					jobs[c][0] = jobs[pareNode][0];
//					jobs[c][1] = jobs[pareNode][1];
//					jobs[pareNode][0] = tmp0;
//					jobs[pareNode][1] = tmp1;
//
//				} else if (Math.abs(jobs[pareNode][1]) == Math.abs(jobs[c][1])) {
//					if (Math.abs(jobs[pareNode][0]) < Math.abs(jobs[c][0])) {
//						int tmp0 = jobs[c][0];
//						int tmp1 = jobs[c][1];
//						jobs[c][0] = jobs[pareNode][0];
//						jobs[c][1] = jobs[pareNode][1];
//						jobs[pareNode][0] = tmp0;
//						jobs[pareNode][1] = tmp1;
//					}
//				}
//				c = pareNode;
//			} while (c != 0);
//		}
//
//		for(int i=jobs.length-1 ; i>=0; i--) {
//			
//			int tmp0 = jobs[0][0];
//			int tmp1 = jobs[0][1];
//			
//			jobs[0][0] = jobs[i][0];
//			jobs[0][1] = jobs[i][1];
//			
//			jobs[i][0] = tmp0;
//			jobs[i][1] = tmp1;
//			
//			int pareNode = 0;
//			int c = i;
//			do {
//				c = 2 * pareNode + 1; // 자식 중에 더 큰 값을 찾기
//				
//				System.out.println("자식노드 c : " + c + " / 마지막 배열 i : " + i);
//				
//				if (i > 2 && c < i && jobs[c][0] < jobs[c+1][0]) {
//					c++;
//				} // 루트보다 자식이 더 크다면 교환
//				if (c < i && jobs[pareNode][0] < jobs[c][0]) {
//					System.out.println("루트보다 자식이 더 크다면 변경 전   ---- root : " + jobs[pareNode][0] + " / leaf : " + jobs[c][0]);
//					int tmp00 = jobs[pareNode][0];
//					int tmp01 = jobs[pareNode][1];
//					jobs[pareNode][0] = jobs[c][0];
//					jobs[pareNode][1] = jobs[c][1];
//					jobs[c][0] = tmp00;
//					jobs[c][1] = tmp01;
//					System.out.println("루트보다 자식이 더 크다면 변경 전   ---- root : " + jobs[pareNode][0] + " / leaf : " + jobs[c][0]);
//				}else if (c < i && jobs[pareNode][0] == jobs[c][0]) {
//					if (c < i && jobs[pareNode][1] < jobs[c][1]) {
//						System.out.println("루트보다 자식이 더 크다면 변경 전   ---- root : " + jobs[pareNode][0] + " / leaf : " + jobs[c][0]);
//						int tmp00 = jobs[pareNode][0];
//						int tmp01 = jobs[pareNode][1];
//						jobs[pareNode][0] = jobs[c][0];
//						jobs[pareNode][1] = jobs[c][1];
//						jobs[c][0] = tmp00;
//						jobs[c][1] = tmp01;
//						System.out.println("루트보다 자식이 더 크다면 변경 전   ---- root : " + jobs[pareNode][0] + " / leaf : " + jobs[c][0]);
//					}
//				}
//				
//				
//				pareNode = c;
//				System.out.println("root : " + pareNode);
//				System.out.println("--------------------------------------------------------");
//			} while (c < i);
//			
//			
//		}
//		
//		for (int[] num : jobs) {
//			for (int num2 : num) {
//				System.out.print(num2);
//				System.out.print("  ");
//			}
//			System.out.println("");
//		}
//		
//		int sec = 0;
//		int cnt = 0;
//		int cntt =0;
//		Queue<Integer> qe0 = new LinkedList<Integer>();
//		Queue<Integer> qe1 = new LinkedList<Integer>();
//		
//		for(int i=0; i<jobs.length; i++) {
//			qe0.add(jobs[i][0]);
//			qe1.add(jobs[i][1]);
//		}
//		
//		System.out.println("========================================================================");
//		
//		while(true) {
//			
//			if(qe0.isEmpty()) {
//				break;
//			}
//			sec++;
//			/*
//			 * if(cnt > 0) { cnt--; }
//			 */
//			while(!qe0.isEmpty() && qe0.peek() == sec) {
//				System.out.println("qe0.peek() : " + qe0.peek());
//				System.out.println("qe1.peek() : " + qe1.peek());
//				System.out.println("cnt : " + cnt);
//				System.out.println("cntt : " + cntt);
//				cnt = qe1.peek() + (cnt - (qe0.peek()  - cntt));
//				System.out.println("cnt ~ : " + cnt);
//				System.out.println();
//				sum += cnt;
//				cntt = qe0.peek();
//				qe0.remove();
//				qe1.remove();
//			}
//		}
//		
//		
//		System.out.println((int)Math.floor(sum / jobs.length));
//		
//
//		/*
//		 * for (int i = 0; i < jobs.length; i++) { if (i == 0) { sum += jobs[i][1] -
//		 * jobs[i][0]; System.out.println(sum); } else { sum += jobs[i][1] + jobs[i -
//		 * 1][1] - jobs[i][0]; System.out.println(sum); } } System.out.println(sum /
//		 * jobs.length);
//		 */
//		 
//		
		
	}
}

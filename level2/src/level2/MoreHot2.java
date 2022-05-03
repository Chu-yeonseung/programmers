package level2;

import java.util.PriorityQueue;

public class MoreHot2 {
	public static void main(String args[]) {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;

		int mix = 0;
		int answer = 0;
		PriorityQueue<Integer> pQ = new PriorityQueue<Integer>();
		
		for(int num : scoville) {
			pQ.add(num);
		}
		if(K == 0) {
			answer = 0;
		}else {
			while(pQ.size() > 1) {
				if(pQ.peek() < K) {
					System.out.println("1 : " + pQ.peek());
					int first = pQ.poll();
					System.out.println("2 : " + pQ.peek());
					int second = pQ.poll();
					System.out.println("3 : " + pQ.peek());
					
					mix = first  + (second * 2);
					answer++;
					pQ.add(mix);
					if(pQ.peek() >= K) {
						break;
					}else {
					}
				}else {
					break;
				}
			}
		}
		
		
		if(mix < K) {
			answer = -1;
		}
		
		System.out.println(answer);
	}
}

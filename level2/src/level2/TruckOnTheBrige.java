package level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TruckOnTheBrige {
	public static void main(String args[]) {
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};

		// 2	10	[7,4,5,6] 8
		// 100	100	[10] 101
		// 100	100	[10,10,10,10,10,10,10,10,10,10]	110
		
		int timer = 0;
		int truckWeight = 0;
		Queue<Integer> beforeQe = new LinkedList<Integer>();
		Queue<Integer> onBridgeQe = new LinkedList<Integer>();
		Queue<Integer> afterQe = new LinkedList<Integer>();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		for(int num : truck_weights) {
			beforeQe.add(num);
		}
		
		while(true) {
			timer ++;
			
			if(arr.size() != 0) {
				for(int i=0; i<arr.size(); i++) {
					arr.set(i, arr.get(i)+1);
				}
				
				if(!onBridgeQe.isEmpty()) {
					if(arr.get(0) == bridge_length+1) {
						truckWeight -= onBridgeQe.peek();
						afterQe.add(onBridgeQe.poll());
						arr.remove(0);
					}
				}
			}
			
			while((!beforeQe.isEmpty() && (onBridgeQe.size() < bridge_length)) && (truckWeight + beforeQe.peek() <= weight)) {
				
				truckWeight += beforeQe.peek();
				onBridgeQe.add(beforeQe.poll());
				arr.add(1);
				
				break;
			}
			
			if(afterQe.size() == truck_weights.length) {
				break;
			}
		}
	
		System.out.println(timer);
	}
}

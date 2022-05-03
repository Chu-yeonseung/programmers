package level2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SkCodingTest {

	public static void main(String[] args) {
		
		
		int money = 4578;
		// 1999
		// 1, 5, 10, 50, 100, 500
		//String[] cost = {"1", "5", "10", "50", "100", "500"};
		int[] cost = {1, 5, 10, 50, 100, 500};
		int[] costs = {1, 4, 99, 35, 50, 1000}; 
		// {2, 11, 20, 100, 200, 600}

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		
		for(int i=0; i<cost.length; i++) {
			map.put(cost[i], (500/ cost[i]*costs[i]));
		}
		
		
		int total = 0;
		List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
		entryList.sort(Map.Entry.comparingByValue());
		
		while(money > 0) {
			for(Map.Entry<Integer, Integer> entry : entryList){
			    if(money / entry.getKey() != 0) {
			    	total += (money / entry.getKey()) * differ(entry.getKey());
			    	money = money % entry.getKey();
			    }
			    System.out.println(money);
			    System.out.println(total);
			    
			}	
		}
		
	}
	
	static int differ(int entCost) {
		int[] cost = {1, 5, 10, 50, 100, 500};
		int[] costs = {1, 4, 99, 35, 50, 1000};
		int rtnCost = 0;
		
		for(int i=0; i<cost.length; i++) {
			if(cost[i] == entCost) {
				 rtnCost = costs[i];
			}
		}
		return rtnCost;
	}

}

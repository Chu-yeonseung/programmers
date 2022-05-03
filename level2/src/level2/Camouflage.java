package level2;

import java.util.HashMap;
import java.util.Map;

public class Camouflage {
	public static void main(String args[]) {

		//String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
		//String[][] clothes = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
		String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}, {"redsunglasses", "eyewear"}, {"crowmask", "face"}};
		// 3 + (2 x 1) - 최초 생각 값
		// ((2+1) x 1) + ((1+1) x 1) - 풀이  낱개 값을 따로 더하는게 아니라 경우의 수에 추가해줘야했다....

		
		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < clothes.length; i++) {
			map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
		}

		int sum = 1;
		if (map.size() > 1) {
			for (String str : map.keySet()) {
				System.out.println("key : " + str + " / value  : " + map.get(str));
				sum *= map.get(str)+1;
				System.out.println("sum : " + sum);
			}
			//최소 한개 입음
			sum --;
		}else {
			sum = clothes.length;
		}

		System.out.println(sum);
		 

		System.out.println("------------------------------------------------------------");
		
		
		
		/*
		 * Map<String, Integer> hashMapClothes = new HashMap<>(); for (int i = 0; i <
		 * clothes.length; i++) { hashMapClothes.put(clothes[i][1],
		 * hashMapClothes.getOrDefault(clothes[i][1], 0) + 1); }
		 * 
		 * int count = 1; if (hashMapClothes.size() > 1) { for (String key :
		 * hashMapClothes.keySet()) { System.out.println("key : " + key + " / value  : "
		 * + map.get(key)); count *= hashMapClothes.get(key) + 1;
		 * System.out.println("count : " + count); } count--; } else { count =
		 * clothes.length; } System.out.println(count);
		 */
		 
		 
		
		
	}
}

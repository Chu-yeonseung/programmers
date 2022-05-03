package level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
	public static void main(String args[]) {
		//["119", "97674223", "1195524421"]	false
		//["123","456","789"]	true
		//["12","123","1235","567","88"]	false
		
		String[] phone_book = {"119", "97674223", "1195524421"};
		//String[] phone_book = {"123","456","789"};
		//String[] phone_book = {"12","123","1235","567","88"};
		//Map<String, Integer> map = new HashMap<String, Integer>();
		
		boolean answer = true;
		
		
		HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0 ; i < phone_book.length ; i++) {
        	map.put(phone_book[i],i);
        }

        for(int i = 0 ; i < phone_book.length ; i++) {
        	for(int j = 1 ; j < phone_book[i].length() ; j++ ) {
        		if(map.containsKey(phone_book[i].substring(0,j))) {
        			answer = false;          
        		}
        	}
        }
		
		/*
		 * if (phone_book.length > 1) { Arrays.sort(phone_book); for (int i = 0; i <
		 * phone_book.length - 1; i++) { for (int j = i + 1; j < phone_book.length - 1;
		 * j++) { if (phone_book[i].length() > phone_book[j].length()) { continue; }
		 * else { if (phone_book[i].equals(phone_book[j].substring(0,
		 * phone_book[i].length()))) { answer = false; break; } } } } }
		 */
		 
		
		
		
		
		/*
		 * for (int i=0; i<phone_book.length; i++) { map.put(phone_book[i], i); }
		 * 
		 * if(phone_book.length > 1) { for (int i = 0; i < phone_book.length; i++) { for
		 * (Map.Entry<String, Integer> entry : map.entrySet()) { if(i !=
		 * entry.getValue()) { if(entry.getKey().contains(phone_book[i])) { answer =
		 * false; } } } } }
		 */
		
		 
		
		System.out.println(answer);
		
		
	}
}

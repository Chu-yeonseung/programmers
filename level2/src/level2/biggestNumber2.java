package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class biggestNumber2 {
	public static void main(String args[]) {
		//[6, 10, 2]	"6210"
		//[3, 30, 34, 5, 9]	"9534330"
		//int[] numbers = {3, 30, 34, 5, 51, 5, 9};
		int[] numbers = {0, 0, 0, 0};
		ArrayList<Integer> lstNum = new ArrayList<>(); 
		int numLen = 0;
		String answer = ""; 
		
		for(int num : numbers) {
			lstNum.add(num);
			numLen += String.valueOf(num).length();
		}
		
		for(int i=0; i<lstNum.size(); i++) {
			System.out.println(lstNum.get(i));
		}
		
		while (answer.length() < numLen) {
			
			int bigIdx = 0;
			ArrayList<Integer> arrLst = new ArrayList<Integer>();
			for (int i = 1; i < lstNum.size(); i++) {
				
				if (String.valueOf(lstNum.get(bigIdx)).charAt(0) < String.valueOf(lstNum.get(i)).charAt(0)) {
					bigIdx = i;
					arrLst.clear();
				} else if (String.valueOf(lstNum.get(bigIdx)).charAt(0) == String.valueOf(lstNum.get(i)).charAt(0)) {
					arrLst.add(lstNum.get(i));
				}
			}
			if (arrLst.size() == 0) {
				answer += String.valueOf(lstNum.get(bigIdx));
				lstNum.remove(bigIdx);
			} else {
				arrLst.add(lstNum.get(bigIdx));
				
				arrLst.sort(new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						String str1 = String.valueOf(o1) + String.valueOf(o2);
						String str2 = String.valueOf(o2) + String.valueOf(o1);
						
						if(Integer.parseInt(str1) == Integer.parseInt(str2)) {
							return 0;
						}else if(Integer.parseInt(str2) > Integer.parseInt(str1)) {
							return 1;
						}else {
							return -1;
						}
					}
				});
				
				for(int j=0; j<arrLst.size(); j++) {
					System.out.println("arrLst.get(j)  : "  + arrLst.get(j));
					answer += String.valueOf(arrLst.get(j));
					lstNum.remove(arrLst.get(j));
				}
				arrLst.clear();
			}
		}
		String pattern = "^[0]*$";
		if(Pattern.matches(pattern, answer)) {
			answer = Integer.parseInt(answer) + "";
		}
		System.out.println("answer : " + answer);
	}

	 
}

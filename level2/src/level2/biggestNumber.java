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

public class biggestNumber {
	public static void main(String args[]) {
		//[6, 10, 2]	"6210"
		//[3, 30, 34, 5, 9]	"9534330"
		int[] numbers = {3, 30, 34, 5, 9};
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
			HashMap<String, Integer> hm1 = new HashMap<>();
			HashMap<String, Integer> hm2 = new HashMap<>();
			HashMap<String, Integer> hm3 = new HashMap<>();
			HashMap<String, Integer> hm4 = new HashMap<>();
			HashMap<String, Integer> hm5 = new HashMap<>();
			
			for (int i = 1; i < lstNum.size(); i++) {
				if (String.valueOf(lstNum.get(bigIdx)).charAt(0) < String.valueOf(lstNum.get(i)).charAt(0)) {
					bigIdx = i;
					arrLst.clear();
				} else if (String.valueOf(lstNum.get(bigIdx)).charAt(0) == String.valueOf(lstNum.get(i)).charAt(0)) {
					arrLst.add(i);
				}
			}
			if (arrLst.size() == 0) {
				answer += String.valueOf(lstNum.get(bigIdx));
				lstNum.remove(bigIdx);
			} else {
				System.out.println("arrLst.size() : " + arrLst.size());
				char oriNo = String.valueOf(lstNum.get(bigIdx)).charAt(0);
				for (int j = 0; j < arrLst.size(); j++) {
					if (String.valueOf(lstNum.get(arrLst.get(j))).length() == 3 && String.valueOf(lstNum.get(arrLst.get(j))).charAt(2) >= oriNo && String.valueOf(lstNum.get(arrLst.get(j))).charAt(1) >= oriNo) {
						hm1.put(String.valueOf(j),lstNum.get(arrLst.get(j)));
					}else if (String.valueOf(lstNum.get(arrLst.get(j))).length() == 2 && String.valueOf(lstNum.get(arrLst.get(j))).charAt(1) >= oriNo) {
						hm2.put(String.valueOf(j),lstNum.get(arrLst.get(j)));
					}else if (String.valueOf(lstNum.get(arrLst.get(j))).length() == 1) {
						hm3.put(String.valueOf(j),lstNum.get(arrLst.get(j)));
					}else if (String.valueOf(lstNum.get(arrLst.get(j))).length() == 2 && String.valueOf(lstNum.get(arrLst.get(j))).charAt(1) < oriNo) {
						hm4.put(String.valueOf(j),lstNum.get(arrLst.get(j)));
					}else if (String.valueOf(lstNum.get(arrLst.get(j))).length() == 3 && String.valueOf(lstNum.get(arrLst.get(j))).charAt(1) < oriNo) {
						hm5.put(String.valueOf(j),lstNum.get(arrLst.get(j)));
					}
				}
				
				if (hm1.size() != 0) {
					System.out.println("hm1");
					List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(hm1.entrySet());
					Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
						// compare로 값을 비교
						public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
						// 내림 차순으로 정렬
							return obj2.getValue().compareTo(obj1.getValue());
						}
					});
					for (Entry<String, Integer> entry : list_entries) {
						System.out.println(entry.getKey() + " : " + entry.getValue());
						answer += String.valueOf(entry.getValue());
						lstNum.remove(Integer.parseInt(entry.getKey()));
					}
				}
				if (hm2.size() != 0) {
					System.out.println("hm2");
					List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(hm2.entrySet());
					Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
						// compare로 값을 비교
						public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
						// 내림 차순으로 정렬
							return obj2.getValue().compareTo(obj1.getValue());
						}
					});
					for (Entry<String, Integer> entry : list_entries) {
						System.out.println(entry.getKey() + " : " + entry.getValue());
						answer += String.valueOf(entry.getValue());
						lstNum.remove(Integer.parseInt(entry.getKey()));
					}
				}
				if (hm3.size() != 0) {
					System.out.println("hm3");
					List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(hm3.entrySet());
					Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
						// compare로 값을 비교
						public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
						// 내림 차순으로 정렬
							return obj2.getValue().compareTo(obj1.getValue());
						}
					});
					for (Entry<String, Integer> entry : list_entries) {
						System.out.println(entry.getKey() + " : " + entry.getValue());
						answer += String.valueOf(entry.getValue());
						lstNum.remove(Integer.parseInt(entry.getKey()));
					}
				}
				if (hm4.size() != 0) {
					System.out.println("hm4");
					List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(hm4.entrySet());
					Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
						// compare로 값을 비교
						public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
						// 내림 차순으로 정렬
							return obj2.getValue().compareTo(obj1.getValue());
						}
					});
					for (Entry<String, Integer> entry : list_entries) {
						System.out.println(entry.getKey() + " : " + entry.getValue());
						answer += String.valueOf(entry.getValue());
						lstNum.remove(Integer.parseInt(entry.getKey()));
					}
				}
				if (hm5.size() != 0) {
					System.out.println("hm5");
					List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(hm5.entrySet());
					Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
						// compare로 값을 비교
						public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
						// 내림 차순으로 정렬
							return obj2.getValue().compareTo(obj1.getValue());
						}
					});
					for (Entry<String, Integer> entry : list_entries) {
						System.out.println(entry.getKey() + " : " + entry.getValue());
						answer += String.valueOf(entry.getValue());
						lstNum.remove(Integer.parseInt(entry.getKey()));
					}
				}
			}
		}
		
		System.out.println("answer : " + answer);
	}
	
	public static void hashComp(HashMap<String, Integer> hm) {
		List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String,Integer>>(hm.entrySet());
		// 비교함수 Comparator를 사용하여 내림 차순으로 정렬
		Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
			// compare로 값을 비교
			public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
			// 내림 차순으로 정렬
				return obj2.getValue().compareTo(obj1.getValue());
			}
		});
	  
	}
	 
}

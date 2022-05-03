package level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

public class BestAlbum {
	public static void main(String arsg[]) {
		
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};	
		int[] plays = {500, 600, 150, 800, 2500};
		// ������ȣ - idx 
		
		// ��Ʈ���� ����Ʈ���� �帣 ���� ���� ���� ����� �뷡�� �� ���� ��� ����Ʈ �ٹ��� ����Ϸ� �մϴ�. 
		// �뷡�� ���� ��ȣ�� �����ϸ�

		// �з� ���� 
		// �뷡�� �����ϴ� ������ ������ �����ϴ�.
		// ���� �뷡�� ���� ����� �帣�� ���� �����մϴ�.
		// �帣 ������ ���� ����� �뷡�� ���� �����մϴ�.
		// �帣 ������ ��� Ƚ���� ���� �뷡 �߿����� ���� ��ȣ�� ���� �뷡�� ���� �����մϴ�.
		
		// �뷡�� �帣�� ��Ÿ���� ���ڿ� �迭 genres 
		// �뷡�� ��� Ƚ���� ��Ÿ���� ���� �迭 plays
		// ����Ʈ �ٹ��� �� �뷡�� ���� ��ȣ�� ������� return �ϵ��� solution �Լ��� �ϼ��ϼ���.
		
		// ����
		// genres[i]�� ������ȣ�� i�� �뷡�� �帣�Դϴ�.
		// plays[i]�� ������ȣ�� i�� �뷡�� ����� Ƚ���Դϴ�.
		// genres�� plays�� ���̴� ������, �̴� 1 �̻� 10,000 �����Դϴ�.
		// �帣 ������ 100�� �̸��Դϴ�.
		// �帣�� ���� ���� �ϳ����, �ϳ��� � �����մϴ�.
		// ��� �帣�� ����� Ƚ���� �ٸ��ϴ�.
		
		HashMap<String, Integer> map = new HashMap<>();
		LinkedHashMap<Integer, String> mapStr = new LinkedHashMap<>();
		LinkedHashMap<Integer, Integer> mapNum = new LinkedHashMap<>();
		LinkedList<Integer> linkLst = new LinkedList<Integer>();
		LinkedList<Integer> linkAnswer = new LinkedList<Integer>();
		ArrayList<Integer> arr = new ArrayList<Integer>();

		// ���� ����� �帣
		// ������ȣ Ű ���� ����
		for(int i=0; i<genres.length; i++) {
			map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
			mapStr.put(i, genres[i]);	
			mapNum.put(i, plays[i]);	
		}
		// Collections.max(map.values())
		while(map.size() > 0) {
			String entStr = "";
			for(Entry<String, Integer> entry : map.entrySet()) {
				if(entry.getValue() == Collections.max(map.values())) {
					entStr = entry.getKey();
					for(Entry<Integer, String> mapEnt : mapStr.entrySet() ) {
						if(mapEnt.getValue().equals(entry.getKey())) {
							if(linkLst.size() == 0) {
								linkLst.add(mapNum.get(mapEnt.getKey()));
								linkAnswer.add(mapEnt.getKey());
							}else {
								if(linkLst.get(0) < mapNum.get(mapEnt.getKey())) {
									linkLst.add(0,mapNum.get(mapEnt.getKey()));
									linkAnswer.add(0,mapEnt.getKey());
								}else {
									if(linkLst.size() < 2) {
										linkLst.add(mapNum.get(mapEnt.getKey()));
										linkAnswer.add(mapEnt.getKey());
									}else {
										if(linkLst.get(1) < mapNum.get(mapEnt.getKey())) {
											linkLst.set(1,mapNum.get(mapEnt.getKey()));
											linkAnswer.set(1,mapEnt.getKey());
										}
									}
								}
							}
							if(linkLst.size() > 2) {
								linkLst.remove(2);	
								linkAnswer.remove(2);	
							}
						}
						
					}
				}
			}
			arr.addAll(linkAnswer);
			linkLst.clear();
			linkAnswer.clear();
			map.remove(entStr);
		}
		int[] answer = new int[arr.size()];
		
		for(int i=0; i<answer.length; i++) {
			answer[i] = arr.get(i);
			
			System.out.println(answer[i]);
		}

		
		
		
			
	}
}

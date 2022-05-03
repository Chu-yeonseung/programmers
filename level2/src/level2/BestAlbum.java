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
		// 고유번호 - idx 
		
		// 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 
		// 노래는 고유 번호로 구분하며

		// 분류 기준 
		// 노래를 수록하는 기준은 다음과 같습니다.
		// 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
		// 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
		// 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
		
		// 노래의 장르를 나타내는 문자열 배열 genres 
		// 노래별 재생 횟수를 나타내는 정수 배열 plays
		// 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
		
		// 조건
		// genres[i]는 고유번호가 i인 노래의 장르입니다.
		// plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
		// genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
		// 장르 종류는 100개 미만입니다.
		// 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
		// 모든 장르는 재생된 횟수가 다릅니다.
		
		HashMap<String, Integer> map = new HashMap<>();
		LinkedHashMap<Integer, String> mapStr = new LinkedHashMap<>();
		LinkedHashMap<Integer, Integer> mapNum = new LinkedHashMap<>();
		LinkedList<Integer> linkLst = new LinkedList<Integer>();
		LinkedList<Integer> linkAnswer = new LinkedList<Integer>();
		ArrayList<Integer> arr = new ArrayList<Integer>();

		// 많이 재생된 장르
		// 고유번호 키 벨류 설정
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

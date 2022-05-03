package level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OpenChat {
	public static void main(String arsg[]) {
		// ["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]
		// ["Prodo���� ���Խ��ϴ�.", "Ryan���� ���Խ��ϴ�.", "Prodo���� �������ϴ�.", "Prodo���� ���Խ��ϴ�."]
		
		
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
		ArrayList<String> result = new ArrayList<String>();
		Map<String, String> idMap = new HashMap<String, String>();
		
		for(String str : record) {
			String[] arrSplit = str.split(" ");
			
			if(arrSplit[0].equals("Enter")) {
				idMap.put(arrSplit[1], arrSplit[2]);
			}else if(arrSplit[0].equals("Change")){
				idMap.replace(arrSplit[1], arrSplit[2]);
			}
		}
		
		
		for (String str : record) {
			String[] arrSplit = str.split(" ");
			if ("Enter".equals(arrSplit[0])) {
				result.add(idMap.get(arrSplit[1]) + "���� ���Խ��ϴ�.");
			}else if("Leave".equals(arrSplit[0])) {
				result.add(idMap.get(arrSplit[1]) + "���� �������ϴ�.");
			}
		}
		 
		String answer[] = result.toArray(new String[result.size()]);
		
	}
	
	
}

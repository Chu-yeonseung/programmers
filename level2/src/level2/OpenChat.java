package level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OpenChat {
	public static void main(String arsg[]) {
		// ["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]
		// ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
		
		
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
				result.add(idMap.get(arrSplit[1]) + "님이 들어왔습니다.");
			}else if("Leave".equals(arrSplit[0])) {
				result.add(idMap.get(arrSplit[1]) + "님이 나갔습니다.");
			}
		}
		 
		String answer[] = result.toArray(new String[result.size()]);
		
	}
	
	
}

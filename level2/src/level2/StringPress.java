package level2;

public class StringPress {
	public static void main(String args[]){

		String s = "abcabcdede";
		//String s = "aabbaccc";
		//2abcdede
		
		int answer = 0;
		
		if(s.length() == 1) {
			answer = 1;
		}
		for (int var = 1; var <= s.length() / 2; var++) {
			String rst = "";
	        String sub = "";
	        int cnt = 0;
	        int loofCnt = 0;
	        for(int i=0; i<s.length(); i+=var) {
	        	loofCnt++;
	        	if(i == 0) {
	    			sub = s.substring(i, (i+var));
	        		cnt++;
	        		continue;
	        	}else if(loofCnt == s.length()/var) {
	        		if(s.substring(i, (i+var)).equals(sub)) {
						cnt++;
						if(cnt > 1) {
		        			rst += cnt + sub;	
		        		}else {
		        			rst += sub;
		        		}
					}else {
						if(cnt > 1) {
		        			rst += cnt + sub;
		        		}else {
		        			rst += sub;
		        		}
						rst += s.substring(i, (i+var));
					}
	        		
	        		if(s.length()%var != 0) {
	        			rst += s.substring((i+var), s.length());
	        			break;
	        		}
	        		
	    		}else if(s.substring(i, (i+var)).equals(sub)) {
	    			cnt++;
	    			continue;
	    		}else if(!s.substring(i, (i+var)).equals(sub)) {
	    			if(cnt > 1) {
	        			rst += cnt + sub;	
	        		}else {
	        			rst += sub;
	        		}
	    			
	    			sub = s.substring(i, (i+var));
	    			cnt = 1;
	    		}
	    		
	    	}
			if (var == 1) {
				answer = rst.length();
			}
			if (answer > rst.length()) {
				answer = rst.length();
			}
		}
		System.out.println(answer);
		 
        
		
		
        
	}
}
package level2;

public class SkCodingTest2 {

	static boolean lr = false;
	
	public static void main(String[] args) {
		
//		[
//		 [1,2,3,4,1],
//		 [4,5,6,5,2],
//		 [3,6,7,6,3],
//		 [2,5,6,5,4],
//		 [1,4,3,2,1]
//		]
//		 [1,2,3,4,5,1],
//		 [5,6,7,8,6,2],
//		 [4,8,9,9,7,3],
//		 [3,7,9,9,8,4],
//		 [2,6,8,7,6,5],
//		 [1,5,4,3,2,1]
//		]

		// 배열 변수
		// 회오리 방향 변수
		
		// 이중배열 변수
		// 반복 카운트 변수
		
		// 크기에 맞는 이중배열 생성		
		// 회오리 방향 설정 (0 : 좌 - ←,↓,→,↑  / 1 : 우 - →,↓,←,↑)
		// 진행 방향의 배열 값이 공백이면 이동 후 값 추가
		// - 이동하려는 방향의 배열 위치 + 스코프 범위가 배열 크기를 초과하면 회오리 방향 변경 후 이동 값 추가
		// - 이동하려는 방향의 배열 값이 존재한다면 회오리 방향 변경 스코프 추가 이동 기본 숫자 변경
		
	
		int[][] arrD = new int[5][5];
		int x = 0;
		int y = 0;
		
		int scX = 0;
		int scY = 0;
		
		
		int init = 1;
		int scope = 0;
		String dir = "";
		
		if(lr) {
			dir = "L";
		}else {
			dir = "R";
		}
		
		int rel = init;
		
		for (int i = 1; i <= 5 * 5; i++) {

			if(i == 1) {
				arrD[x][y] = 1;
				continue;
			}
			
			if (dir.equals("L") || dir.equals("R")) {
				
				if (y + movePoint(dir) == (arrD.length) - scope || y + movePoint(dir) == 0 + scope) {
					dir = direction(dir);
					rel = init;
					
				}else if(arrD[x][y + movePoint(dir)] != 0) {
					if (scX == x && scY == y + movePoint(dir)) {
						scope++;
						init = rel+1;
						dir = direction(dir);
						scX = (x + movePoint(dir));
						scY = y;
						
					}else {
						dir = direction(dir);	
					}
				}else {
					y = y + movePoint(dir);
					rel++;
				}
				
			} else if (dir.equals("U") || dir.equals("D")) {
				if (x + movePoint(dir) == (arrD.length) - scope || x + movePoint(dir) == 0 + scope) {
					dir = direction(dir);
					rel = init;
				}else if(arrD[x + movePoint(dir)][y] != 0) {
					if (scX == x + movePoint(dir) && scY == y) {
						scope++;
						init = rel+1;
						dir = direction(dir);
						scX = x;
						scY = (y + movePoint(dir));
					}else {
						dir = direction(dir);	
					}
					
				}else {
					x = x + movePoint(dir);
					rel++;
				}
			}
			
			arrD[x][y] = rel;
			System.out.println("x : " + x + " / y : " + y + " / rel : " + rel);
		}
		 
		
		
		
		/*
		 * for (int i = 1; i <= 5 * 5; i++) { System.out.println(i); if (i == 1) {
		 * arrD[0][0] = 1; rel++; continue; } if (dir.equals("L") || dir.equals("R")) {
		 * if (y + movePoint(dir) > (arrD.length-1) - scope || y + movePoint(dir) < 0 +
		 * scope && arrD[x][(y + movePoint(dir))] != 0) { dir = direction(dir); if (scX
		 * == x && scY == y) { scope++; init = rel; } } else if (y + movePoint(dir) >
		 * (arrD.length-1) - scope || y + movePoint(dir) < 0 + scope) { dir =
		 * direction(dir); y = y + movePoint(dir); } else { y = y + movePoint(dir); }
		 * 
		 * } else if (dir.equals("U") || dir.equals("D")) { if (x + movePoint(dir) >
		 * (arrD.length-1) - scope || x + movePoint(dir) < 0 + scope) { dir =
		 * direction(dir); x = x + movePoint(dir); } else if (arrD[(x +
		 * movePoint(dir))][y] != 0) { dir = direction(dir); scope++; init = rel; } else
		 * { x = x + movePoint(dir); } }
		 * 
		 * System.out.println("x : " + x + " / y : " + y);
		 * 
		 * if (rel == arrD.length - (scope + 1)) { rel = init; } else { rel++; }
		 * arrD[x][y] = rel;
		 * 
		 * // System.out.println("arrD["+x+"]["+y+"] = " + arrD[x][y]); }
		 */
		 
		
		for(int i=0; i<arrD.length; i++) {
			for(int j=0; j<arrD[0].length; j++ ) {
				System.out.print(arrD[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	public static String direction(String dir) {
		if(lr) {
			switch(dir) {
			case "L" : dir = "D";
				break;
			case "D" : dir = "R";
				break;
			case "R" : dir = "U";
				break;
			case "U" : dir = "L";
				break;
			}
		}else {
			switch(dir) {
			case "R" : dir = "D";
				break;
			case "D" : dir = "L";
				break;
			case "L" : dir = "U";
				break;
			case "U" : dir = "R";
				break;
			}
		}
		
		return dir;
	}
	
	public static int movePoint(String dir) {
		
		int point = 0;
		
		if(dir.equals("L")) {
			point = (-1);
		}else if(dir.equals("R")) {
			point = (+1);
		}else if(dir.equals("U")) {
			point = (-1);
		}else if(dir.equals("D")) {
			point = (+1);
		}
		
		return point;
	}

}

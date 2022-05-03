package level2;

import java.util.ArrayList;
import java.util.Collections;

public class MoreHot {
	
	static ArrayList<Integer> arr = new ArrayList<Integer>();
	int K = 0;
	public MoreHot(int[] scoville, int num) {
		this.K = num;
		
		for(int n : scoville) {
			arr.add(n);
		}
		
	}
	
	public static void removeValue() {
		arr.remove(0);
		
	}
	
	
	//int K;
	public static void main(String args[]) {
		// ���� ������ ���ں� ���� = ���� ���� ���� ������ ���ں� ���� + (�� ��°�� ���� ���� ������ ���ں� ���� * 2)
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int[] heap = {7, 6, 5, 8, 3, 5, 9, 1, 6};
		int num = 7;
		int number = 0;
		int answer = 0;
		
		
		MoreHot mh = new MoreHot(scoville, num);
		
		int mix = 0;
		
		while(arr.size() > 1) {
			number++;
			if(mix < mh.K) {
				int first = arr.get(0);
				removeValue();
				int second = arr.get(0);
				removeValue();
				
				System.out.println("first : " + first + " / second : " + second);
				mix = first + (second * 2);
				answer++;
				
				if(mix >= mh.K) {
					break;
				}else {
					arr.add(mix);
					orderByHeap();
				}
			}
		}
		
		System.out.print("���� �迭 ����2 : ");
		for (int j : arr) {
			
			System.out.print(j + "  ");
		}
		System.out.println("answer : " + answer  + " /  number : " + number);
		
	

		/*
		 * int mix = arr.get(0) + arr.get(1) * 2; answer++; if (mix >= K) { break; }
		 * else {
		 * 
		 * }
		 */
		 
		
		
		
	}
	
	public static void orderByHeap() {
		for(int i=1; i<arr.size(); i++) {
			int c = i;
			System.out.println("c [i��° �迭] : " + c);
			System.out.println("==============================");
			do {
				int root = (c - 1) / 2;
				System.out.println("root[�θ� ���] : " + root);
				System.out.println("------------------------------------------------------------");
				System.out.println("�θ��� - arr.get(root] : " + arr.get(root) + " / �ڽĳ�� - arr.get(c] : " + arr.get(c));
				if(arr.get(root) < arr.get(c)) {
					int temp = arr.get(root);
					arr.set(root, arr.get(c));
					arr.set(c, temp);
					System.out.println("�ڽ� ��尡 �θ� ��庸�� ũ�� �θ� ���� �ڽĳ���� ��ġ�� ����");
					System.out.println("�θ��� - arr.get(root) : " + arr.get(root) + " / �ڽĳ�� - arr.get(c) : " + arr.get(c));
				}
				c = root;
			} while(c != 0);
		}
		
		System.out.print("���� �迭 ���� : ");
		for(int j : arr) {
			
			System.out.print(j + "  ");
		}
		System.out.println("");
		
		for (int i = arr.size() - 1; i >= 0; i--) {
			System.out.println("--- i --- : " + i);
			System.out.println("���� ��   ---- root : " + arr.get(0) + " / leaf : " + arr.get(i));
			int temp = arr.get(0);
			arr.set(0, arr.get(i));
			arr.set(i, temp);
			System.out.println("���� ��   ---- root : " + arr.get(0) + " / leaf : " + arr.get(i));
			
			System.out.println("============================================================");
			int root = 0;
			int c = i;
			do {
				c = 2 * root + 1; // �ڽ� �߿� �� ū ���� ã��
				System.out.println("�ڽĳ�� c : " + c + " / ������ �迭 i : " + i);
				if (i <= 2) {
					
				}
				if (i > 2 && c < i && arr.get(c) < arr.get(c + 1)) {
					c++;
				} // ��Ʈ���� �ڽ��� �� ũ�ٸ� ��ȯ
				if (c < i && arr.get(root) < arr.get(c)) {
					System.out
					.println("��Ʈ���� �ڽ��� �� ũ�ٸ� ���� ��   ---- root : " + arr.get(root) + " / leaf : " + arr.get(c));
					int tmp = arr.get(root);
					arr.set(root, arr.get(c));
					arr.set(c, tmp);
					System.out
					.println("��Ʈ���� �ڽ��� �� ũ�ٸ� ���� ��   ---- root : " + arr.get(root) + " / leaf : " + arr.get(c));
				}
				root = c;
				System.out.println("root : " + root);
				System.out.println("--------------------------------------------------------");
			} while (c < i);
			
			System.out.print("���� �迭 ���� : ");
			for (int j : arr) {
				
				System.out.print(j + "  ");
			}
			System.out.println("");
		}
	}
	
	
}

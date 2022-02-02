package PermutationTest;

public class Permutation {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6}; //순열을 만들 배열 
		int n = arr.length; //배열의 길이 
		int[] output = new int[n]; //순열 출력을 위한 배열 
		boolean[] visited = new boolean[n]; 
		 
		
		System.out.println("-------- 1. Swap ---------");
		double beforeTime = System.currentTimeMillis();
		per1(arr, 0, n, 3);
		double afterTime = System.currentTimeMillis();
		double secDiffTime = (afterTime - beforeTime)*1000; 
		System.out.println("시간차이(m) : "+secDiffTime);

		System.out.println("\n-------- 2. DFS ---------");
		beforeTime = System.currentTimeMillis(); 
		per2(arr, output, visited, 0, n, 3); 
		afterTime = System.currentTimeMillis(); 
		secDiffTime = (afterTime - beforeTime)*1000;
		System.out.println("시간차이(m) : "+secDiffTime);
	}

	//1. Swap 함수를 이용해 구현 
	static void per1(int[] arr, int depth, int n, int r) {
		if(depth == r) {
			print(arr, r);
			return;
		}

		for(int i = depth; i < n; i++) {
			swap(arr, depth, i);
			per1(arr, depth + 1, n, r);
			swap(arr, depth, i);
		}
	}

	static void swap(int[] arr, int depth, int i) { 
		int temp = arr[depth];
		arr[depth] = arr[i];
		arr[i] = temp;
	}

	//2. DFS를 이용해 구현  
	static void per2(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
		if(depth == r) {
			print(output, r); 
			return;
		}

		for(int i = 0; i < n; i++) {
			if(visited[i] != true) {
				visited[i] = true;
				output[depth] = arr[i];
				per2(arr, output, visited, depth + 1, n, r);    
				visited[i] = false;
			}
		}
	}

	// 배열 출력
	static void print(int[] arr, int r) {
		for(int i = 0; i < r; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}
package bubble;

import java.util.Scanner;

public class bubble_Sort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N];

		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();

		
		 bubble_Sort_ASCE(arr); 
		 for(int j=0 ; j<N ; j++) 
			 System.out.print(arr[j] + " ");
		

		System.out.println();

		bubble_Sort_DESC(arr);
		for (int j = 0; j < N; j++)
			System.out.print(arr[j] + " ");
	}

	// 오름차순
	public static int[] bubble_Sort_ASCE(int[] arr) {
		int idx = 0;

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 1; j < arr.length - i; j++) {
				int save = arr[idx];
				if (save > arr[j]) {
					arr[idx] = arr[j];
					arr[j] = save;
				}
				idx++;
			}
			idx = 0;
		}
		return arr;
	}

	// 내림차순
	public static int[] bubble_Sort_DESC(int[] arr) {
		int idx = 0;

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 1; j < arr.length - i; j++) {
				int save = arr[idx];
				if (save < arr[j]) {
					arr[idx] = arr[j];
					arr[j] = save;
				}
				idx++;
			}
			idx = 0;
		}
		return arr;
	}
}
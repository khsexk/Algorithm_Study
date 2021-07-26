package _insertion_sort;
import java.util.*;

public class insertion_Sort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N];
				
		for(int i=0 ; i<N ; i++) 
			arr[i] = sc.nextInt();
		
		insertion_Sort_ASCE(arr);
		for(int j=0 ; j<N ; j++) 
			System.out.print(arr[j] + " ");
		
		System.out.println();
		
		insertion_Sort_DESC(arr);
		for(int j=0 ; j<N ; j++) 
			System.out.print(arr[j] + " ");
		
	}
	// 오름차순
	public static int[] insertion_Sort_ASCE(int[] arr) {
		for(int i=1 ; i<arr.length ; i++) {
				int index = i;
				int save = arr[i];
				
				for(int j=i-1 ; j>=0 ; j--){
					if(save<arr[j]) {
						arr[index] = arr[j]; 
						index--;
					}
				}
			arr[index] = save;	
		}
		return arr;
	} 
	// 내림차순
	public static int[] insertion_Sort_DESC(int[] arr) {
		for(int i=1 ; i<arr.length ; i++) {
				int index = i;
				int save = arr[i];
				
				for(int j=i-1 ; j>=0 ; j--){
					if(save>arr[j]) {
						arr[index] = arr[j]; 
						index--;
					}
				}
			arr[index] = save;	
		}
		return arr;
	}
}

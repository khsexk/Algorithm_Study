package _euclidean_algorithm;
import java.util.*;

public class euclidean_algorithm {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int l, s =0;
		
		if(a >= b) {
			l = a;
			s = b;
		} else {
			l = b;
			s = a;
		}
		int gcdNum = gcd(l, s);
			
		System.out.println("GCD = "+ gcdNum);
	}
	static int gcd(int l, int s){
		return (l%s == 0) ? s : gcd(s,l%s);
	}
}

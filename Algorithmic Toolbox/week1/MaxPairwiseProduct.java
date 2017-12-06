import java.util.Scanner;
import java.util.Arrays;

public class MaxPairwiseProduct {
	static private int n;
	static private long a[];

	public static long getMaxProduct() {
		Arrays.sort(a);
		return a[a.length - 1] * a[a.length - 2];
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new long[n];
		
		for(int i = 0;i < n;i++) {
			a[i] = sc.nextLong();
		}

		System.out.print(getMaxProduct());
	}
}
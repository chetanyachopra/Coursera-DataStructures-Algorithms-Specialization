import java.util.Scanner;
import java.util.Arrays;

public class Fibonacci {
    
    private static long calc_fib(int n) {
    	int a = 0, b = 1, c = 0;
    	if(n <= 1)return n;
    	for(int i = 2;i <=n;i++) {
    		c = a + b;
    		a = b;
    		b = c;
    	}
    	return (long)c;
    }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    
    System.out.println(calc_fib(n));
  }
}

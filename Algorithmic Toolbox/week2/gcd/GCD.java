import java.util.*;

public class GCD {
  private static int gcd_naive(int a, int b) {
      if(a == 0 || b == 0) return 0;
      if(a == 1 || b == 1)return 1;
      if(a == b) 
        return a;
      return (a > b) ? gcd_naive(a - b, b) : gcd_naive(a, b - a);
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(gcd_naive(a, b));
  }
}

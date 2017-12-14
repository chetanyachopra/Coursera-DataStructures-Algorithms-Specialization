import java.util.*;

public class LCM {

  private static long gcd(int a, int b) {
      if(a < 0 || b < 0)return 0;
      if(a == 0 || b == 0)
        return 0;
      
      if(a == 1 || b == 1)
        return 1;

      if(a == b)
        return  (long)a;

      return (a > b) ? gcd(a - b, b) : gcd(a, b - a);
  }
  private static long lcm_naive(int a, int b) {
    //System.out.println("a * b = " + (long)((long)a * (long)b));
    //System.out.println("div = " + (long)((long)((long)a * (long)b) / (long)gcd(a, b));
    //System.out.println("gcd a, b = " + gcd(a, b));
    long _gcd = gcd(a, b);
    if(_gcd == 0)return 0;
    return (a * b) / _gcd;
    //return a * b;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    System.out.println(a + " " + b);
    System.out.println(lcm_naive(a, b));
  }
}

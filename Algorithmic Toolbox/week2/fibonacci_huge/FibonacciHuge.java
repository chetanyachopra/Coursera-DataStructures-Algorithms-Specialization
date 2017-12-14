import java.util.*;

public class FibonacciHuge {

    private static long getPissanoPeriod(long m) {
        long a = 0, b = 1, c = a + b;
        for(int i = 0;i < m * m; i++) {
            c = (a + b) % m;
            a = b;
            b = c;
            if(a == 0 && b == 1) return i + 1;
        }
        return 0;
    }

    private static long getFibonacciHugeNaive(long n, long m) {
       long rem = n % getPissanoPeriod(m);

       long a = 0, b = 1, c;

       long res = rem;
       for(int i = 1;i < rem;i++) {
            res = (a + b) % m;
            a = b;
            b = res;
       }
       return res % m;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeNaive(n, m));
    }
}


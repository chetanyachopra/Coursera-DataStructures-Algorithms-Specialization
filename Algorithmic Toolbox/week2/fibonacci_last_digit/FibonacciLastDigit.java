import java.util.*;

public class FibonacciLastDigit {
    
    private static int getFibonacciLastDigitNaive(int n) {
        if(n <= 1)  
            return n;

        int previous = 0;
        int current  = 1;
        int tmp_previous;
        for (int i = 2; i <= n; ++i) {
            tmp_previous = previous % 10;
            tmp_previous %= 10;
            previous = current % 10;
            previous %= 10;
            current = tmp_previous + current;
            current %= 10;
           // System.out.println(i + " = " + current);
        }

        return current;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        int c = getFibonacciLastDigitNaive(n);
        System.out.println(c);
    }
}


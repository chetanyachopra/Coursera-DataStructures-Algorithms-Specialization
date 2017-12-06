import java.util.Scanner;

public class APlusB {
	private int a, b;

	APlusB() {
		a = 0;
		b = 0;
	}

	private int add(int a, int b) {
		return a + b;
	}

	public int add() {
		return add(this.a, this.b);
	}

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    APlusB ob = new APlusB();
    ob.a = sc.nextInt();
    ob.b = sc.nextInt();
    System.out.print(ob.add());
  }
}
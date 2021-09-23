import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args){
        int a = 0, b = 1, c = 1;
        Scanner s = new Scanner(System.in);

        System.out.println("How many fibonacci numbers");
        int n= s.nextInt();

        System.out.println("Fibonacci Series:");
        for(int i=1; i <=n; i++){
            System.out.println(c);
            c = a + b;
            a = b;
            b = c;
        }
    }
}

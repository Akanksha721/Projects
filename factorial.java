import java.util.Scanner;

public class factorial {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n, fact = 1;
        System.out.println("Enter a number");
        n = s.nextInt();

        for(int i =1; i <= n; i++){
            fact = fact * i;
        }
        System.out.println("Factorial =" +fact);
    }
}

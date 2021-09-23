import java.util.Scanner;

public class reverse {
    public static void main(String[] args){
        int num,rev = 0, temp;
        Scanner s = new Scanner(System.in);

        System.out.println("Enter a number");
        num= s.nextInt();

        while(num!= 0){
            temp = num % 10;
            rev = rev *10 +temp;
            num = num / 10;
        }
        System.out.println("Reverse= " + rev);
    }
}

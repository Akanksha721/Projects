import java.util.Scanner;

public class Array {
    public static void main(String[] args){
        int sum = 0;
        int arr[] = new int[5]; //creating array

        /*arr[0]= 5;
        arr[1]= 4;
        arr[2]= 3;
        arr[3]= 2;
        arr[4]= 1;
        */
        System.out.println("Enter numbers");
        Scanner s = new Scanner(System.in);
        for(int i= 0; i < 5 ; i++){
            arr[i]= s.nextInt();
        }

        for(int i =0; i < arr.length; i++) {

            System.out.println(arr[i]);

            sum += arr[i];


        }
        System.out.println(sum);
    }
}

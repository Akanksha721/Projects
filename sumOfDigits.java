public class sumOfDigits {
    public static void sumofdigits(int n){
        int sum = 0;
        while( n >= 1){
            sum += n % 10;
            n = n / 10;
        }
        System.out.println(sum);

    }

    public static void main(String[] args){
        sumofdigits(97985);


    }
}


import java.util.Scanner;

public class Task4c {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int ans = 0;

        //---------------write your code BELOW this line only!--------------
        // program that generate random number in range of 2 until n-1
        int n = scanner.nextInt();
        ans = (int)(2+(Math.random()*(n-2)));
        //---------------write your code ABOVE this line only!--------------

        System.out.println(ans);
		scanner.close();
    }
}

import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int ans = 0;

        //---------------write your code BELOW this line only!--------------
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int range = b-a +1; // creating the number that will represent the range
        // Math.random() will generate double number between 0-1 not include 1
        // Math.random()*range will generate double number between 0-range number not include
        ans = (int)(Math.random()*range)+a;
        //---------------write your code ABOVE this line only!--------------
        System.out.println(ans);
		scanner.close();
    }
}
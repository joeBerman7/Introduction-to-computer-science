
import java.util.Scanner;

public class Task4a {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean ans = true;

        //---------------write your code BELOW this line only!--------------
		// program that check if our number n is prime
        int n = scanner.nextInt();
		for (int p=2; p*p<=n & ans ; p++) {
			if(n%p==0)
				ans = false;	
		}
        //---------------write your code ABOVE this line only!--------------
 
        System.out.println(ans);
		scanner.close();
    }
} 
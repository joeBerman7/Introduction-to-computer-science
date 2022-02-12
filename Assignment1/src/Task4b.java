
import java.util.Scanner;

public class Task4b {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int ans = 0;

        //---------------write your code BELOW this line only!--------------
        // program that count the amount of prime numbers until our given number include him.
        int n = scanner.nextInt();
        int counter = 2; // 2 is our first prime number

        while (counter <= n) {
            int p = 2;
            boolean isPrime = true;
            
            // to create more efficient code we can check p*p <= counter like we saw in the class
            while (p*p <= counter & isPrime) {
                if (counter % p == 0) 
                    isPrime = false;
                p++;
            }
            
            if (isPrime)
                ans++;
            
            counter++;
        } 
        //---------------write your code ABOVE this line only!--------------

        System.out.println(ans);    
		scanner.close();    
    }
}
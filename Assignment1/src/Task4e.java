
import java.util.Scanner;

public class Task4e {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean ans1 = true;
        int ans2 = 0;

        //---------------write your code BELOW this line only!--------------
        // Program that gets 4 inputs integer numbers, one of them is n that is odd, and checked with help of other variables if n is prime. 
        // if n is prime the output is true and -1 (-1 represent no such answer exists)
        // else n is not prime, the out put is false and b as witness for that
        
        int n = scanner.nextInt();
        int b = scanner.nextInt();
        int s = scanner.nextInt();
        int d = scanner.nextInt();
        
        // during this task i will create with my n,b,s,d variables new more complicated variables.
        int BpowD = 1; // Initialized BpowD as 1 and then as b^d 
        int twoPowI = 1; // Initialized twoPowI as 1 and then twoPowI 2^i 

        // first i create the object that will be checked in the first condition 
        for (int i = 1; i <= d; i++) {
            BpowD = ((BpowD%n)*(b%n))%n; // reminder formula from 3.b that help us working with reminder in big numbers
        }
 
        // first condition check
        if (!(BpowD == 1)) {
            ans1 = false;
        }
        
        // second condition check 
        for (int i = 0; i <= s-1 & !ans1; i++) {
        	// x = BpowD, y = twoPowI, and i'm working with x^y
            if (BpowD == (n-1)) {
                ans1 = true;
                ans2 = -1;
            }
            // i will check the condition for BpowD twoPowI times
            twoPowI = twoPowI*2; // depends on i
            BpowD = ((BpowD%n)*(BpowD%n))%n; // reminder formula from 3.b that help us working with reminder in big numbers
        }
        
        // if our answer is false we attach our ans2 to b our witness
        if (!ans1) {
            ans2 = b; 
        }
        //---------------write your code ABOVE this line only!--------------

        System.out.println(ans1);
        System.out.println(ans2);
		scanner.close();
    }
}
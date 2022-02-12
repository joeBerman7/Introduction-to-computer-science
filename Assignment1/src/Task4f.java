
import java.util.Scanner;

public class Task4f {

    public static void main(String[] args) {
        
		Scanner scanner = new Scanner(System.in);
        boolean ans = true;

        //---------------write your code BELOW this line only!--------------
        // program related to 4.e program, this time the program will check if n is prime with random b maximum k times.
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int d = scanner.nextInt();
        int k = scanner.nextInt();

        int counter =1; 
        while((counter<k) & ans) {
        	
        	int b =(int)(2+(Math.random()*(n-2))); 
            int BpowD = 1;
            int twoPowI = 1; 
 
            for (int i = 1; i <= d; i++) {
                BpowD = ((BpowD%n)*(b%n))%n; 
            }

            if (!(BpowD == 1)) {
                ans = false;
            }
            
            for (int i = 0; i <= s - 1 & !ans; i++) {
                if (BpowD == (n-1)) {
                    ans = true;
                }
                twoPowI = twoPowI * 2;
                BpowD = ((BpowD%n)*(BpowD%n))%n;
            }

        	counter++;
        }
        //---------------write your code ABOVE this line only!--------------

        System.out.println(ans);
		scanner.close();
    }
}
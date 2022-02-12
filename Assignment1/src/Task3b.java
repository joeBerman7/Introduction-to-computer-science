
import java.util.Scanner;


public class Task3b {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int ans = 0;

        //---------------write your code BELOW this line only!--------------
        // program that calculate the reminder of (2^n)%k
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        // we will use our solution from 3.a with small changes
        ans =1;
        for(int i=1;(i<=n) & (n>=0);i++) {
        	if (n==0)
        		ans =1;
        	else {
        		// this method working with reminders will allow us work with big numbers
        		// by the example of 3.b EXR (a*b)%k=((a%k)*(b%k))%k
        		// this case i took a = 2^n and b = 2
        		ans =((ans%k)*(2%k))%k;	
        	}
        }
        //---------------write your code ABOVE this line only!--------------

        System.out.println(ans);
		scanner.close();
    }
}
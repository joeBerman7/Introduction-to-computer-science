
import java.util.Scanner;

public class Task3a {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int ans = 0;

        //---------------write your code BELOW this line only!--------------
        // Program that calculate 2^n
        int n = scanner.nextInt();
        ans = 1;
        for(int i=1;(i<=n) & (n>=0 & n<=31);i++) {
        	if (n==0) 
        		ans =1;
        	else 
        		ans =ans*2;	
        } 
        //---------------write your code ABOVE this line only!--------------
        System.out.println(ans);
		scanner.close();
    }
}
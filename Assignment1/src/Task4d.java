
import java.util.Scanner;

public class Task4d {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int ans1 = 0;
        int ans2 = 0;

        //---------------write your code BELOW this line only!--------------
        // program that will calculate power s and d by given n odd number
        int n= scanner.nextInt(); // not even input number
        int m= n-1; // our even number
        int s =1; // counter for the power (s>0)
        int isEven=m/2; // finally will represent our d

        // if isEven is divided by two its not our d we looking for 
        // each division we will increase our s
        // and finally we should find our not divided isEven that will be our d
        
        while(isEven%2==0) {
        	isEven=isEven/2;
        	s++;
        }
        
        ans1 =s;
        ans2 = isEven;
        //---------------write your code ABOVE this line only!--------------

        System.out.println(ans1);
        System.out.println(ans2);
		scanner.close(); 
    }
}
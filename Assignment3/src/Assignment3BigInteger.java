import java.util.Random;
import java.math.BigInteger;

class Assignment3BigInteger{

    public static BigInteger sumSmaller(BigInteger n){
        BigInteger sum =  new BigInteger("0"); //creating a new BigInteger object value 0
        // n.intValue() is BigInteger method that gets a integer value from a BigInteger variable
        if(n.intValue()<0)
        	sum=BigInteger.ZERO;
        else {
        	for(int i =0;i<n.intValue();i++) { 
        		sum = sum.add(BigInteger.valueOf(i)); //BigInteger.valueOf(i) getting a long value of i and "add" is summing sum with i every time in the loop
        	}
        }
        return sum;
    }

    public static void printRandoms(int n){
        Random random = new Random(); // creating new random object
        for(int i = 0;i<n;i++) {
        	System.out.println(random.nextInt()); // nextInt() generating for us random numbers all 2^32 possible int values
        }
    }

    public static boolean isPrime(BigInteger n){
        boolean ans= true;
        
        // initializing our BigInteger objects that will help us to decide if number is prime 
        BigInteger divisor = new BigInteger("2");
        
        if(n.intValue()==0 | n.intValue()==1) // disable 0,1 from crashing the program because they are not prime
        	ans=false;
        else {
			while (divisor.multiply(divisor).intValue() <= n.intValue() & ans) { //Loop optimization with (divisor.multiply(divisor) 
				if (n.mod(divisor).equals(BigInteger.ZERO)) // if our n%divisor ==0 then is not a prime number.
					ans = false; 
				divisor = divisor.add(new BigInteger("1")); // increasing our divisor by 1.
			} // while		
		} 
		return ans; 
    }

    public static BigInteger randomPrime(int n){
        BigInteger randBig = new BigInteger("0");
        BigInteger two = new BigInteger("2"); //will help us to generate 2 pow n
        
        Random rand = new Random(); //instance of random class
        int upperbound = two.pow(n).intValue(); // creating our upper condition 2 pow n
        int int_random = rand.nextInt(upperbound) +2; // Initialising our int random value.
        
        while(!(isPrime(BigInteger.valueOf(int_random)) && int_random<upperbound)) {//i use my previous function isPrime to only generate random prime numbers.
        	int_random = rand.nextInt(upperbound);
        }
        
        randBig =BigInteger.valueOf(int_random); // converting our answer to BigInteger object.
        
        return randBig;
    }

}
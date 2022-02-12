public class BitVector {
    private Bit[] bits;
    
    public BitVector(String s) {
        
        if(!NumericalString.legalNumericString(s, 2)) 
        	throw new IllegalArgumentException("put ligal input"); 
        
        bits =new Bit[s.length()]; // initialize our bits array.
        for(int i =0;i<s.length();i++) {
        	if(s.charAt(i)-'0'==0) 
        	     // if the given char in the string is 0 we will put in our array in that place Bit object false.
        		 bits[i]=new Bit(false);
        	else
        	    // else the given char in the string is 1 we will put in our array in that place Bit object true.
        		bits[i]=new Bit(true);
        }
    }

    public String toString() {
        String ans;
  
        int value = 0, power = 1; // our help variables to create a power resulst
        for (int i = 0; i <bits.length; i = i + 1) {
            // converting our binary string to int and converting again to decimal number
            value = value + bits[i].toInt() * power; 
            power = power * 2;
        }

        ans = String.valueOf(value); // converting back again our value to string.
        return ans;
    }

}

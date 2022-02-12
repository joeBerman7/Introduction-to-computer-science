public class NumericalString {
    
    //////////////////////// Help functions ////////////////////////////////////
    
    // help function for task 3.2
	public static String decimalIncrementRec(String s,int carry, int inc) {
	  	String ans = "";

    	if(s.length()>0) { // our base case
	    	if((s.charAt(0)-'0') == 9) { // case we have letter equal to 9
	    		ans= ans +(inc+ carry + (s.charAt(0)-'0'))%10 ; // first time carry = 0, inc = 1. 
	    		if((inc+ carry + (s.charAt(0)-'0')) >= 10) // checking if we need to change carry to 1
	    			carry=1;
	    		ans = ans + decimalIncrementRec(s.substring(1),carry,0); // calling our function without the first letter	
	    	}
	    	else { // the letter we checking is less than 9
	    		// it possible that we will got a inc 0 and carry 1 so for the next time we want to initialized the carry back to 0 again. 
	    		ans =ans  + ((s.charAt(0)-'0') + inc + carry); 
	    		carry=0; // Initialize carry to 0 
	    		ans = ans + decimalIncrementRec(s.substring(1),carry,0); // calling our function without the first letter
	    	}	
    	}
    	
    	
    	if(s.length() == 0 & carry ==1) // in the case we finish and we got a carry we will add it to ans
    		ans = ans +'1';

		return ans;	
	}
	
	// help function for task 3.3
	public static String decimalDoubleRecursion(String s, int carry) {
    	String ans = "";

    	if(s.length()>0) { // our base case 
    	    // first time carry = 0, and we want to see if condition is bigger of 9 to increase carry to 1.
	    	if((s.charAt(0)-'0')*2 + carry > 9) {
	    		ans= ans +(carry + (((s.charAt(0)-'0')*2)-10)) ;
	    		carry=1;
	    		ans = ans + decimalDoubleRecursion(s.substring(1),carry); // calling our function without the first letter
	    		
	    	}
	    	else { // (s.charAt(0)-'0')*2 + carry <=9, our first letter is less than 5
	    		int sum = (carry + ( (s.charAt(0)-'0')*2)); // holding our value with our carry that could be 1/0 and then initialize him to 0
	    		carry=0;
	    		ans = ans + sum +  decimalDoubleRecursion(s.substring(1),carry); // calling our function without the first letter
	    	}	
    	}
    	
    	if(s.length() == 0 & carry ==1) // in the case we finish and we got a carry we will add it to ans.
    		ans = ans +'1';

		return ans; 
    }
    
    
    // help function for task 3.4
    public static String binary2DecimalRec(String s,String ans) {
        /* the algorithm:
    	 * ans initialize to "0" 
    	 * (ans*2) + s.charAt(s.length()-1 (last letter in the string)
    	 * call the function with substring without the last letter
    	 * multiply and adding using my builded functions. */
    	 
    	if(s.length()>0 &&(s.charAt(s.length()-1) -'0'==1)) { // first case the last letter is 1
    		ans = decimalDouble(ans); // for the first time 1*2
	    	ans = decimalIncrement(ans); // for the first time 2+1 =3 
	    	ans = binary2DecimalRec(s.substring(0,s.length()-1),ans); // calling our function without the last letter and now ans is 3 for the first time in the case
    	}
    	else if(s.length()>0 &&(s.charAt(s.length()-1) -'0'==0)) { // first case the last letter is 0
	    	ans =decimalDouble(ans); // for the first time 0*2
	    	ans = binary2DecimalRec(s.substring(0,s.length()-1),ans); // calling our function without the last letter and now ans is 0 for the first time in the case
    	}
        //each call for recursive function the function will update the ans to the value from the last time operations, until we stop calling the function.
        return ans;
    }
    
    ////////////////////////////////////////////////////////////////////////////

    
    public static boolean legalNumericString(String s, int b) {
        boolean ans = true; 
	        
        if((s == null ) || (b<2 |b>10))
            // there will be throw exception if the given numbers not in the base we check.
	        throw new IllegalArgumentException("put ligal input");
	       
        for(int i=0;i<s.length() & ans;i++) {
            // The ASCII table is arranged so that the value of the character 'b' is b greater than the value of '0'
	        // So we can get the int value of a decimal digit char by subtracting '0'.
	       	if(s.charAt(i)-'0'>b) 
	       		ans=false;
	   		}

	   return ans;
    }

    public static String decimalIncrement(String s) {
        return 
        	decimalIncrementRec(s,0,1); // calling my help function 3.2
    }

    public static String decimalDouble(String s) {
        return 
        	decimalDoubleRecursion(s,0); // calling my help function 3.3
    }

    public static String binary2Decimal(String s) {
        if(!(legalNumericString(s, 2))) // if the given string cointain letters not in the given base there will be an exception.
        	throw new IllegalArgumentException("put ligal input");

        return 
        	binary2DecimalRec(s,"0"); // calling my help function 3.4
    }

    public static void main(String[] args) {
        System.out.println("Good Luck! :)");
    }
}

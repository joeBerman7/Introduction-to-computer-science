/*
I, <name> (<ID>), assert that the work I submitted is entirely my own.
I have not received any part from any other student in the class,
nor did I give parts of it for use to others.
I realize that if my work is found to contain code that is not originally my own,
 a formal case will be opened against me with the BGU disciplinary committee.
*/

import java.util.Iterator;


public class BinaryNumber implements Comparable<BinaryNumber>{
    private static final BinaryNumber ZERO = new BinaryNumber(0);
    private static final BinaryNumber ONE  = new BinaryNumber(1);
    private BitList bits;

    // Copy constructor
    //Do not chainge this constructor
    public BinaryNumber(BinaryNumber number) {
        bits = new BitList(number.bits);
    }

    //Do not chainge this constructor
    private BinaryNumber(int i) {
        bits = new BitList();
        bits.addFirst(Bit.ZERO);
        if (i == 1)
            bits.addFirst(Bit.ONE);
        else if (i != 0)
            throw new IllegalArgumentException("This Constructor may only get either zero or one.");
    }

    //Do not chainge this method
    public int length() {
        return bits.size();
        
    }

    //Do not change this method
    public boolean isLegal() {
        return bits.isNumber() & bits.isReduced();
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.1 ================================================
    // i got help on this task from the weekly tigbur
    public BinaryNumber(char c) {
    	// this constructor build a binaryNumber object made of 1/0 and equal to given char to the constructor
        if(c<'0' | c>'9')
    		throw new IllegalArgumentException(c+ " is not a valid digit"); 
    	
    	int cValue = c-'0';
    	bits = new BitList(); 
    	while(cValue>0) {
    		int digit = cValue%2;
    		bits.addLast(new Bit(digit));
    		cValue = cValue/2;
    	}
    	bits.addLast(Bit.ZERO); 
    } 

  //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.2 ================================================
    public String toString() {
        // Do not remove or change the next two lines
        if (!isLegal()) // Do not change this line
            throw new RuntimeException("I am illegal.");// Do not change this line
        
        //this method override Object toString method.
        //this method takes binaryNumber object and convert him to string 
        String ans ="";
        Iterator<Bit> iterA= bits.iterator(); // we will iterate our list elements and adding adding then to string that we will return
        while(iterA.hasNext()) {
        	ans = iterA.next() + ans;
        }

        return ans;
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.3 ================================================
    public boolean equals(Object other) {
    	//this method override Object equals method.
    	//this method takes 2 binaryNumbers objects and comparing between them.
        boolean ans = false;
    	
        //Because binaryNumber has bits field we can reach to string of bits, and we use it to converting our binary number to string.
        // after to converting to string we use String method of equals to compare between the elements.
    	if(other instanceof BinaryNumber)
    		ans = bits.toString().equals(((BinaryNumber)other).bits.toString());

        return ans;  
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.4 ================================================
    public BinaryNumber add(BinaryNumber addMe) {
    	// program that adding the given number with this number.
    	//first of all check if the given value is legal
    	if(!(addMe.isLegal()))
    		throw new IllegalArgumentException("put ligal input"); 
    	
    	// Initialize my answer variable
    	BinaryNumber ans = new BinaryNumber('0');
		ans.bits.clear();
    	
    	BinaryNumber firstNum = this; // the number that we will be adding to

    	//padding the numbers that the sum operation will be done properly
    	if (firstNum.length()>addMe.length())
    		addMe.bits.padding(firstNum.length());
    	else
    		firstNum.bits.padding(addMe.length());

    	// creating our iterators that we will work with
    	Iterator<Bit> iterFirstNum= firstNum.bits.iterator(); 
    	Iterator<Bit> iteraddMe= addMe.bits.iterator(); 
    	
    	// Initialize my bits i will be use for calculation
    	Bit sum = Bit.ZERO; 
    	Bit carry = Bit.ZERO;
    	Bit firstNumNextBit;
    	Bit addMeNextBit;
    	
    	//we will be separate between to cases
    	
    	// first case the both numbers has different signs and that case we will be not add carry in the end.
    	if(!(firstNum.bits.getLast().equals(addMe.bits.getLast()))){
    		while(iterFirstNum.hasNext() & iteraddMe.hasNext()) {
    			firstNumNextBit = iterFirstNum.next();
    			addMeNextBit = iteraddMe.next();
    			sum = Bit.fullAdderSum(firstNumNextBit, addMeNextBit, carry); // calculating the sum with our fullAdderSum function that was created in Bit class
    			carry = Bit.fullAdderCarry(firstNumNextBit, addMeNextBit, carry); // calculating the carry with our fullAdderCarry function that was created in Bit class
    			ans.bits.addLast(sum); // adding the bits to my ans
    		}
    		
    	}else { // second case the numbers has the same signs and that case we will be add carry in the end.
    		while(iterFirstNum.hasNext() & iteraddMe.hasNext()) {
    			firstNumNextBit = iterFirstNum.next();
    			addMeNextBit = iteraddMe.next();
    			sum = Bit.fullAdderSum(firstNumNextBit, addMeNextBit, carry); // calculating the sum with our fullAdderSum function that was created in Bit class
    			carry = Bit.fullAdderCarry(firstNumNextBit, addMeNextBit, carry); // calculating the carry with our fullAdderCarry function that was created in Bit class
    			ans.bits.addLast(sum); // adding the bits to my ans
    		}
    		ans.bits.addLast(carry); // adding the final carry
	
    	}
    	
    	// for the legal answers we will reduce the objects we work with
    	ans.bits.reduce();
    	addMe.bits.reduce();
    	bits.reduce();
    	return ans;
	
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.5 ================================================
    public BinaryNumber negate() {
    	// program that converting positive number to negative number by complement 2 method in binary number.
    	
        BinaryNumber ans = new BinaryNumber('0'); // Initialize our answer
    	ans.bits.removeFirst(); // clear the number to work with
    	
    	BinaryNumber myAns = this; // creating this binary number the we will negate
    	ans.bits= myAns.bits.complement(); // first of all we opposite the numbers by complement 1 method
    	ans=ans.add(new BinaryNumber('1')); // than we will add one to number to be represent in complement 2 way.
    	
    	return ans;
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.6 ================================================
    public BinaryNumber subtract(BinaryNumber subtractMe) {
    	// program that subtracting between two binary numbers that it equal to add the negative show of subtracting number
   	    if(!(subtractMe.isLegal()))
			throw new IllegalArgumentException("put ligal input"); 

    	BinaryNumber ans;
    	subtractMe= subtractMe.negate();
    	ans=this.add(subtractMe);
    	
    	return ans;
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.7 ================================================
    public int signum() {
    	// program the return int value base on the sign of the binaryNumber
        int ans;
        
        if(this.bits.size() ==1 & this.bits.getLast().equals(Bit.ZERO)) // 0
        	ans=0;
        else if(this.bits.getLast().equals(Bit.ZERO)) //Positive number
        	ans=1;
        else 
        	ans=-1; // negative number

        return ans;
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.8 ================================================
    public int compareTo(BinaryNumber other) {
    	// program the comparing between to binary numbers and return int value based on the binary numbers values.
        if(!(other instanceof BinaryNumber))
			throw new IllegalArgumentException("put ligal input"); 
    	
        int ans=0;
        boolean isBigger = true;
        
        // padding the numbers that we will able to compare to
        if(this.length()>other.length())
        	other.bits.padding(this.length());
        else
        	this.bits.padding(other.length());
        
        int len = other.length()-2; // will help us to compare more precise between the objects.
        
        if(this.bits.getLast().toInt() < other.bits.getLast().toInt()) // first is positive and the second is negative so the first is bigger.
        	ans=1;
        else if(this.bits.getLast().toInt() > other.bits.getLast().toInt())	// second is negative and the second is positive so the second is bigger.
        	ans =-1;
        else {
        	// running on the element of the objects and comparing between them
        	 for(int i=len;i>=0 & isBigger;i--) {
             	if(this.bits.get(i).toInt() > other.bits.get(i).toInt()) {
             		ans =1;
             		isBigger=false;
             	}
             	else if(this.bits.get(i).toInt() < other.bits.get(i).toInt()) {
             		ans =-1;
             		isBigger=false;
             	}
             }
        }
        return ans;
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.9 ================================================
    public int toInt() {
        // Do not remove or change the next two lines
        if (!isLegal()) // Do not change this line
            throw new RuntimeException("I am illegal.");// Do not change this line

        // program that returns int value of the binary number.
        int value = 0;
        int power = 1;
        
        if(length()>31) // because we return int value it should be less the max value an bigger than min value
        	throw new RuntimeException("way big number");
        else {
		    while(length()>0 & length()<31) { 
		    	if(this.bits.size()==1 && this.bits.getFirst().equals(Bit.ONE)) {
	       			value = value - ((this.bits.getFirst().toInt()* power));
	       		}
		    	else {
		    		value = value + this.bits.getFirst().toInt()* power;
			    	power = power *2;
		    	}
		    	this.bits.removeFirst();
		    }
        }
        return value;
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.10 ================================================
    // Do not change this method
    public BinaryNumber multiply(BinaryNumber multiplyMe) {
    	BinaryNumber ans; // Initializing my answer
    	
    	// we will use our private method of multiplyPositive to multiply.
    	//Separate the multiply function to cases of positive/negative.
    	if(this.signum() == 1 & multiplyMe.signum() == 1)
    		ans = this.multiplyPositive(multiplyMe);
    	else if(this.signum() == -1 & multiplyMe.signum()==1) 
    		ans = (this.negate().multiplyPositive(multiplyMe)).negate();
    	else if(this.signum() == 1 & multiplyMe.signum()==-1) 
    		ans = (this.multiplyPositive(multiplyMe.negate())).negate();
    	else if(this.signum() == 0 | multiplyMe.signum()==0) 
    		ans = new BinaryNumber('0');
    	else
    		ans = (this.negate()).multiplyPositive(multiplyMe.negate());
    	
    	return ans;
    }

    private BinaryNumber multiplyPositive(BinaryNumber multiplyMe) {
    	
        return 
        	multiplyPositive(this,multiplyMe,new BinaryNumber('0'));
    }
    
    //help function task 3.10
    public BinaryNumber multiplyPositive(BinaryNumber times,BinaryNumber multiplyMe,BinaryNumber sum) {
    	// recursive program the calculate the multiplication between two positive numbers.
    	// we will try to optimize the program to calculate more even numbers and reduce the calls for the recursion
     	if(multiplyMe.equals(ONE)) // our base case the recursion will stop
    		sum=times;
    	else { 
    			// first case the even multiplyme number
	    		if(multiplyMe.bits.getFirst().toInt() ==0) {
	    		BinaryNumber temp = multiplyPositive(times, multiplyMe.divideBy2(), sum);
	    		sum= temp.multiplyBy2();
	    	}
	    	else // second case the odd multiplyme number
	    		sum = times.add(multiplyPositive(times,multiplyMe.subtract(ONE),sum));  
	    		
    	} 
    	return sum;
    	
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.11 ================================================
    // Do not change this method
    public BinaryNumber divide(BinaryNumber divisor) {
    	// Do not remove or change the next two lines
    	if (divisor.equals(ZERO)) // Do not change this line
            throw new RuntimeException("Cannot divide by zero."); // Do not change this line
    	//
    	// Do not remove or change the next two lines
    	if (divisor.equals(ZERO)) // Do not change this line
            throw new RuntimeException("Cannot divide by zero."); // Do not change this line
    	
    	//separating my divisions cases
    	BinaryNumber ans;
    	if(this.signum() == 1 & divisor.signum()==1)
    		ans = this.dividePositive(divisor);
    	else if(this.signum() == -1 & divisor.signum()==1) 
    		ans = this.negate().dividePositive(divisor).negate();
    	else if(this.signum() == 1 & divisor.signum()==-1) 
    		ans = (this.dividePositive(divisor.negate())).negate();
    	else if(this.signum() == 0) 
    		ans = new BinaryNumber('0');	
    	else
    		ans = (this.negate()).dividePositive(divisor.negate());
    	
    	return ans; 
    }

    private BinaryNumber dividePositive(BinaryNumber divisor) {
    	//program that calculate the devision between two positive numbers
    	// for correct answer we need to consider the remains. so i create a additional program that calculate the remains.
        BinaryNumber reminder = reminder(this, divisor, ZERO, ONE);
    	reminder = dividePositive(reminder, divisor,ONE);
    	
    	return
        	dividePositive(this, divisor,ONE).add(reminder); 
    }
    
    //help function 3.11
    public BinaryNumber dividePositive(BinaryNumber mone,BinaryNumber divisor,BinaryNumber sum) {
    	// recursive program that calculate the division between two binary numbers. 
    	
    	if(mone.compareTo(divisor)==-1) // base case the recursion will stop
    		sum=sum.divideBy2();

    	else 
    		sum= dividePositive(mone.divideBy2(),divisor,sum.multiplyBy2());

    	return sum;	 
    }
    // help function 2 for 3.11
    public static BinaryNumber reminder (BinaryNumber mone, BinaryNumber mechane, BinaryNumber remindersSum, BinaryNumber step) {
    	 // recursive program that calculating the reminders.   
    	mechane.bits.reduce();
    	mone.bits.reduce();
    	
    	if(mone.compareTo(mechane)==-1 ) {
	   		mone= mone.multiplyBy2();
	   		step=step.divideBy2();	
	   		remindersSum=remindersSum.add(step.multiply(mone.subtract(mechane)));	    		
	    }
    	
    	// the given mone is even
	   	else if(mone.bits.getFirst().equals(Bit.ZERO)) 
	   		remindersSum=reminder(mone.divideBy2(), mechane, remindersSum, step.multiplyBy2());
    	
    	else // the given mone is odd
    		remindersSum=reminder(mone.divideBy2(), mechane, remindersSum.add(ONE.multiply(step)), step.multiplyBy2());

    	return remindersSum;
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.12 ================================================
    public BinaryNumber(String s) {
    	// program that construct the binary number by given String
    	BinaryNumber five = new BinaryNumber('5');
    	BinaryNumber ten = five.multiplyBy2();
    	BinaryNumber one = new BinaryNumber('1');
    	BinaryNumber ans =  new BinaryNumber('0'); 

    	
    	if(s.charAt(0) =='-') { // negative string number
			String str = s.substring(1);
    		
			for(int i=str.length()-1;i>=0;i--) {
				BinaryNumber temp = new BinaryNumber(str.charAt(i));
				ans=ans.add(temp.multiply(one));
				one=one.multiply(ten);	
			}
    		
			ans = ans.negate();    
			bits=ans.bits;
    	}
    	else { // positive string number
    		for(int i=s.length()-1;i>=0;i--) {
				BinaryNumber temp = new BinaryNumber(s.charAt(i)); 
				ans=ans.add(temp.multiply(one));
				one=one.multiply(ten);
			}
    		bits=ans.bits;
    	}
    	
    }
    
    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.13 ================================================
    public String toIntString() {
        // Do not remove or change the next two lines
        if (!isLegal()) // Do not change this line
            throw new RuntimeException("I am illegal.");// Do not change this line
        
        String myAns = "";
    	String myFinalAns = "";

        if(this.signum()==-1) {
        	BinaryNumber negNumber = this.negate();
        	String s = negNumber.bits.toString();
        	s=s.substring(1,s.length()-1);

        	for(int i =s.length()-1;i>=0;i--) {
        		myAns = myAns+s.charAt(i);
        	}
        	
        	myAns = binary2Decimal(myAns);
        	
        	for(int i =myAns.length()-1;i>=0;i--) {
        		myFinalAns = myFinalAns+myAns.charAt(i);
        	}
        	myFinalAns= "-" + myFinalAns;
	
        }
        else {
        	//BinaryNumber negNumber = this.negate();
        	String s = this.bits.toString();
        	s=s.substring(1,s.length()-1);
        	
        	for(int i =s.length()-1;i>=0;i--) {
        		myAns = myAns+s.charAt(i);
        	}
        	
        	myAns = binary2Decimal(myAns);
        	for(int i =myAns.length()-1;i>=0;i--) {
        		myFinalAns = myFinalAns+myAns.charAt(i);
        	}
        }
        
         return myFinalAns;
    }
    

    
    
    /////////////////////////////  Help functions to 3.13 /////////////////////////////////////////////////
    
    
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
         	binary2DecimalRec(s,"0"); 
     }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////
     
    // Returns this * 2
    public BinaryNumber multiplyBy2() {
        BinaryNumber output = new BinaryNumber(this);
        output.bits.shiftLeft();
        output.bits.reduce();
        return output;
    }

    // Returens this / 2;
    public BinaryNumber divideBy2() {
        BinaryNumber output = new BinaryNumber(this);
        if (!equals(ZERO)) {
            if (signum() == -1) {
                output.negate();
                output.bits.shiftRight();
                output.negate();
            } else output.bits.shiftRight();
        }
        return output;
    }

}

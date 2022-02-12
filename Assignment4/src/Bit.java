/*
I, <Yossef Berman> (<316812569>), assert that the work I submitted is entirely my own.
I have not received any part from any other student in the class,
nor did I give parts of it for use to others.
I realize that if my work is found to contain code that is not originally my own,
 a formal case will be opened against me with the BGU disciplinary committee.
*/

public class Bit {

    private  boolean value;
    public static  final Bit ONE  = new Bit(true);
    public static  final Bit ZERO = new Bit(false);

    public Bit(boolean value) {
        this.value = value;
    }

    public Bit(int intValue) {
        if (intValue == 0)
            value = false;
        else {
            if (intValue == 1)
                value = true;
            else throw new IllegalArgumentException(value + " is neither 0 nor 1.");
        }
    }

    
    public String toString() {
        return "" + toInt();
    }

    @Override
    public boolean equals(Object obj) {
        if (! (obj instanceof Bit))
            return false;
        else return value == ((Bit) obj).value;
    }

    public Bit negate() {
        Bit output;
        if (value)
            output = ZERO;
        else output = ONE;
        return output;
    }

    public int toInt() {
        int output;
        if(value)
            output = 1;
        else
            output = 0;
        return output;
    }
       
    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 1.1 ================================================
    public static Bit fullAdderSum(Bit bit1, Bit bit2, Bit bit3) {
    	// program that gets three bits and sum them in binary base.
    	// as long the sum function will return a odd number the sum is one else the sum is zero
    	Bit sum;
    	if((bit1.toInt() + bit2.toInt() + bit3.toInt()) %2 == 1) 
    		sum=Bit.ONE;
    	
    	else
    		sum=Bit.ZERO;
        
        return sum;
    }

    public static Bit fullAdderCarry(Bit bit1, Bit bit2, Bit bit3) {
    	// program that gets three bits and check is carry left after sum function.
    	Bit carry = Bit.ZERO; // at the beginning carry always is zero.
    	// as long the sum function will return a number bigger than 1 we will have a carry.
    	if(bit1.toInt() + bit2.toInt() + bit3.toInt() >1)
    		carry = Bit.ONE;
    	
    	return carry; 
    }
    
}

/*
I, <Yossef Berman> (<316812569>), assert that the work I submitted is entirely my own.
I have not received any part from any other student in the class,
nor did I give parts of it for use to others.
I realize that if my work is found to contain code that is not originally my own,
 a formal case will be opened against me with the BGU disciplinary committee.
*/

import java.util.LinkedList;
import java.util.Iterator;

public class BitList extends LinkedList<Bit> {
    private int numberOfOnes;

    // Do not change the constructor
    public BitList() {
        numberOfOnes = 0;
    }

    // Do not change the method
    public int getNumberOfOnes() {
        return numberOfOnes;
    }


//=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 2.1 ================================================

    public void addLast(Bit element) {
    	//Appends the specified Bit to the end of this list.
    	if(element == null)
    		throw new IllegalArgumentException("null is not allowed.");
    	if(element.equals(Bit.ONE))
    		numberOfOnes++; // if we append one we update the number of ones
    	
    	//addLast is method in LinkedList,because bits extends LinkedList we can inherit method from the super class with super method.
    	super.addLast(element);   	
    }

    public void addFirst(Bit element) {
    	//Inserts the specified element at the beginning of this list.
    	if(element == null)
    		throw new IllegalArgumentException("null is not allowed.");
    	if(element.equals(Bit.ONE))
    		numberOfOnes++; // if we append one we update the number of ones
    	
    	//addFirst is method in LinkedList,because bits extends LinkedList we can inherit method from the super class with super method.
    	super.addFirst(element);  
    }

    public Bit removeLast() {
    	//Removes and returns the last element from this list.
    	Bit last = super.getLast(); // save the last bit to return him.
    	//getLast is method in LinkedList,because bits extends LinkedList we can inherit method from the super class with super method.
    	if(super.getLast().toInt() ==1) // getLast returns the last element in this list and toInt() will convert the bit to int
    		numberOfOnes= numberOfOnes-1; // updating the removing one.
    	
    	//removeLast is method in LinkedList,because bits extends LinkedList we can inherit method from the super class with super method.
    	super.removeLast();
    	return last; 	
    }

    public Bit removeFirst() {
    	//Removes and returns the first element from this list.
    	Bit first = super.getFirst(); // save the first bit to return him.
    	//getFirst is method in LinkedList,because bits extends LinkedList we can inherit method from the super class with super method.
    	if(super.getFirst().toInt() ==1) // getFirst returns the first element in this list and toInt() will convert the bit to int
    		numberOfOnes= numberOfOnes-1; //// updating the removing one.
    	
    	//removeFirst is method in LinkedList,because bits extends LinkedList we can inherit method from the super class with super method.
    	super.removeFirst();
    	return first ;    
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 2.2 ================================================
    public String toString() {
    	// overriding the toString method of LinkedList
    	//creating a string in form list <...> with bits inside in a form of string. 
        String ans = "<";

        //size and get is method in LinkedList,because bits extends LinkedList we can inherit method from the super class with super method.
        //size Returns the number of elements in this list. and get(i) Returns the element at the specified position in this list.
    	for(int i=super.size()-1;i>=0;i--) {
    		ans = ans + super.get(i);
    	}
    	
        return ans + ">"; 
    }
    
    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 2.3 ================================================
    public BitList(BitList other) {
    	// Bitlist constructor that copies other object
        if(!(other instanceof BitList))
			throw new IllegalArgumentException("put ligal input in Botlist constructor");
  
        //iterator Implementing LinkedList so we can use him
		Iterator<Bit> iterA= other.iterator(); // Returns an iterator over the elements in this list.
		while (iterA.hasNext()) { // while i have next element in my list will enter the loop
			 super.addLast(iterA.next()); //the constructor adding from the last the bits from the list
		}
		numberOfOnes= other.getNumberOfOnes(); // updating number of ones
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 2.4 ================================================
    public boolean isNumber() {
    	// program that returns true when the number has legal performance in binary number else false
        boolean ans = true; 
        
        if(super.size() ==0 || (numberOfOnes<=1 & (!super.getLast().equals(Bit.ZERO))))
        	ans=false;
        
        return ans;
    }
    
    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 2.5 ================================================
    public boolean isReduced() {
    	//program the checks if the given binary number is reduced by the rules bellow.
        boolean ans=false;
        
        if(isNumber()) {
            if(super.size() == 1 && this.getNumberOfOnes()==0) //0
    			ans=true;
            else if(super.size() == 2 && // 01 or 11
            		(super.getLast().equals(Bit.ZERO) & super.getFirst().equals(Bit.ONE) 
            				| super.getLast().equals(Bit.ONE) & super.getFirst().equals(Bit.ONE)))
            	ans = true;
            
            else if(super.size() >= 3 && //0100,01011,101,10101
            		(super.get(super.size()-1).equals(Bit.ZERO) & super.get(super.size()-2).equals(Bit.ONE)) 
            		| super.get(super.size()-1).equals(Bit.ONE) & super.get(super.size()-2).equals(Bit.ZERO))
            	ans = true;
            else if(super.size() >= 3 && // 11000,110...
            		(this.getNumberOfOnes()==2 
            		&& (super.get(super.size()-1).equals(Bit.ONE) & super.get(super.size()-2).equals(Bit.ONE))))
            	ans= true;
        }
        return ans;
    }

    public void reduce() {
        while(!isReduced()) { // as long the the number is'nt reduced we will remove the last bit
    	   this.removeLast();
       }	
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 2.6 ================================================
    public BitList complement() {
    	// program that turns the bits from 1 to 0 and opposite and return the opposite bitlist
        BitList compList = new BitList();
        
        Iterator<Bit> iterA= this.iterator(); 
		while (iterA.hasNext()) {
			if(iterA.next().equals(Bit.ZERO))
				compList.addLast(Bit.ONE);
			else
				compList.addLast(Bit.ZERO);
		}

        return compList;
    } 

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 2.7 ================================================
    public Bit shiftRight() {
    	// program that shift bitlist right by removing the first bit
        Bit firstBit = this.getFirst();
        this.removeFirst();
        return firstBit; 
    }

    public void shiftLeft() {
    	// program that shift bitlist left by adding zero in the beginning of the list.
        this.addFirst(Bit.ZERO);
    }

    //=========================== Intro2CS 2021, ASSIGNMENT 4, TASK 2.8 ================================================
    // this task i got help from the weekly tigbur
    public void padding(int newLength) {
    	// the program compare two lengths and add in the last of the smallest list the same bit as the last
    	// this program will help us to do mathematical operations between to binary numbers
        if(size() == 0)
         	throw new IllegalArgumentException("Cannot pad an empty Bit list");
         
         while(newLength>size()) {
        	 addLast(getLast());
         } 
    }

    

    //----------------------------------------------------------------------------------------------------------
    // The following overriding methods must not be changed.
    //----------------------------------------------------------------------------------------------------------
    public boolean add(Bit e) {
        throw new UnsupportedOperationException("Do not use this method!");
    }

    public void add(int index, Bit element) {
        throw new UnsupportedOperationException("Do not use this method!");
    }

    public Bit remove(int index) {
        throw new UnsupportedOperationException("Do not use this method!");
    }

    public boolean offer(Bit e) {
        throw new UnsupportedOperationException("Do not use this method!");
    }

    public boolean offerFirst(Bit e) {
        throw new UnsupportedOperationException("Do not use this method!");
    }

    public boolean offerLast(Bit e) {
        throw new UnsupportedOperationException("Do not use this method!");
    }

    public Bit set(int index, Bit element) {
        throw new UnsupportedOperationException("Do not use this method!");
    }

    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Do not use this method!");
    }
}

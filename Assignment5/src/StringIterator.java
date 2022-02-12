import java.util.Iterator;
import java.util.NoSuchElementException;


public class StringIterator implements Iterator<String> {
		
	private String str;

	//Complete the following methods
    public StringIterator(String start){
    	this.str = start; // our constructor will be initialize to start
    }

    public boolean hasNext(){
    	// task 0
    	// our iterator will be iterate as long the string length is lee than MAX_VALUE
    	return this.str.length()<Integer.MAX_VALUE; 
    }

    public String next(){
    	// task 0
    	//program that return the current value and the next after it.
    	if(!hasNext())
    		throw new NoSuchElementException("no such element"); // if our string length is bigger than max value
    	
    	String current =str; // will save our current value 
    	
    	if(str.isEmpty()) // special case we need initialize our string
    		str=addOne(); // calling our help function to begin the string

    	else if (this.str.charAt(str.length()-1)=='Z') { // special case big Z 
    		str=bigZ(); // calling our help function 
    	}
    	else // any other case just increase the char by one
    		str=addOne();
    	return
    			current;
 
    }

    
    ///////////////////////////////// help functions ///////////////////////////////
    public String addOne() {
    	//program that add 1 to the char value and increment the char by 1
    	if(this.str.isEmpty()) {//base case the start is empty so will be initialize it to 'a'
    		str="a"; 
    	}
    	else if(this.str.charAt(str.length()-1)=='z') {
    		//changing the last letter z to big A
    		str=str.substring(0,str.length()-1)+'A';
    	}
    	else {
    		//any other case we will be increment our char by one
    		char temp = str.charAt(str.length()-1);
    		temp++;
    		str = str.substring(0,str.length()-1) + temp;
    	}
    	return
    			str;  
    	
    }
    
    // help function to special case for Big Z in the end of our string
    public String bigZ () {
    	int counter=0; // counter to count the 'Z' amount
    	while(!str.isEmpty() && str.charAt(str.length()-1) =='Z') { 
    		//as long the sting is'nt empty and Z is the last letter
    		// we will cut the last letter Z and count how many times we cut
    		str= str.substring(0,str.length()-1); 
			counter++;
    	}
    	
    	// before we will be adding the replacement a for the cut Z's we will examine two cases.
    	if(!str.isEmpty()) // first the string is'nt empty so we need to add one to last char
    		str=addOne();
    	else 
    		str ="a"; // else the string is empty and we need to initialize it to a
 
    	for(int i=0;i<counter;i++) {//adding replacement a for missing Z's
    		str=str+'a';
    	}
    	return
    			str;
    }
    
    
    
    
}

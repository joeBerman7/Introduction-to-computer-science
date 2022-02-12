
public class Bit {

    private boolean value; 

    public Bit(boolean value){
    	this.value=value; // creating our Bit object with given value

    }

    public int toInt(){ 
        // by given boolean value the program will return representing int value of the value
        int ans = 0;
        if(value)
        	ans=1;
        return ans;

    }

    public String toString(){
        // by given boolean value the program will return representing string value of the value
        String ans = "0";
        if(value)
        	ans="1";
        return ans; 
    }
}


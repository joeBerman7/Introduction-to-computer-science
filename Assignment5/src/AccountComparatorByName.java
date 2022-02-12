import java.util.Comparator;

public class AccountComparatorByName implements Comparator<BankAccount>{

	@Override
	public int compare(BankAccount account1, BankAccount account2) {
		// task 2a
		// program that Compares two strings lexicographically using String compareTo method.
		int ans =0; // in the case the names are the same
		if(account1.getName().compareTo(account2.getName())>0) 
			ans=1; // The result is a positive number by the string argument, but in our case bigger will be represents by 1
		else if(account1.getName().compareTo(account2.getName())<0)
			ans=-1; // The result is a negative number by the string argument, but in our case bigger will be represents by -1
		
		return ans; 
	}

}

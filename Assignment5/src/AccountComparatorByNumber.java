import java.util.Comparator;

public class AccountComparatorByNumber implements Comparator<BankAccount>{

	@Override
	public int compare(BankAccount account1, BankAccount account2) {
		// task 2b
		// program that Compares two Bank account numbers by theirs size
		int ans =0; // in the case the names are the same
		if(account1.getAccountNumber() > account2.getAccountNumber())  
			ans=1; // account1 Bank account number is bigger than account2 Bank account number
		else if(account1.getAccountNumber() < account2.getAccountNumber())
			ans=-1; // account1 Bank account number is less than account2 Bank account number
		
		return ans; 
	} 

}

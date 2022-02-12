import java.util.Currency;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class FilteredBankAccountsIterator implements Iterator<BankAccount> {

	private BinaryTreeInOrderIterator<BankAccount> iterator;
	private Filter<BankAccount> filter;
    private BankAccount current;
    
    public FilteredBankAccountsIterator(BankAccountsBinarySearchTree bankAccountsTree, Filter<BankAccount> filter) {
        // task 5c
    	this.filter=filter; 
    	this.iterator= (BinaryTreeInOrderIterator<BankAccount>) bankAccountsTree.iterator();
    	
    	// we will need to store our temporary valid bank account result
    	BankAccount temp=null; // bank account that will be pass filter
    	boolean notFound=true; // when is legal bank account is found we will stop
    	while(iterator.hasNext()&notFound) {
    		temp=iterator.next();
    		if(filter.accept(temp)) // checking if our bank account is valid and than we will stop for the next time.
    			notFound=false; 
    	}
    	if(notFound) // if we didn't found valid bank account we don't have current bank account to return
    		this.current=null;
    	else this.current=temp; // we found valid bank account.
    }

    //Complete the following method
    @Override
    public boolean hasNext() {
        // task 5c
        return 
        		current!=null;  
    }

    //Complete the following method
    @Override
    public BankAccount next() {
        // task 5c
    	
      	if(!hasNext())
    		throw new NoSuchElementException("no such element"); //in the case we don't found valid bank account.
    	
    	BankAccount cuurTemp = current; // storage valid bank accounts
    	boolean notFound=true; // when is legal bank account is found we will stop
    	while(iterator.hasNext()&notFound) {
    		current=iterator.next();
    		if(filter.accept(current)) // checking if our bank account is valid and than we will stop for the next time.
    			notFound=false;
    	}
    	if(notFound)
    		this.current=null; // in the case we didn't found a valid bank account

    	return cuurTemp; // returning all valid bank accounts. 
    	
    }
}

import java.util.Iterator;

public class Bank {

	private BankAccountsBinarySearchTree namesTree;
	private BankAccountsBinarySearchTree accountNumbersTree;
	
	public Bank() {
		namesTree = new BankAccountsBinarySearchTree(new AccountComparatorByName());
		accountNumbersTree = new BankAccountsBinarySearchTree(new AccountComparatorByNumber());
	}

	public BankAccount lookUp(String name){
		// create an Entry with the given name, a "dummy" accountNumber (1) and zero balance
		// This "dummy" accountNumber will be ignored when executing getData
		BankAccount lookFor = new BankAccount(name, 1, 0);
		return (BankAccount)namesTree.findData(lookFor);
	}
	
	public BankAccount lookUp(int accountNumber){
		// create an Entry with a "dummy" name, zero balance and the given accountNumber
		// This "dummy" name will be ignored when executing getData
		BankAccount lookFor = new BankAccount("dummy", accountNumber,0);
		return (BankAccount)accountNumbersTree.findData(lookFor);
	}
	
	// END OF Given code -----------------------------------
	
	// Complete the methods from here on

	public boolean add(BankAccount newAccount) {
		// task 6a
		//program that check if newAccount is already "register" in BankAccountsBinarySearchTree with name or account number
		// if this account is new account we will add him an update the system, and returning if this action was executed.
		boolean ans=false;
		if(lookUp(newAccount.getAccountNumber()) == null & lookUp(newAccount.getName()) == null) {
			//check if the account is already exist in our system
			ans = true;
			//updating the details
			namesTree.insert(newAccount);
			accountNumbersTree.insert(newAccount);
		}
		return ans;

	}

	public boolean delete(String name){ 
		// this first line is given in the assignment file
		BankAccount toRemove = lookUp(name);
		// complete this:

		// task 6b
		// program that removing existing account member and returning if this action was executed
		boolean ans = false;
		if(toRemove != null) { //checking by name if the account is register in our system.
			ans = true; // if this account in our system we will update the system by removing name and number account
			namesTree.remove(toRemove);
			accountNumbersTree.remove(toRemove);
		}
		return ans;
	}
	
	public boolean delete(int accountNumber){
		// this first line is given in the assignment file
		BankAccount toRemove = lookUp(accountNumber);
		// complete this:

		// task 6c
		// program that removing existing account member and returning if this action was executed
		boolean ans = false;
		if(toRemove != null) {//checking by account number if the account is register in our system.
			ans = true; // if this account in our system we will update the system by removing name and number account
			namesTree.remove(toRemove);
			accountNumbersTree.remove(toRemove);
		}
		return ans; 
	}

	public boolean depositMoney(int amount, int accountNumber){
		// task 6d
		//program that adding money to account member balance, and returning if this action was executed
		boolean ans = false;
		if(lookUp(accountNumber) != null) { // checking by account number if there is an account register
			ans = true; // if there is we will deposit money in his account.
			lookUp(accountNumber).depositMoney(amount);
		}
		return ans; 
	}

	public boolean withdrawMoney(int amount, int accountNumber){
		// task 6e
		//program that taking out money for account member and returning if this action was executed
		boolean ans = false;
		//first we need to see if there is an register account
		//second we need to see if we can take money from this account by checking the balance account
		if(lookUp(accountNumber) != null && lookUp(accountNumber).getBalance()>=amount) {
			ans = true;
			lookUp(accountNumber).withdrawMoney(amount);
		}
		return ans; 
	}	
	
	public boolean transferMoney(int amount, int accountNumber1, int accountNumber2) {
		// task 6f
		//program that transfer money from account to another, and returning if this action was executed
		boolean ans = false;
		// assuming the accounts is registered, and than checking if we can take money from this account by checking the balance account 
		if(lookUp(accountNumber1).getBalance()>=amount) {
			ans = true; 
			//updating both bank accounts
			withdrawMoney(amount, accountNumber1);
			depositMoney(amount, accountNumber2); 
		}
		return ans; 
	}	
	public boolean transferMoney(int amount, int accountNumber, String name) {
		// task 6g
		//program that transfer money from account to another, and returning if this action was executed
		boolean ans = false;
		//we need to look if there is account register on the name requested and if the account member can effort him self giving money.
		if(lookUp(accountNumber).getBalance()>=amount & lookUp(name)!=null) {
			ans= true;
			int accountNumber2 = lookUp(name).getAccountNumber(); // for the convenience we will work with number account
			//updating both bank accounts
			withdrawMoney(amount, accountNumber);
			depositMoney(amount, accountNumber2);
		}
		return ans;
	}	
}

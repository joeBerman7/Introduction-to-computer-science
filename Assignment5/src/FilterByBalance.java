public class FilterByBalance implements Filter<BankAccount>{
	private int balanceThreshold;
	public FilterByBalance(int balanceThreshold) {
        // task 5c
        this.balanceThreshold=balanceThreshold; // Initialize our constructor to our field
	} 
	@Override
	public boolean accept(BankAccount elem) {
		// task 5c
		// program that get true value if we got enough money by balanceThreshold else false
		return
				elem.getBalance()>=balanceThreshold; 
	} 
}

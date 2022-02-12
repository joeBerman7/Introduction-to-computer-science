import java.util.Comparator;
import java.util.Iterator;

public class BankAccountsBinarySearchTree extends BinarySearchTree<BankAccount>{

	public BankAccountsBinarySearchTree(Comparator<BankAccount> myComparator) {
		super(myComparator);
	}
	
	// Complete the following methods
	public void balance(){
		// task 5b
		//program that balancing binary trees
		Iterator<BankAccount> itr= this.iterator(); // creating iterator to iterate in in order list.
		List<BankAccount> myTree = new LinkedList<>(); // saving the in order values in the list.
	
		//adding the values in the list we gonna work with and clear our tree to construct on
		while(itr.hasNext()) {
			BankAccount temp =itr.next(); // will serve us to remove this element from the tree 
			myTree.add(temp); // and of course to append our list 
			this.remove(temp);
			
		}
		//calling our recursive help function with our list,low is lows't index in the list 
		//and high is highest index number in the list
		buildBalancedTree(myTree,0,myTree.size()-1);
	}
	
	private void buildBalancedTree(List<BankAccount> list, int low, int high){
		// task 5b
		//help function the will construct our balanced tree
		
        if (low > high) // base case when we will stop like in the lion in the desert case
            return ;
	
        //Get the middle element and make it root
        int mid = (low + high) / 2;
        insert(list.get(mid));

        //calling our recursion to get it further from both side of the tree
	    buildBalancedTree(list, low, mid - 1);
	    buildBalancedTree(list, mid + 1, high);
	  
	}
}

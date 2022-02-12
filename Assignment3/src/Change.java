
class Change{
    
    //////////////////////////////  help functions /////////////////////////////
    
    //help function 2.1
	public static boolean subsetSum(int[] weights, int sum, int i){
	    //check if the sum can be taken from weights, starting at index i.
		boolean ans = false;
		if(sum == 0) // our base case we want to reach.
			ans = true;
		else if(sum < 0 | i >= weights.length) 
			ans = false;
		else 
		    // as long as sum > 0 and i<weights.length we will call our function.
			ans = subsetSum(weights, sum - weights[i], i) || subsetSum(weights, sum, i + 1);
		return ans;
	}
    
    // help function to task2.2
    public static boolean subsetSum(int[] weights, int sum, int i,int numOfCoins){
    	//check if the sum can be taken from weights limited by numOfCoins, starting at index i.
    	boolean ans; 
    	if(sum==0)  // our base case we want to reach
    		ans=true;
    	else if(sum<0 | i>= weights.length | numOfCoins<1)
    		ans= false;
    	else
    	    // as long as sum != 0 and i<weights.length and we still have coins to use, we will call our function.
    		ans = subsetSum(weights, sum-weights[i],i,numOfCoins-1) || subsetSum(weights, sum,i+1,numOfCoins) ;
    	
    	return ans; 
    }
    
    /// help function task2.3
    public static boolean printAtleastOneSubSum(int[] weights, int sum, int ind,int numOfCoins,String ans,boolean print){
        // print the first option from all options that sum can be taken from weights limited by numOfCoins, starting at index ind.
    	if(sum==0 & !print & numOfCoins>=0) { // our base case we want to reach.
    		System.out.println(ans.substring(1)); // when we will be reach the condition we will print our ans without ',' using substring method.
    		print = true; // we will be use our boolean print to stop after first time.
    	}
    	else if(ind<weights.length && numOfCoins>0 & sum>0 & !print) {
    	    // as long as sum > 0 and ind < weights.length and we still have coins to use, we will call our function.
    		// it's important to use here || operator that will stop to check after it will find first case true.
    		print = printAtleastOneSubSum(weights, sum-weights[ind],ind,numOfCoins-1,ans + "," + weights[ind],print) || // check with first weight more then one time each round.
    				printAtleastOneSubSum(weights, sum,ind+1,numOfCoins,ans,print) ; // check without first weight each round.
    	}
    	
    	return print;
    }
    

    // help function task 2.4
    public static int subsetSumCount(int[] weights, int sum, int i,int numOfCoins ) {
    	//count the different options to add elements from weights starting at index i that sums to sum.
    	int ans = 0;
    	if(sum ==0) // our base case we want to reach and add the ans to total ans.
    		ans =1;
    	else if((sum<0 |i>=weights.length) | numOfCoins==0)
    		ans=0;
    	else
    	    // as long as sum > 0 and i<weights.length and we still have coins to use, we will call our function and count the choices we got.
    		ans = subsetSumCount(weights, sum - weights[i], i,numOfCoins-1) + subsetSumCount(weights, sum, i+1,numOfCoins);
    	
    	return ans;
    }
    
 
    /// help function task2.5
    public static void printSubsetSum(int[] weights, int sum, int ind,int numOfCoins,String ans){
    	// print the all different options sum can be taken from weights limited by numOfCoins, starting at index ind
    	if(sum==0) // our base case we want to reach
    		System.out.println(ans.substring(1)); // when we will be reach the condition we will print our ans without ',' using substring method.

    	else if(ind<weights.length && numOfCoins>0 & sum>0) {
    	    // as long as sum > 0 and ind <weights.length and we still have coins to use, we will call our function.
    		printSubsetSum(weights, sum-weights[ind],ind,numOfCoins-1,ans + "," + weights[ind]); // check with first weight more then one time each round.
    		printSubsetSum(weights, sum,ind+1,numOfCoins,ans) ; // check without first weight each round.
    	} 
    }
    
    ////////////////////////////////////////////////////////////////////////////

    public static boolean change(int [] coins, int n){
        return
        		subsetSum(coins, n, 0); // calling my help function 2.1
    }

    public static boolean changeLimited(int[] coins, int n, int numOfCoinsToUse){
        return 
        	subsetSum(coins, n, 0,numOfCoinsToUse); // calling my help function 2.2
    }

    public static void printChangeLimited(int[] coins, int n, int numOfCoinsToUse){
        printAtleastOneSubSum(coins,n,0, numOfCoinsToUse, "", false); // calling my help function 2.3
    }

    public static int countChangeLimited(int[] coins, int n, int numOfCoinsToUse){
         return 
        	subsetSumCount(coins, n,0, numOfCoinsToUse); // calling my help function 2.4
    }

    public static void printAllChangeLimited(int[] coins, int n, int numOfCoinsToUse){
        printSubsetSum(coins, n, 0, numOfCoinsToUse, ""); // calling my help function 2.5
    }

}

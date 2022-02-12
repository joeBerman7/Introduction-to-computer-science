
public class Assignment2 {
	
	/*------------------
	 *| Help Functions |
	 * -----------------*/
	
	///////////// I create These functions to help me to solve some tasks and create more readable code. ///////////
	
	// arrayConstructor function helped me on tasks: 11,13,14,16,17
	public static int[][] arrayConstructor(int[][] arr1,int[][] arr2) {
		//program that gets a two dimensional array and construct a third array with values of the two given arrays
		int[][] arr3 = new int[arr1.length+arr2.length][]; // third array length will be the sum of two given arrays
		int arrIndex=0; // this counter will help us to put the values of the given arrays with numerical order
		
		if(arr1.length!=0) {//we will construct only not empty arrays
			for (int i = 0; i < arr1.length; i++, arrIndex++) {//adding first array values to our final array
	            arr3[arrIndex] = arr1[i];
	        }	
		}
		if(arr2.length!=0) {//we will construct only not empty arrays
			for (int j = 0; j < arr2.length; j++, arrIndex++) {//adding second array values to our final array
	            arr3[arrIndex] = arr2[j];
	        }
		}
		return arr3;
	}
	
	// reverse function helped me on task 20
	public static int[] reverse(int[] array){
		//program that gets a integer array and returns the arrays values from the last to the first (reversed).
		int[] reversedArray = new int[array.length]; //Initializing reversed array
		for(int i = 1; i < array.length; i++){ //we want to reverse only from index 1, for task 20 requirements.
		    reversedArray[i] = array[array.length - i ];
		}
		return reversedArray;	
	}
	
	// notAtLeastOne function is opposite function to AtLeastOne function created in task task9, this function helped me in task 20.
	public static int[][] notAtLeastOne(int[] lits) {
		//throw new UnsupportedOperationException("Not Implemented yet.");	
	    int [][] cnf = new int[1][lits.length];
			for(int i=0;i<lits.length;i++) {
				cnf[0][i]=-lits[i];// here we get cnf with negative values.
			}
		
		return cnf; 	 
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/*-----------------------
	 *| Part A - tasks 1-11 |
	 * ----------------------*/
		
	// task 1
	public static boolean isSquareMatrix(boolean[][] matrix) {
		//Program that checks if the given matrix array is square.
		//The program will return false weather the matrix is null, empty or not square, else it will return true.
		boolean isisSquare = true;
		if (matrix==null) 
			isisSquare = false;
		if (matrix.length==0)
			isisSquare = false;
		 
		for(int i=0;i<=matrix.length-1;i++) {
			if(matrix.length!=matrix[i].length)
				isisSquare= false;
		}
		return isisSquare; 
	}
	
	// task 2
	public static boolean isSymmetricMatrix(boolean[][] matrix) {
		//Program that checks if the given matrix array is symmetric.
		//The program will return false each time the element in the matrix in the position matrix[j][i]
		//Will not be equal to the element in the matrix in the symmetric opposite position matrix[i][j] else if they are equal the Program will return true.
		boolean isSymmetric = true;
		for(int i=0;i<matrix.length-1 & isSymmetric;i++) {
			for (int j=i+1;j<matrix.length & isSymmetric;j++) {
				if(matrix[j][i]!=matrix[i][j])
					isSymmetric=false;
			}
		} 
		return isSymmetric; 
	}

	// task 3
	public static boolean isAntiReflexiveMatrix(boolean[][] matrix) {
		//Program that checks whether the given matrix array is anti-reflexive, thus if we don't have the each elements twice <x,x>
		//The program must return false for <x,x> element and in our case, the matrix[i][i] should be false 
		boolean isAntiReflexive = true;
		for(int i=0;i<=matrix.length-1;i++) {
		    if(matrix[i][i]!= false)
		    	isAntiReflexive = false;
		}
		return isAntiReflexive; 
	}
	
	// task 4
	public static boolean isLegalInstance(boolean[][] matrix) {
		//Program that checks whether the given matrix array is square, symmetric and anti-reflexive all together.
		boolean isLegal =(isSquareMatrix(matrix) & isSymmetricMatrix(matrix) & isAntiReflexiveMatrix(matrix));
		return isLegal; 
	}
	
    // task 5
	public static boolean isPermutation(int[] array) {
		//Program that checks whether the given matrix array is Permutation. 
		//If the given array is Permutation the function will be return true, else it will be returns false.
		//Permutation array is integer array that include all the integer numbers from 0 to arrays length -1 only once.
		boolean isPermut = true;
		//First loop will check if the elements of the array is in the range of Permutation.
		for (int i = 0;i <= array.length-1 & isPermut;i++) {
			if (array[i]<0 | array[i]>array.length-1)
				isPermut=false;
		}
		//Second loop will check if our elements in the array appear only once.
		for (int j=0;j<array.length-1 & isPermut;j++) {
			  for (int k=j+1;k<array.length;k++) {
			    if (k!=j & array[k] == array[j])
			      isPermut=false;	
			  }
		}
		return isPermut; 
	}
	
	// task 6
	public static boolean hasLegalSteps(boolean[][] flights, int[] tour) {
		//Flights it's our two dimensional array that represent the flights we have each step.
		//Tour it's our one dimensional array that represent legal trip between the cities.
		// if the given tour are legal trip based on flights the program will return true, else will be return false
		boolean isLegal =true;
		//In the loop we check in flights array if we got flight between cities tour[i] to tour[i+1] and the way back home
		for(int i=0;i<tour.length-1;i++) {
			if(!(flights[tour[i]][tour[i+1]] & flights[tour[tour.length-1]][tour[0]]))
				isLegal=false;;
		}
		return isLegal; 
	}
	
	// task 7
	public static boolean isSolution(boolean[][] flights, int[] tour) {
		//Program that combined tasks 5,6.
		
		// the program will return true only if:
		/* 1.include all the integer numbers from 0 to arrays length -1 only once.
		   2.tour[0]=0 the first city in our tour represent by 0.
		   3.In flights array if we got flight between cities tour[i] to tour[i+1] and the way back home
		//else the program will return false. */
		boolean Solution = true; 
		if (flights.length != tour.length)
			throw new UnsupportedOperationException("Tour array length is no equal to flights array length.");
		else {
			if(isPermutation(tour) & (tour[0]==0) & hasLegalSteps(flights,tour))
				Solution=true;
			else
				Solution = false;
		}
		return Solution; 
	}
	
	// task 8
	//I used the weekly "Tigbur" help to solve this task
	public static boolean evaluate(int[][] cnf, boolean[] assign) {
		//Program that get help from two help functions that we created below.
		//Program that gets input cnf array and assign array, and define the boolean value of the result from check cnf array with the assign.
		boolean result = true;
		//in the loop we will evaluate the clauses from the cnf with assign, to finally get true value only if the whole cnf get true value with assign
		for(int cluaseNum=0;cluaseNum<cnf.length & result;cluaseNum++) {
			result = result & evaluateClause(cnf[cluaseNum], assign); //result will be true only if the evaluation of whole cnf we be true
		}
		return result; 
	}
	public static boolean evaluateLiteral(int literal, boolean[] assign) {
		//first help function to task 8.
		//Program that gets input literal and assign array, and define the boolean value of the literal with the assign.
		boolean literalValue;
		if(literal>0) 
			literalValue =assign[literal];
		else
			literalValue=!assign[-literal];
		return literalValue; 		
	}
	
	public static boolean evaluateClause(int[] clause, boolean[] assign) {
		//Second help function to task 8. also get helped with evaluateLiteral first help function to task 8.
		//Program that gets input clause array and assign array, and define the boolean value of the clause with the assign.
		boolean result = false;
		for(int literalidx =0;literalidx<clause.length & !result;literalidx++) {
			int literal = clause[literalidx]; //creating literal from the clause
			boolean literalValue = evaluateLiteral(literal, assign); //evaluate the created literal with the assign
			result = result | literalValue; //result can get false only if literalValue come back false else it will get true
		}
		return result;
	}
	
	// task 9
	public static int[][] atLeastOne(int[] lits) {
		//Program that gets lits array as an input and Forces the literals so that at least one of them gets true value in placement 
		//The output is two dimensional array cnf with that solution.
		int [][] cnf = new int[1][lits.length]; //Initializing the cnf
		//Constructing the cnf
		for(int i=0;i<lits.length;i++) { 
			cnf[0][i]=lits[i]; 
		}
		return cnf; 	
	}

	// task 10
	// I used the weekly "Tigbur" help to solve this task
	public static int[][] atMostOne(int[] lits) {
		//program that gets lits array as an input and and return array that satisfy maximum only one solution or none from given literals array
		int numOfcluses = lits.length*(lits.length-1)/2;
		int [][] cnf = new int[numOfcluses][2]; // Initializing the cnf
		int cnfIndex =0; // we will use different counter outside of the loop to construct the cnf values.
		
		//Constructing the cnf
		for(int i=0;i<lits.length-1;i++) {
			for(int j=i+1;j<lits.length;j++,cnfIndex++) {
				int[] clause = {-lits[i],-lits[j]};
				cnf[cnfIndex]= clause;
			}
		}
		return cnf;
	}
	
	// task 11
    public static int[][] exactlyOne(int[] lits) {
		//Program 11 is a function combination from tasks 9,10
    	//this program gets literals array and will be return a cnf array with only 1 solution from given literals array
		int[][] cnf = new int[0][];
		cnf= arrayConstructor(atLeastOne(lits), atMostOne(lits));
		return cnf; 
	}
	
	/*------------------------
	 *| Part B - tasks 12-20 |
	 * -----------------------*/
	
	// task 12a
	public static int map(int i, int j, int n) {
		//Program that calculate integer number that will be representing if we been visited in the city (j) in the step (i). (n represents number of cities).
	    int ans = (n*i)+j+1;
		return ans;
	}
	
	// task 12b
	public static int[] reverseMap(int k, int n) {
		//Program that make opposite from map function. by given k the program will calculate [i,j] when i is stage and j is the city
		int[] ans = new int [2]; //only for i and j
		int i = (k-1)/n;
		int j = (k-1)%n;
		ans[0]=i;
		ans[1]=j;
		return ans; 
	}
	
	// task 13
	public static int[][] oneCityInEachStep(int n) {
		//Program that gets integer n the represent number of cities and program output is cnf two dimensional array with solution to Constraint.
		//the Constraint is for each step i there is one city j that the variable map(i, j, n) will get value true in the sufficient Placement

        int[] lits = new int[n]; // initializing our literals array
        int[][] cnf = new int[0][]; //initializing our cnf array, we will construct the array with our help function so the size will be set there.
        
        //constructing the cnf
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
            	//for each step i there is city j in variable map(i, j, n) that the variable in the statement will get true value with the assign
                lits[j] = map(i, j, n);
            }
            //we will use here a exactlyOne function from task 11
            //exactlyOne will be return a cnf array with only one solution from given literals array
            cnf = arrayConstructor(cnf, exactlyOne(lits)); //constructing our final cnf array from the others cnf arrays that was created in the loop
        }
        return cnf;
	}

	// task 14
	public static int[][] eachCityIsVisitedOnce(int n) {
		//Program that gets integer n the represent number of cities and program output is cnf two dimensional array with solution to Constraint.
		//the Constraint is for each city j there is one step i that the variable map(i, j, n) will get value true in the sufficient Placement
		
		int[] lits = new int[n]; // initializing our literals array
        int[][] cnf = new int[0][]; //initializing our cnf array, we will construct the array with our help function so the size will be set there.
        
        //constructing the cnf
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
            	//for each city j there is step i in variable map(i, j, n) that the variable in the statement will get true value with the assign
                lits[j] = map(j, i, n);
            }
            //we will use here a exactlyOne function from task 11
            //exactlyOne will be return a cnf array with only one solution from given literals array
            cnf = arrayConstructor(cnf, exactlyOne(lits)); //constructing our final cnf array from the others cnf arrays that was created in the loop
        }
        return cnf;
	}
	
	// task 15
	public static int[][] fixSourceCity(int n) {
		//Program that gets integer n representing number of cities and program output is cnf two dimensional array with solution to Constraint.
		//the Constraint is for each number of cities n the variable map(0,0,n) will get value true in the sufficient Placement our source city.
		
		int[] lits = {map(0,0,n)}; // creating the lits array that we will use to create the cnf array. there will be only one value in this array.
        int[][] cnf = new int[exactlyOne(lits).length*n][]; //initializing our cnf array.
        //we will use here a exactlyOne function from task 11
        //exactlyOne will be return a cnf array with only one solution from given literals array
        cnf=exactlyOne(lits);
        return cnf;
	}
	
    // task 16
	public static int[][] noIllegalSteps(boolean[][] flights) {
		//Program that gets two dimensional array flights and the output is cnf two dimensional array with solution to Constraint.
		//the Constraint is for at most one of the variables map(i, j, n) or map((i + 1) % n, k, n) will get value true in the sufficient Placement.
				
        int n = flights.length; //variable that will help us create more organized code. 
        int[] lits = new int[2]; // initializing our literals array that will hold two value each loop.
        int[][] cnf = new int[0][]; //initializing our cnf array, we will construct the array with our help function so the size will be set there.
    
        //constructing the cnf
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
            	//we will demand for each different cities j and k there will not be a flight between them each step i and i+1.
                if (!flights[j][k] & (j!=k)) {
                    for(int i=0;i<n;i++) {
                    	//creating our lits array
                    	lits[0] = map(i, j, n);
                    	lits[1] = map((i + 1) % n, k, n); 
                    	
                    	//we will use here atMostOne function from  task 10.
                    	//program that gets lits array as an input and and return array that satisfy maximum only one solution or none from given literals array
                    	cnf= arrayConstructor(cnf,atMostOne(lits)); //constructing our final cnf array from the others cnf arrays that was created in the loop
                    }
                 }      
            }    
         }
        return cnf; 
	}
	
	// task 17
	public static int[][] encode(boolean[][] flights) {
		//this program is combination of tasks 13,14,15,16.
		//Program that gets two dimensional array flights and the output is cnf two dimensional array with solution to all 4 Constraint above.
		
		// initializing our cnfs arrays. we will construct our cnf array with our help function so the size will be set there.
	    int[][] cnf = new int [0][];
		int[][] cnf1 = new int [0][];
		int[][] cnf2 = new int [0][];
		
		//creating the arrays from the tasks before
		cnf1= arrayConstructor(oneCityInEachStep(flights.length),eachCityIsVisitedOnce(flights.length));
		cnf2= arrayConstructor(fixSourceCity(flights.length), noIllegalSteps(flights));
		cnf = arrayConstructor(cnf1, cnf2); // combine all the cnfs from the tasks before
		return cnf;	
	}

	// task 18
	public static int[] decode(boolean[] assignment, int n) {
		//Program gets boolean two dimensional array assignment and integer and return integer array only if assignment[map(i, j, n)] is true so tour[i]=j
		//n represents number of cities i represents the stage in the trip and j represents the city.
		
		//we have two Exceptions to be careful with.
		if(assignment==null)
			throw new UnsupportedOperationException("assignment is null.");
		else if(assignment.length!=((n*n)+1))
			throw new UnsupportedOperationException("assignment length is not (n*n)+1.");
		
		int [] tour = new int[n]; // initializing tour array.
		int tourInd =0; // our tour counter to tour it's should be a different counter outside of the loop to construct the tour values.
		
		//constructing tour by our condition if assignment[map(i, j, n)] is true so tour[i]=j
		for(int i=0;i<n;i++,tourInd++) {
			for(int j=0;j<n;j++) {
				if(assignment[map(i, j, n)]){
					tour[tourInd]=j;
				}
			}
		}
		return tour; 
	}
	
	// task19
	public static int[] solve(boolean[][] flights) {
	    //program gets two dimensional array flights and return a one dimensional array tour with solve for all the Constraints.
		//this program solve the problem with sat solver.
			
	    if(!isLegalInstance(flights))
	    	throw new UnsupportedOperationException("flights array is not legal instance.");
	    		
        int nVars = flights.length*flights.length; //number of literals (x1,x2,x3...x(flights.length*flights.length))
		int[] tour =new int[nVars];// initializing tour array.
		int[][] cnf =encode(flights); // creating cnf array standing in all relevant Constraints using encode function from task 17
		SATSolver.init(nVars); // initializing our sat solver
		SATSolver.addClauses(cnf); //adding cnfs clauses to sat solver.
		boolean[] assignment = new boolean[nVars]; // initializing our assignment array.
		assignment =SATSolver.getSolution();// storing our solutions from sat solver in our assignment array.
		
		if(assignment.length==0) 	
			return null; // in case we didn't got a solution from sat solver and assignment is empty there is no sufficient Placement.
		else {//there is sufficient Placement and we will return it
			
    		tour=decode(assignment, flights.length); //using function decode from task 18 to create our tour array
    		// if returned tour solution and flights is capable for all conditions to is solution function from task 7, we got our answer in tour. 
    		if(isSolution(flights, tour)) 
    			return tour; 
    		else
    			throw new UnsupportedOperationException("Iligal solution");
		}
        
	}
	
	// task20
	public static boolean solve2(boolean[][] flights) {
	    //program gets two dimensional array flights and return a one dimensional array tour with solve for all the Constraints.
		//this program solve the problem with sat solver and will return true if there is another solution for task 19.
		
		//we will create another two clauses that shouldn't change the result for the sat solver thus sat solver can handle them
		// and we will see if we capable to get a another solution by to conditions of the task 
		
		int[] tour =solve(flights); //storing our solve solution in tour array
		int tourLen = tour.length; // help integer variable to get more readable code
		
		int[] tour2 = new int[tourLen]; // initializing tour2 array.
		int tourInd2 =0; // our tour counter to tour2, it's should be a different counter outside of the loop to construct the tour values.
		//constructing tour2 by all the numbers that get value true in the sufficient Placement.
		for(int i =0;i<tourLen;i++,tourInd2++) {
			tour2[tourInd2]=map(i,tour[i],flights.length);
		}
			
		int [] reversedTour = reverse(tour); // i used my help function to create reversed array tour.
		
		int[] tour3 = new int[tourLen]; // initializing tour3 array.
		int tourInd3 =0; // our tour counter to tour3, it's should be a different counter outside of the loop to construct the tour values.
		//constructing tour3 by all the numbers that get value true in the sufficient Placement.
		for(int i =0;i<tourLen;i++,tourInd3++) {
			tour3[tourInd3]=map(i,reversedTour[i],flights.length);
		}
		
		//two new clauses created with notAtLeastOne my help function.
		int[][] newClause1 = notAtLeastOne(tour2);
		int[][] newClause2 = notAtLeastOne(tour3);

	    if(!isLegalInstance(flights))
	    	throw new UnsupportedOperationException("flights array is not legal instance.");
	    		
        int nVars = flights.length*flights.length; //number of literals (x1,x2,x3...x(flights.length*flights.length))
		int[][] cnf =encode(flights); // creating cnf array standing in all relevant Constraints using encode function from task 17
		int[] myTour =new int[nVars]; // // initializing myTour array. hopefully returned array if it standing by the conditions.
		SATSolver.init(nVars); // initializing our sat solver.
		SATSolver.addClauses(cnf); //adding cnfs clauses to sat solver.
		SATSolver.addClauses(newClause1); //adding newClause1 clauses to sat solver.
		SATSolver.addClauses(newClause2); //adding newClause2 clauses to sat solver.
		
		boolean[] assignment = SATSolver.getSolution();	// storing our solutions from sat solver in our assignment array.	
		if(assignment.length==0) // in case we didn't got a solution from sat solver and assignment is empty there is no sufficient Placement.
			return false; 
		else { //there is sufficient Placement and we will return it
			
			myTour=decode(assignment, flights.length); //using function decode from task 18 to create our tour array
			// if returned myTour solution and flights is capable for all conditions to is solution function from task 7, we got our answer in myTour. 
			if(isSolution(flights, myTour))
				return true;
			else
				throw new UnsupportedOperationException("Iligal solution");
		}
		
	}
			
}

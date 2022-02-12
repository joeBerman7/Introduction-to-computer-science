

public class vplOutut {

	/*-----------------------
	 *| Part A - tasks 1-11 |
	 * ----------------------*/
	
	// help function
	public static int[][] arrayConstructor(int[][] arr1,int[][] arr2) {
		int[][] arr3 = new int[arr1.length+arr2.length][];
		int arrIndex=0;
		
		if(arr1.length!=0) {
			for (int i = 0; i < arr1.length; i++, arrIndex++) {
	            arr3[arrIndex] = arr1[i];
	        }	
		}
		if(arr2.length!=0) {
			for (int j = 0; j < arr2.length; j++, arrIndex++) {
	            arr3[arrIndex] = arr2[j];
	        }
		}
		return arr3;
	}
	
	// task 1
	public static boolean isSquareMatrix(boolean[][] matrix) {
		//throw new UnsupportedOperationException("Not Implemented yet.");
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
		//throw new UnsupportedOperationException("Not Implemented yet.");
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
		//throw new UnsupportedOperationException("Not Implemented yet.");
		boolean isAntiReflexive = true;
		for(int i=0;i<=matrix.length-1;i++) {
		    if(matrix[i][i]!= false)
		    	isAntiReflexive = false;
		}
		return isAntiReflexive; 
	}
	
	// task 4
	public static boolean isLegalInstance(boolean[][] matrix) {
		//throw new UnsupportedOperationException("Not Implemented yet.");	
		boolean isLegal =(isSquareMatrix(matrix) & isSymmetricMatrix(matrix) & isAntiReflexiveMatrix(matrix));
		return isLegal; 
	}
	
    // task 5
	public static boolean isPermutation(int[] array) {
		//throw new UnsupportedOperationException("Not Implemented yet.");	
		boolean isPermut = true;
		for (int i = 0;i <= array.length-1 & isPermut;i++) {
			if (array[i]<0 | array[i]>array.length-1)
				isPermut=false;
		}
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
		//throw new UnsupportedOperationException("Not Implemented yet.");	
		boolean isLegal =true;
		for(int i=0;i<tour.length-1;i++) {
			if(!(flights[tour[i]][tour[i+1]] & flights[tour[tour.length-1]][tour[0]]))
				isLegal=false;;
		}
		return isLegal; 
	}
	
	// task 7
	public static boolean isSolution(boolean[][] flights, int[] tour) {
			
        boolean Solution = true;
		if (flights.length != tour.length)
			throw new UnsupportedOperationException("Tour array length is noe equal to flights array length.");
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
		//throw new UnsupportedOperationException("Not Implemented yet.");	
		int [][] cnf = new int[1][lits.length];
		for(int i=0;i<lits.length;i++) {
			cnf[0][i]=lits[i];
		}
	
		return cnf; 	
	}

	// task 10
	public static int[][] atMostOne(int[] lits) {
		//throw new UnsupportedOperationException("Not Implemented yet.");	
		int numOfLitss = lits.length;
		int numOfcluses = numOfLitss*(numOfLitss-1)/2;
		int currIndex =0;
		int [][] cnf = new int[numOfcluses][2];
		
		for(int i=0;i<lits.length-1;i++) {
			for(int j=i+1;j<lits.length;j++,currIndex++) {
				int[] clause = {-lits[i],-lits[j]};
				cnf[currIndex]= clause;
			}
		}
		return cnf;
	}
	
	// task 11
    public static int[][] exactlyOne(int[] lits) {
		//throw new UnsupportedOperationException("Not Implemented yet.");
		int[][] cnf = new int[0][];
		cnf= arrayConstructor(atLeastOne(lits), atMostOne(lits));
		return cnf; 
	}
	
	/*------------------------
	 *| Part B - tasks 12-20 |
	 * -----------------------*/
	
	// task 12a
	public static int map(int i, int j, int n) {
		//throw new UnsupportedOperationException("Not Implemented yet.");
	    int ans = (n*i)+j+1;
		return ans;
	}
	
	// task 12b
	public static int[] reverseMap(int k, int n) {
		//throw new UnsupportedOperationException("Not Implemented yet.");
		int[] ans = new int [2];
		int i = (k-1)/n;
		int j = (k-1)%n;
		ans[0]=i;
		ans[1]=j;
		return ans; 
	}
	
	// task 13
	public static int[][] oneCityInEachStep(int n) {
		//throw new UnsupportedOperationException("Not Implemented yet.");
        int[] lits = new int[n];
        int[][] cnf = new int[0][];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                lits[j] = map(i, j, n);
            }
            cnf = arrayConstructor(cnf, exactlyOne(lits));
        }
        return cnf;
	}

	// task 14
	public static int[][] eachCityIsVisitedOnce(int n) {
		//throw new UnsupportedOperationException("Not Implemented yet.");	
		int[] lits = new int[n];
        int[][] cnf = new int[0][];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                lits[j] = map(j, i, n);
            }
            cnf = arrayConstructor(cnf, exactlyOne(lits));
        }
        return cnf;
	}
	
	// task 15
	public static int[][] fixSourceCity(int n) {
		//throw new UnsupportedOperationException("Not Implemented yet.");	
		int[] lits = {map(0,0,n)};
        int[][] cnf = new int[exactlyOne(lits).length*n][];
        cnf=exactlyOne(lits);
        return cnf;
	}
	
    // task 16
	public static int[][] noIllegalSteps(boolean[][] flights) {
		//throw new UnsupportedOperationException("Not Implemented yet.");	
        int n = flights.length;        
        int[] lits = new int[2];
        int[][] cnf = new int[0][];
    
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                if (!flights[j][k] & (j!=k)) {
                    for(int i=0;i<n;i++) {
                    	lits[0] = map(i, j, n);
                    	lits[1] = map((i + 1) % n, k, n);
                    	cnf= arrayConstructor(cnf,atMostOne(lits)); 
                    }
                 }      
            }    
         }
        return cnf; 
	}
	
	// task 17
	public static int[][] encode(boolean[][] flights) {
		//throw new UnsupportedOperationException("Not Implemented yet.");	
	    int[][] cnf = new int [0][];
		int[][] cnf1 = new int [0][];
		int[][] cnf2 = new int [0][];
			
		cnf1= arrayConstructor(oneCityInEachStep(flights.length),eachCityIsVisitedOnce(flights.length));
		cnf2= arrayConstructor(fixSourceCity(flights.length), noIllegalSteps(flights));
		cnf = arrayConstructor(cnf1, cnf2);
		return cnf;	
	}

	// task 18
	public static int[] decode(boolean[] assignment, int n) {
		if(assignment==null)
			throw new UnsupportedOperationException("assignment is null.");
		else if(assignment.length!=((n*n)+1))
			throw new UnsupportedOperationException("assignment length is not (n*n)+1.");
		
		int [] tour = new int[n];
		int tourInd =0;
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
	    
	    if(!isLegalInstance(flights))
	    	throw new UnsupportedOperationException("here.");
	    		
        int nVars = flights.length*flights.length;
		int[] tour =new int[nVars];
		int[][] cnf =encode(flights);
		SATSolver.init(nVars); 
		SATSolver.addClauses(cnf);
		boolean[] assignment = new boolean[nVars];
		assignment =SATSolver.getSolution();
		
		if(assignment.length==0) 	
			return null;
		else {
    		tour=decode(assignment, flights.length);
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
	
	public static int[] reverse(int[] array){
		int[] reversedArray = new int[array.length];
		for(int i = 1; i < array.length; i++){
		    reversedArray[i] = array[array.length - i ];
		}
		return reversedArray;	
	}
		
	public static int[][] notAtLeastOne(int[] lits) {
		//throw new UnsupportedOperationException("Not Implemented yet.");	
	    int [][] cnf = new int[1][lits.length];
			for(int i=0;i<lits.length;i++) {
				cnf[0][i]=-lits[i];
			}
		
		return cnf; 	
	}	
		
}


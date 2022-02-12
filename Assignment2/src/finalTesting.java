import java.util.Arrays;

public class finalTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//boolean[][] flights = {{false, true, true, true}, 
		//						{true, false, true, true}, 
		//						{true, true, false, true},
		//						{true, true, true, false}};
		
		
		//boolean[][] flights2 = {{true, true, true, true},{ true, false, true, true},{true, true, true, true}, {true, true, true, false}};

		boolean[][] flights3 = {{false, false, true, true },
                				{false, false, true, true },
                				{true, true, false, true },
                				{true, true, true, false}};
		
		boolean[][] flights = {{false, false, true,  true },                     
								{false, false, true,  true },                         
								{true,  true,  false, true },                         
								{true,  true,  true,  false}};
		
		
		int[] lits1 = {1,2,3}; // {𝑥1,𝑥2,𝑥3}  
		int[] lits2 = {-1,2,3}; // {¬𝑥1,𝑥2,𝑥3}   
		boolean[] assign1 = {false, false, false, false};   
		boolean[] assign2 = {false, false, true, true};    
		boolean[] assign3 = {false, true, false, false};
		int[][] cnf = {{1,-2}, {-1, 2, 3}, {-3, 2}};
		
		//System.out.println(evaluate(cnf, assign1));  //true  
		//System.out.println(evaluate(cnf, assign2));  // false
		
		int[][] cnf1 = atLeastOne(lits1);  
		int[][] cnf2 = atLeastOne(lits2); 
		
		System.out.println(evaluate(cnf1, assign1)); // false  
		System.out.println(evaluate(cnf1, assign2)); // true  
		System.out.println(evaluate(cnf1, assign3)); // true  
		System.out.println(evaluate(cnf2, assign1)); // true  
		System.out.println(evaluate(cnf2, assign2)); // true  
		System.out.println(evaluate(cnf2, assign3)); // false 
		
		
	}
	
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
			if (matrix==null) 
				return false;
			if (matrix.length==0)
			    return false;
			
			for(int i=0;i<=matrix.length-1;i++) {
				if(matrix.length!=matrix[i].length)
					return false;
			}
			return true; 
		}
		
		// task 2
		public static boolean isSymmetricMatrix(boolean[][] matrix) {
			//throw new UnsupportedOperationException("Not Implemented yet.");
			boolean isSymmetric = true;
			for(int i=0;i<matrix.length-1 & isSymmetric;i++) {
				for (int j=i+1;j<matrix.length & isSymmetric;j++) {
					if(matrix[j][i]!=matrix[i][j])
						return false;
				}
			} 
			return true; 
		}

		// task 3
		public static boolean isAntiReflexiveMatrix(boolean[][] matrix) {
			//throw new UnsupportedOperationException("Not Implemented yet.");
			for(int i=0;i<=matrix.length-1;i++) {
			    if(matrix[i][i]!= false)
					return false;
			}
			return true;
		}
		
		// task 4
		public static boolean isLegalInstance(boolean[][] matrix) {
			//throw new UnsupportedOperationException("Not Implemented yet.");	
			if(isSquareMatrix(matrix) & isSymmetricMatrix(matrix) & isAntiReflexiveMatrix(matrix))
				return true;
			return false; 
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
			for(int i=0;i<tour.length-1;i++) {
				if(!(flights[tour[i]][tour[i+1]] & flights[tour[tour.length-1]][tour[0]]))
					return false;
			}
			return true; 
		}
		
		// task 7
		public static boolean isSolution(boolean[][] flights, int[] tour) {
				
			if (flights.length != tour.length)
				throw new UnsupportedOperationException("Not Implemented yet.");
			else {
				if(isPermutation(tour) & (tour[0]==0) & hasLegalSteps(flights,tour))
					return true;
				else
					return false;
			}
		}
		
		// task 8
		public static boolean evaluate(int[][] cnf, boolean[] assign) {
			//throw new UnsupportedOperationException("Not Implemented yet.");	
			boolean res = true;
			for(int cluaseNum=0;cluaseNum<cnf.length & res;cluaseNum++) {
				res = res & evaluateClause(cnf[cluaseNum], assign);
			}
			return res;
		}
		public static boolean evaluateLiteral(int literal, boolean[] assign) {
			boolean literalValue;
			if(literal>0) 
				literalValue =assign[literal];
			else
				literalValue=!assign[-literal];
			return literalValue; 		
		}
		
		public static boolean evaluateClause(int[] clause, boolean[] assign) {
			boolean res = false;
			for(int literalidx =0;literalidx<clause.length & !res;literalidx++) {
				int literal = clause[literalidx];
				boolean literalValue = evaluateLiteral(literal, assign);
				res = res | literalValue;
			}
			return res;
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
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(assignment[map(i, j, n)]){
						tour[tourInd]=j;
						tourInd++;
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
			
			tour=decode(assignment, flights.length);
			if(isSolution(flights, tour))
				return tour; 
			else
				throw new UnsupportedOperationException("Iligal solution");
	        
		}
		
		// task20
		public static boolean solve2(boolean[][] flights) {
			throw new UnsupportedOperationException("Not Implemented yet.");		
		}
		
		public static int[][] notAtLeastOne(int[] lits) {
			//throw new UnsupportedOperationException("Not Implemented yet.");	
			int [][] cnf = new int[1][lits.length];
			for(int i=0;i<lits.length;i++) {
				cnf[0][i]=-lits[i];
			}
		
			return cnf; 	
		}
		
		public static int[] reverse(int[] array){
		    int[] reversedArray = new int[array.length];
		    for(int i = 1; i < array.length; i++){
		        reversedArray[i] = array[array.length - i ];
		    }
		    return reversedArray;	
		}
		
		
}
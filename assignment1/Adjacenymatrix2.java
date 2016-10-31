/**
 * 
 */

/**
 * @author Fisk
 *
 */
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Stack;

public class Adjacenymatrix {

	/**
	 * @param args
	 */
	 private int Vertices;
	 private int Edges;
	 private boolean[][] matrix;
	 private static int alphabetno = 26;
	 private static final String NEWLINE = System.getProperty("line.separator");
	 int depthbound = 1;
	  
     static int depth = 0;

     int maxDepth = 1;
	 boolean goalFound = false; 
	 public Adjacenymatrix(int vertices){
		 //make empty matrix with 26 vertices
		 if (vertices<0) throw new RuntimeException("Number of vertices must be greater than 0");
		 
		 this.Vertices = vertices;
		 this.Edges = 0;
		 this.matrix = new boolean[Vertices][Vertices];
		 diagonalMatrix();
	 }
	 
	 public int Vertices(){
		 return Vertices;
	 }
	 public int Edges(){
		 
		 return Edges;
	 }
	 
	 public void diagonalMatrix(){
		
		 for (int i = 0; i<26; i++){
			 
			 // cities cannot be adjacent to themselves
			 matrix[i][i] = false;
			 
		 }
		 
		 randomAssignment();
		 
	 }
	 
	 public void randomAssignment(){
		 
		 //populate remaining graph with 260 0's and 390 1's
		 
		 int lcount = 390;
		 
		 while (lcount>0){
		 
		 int x =  (int)(Math.random()*26);
		 int y =  (int)(Math.random()*26);
		 
		// System.out.println("This is x: " + x + "This is Y: " + y );
		 
		 if(x == y){
			 
			 matrix[x][y] = false;
		 }
		 
		 else if(matrix[x][y] == false){
			 
			 matrix[x][y] = true;
			 
			 lcount--;
			 
		 }
		 
		 }
		 
		 
		 
		/* for (int i = 0; i<26; i++){
			 
			 for (int j = 0 ; j<26; j++){
				 double random = Math.random();
			if (i==j){
					 matrix[i][i] = false;
					 
				 }
				 
		
				 
		 else if(random < 0.5 && ocount != 0){
			 
			 ocount --;
			 matrix[i][j]= false;
			 
		 		}
		 else if (random > 0.5 && lcount!=0){
			 
			 lcount --;
			 
			 matrix[i][j] = true;
			 
		 }
		 else if (random < 0.5 && ocount == 0 ){
			 
			 matrix[i][j] = true;
			 
			 lcount --;
			 
		 }
		 else if (random > 0.5 && lcount == 0 ){
			 
			 matrix[i][j] = false;
			 
			 lcount --;
			 
		 }	
			
			 }
			 
			 //
		 
		 }*/
		 
	 }
	 public Iterable<Integer> matrix(int v) {
	        return new matrixIterator(v);
	    }

	    // support iteration over graph vertices
	    private class matrixIterator implements Iterator<Integer>, Iterable<Integer> {
	        private int v;
	        private int w = 0;

	        matrixIterator(int v) {
	            this.v = v;
	        }

	        public Iterator<Integer> iterator() {
	            return this;
	        }

	        public boolean hasNext() {
	            while (w < Vertices) {
	                if (matrix[v][w]) return true;
	                w++;
	            }
	            return false;
	        }

	        public Integer next() {
	            if (!hasNext()) {
	                throw new NoSuchElementException();
	            }
	            return w++;
	        }

	        public void remove()  {
	            throw new UnsupportedOperationException();
	        }
	    }
	 public String toString() {
	        StringBuilder s = new StringBuilder();
	        s.append(Vertices + " " + Edges + NEWLINE);
	        for (int v = 0; v < Vertices; v++) {
	            s.append(v + ": ");
	            for (int w : matrix(v)) {
	                s.append(w + " ");
	            }
	            s.append(NEWLINE);
	        }
	        return s.toString();
	    }
	
	 
	 public void dfs(){
		 
		 //Depth-first searching of the adjacency matrix
		 
		 Stack<Integer> search = new Stack<Integer>();
		 search.push(0);
		 //int level1;
		 //int level2;
		 //int level3;
		 //Build a path to iterate
		 //int swap;
		 for(int i=0; i<26 ; i++){
			 
			 
			 for (int j=0; j<26 ; j++){
			 
			//System.out.println("I: " + i + "J: " + j);	 
			// Print the system state for debugging
			 if (matrix[i][j] == true && j == 25){
				 
				 System.out.println("Found the city: Z");
				 //search.push(25);
				 while(!search.isEmpty()){
					 
					 System.out.println(search.pop());		
					 
				 
				
				 }
				 System.exit(0);
			 }	 
			 if(matrix[i][j] == true){
				 
				 if(!search.contains(j)){
				 System.out.println("Traversed: " + j);
				 search.push(j);
				 i = j;
				 j = 0;
				 }
				 
			 }
			 
			 if (j == 25 && matrix[i][j] != true){
				 
				 j = (Integer)search.pop();
				 
			 }
		
		 }
		 
		 }
	 }
	 
	public void bfs(){
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		
		for (int row=0 ; row<26; row++){
			
			
			
			for (int column = 0; column < 26 ; column++){
				
				 if (matrix[row][column] == true && column == 25){
					 
					 System.out.println("Found the city Z:");
					 System.exit(0);
					 
				 }
				
				if(matrix[row][column] == true){
					
					if(!queue.contains(column)){
					
					queue.add(column);
					}
					
				}
				
				
				
			}
			
			row = queue.remove();
			
		}
		
		
		
		
	}
	 
	/*public void ids(){
	
	
	int moves = 0;
	//PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
	Stack<Integer> search = new Stack<Integer>();
	int statesave = 0;
	search.push(0);
	matrix[0][25] = false;
	for (int row=0 ; row < 26; row++){
		
		
		
		for (int column = 0; column < 26 ; column++){
			
			if (matrix[row][column] == true && column == 25){
				 
				 System.out.println("Found the city Z:");
				 System.exit(0);
				 
			 }	
			if (depthbound == moves){
				
				statesave = (Integer)search.pop();
				
				System.out.println(statesave);
				
				//row = (Integer)search.peek();
				
				
				column = statesave +1;
				
				if (column == 24){
					
					if(search.peek() != 0 ){
					statesave = (Integer)search.pop();
					
					row = (Integer)search.peek();
					
					column = statesave +1;
					}
				
					else{
						
						row = 0;
						
						column = statesave + 1;
					}
					
				}
				
				moves -- ;
				
			}
			
			if(depthbound > moves){
				
				if(matrix[row][column] == true){
					 
					 if(!search.contains(column)){
					 System.out.println("Traversed: " + column);
					 search.push(column);
					 row = column;
					 column = 0;
					 moves++;
					 }
					 
				 }
				
		
				
			}
			if(depthbound < moves){
				
				
				depthbound++;
				
				System.out.println("ROUND COMPLETED: DEPTH = " + depthbound);
				search.clear();
				moves = 0;
				row = 0;
				
				column = 0;
				
				
			}
			
		}
		
		
		
	}*/	
		
    public void depthLimitedSearch(int source, int goal)
    {
        Stack<Integer> stack;

     

        while(!goalFound){
        
        int element, destination = 1;

        int[] visited = new int[26];
        stack = new Stack<Integer>();
        stack.push(source);

        depth = 0;
        
        
        
      
        System.out.println("\nAt Depth " + maxDepth);

        System.out.print(source + "\t");

    
        
        while (!stack.isEmpty())

        {

            element = stack.peek();

            while (destination <= 25)

            {

                if (depth < maxDepth)

                {

                    if (matrix[element][destination] == true)

                    {

                        stack.push(destination);

                        visited[destination] = 1;

                        System.out.print(destination + "\t");

                        depth++;

                        if (goal == destination)

                        { 

                            goalFound = true;

                            return;

                        }

                        element = destination;

                        destination = 1;

                        continue;

                    }

                } else 

                {

                    break;

                }

                destination++;

            }

            destination = stack.pop() + 1;

            depth--;

        }
        maxDepth++;
        }
        
    }	
		
		
		
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Adjacenymatrix test = new Adjacenymatrix(alphabetno);
		System.out.println(test.toString());
		
		//test.dfs();
		//test.bfs();
		//test.ids();
		
		
		test.depthLimitedSearch(0, 25);
		System.out.println("\nGoal Found at depth " + depth);
		
		
	}

}

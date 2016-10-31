import java.util.ArrayList;
import java.util.List;

public class Test {
	static int startx;
	static int starty;
	static Position startnode;
	 static City[][] rooms = new City[100][100];
	 static List<City> visitedList = new ArrayList<City>();
	 private static boolean[][] matrix;
	 
	 
	 public static void diagonalMatrix(){
		 matrix = new boolean[26][26];
		 for (int i = 0; i<26; i++){
			 
			 // cities cannot be adjacent to themselves
			 matrix[i][i] = false;
			 
		 }
		 
		 randomAssignment();
		 
	 }
	 
 public static void randomAssignment(){
		 
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
 }
	
	public static void createCities(){
		
		 for (int i = 0; i < 26 ; i++){
					 
					 int x =  (int)(Math.random()*100);
					 int y =  (int)(Math.random()*100);
					 
					 if (rooms[x][y] == null && i > 0){
						 
						 rooms[x][y] = new City(x, y, i);
						 
						 System.out.println("City Generated at :" + x + " " + y);
						 
						 
					 }
					 
					 if (i == 0){
						 
						 rooms[x][y] = new City(x, y, i);
						 
						 startx = x;
						 
						 starty = y;
					 }
				 }
		 startnode = new Position(startx, starty);
		 putitallTogether();
		// System.out.println("Start Position: " + startnode.x + " " startnode.y);
				 
			 }
	
	public static void putitallTogether(){
		
		City temp;
		int k;
		int adjcityno;
		for (int i = 0 ; i<100 ; i++){
			
			
			for (int j = 0 ; j <100 ; j++){
				
				if (rooms[i][j] != null){
					
					
					temp = rooms[i][j];
					
					k = temp.number;
					
					for (int column = 0; column <26 ; column++){
						
						
						if(matrix[k][column]== true){
							
							adjcityno = column;
							
							input(adjcityno, temp);
							
							
							
						}
						
					}
					
					
				}
				
				
				
			}
			
			
		}
		
		
		
	}
	
	public static void input(int adjcityno, City temp){
		

		for (int p = 0 ; p < 100; p++){
			
			for (int y = 0; y < 100; y++){
				
				if (rooms[p][y] != null && rooms[p][y].number == adjcityno){
					
					if (!rooms[p][y].adjacencyList.contains(temp.current))
					rooms[p][y].adjacencyList.add(temp.current);
					
					for(int i = 0; i<rooms[p][y].adjacencyList.size(); i++){
						
						System.out.println(rooms[p][y].adjacencyList.get(i).x + " " +rooms[p][y].adjacencyList.get(i).y );
						
						
					}
					
				}
				
			}
			
			
		}
		
	}
	
	public static void main(String[] args) {
		
	
		
		
		
		///DepthFirstSearch dfs = new DepthFirstSearch(startNode);
		//dfs.dfs();
		
		//BreadthFirstSearch bfs = new BreadthFirstSearch(startNode);
		//bfs.bfs();
		
		//IterativeDeepeningSearch ids = new IterativeDeepeningSearch(startNode);
		//ids.ids();
		
	//	UniformCostSearch uniform = new UniformCostSearch(startNode);
	//	uniform.uniform();
		diagonalMatrix();
		createCities();
		
		
		
		//GreedyBestFirst greedy = new GreedyBestFirst(startnode, rooms, visitedList);
		//greedy.greedy();
		
		Astar aStar = new Astar(startnode, rooms, visitedList);
		aStar.astar();
		
	}

}

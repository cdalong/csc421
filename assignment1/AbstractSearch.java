
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class AbstractSearch {
	int startx, starty;
	protected Position startNode;
	protected City[][] rooms = new City[100][100];
	protected List<City> visitedList = new ArrayList<City>();
	
	public AbstractSearch() {
		this.startNode = new Position(startx, starty);
	}
	
	public void createRooms(){
		this.createRooms("input/maze.txt");
	}
	
	public void createRooms(String fileName){
		
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
		 
	 }
					
	
	
	
	
	/*
	 * Prints the output to file.
	 * Each algorithm's output place in distinct files.
	 * File will place under output/alg.txt file.
	 * 
	 */
	public void printSolution(String alg, City r){
		File file = new File("output/"+alg+".txt");
		PrintWriter pw;
		try {
			pw = new PrintWriter(file);
			pw.append("Solution Path:\n" );
			int totalCost = 1;
			totalCost = printSolutionPath(r, pw, totalCost);
			pw.append("Solution Cost: "+totalCost+"\n");
			
			pw.append("Expanded Path\n");
			printVisited(pw, visitedList);
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private void printVisited(PrintWriter pw, List<City> visited) {
		for (City room : visited) {
			pw.append("x: "+(room.current.x+1)+"\ty: "+(room.current.y+1)+"\n");
		}
	}


	public int printSolutionPath(City r, PrintWriter pw, Integer totalCost){
		pw.append("x: "+(r.current.x+1)+"\ty: "+(r.current.y+1)+"\n");
		if(r.parent != null)
			totalCost = printSolutionPath(rooms[r.parent.x][r.parent.y], pw, ++totalCost);
		return totalCost;
	}
}
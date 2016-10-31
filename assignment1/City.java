import java.util.ArrayList;
//import java.util.List;

public class City {

	Position parent;
	final Position current;
	boolean goal;
	int number;
	double cost, Euclidean;
	boolean visited = false;
	int isave =0;
	Position closest = null;
	ArrayList<Position> adjacencyList;
	
	
	public City(int x, int y, int number){
		this.current = new Position(x, y);
		cost = 0;
		this.number = number;
		this.adjacencyList = new ArrayList<Position>();
		Euclidean = Math.sqrt((Math.pow((26-x), 2)+Math.pow((26-y), 2)));
		if (number == 25){
			
			goal = true;
		}
	}
	
	public boolean isAdjacent(City city){
		
		return false;
	}
	
	public Position findclosest(){
		
		
		double smallest = 500;
		
		
		for (int i = 0; i< adjacencyList.size(); i++){
		
		Euclidean = Math.sqrt((Math.pow(Math.abs((current.x-adjacencyList.get(i).x)), 2)+Math.pow(Math.abs((current.y-adjacencyList.get(i).y)), 2)));
		
		if (Euclidean < smallest){
			
			smallest = Euclidean;
			
			isave= i; 
		}
		
		}
		
		if (isave == adjacencyList.size()){
			
			return closest;
			
		}
		
		closest =  new Position(adjacencyList.get(isave).x, adjacencyList.get(isave).y);
		
		
		
		return closest; 
		
		
	}
	
	public void remove(){
		
		adjacencyList.remove(isave);
		
	}
}
import java.util.ArrayList;
import java.util.List;

public class Astar extends AbstractSearch {


		public Astar(Position startNode, City[][] rooms, List<City> visitedList) {
			this.startNode = startNode;
			this.rooms = rooms;
			this.visitedList = visitedList;
			//createRooms();
		}	
	
	public void astar(){
		ArrayList<City> queue = new ArrayList<City>();
		queue.add(rooms[startNode.x][startNode.y]);
		City closest = null;
		while(!queue.isEmpty()){
		
			City r = queue.remove(0);
			double cost = 0;
			
			closest = (rooms[r.findclosest().x][r.findclosest().y]);
			
			while(closest.visited == true){
				r.remove();
				closest = (rooms[r.findclosest().x][r.findclosest().y]);
				
				}
			
			if(r.parent != null){
				
				cost = rooms[r.parent.x][r.parent.y].cost+1+r.Euclidean;
			}
			System.out.println("City x-y:"+r.current.x+"-"+r.current.y);
			visitedList.add(r);
			r.visited = true;
			if (r.goal) {
				//printSolution("astar", r);
				
				System.out.println("Cost: " + cost + " Astar Completed");
				
				System.exit(0);
				return;
			}
			
			if(!visitedList.contains(rooms[r.findclosest().x][r.findclosest().y]) && !queue.contains(rooms[r.findclosest().x][r.findclosest().y])){
				
				
				
				queue.add(closest);
				
				closest.parent = r.current;
				
				rooms[r.current.x][r.current.y].cost = cost;
				
			}
		
	}
	}
}


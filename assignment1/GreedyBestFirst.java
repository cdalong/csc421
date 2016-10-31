
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class GreedyBestFirst extends AbstractSearch {
	public GreedyBestFirst(Position startNode, City[][] rooms, List<City> visitedList) {
		this.startNode = startNode;
		this.rooms = rooms;
		this.visitedList = visitedList;
		
	}
	
	public void greedy(){
		
		System.out.println("Startnodes: " + startNode.x + " " + startNode.y);
		
		List<City> queue = new ArrayList<City>();
		queue.add(rooms[startNode.x][startNode.y]);
		City closest;
		while(!queue.isEmpty()){
			/*Collections.sort(queue, new Comparator<City>() {

				@Override
				public int compare(City o1, City o2) {
					return o1.Euclidean>o2.Euclidean?1:-1;
				}
			});*/
			
			City r = queue.remove(0);
			System.out.println("City x-y:"+r.current.x+"-"+r.current.y);
			
			System.out.println(r.number);
			if (r.goal) {
				//printSolution("greedy", r);
				
				System.out.println("Found the Goal ");
				
				System.exit(0);
				
				return;
			}
			
			visitedList.add(r);
			r.visited = true;
			closest = (rooms[r.findclosest().x][r.findclosest().y]);
			while(closest.visited == true){
			r.remove();
			closest = (rooms[r.findclosest().x][r.findclosest().y]);
			
			}
			
			if(!visitedList.contains(rooms[r.findclosest().x][r.findclosest().y]) && !queue.contains(rooms[r.findclosest().x][r.findclosest().y])){
				
				
				closest.parent = r.current;
				
				queue.add(closest);
				
				
			}
			
			
			
		}
	}

}

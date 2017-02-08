import java.util.ArrayList;
import java.util.List;
import java.util.Stack;




public class WeightedGraph {
	
	private int numberOfNodes;
	private final List<Nodes>[] adjList;
	
	private final List<Path> resultList = (List<Path>) new ArrayList<Path>();


	@SuppressWarnings("unchecked")
	public WeightedGraph(int numberOfNodes) 
	{
		this.numberOfNodes = numberOfNodes;
		adjList = (List<Nodes>[]) new ArrayList[numberOfNodes+1];
		for (int i = 0; i < numberOfNodes; i++) {
			adjList[i] = new ArrayList<Nodes>();
		}
	}
	
	public List<Path> getResultList() {
		return resultList;
	}

	public void connectTwoNodes(Nodes node2)
	{
		int node1 = node2.getCurrNode();
		adjList[node1].add(node2);
	}

	public List<Nodes>[] getAdjList() {
		return adjList;
	}
	
	Stack<Integer> stack = new Stack<Integer>();
	int count = 0;
	public void findKshortestPath(List<Nodes>[] adjList, int source, int destination)
	{
		if(source == destination)
		{
			count++;
			printStack(stack, destination, count);
			return;
		}
		if(!stack.contains(source)){
			stack.push(source);
			if(adjList[source] != null)
			{
				for(Nodes i : adjList[source])
				{
					if(!stack.contains(i.getNextNode()))
					{
						findKshortestPath(adjList, i.getNextNode(), destination);
					}
					
				}
				
				stack.pop();
				
				
			}
			
		}	
		
	}
	
	private void printStack(Stack<Integer> stack, int destination, int count) {
		
		String path = "";
		Object[] array = stack.toArray();
		
		for (int i = 0; i < array.length; i++) {
			path += (array[i]+",");
		}
		path += (destination);
		double distance = distanceOfPath(path);
		Path pt = new Path(distance, array);
		
		resultList.add(pt);
	}
	
	private double distanceOfPath(String path)
	{
		double sumOfDistance = 0.0;
		String[] sets = path.split(",");
		Integer[] paths = new Integer[sets.length];
		for (int i = 0; i < sets.length; i++) {
			 paths[i] =  Integer.parseInt(sets[i]);
		}

		for (int i = 0; i < paths.length-1; i++) 
		{
			for (int j = 0; j < adjList[paths[i]].size(); j++) 
			{
				if(adjList[paths[i]].get(j).getNextNode() == paths[i+1])
				{
					sumOfDistance += adjList[paths[i]].get(j).getDistance();
				}
			}
		}
		return sumOfDistance;
	}
}



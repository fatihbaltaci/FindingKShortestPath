
public class Nodes {

	private int currNode;
	private int nextNode;
	private double distance;
	
	/**
	 * Constructor
	 */
	public Nodes(int currNode, int nextNode, double distance) {
		super();
		this.currNode = currNode;
		this.nextNode = nextNode;
		this.distance = distance;
	}
	
	/**
	 * Getters
	 */
	public int getCurrNode() {
		return currNode;
	}
	public int getNextNode() {
		return nextNode;
	}
	public double getDistance() {
		return distance;
	}
	
	@Override
	public String toString()
	{
		return "("+currNode +"->"+ nextNode+")" +" = " + distance;
		
	}
}


public class Path {
	
	private double distance;
	private Object[] path;
	
	
	public Path(double distance, Object[] path) {
		this.distance = distance;
		this.path = path;
	}
	
	public double getDistance() {
		return distance;
	}

	@Override
	public String toString()
	{
		String ret="";
		ret += String.format("%-15.5f",distance);
		
		for (int i = 0; i < path.length; i++) {
			ret += String.format("%-5d", path[i]);
		}
		return ret;
	}

}

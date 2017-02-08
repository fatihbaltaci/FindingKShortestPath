import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Shortest Path Algorithm
 * 
 * @author Fatih Baltaci
 ************************/
public class Main {
	
	

	public static void main(String args[]) {

		Scanner inputReader = null;
		PrintWriter outWriter = null;

		try {
			inputReader = new Scanner(new File("input.txt"));
			outWriter = new PrintWriter(new File("output.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		int source, destination;
		int currNode=0, nextNode=0;
		double distance=0.0;
		
		
		//First Line
		String a = inputReader.nextLine();
		String[] a1 = a.split(",");
		String[] a2 = a1[0].split(":");
		String[] a3 = a1[1].split(":");
		
		source = Integer.parseInt(a2[1]);
		destination = Integer.parseInt(a3[1]);
		
		
		Nodes[] n = new Nodes[1000];
		int count = 0;
		int lineSize = 0;
		while(inputReader.hasNext())
		{
			String s1 = inputReader.nextLine();
			String[] s2 = s1.split("\\.");
			String s7="";
			for (int i = 1; i < s2.length; i++) {
				 s7 += s2[i];
				 if(!(i == s2.length-1))
					 s7 += ".";
			}
			
			String s3 = s7.trim().replaceAll("[()]", "#");
			String[] s4 = s3.split(",");
			String s6 = s3.replaceAll(",", "");
			String[] s5 = s6.split("#");
			
			currNode = Integer.parseInt(s2[0]);
			
			for (int i = 0, j= 0; j <s4.length; i++) {
				
				if((s4[0].contains("##")))
				{
					break;
				}
					
				
				nextNode = Integer.parseInt(s5[i]);
				distance = Double.parseDouble(s5[i+1]);
				n[count] = new Nodes(currNode, nextNode, distance);
			i++;
				count++;
				j++;
			}
	
			lineSize++;
		}
		WeightedGraph wg = new WeightedGraph(lineSize+1);
		
		for (int i = 0; i < count; i++) {
			wg.connectTwoNodes(n[i]);
		}
		
		
		
		
		wg.findKshortestPath(wg.getAdjList(), source, destination);
		
		Collections.sort(wg.getResultList(), customComparator);
		
		for (int j = 0; j < wg.getResultList().size(); j++)
		{
			 outWriter.println((j+1)+". Shortest Path:   "+wg.getResultList().get(j));
		}
		
		inputReader.close();
		outWriter.close();

	}

	public static final Comparator<Path> customComparator = new Comparator<Path>() {
		@Override
		public int compare(Path o1, Path o2) {
			if (o1.getDistance() == o2.getDistance())
				return 0;
			else if (o1.getDistance() < o2.getDistance())
				return -1;
			else
				return 1;
		}

	};

}

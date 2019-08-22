package practice.graphs;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SomeClass {

	public static void main(String[] args) {
		GraphPractice graphs  =new GraphPractice();
		//		adding vertices
		graphs.addVertex("1");
		graphs.addVertex("2");
		graphs.addVertex("3");
		graphs.addVertex("4");
		graphs.addVertex("5");
		graphs.addVertex("6");
//		adding edges
		graphs.addEdge("1","3");
		graphs.addEdge("1","4");
		graphs.addEdge("3","4");
		graphs.addEdge("5","3");
		graphs.addEdge("4","5");
		graphs.addEdge("2","3");
		graphs.addEdge("2","5");
		graphs.addEdge("1","6");
//		display method to dispaly all adjacent vertices of a vertex
//		graphs.displayAdjacent("1");
//		graphs.displayAdjacent("2");
//		graphs.displayAdjacent("3");
//		removing a edge between 1 and 3 vertex
		//graphs.removeEdge("3","1");
//		display method to dispaly all adjacent vertices of a vertex
//		graphs.displayAdjacent("3");
//		to display all vertices of a graph
//		graphs.displayVertex();
//		removing vertex
		//graphs.removeVertex("3");
//		to display all vertices of a graph
//		graphs.displayVertex();
//		System.out.println("breadth first traversel");
//		graphs.BreadthFirstTraversel(graphs, "2");
		System.out.println("depth first search");
		graphs.DepthFirstTraversel(graphs, "1");
		System.out.println("breadth first traversel");
		graphs.BFT(graphs, "1");
		
	}
}

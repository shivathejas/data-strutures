package practice.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class GraphPractice {

	Map<Vertex,List<Vertex>> adjVertex = new HashMap<Vertex, List<Vertex>>();

	public GraphPractice() {
		super();
	}

	public GraphPractice(Map<Vertex, List<Vertex>> adjVertex) {
		super();
		this.adjVertex = adjVertex;
	}

	public Map<Vertex, List<Vertex>> getAdjVertex() {
		return adjVertex;
	}

	public void setAdjVertex(Map<Vertex, List<Vertex>> adjVertex) {
		this.adjVertex = adjVertex;
	}
	public void addVertex(String value) {
		adjVertex.putIfAbsent(new Vertex(value), new ArrayList<>());
	}
	public void addEdge(String value1, String value2) {
		Vertex v1 = new Vertex(value1);
		Vertex v2 = new Vertex(value2);
		adjVertex.get(v1).add(v2);
		adjVertex.get(v2).add(v1);
	}
	public void removeVertex(String value) {
		Vertex vertex = new Vertex(value);
		adjVertex.values().stream().forEach(e -> e.remove(vertex));
		adjVertex.remove(vertex);
	}
	public void removeEdge(String value1,String value2) {
		Vertex v1 = new Vertex(value1);
		Vertex v2 = new Vertex(value2);
		adjVertex.get(v1).remove(v2);
		adjVertex.get(v2).remove(v1);
	}
	public List<Vertex> getAdjvertex(String value){
		return adjVertex.get(new Vertex(value));
	}
	public void DepthFirstTraversel(GraphPractice graph,String root) {
		Set<String> visited = new LinkedHashSet<String>();
		Stack<String> stack  = new Stack<>();
		stack.add(root);
		while(!stack.isEmpty()) {
			String vertex = stack.pop();
			if(!visited.contains(vertex)) {
				visited.add(vertex);
				for(Vertex v: graph.getAdjvertex(vertex)) {
					stack.push(v.label);
				}
			}
		}
		Iterator<String> iterator = visited.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next()+" ");
		}
		System.out.println();
	}
	public void BFT(GraphPractice graph,String root) {
		Set<String> visited = new LinkedHashSet<String>();
		Queue<String> queue = new LinkedList<String>();
		visited.add(root);
		queue.add(root);
		while(!queue.isEmpty()) {
			String vertex = queue.poll();
			for(Vertex v: graph.getAdjvertex(vertex)) {
				if(!visited.contains(v.label)) {
					visited.add(v.label);
					queue.add(v.label);
				}
			}
		}
		Iterator<String> iterator = visited.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next()+" ");
		}
		System.out.println();
	}
	
//	public static void main(String[] args) {
//		GraphPractice graphs  =new GraphPractice();
//		//		adding vertices
//		graphs.addVertex("1");
//		graphs.addVertex("2");
//		graphs.addVertex("3");
//		graphs.addVertex("4");
//		graphs.addVertex("5");
////		adding edges
//		graphs.addEdge("1","3");
//		graphs.addEdge("1","4");
//		graphs.addEdge("3","4");
//		graphs.addEdge("5","3");
//		graphs.addEdge("4","5");
//		graphs.addEdge("2","3");
//		graphs.addEdge("2","5");
////		display method to dispaly all adjacent vertices of a vertex
////		graphs.displayAdjacent("1");
////		graphs.displayAdjacent("2");
////		graphs.displayAdjacent("3");
////		removing a edge between 1 and 3 vertex
//		//graphs.removeEdge("3","1");
////		display method to dispaly all adjacent vertices of a vertex
////		graphs.displayAdjacent("3");
////		to display all vertices of a graph
////		graphs.displayVertex();
////		removing vertex
//		//graphs.removeVertex("3");
////		to display all vertices of a graph
////		graphs.displayVertex();
////		System.out.println("breadth first traversel");
////		graphs.BreadthFirstTraversel(graphs, "2");
//		System.out.println("depth first search");
//		graphs.DepthFirstTraversel(graphs, "1");
//		System.out.println("breadth first traversel");
//		graphs.BFT(graphs, "1");
//	}
}

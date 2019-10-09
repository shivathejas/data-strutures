package practice.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Graphs{
	
	Map<Vertex,List<Vertex>> adjVertex = new HashMap<Vertex, List<Vertex>>();
	public Graphs() {
		super();
	}
	
	public Graphs(Map<Vertex, List<Vertex>> adjVertex) {
		super();
		this.adjVertex = adjVertex;
	}

	public Map<Vertex, List<Vertex>> getAdjVertex() {
		return adjVertex;
	}

	public void setAdjVertex(Map<Vertex, List<Vertex>> adjVertex) {
		this.adjVertex = adjVertex;
	}
	public void addVertex(String label) {
		Vertex vertex = new Vertex(label);
		List<Vertex> list = new ArrayList<Vertex>();
		adjVertex.putIfAbsent(vertex,list);
	}
	public void addEdge(String label1,String label2) {
		Vertex v1 = new Vertex(label1);
		Vertex v2 = new Vertex(label2);
		adjVertex.get(v1).add(v2);
		adjVertex.get(v2).add(v1);
	}
	public void removeVertex(String label) {
		Vertex v = new Vertex(label);
		adjVertex.values().stream().forEach(e -> e.remove(v));
		adjVertex.remove(new Vertex(label));
	}
	public void removeEdge(String label1,String label2) {
		Vertex v1 = new Vertex(label1);
		Vertex v2 = new Vertex(label2);
		List<Vertex> l1 = adjVertex.get(v1);
		List<Vertex> l2 = adjVertex.get(v2);
		if(l1!=null) {
			l1.remove(v2);
		}
		if(l2 != null) {
			l2.remove(v1);
		}
	}
	public void displayAdjacent(String label) {
		Vertex vertex = new Vertex(label);
		for(Vertex v : adjVertex.get(vertex)) {
			System.out.print(v.label+"->");
		}
		System.out.println();
	}
	public void displayVertex() {
		System.out.println("vertex in Map");
		for(Map.Entry<Vertex, List<Vertex>> entry: adjVertex.entrySet()) {
			System.out.print(entry.getKey().label+" ");
		}
		System.out.println();
	}
	public List<Vertex> getAdjVertex(String label){
		List<Vertex> adjList = adjVertex.get(new Vertex(label));
		return adjList;
	}
	public void BreadthFirstTraversel(Graphs graph,String root) {
		Set<String> visited = new  LinkedHashSet<String>();
		Queue<String> queue = new  LinkedList<>();
		visited.add(root);
		queue.add(root);
		while(!queue.isEmpty()) {
			String label = queue.poll();
			for(Vertex v: graph.getAdjVertex(label)) {
				if(!visited.contains(v.label)) {
					visited.add(v.label);
					queue.add(v.label);
				}
			}
		}
		Iterator<String> iterator = visited.iterator();
		while(iterator.hasNext()){
			System.out.print(iterator.next()+" ");
		}
		System.out.println();
	}
	public void DepthFirstTraversel(Graphs graphs,String root) {
		Set<String> visited = new LinkedHashSet<>();
		Stack<String> stack = new Stack<>();
		stack.push(root);
		while(!stack.empty()) {
			String vertex  = stack.pop();
			if(!visited.contains(vertex)) {
				visited.add(vertex);
				int Q = visited.size();
				
				for(Vertex v: graphs.getAdjVertex(vertex)) {
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
	public static void main(String[] args) {
		Graphs graphs = new Graphs();
//		adding vertices
		graphs.addVertex("1");
		graphs.addVertex("2");
		graphs.addVertex("3");
		graphs.addVertex("4");
		graphs.addVertex("5");
//		adding edges
		graphs.addEdge("1","3");
		graphs.addEdge("1","4");
		graphs.addEdge("3","4");
		graphs.addEdge("5","3");
		graphs.addEdge("4","5");
		graphs.addEdge("2","3");
		graphs.addEdge("2","5");
//		display method to dispaly all adjacent vertices of a vertex
		graphs.displayAdjacent("1");
		graphs.displayAdjacent("2");
		graphs.displayAdjacent("3");
//		removing a edge between 1 and 3 vertex
		//graphs.removeEdge("3","1");
//		display method to dispaly all adjacent vertices of a vertex
		graphs.displayAdjacent("3");
//		to display all vertices of a graph
		graphs.displayVertex();
//		removing vertex
		//graphs.removeVertex("3");
//		to display all vertices of a graph
		graphs.displayVertex();
		System.out.println("breadth first traversel");
		graphs.BreadthFirstTraversel(graphs, "1");
		System.out.println("depth first search");
		graphs.DepthFirstTraversel(graphs, "1");


	}
}
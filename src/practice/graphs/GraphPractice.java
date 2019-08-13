package practice.graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class GraphPractice {

	Map<Vertex,List<Vertex>> adjVertex = new LinkedHashMap<Vertex, List<Vertex>>();
	public void addVertex(String label) {
		adjVertex.putIfAbsent(new Vertex(label), new ArrayList());
	}
	public void addEdge(String label1,String label2) {
		Vertex v1 = new Vertex(label1);
		Vertex v2 = new Vertex(label2);
		adjVertex.get(v1).add(v2);
		adjVertex.get(v2).add(v1);
	}
	public void removeVertex(String label1) {
		adjVertex.values().stream().forEach((e)-> e.remove(new Vertex(label1)));
		adjVertex.remove(new Vertex(label1));
	}
	public void removeEdge(String label1,String label2) {
		Vertex v1 = new Vertex(label1);
		Vertex v2 = new Vertex(label2);
		adjVertex.get(v1).remove(v2);
		adjVertex.get(v2).remove(v1);
	}
	public static void main(String[] args) {
		
	}
}

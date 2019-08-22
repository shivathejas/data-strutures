package practice.dijkstra;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class Dijkstra {

	public static Graph calculateShortestPathFromSource(Graph graph,Node source) {
		source.setDistance(0);
		Set<Node> setteledNode = new LinkedHashSet<Node>();
		Set<Node> unsetteledNode = new LinkedHashSet<Node>();
		
		unsetteledNode.add(source);
		while(unsetteledNode.size() != 0) {
			Node currentNode = getLowestDistanceNode(unsetteledNode);
			unsetteledNode.remove(currentNode);
			for(Entry<Node, Integer> adjPair: currentNode.getAdjacentNodes().entrySet()) {
				Node adjacentNode = adjPair.getKey();
				Integer edgeWeight = adjPair.getValue();
				if(!setteledNode.contains(adjacentNode)) {
					calculateMinDistance(adjacentNode,edgeWeight,currentNode);
					unsetteledNode.add(adjacentNode);
				}
			}
			setteledNode.add(currentNode);
			
		}
		return graph;
	}
	public static Node getLowestDistanceNode(Set<Node> unsetteledNode) {
		Node lowestDistanceNode=null;
		Integer lowestDistance = Integer.MAX_VALUE;
		for(Node node: unsetteledNode) {
			int nodeDistance = node.getDistance();
			if(nodeDistance<lowestDistance) {
				lowestDistance=nodeDistance;
				lowestDistanceNode = node;
			}
		}
		return lowestDistanceNode;
	}
	public static void calculateMinDistance(Node evaluationNode,Integer edgeWeigh, Node sourceNode) {
		Integer sourceDistance = sourceNode.getDistance();
		if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
	        evaluationNode.setDistance(sourceDistance + edgeWeigh);
	        LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
	        shortestPath.add(sourceNode);
	        evaluationNode.setShortestPath(shortestPath);
	    }
	}
	public static void main(String[] args) {
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D"); 
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");
		 
		nodeA.addDestination(nodeB, 10);
		nodeA.addDestination(nodeC, 15);
		 
		nodeB.addDestination(nodeD, 12);
		nodeB.addDestination(nodeF, 15);
		 
		nodeC.addDestination(nodeE, 10);
		 
		nodeD.addDestination(nodeE, 2);
		nodeD.addDestination(nodeF, 1);
		 
		nodeF.addDestination(nodeE, 5);
		 
		Graph graph = new Graph();
		 
		graph.addNode(nodeA);
		graph.addNode(nodeB);
		graph.addNode(nodeC);
		graph.addNode(nodeD);
		graph.addNode(nodeE);
		graph.addNode(nodeF);
		 
		graph = Dijkstra.calculateShortestPathFromSource(graph, nodeA);
		Set<Node> nd = graph.getNodes();
		for(Node n: nd) {
			List<Node> listNode = n.getShortestPath();
			for(Node n2: listNode) {
				System.out.print(n2.getName()+"-"+n2.getDistance()+" ");
			}
			System.out.println();
		}
		
	}
}

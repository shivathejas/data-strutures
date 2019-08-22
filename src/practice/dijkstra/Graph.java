package practice.dijkstra;

import java.util.LinkedHashSet;
import java.util.Set;

public class Graph {

	Set<Node> nodes = new LinkedHashSet<Node>();
	
	public Set<Node> getNodes() {
		return nodes;
	}

	public void setNodes(Set<Node> nodes) {
		this.nodes = nodes;
	}

	public void addNode(Node node) {
		nodes.add(node);
	}
}

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Graph {

	private Map<Node, LinkedList<Node>> adjList;

	public Graph() {
		adjList = new HashMap<Node, LinkedList<Node>>();
	}

	private void addVertex(int vertex) {
		if (adjList != null) {
			adjList.put(new Node(vertex), new LinkedList<Node>());
		}

	}

	private void addEdge(int vertex, int edge) {
		if (adjList != null) {
			adjList.get(getNode(vertex)).add(new Node(edge));
		}
	}

	private Node getNode(int vertex) {
		Set<Node> adjNodes = adjList.keySet();

		Iterator it = adjList.keySet().iterator();
		while (it.hasNext()) {
			Node n = (Node) it.next();
			if (n.getId() == vertex) {
				return n;
			}
		}
		return null;
	}

	private void printAdjacencyList() {
		Iterator it = adjList.keySet().iterator();
		while (it.hasNext()) {
			Node vertex = (Node) it.next();
			System.out.print(vertex.getId() + ": ");
			LinkedList neighbours = adjList.get(vertex);
			Iterator edgeIterator = neighbours.iterator();
			while (edgeIterator.hasNext()) {
				Node edge = (Node) edgeIterator.next();
				System.out.print(" -> " + edge.getId());
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		Graph g = new Graph();
		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);
		g.addVertex(5);
		g.addEdge(1, 2);
		g.addEdge(1, 5);
		g.addEdge(2, 1);
		g.addEdge(2, 5);
		g.addEdge(2, 3);
		g.addEdge(2, 4);
		g.addEdge(3, 2);
		g.addEdge(3, 4);
		g.addEdge(4, 2);
		g.addEdge(4, 5);
		g.addEdge(4, 3);
		g.addEdge(5, 4);
		g.addEdge(5, 1);
		g.addEdge(5, 2);
		g.printAdjacencyList();

	}
}

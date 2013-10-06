import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph {

	private Map<Node, LinkedList<Node>> adjList;

	public Graph() {
		adjList = new HashMap<Node, LinkedList<Node>>();
	}

	public void addVertex(int vertex) {
		if (adjList != null) {
			adjList.put(new Node(vertex), new LinkedList<Node>());
		}

	}

	public void addEdge(int vertex, int edge) {
		if (adjList != null) {
			adjList.get(getNode(vertex)).add(new Node(edge));
		}
	}

	public Node getNode(int vertex) {
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

	public void setVertices(List<Node> nodeList) {
		Iterator nodeListIterator = nodeList.iterator();
		while (nodeListIterator.hasNext()) {
			adjList.put((Node) nodeListIterator.next(), new LinkedList<Node>());
		}
	}

	public void printAdjacencyList() {
		Iterator it = adjList.keySet().iterator();
		while (it.hasNext()) {
			Node vertex = (Node) it.next();
			System.out.print(vertex + ": ");
			LinkedList neighbours = adjList.get(vertex);
			Iterator edgeIterator = neighbours.iterator();
			while (edgeIterator.hasNext()) {
				Node edge = (Node) edgeIterator.next();
				System.out.print(" -> " + edge);
			}
			System.out.println();
		}
	}

	public LinkedList<Node> getEdges(Node node) {
		return adjList.get(node);
	}

	public Map<Node, LinkedList<Node>> getAdjacencyList() {
		return adjList;
	}

	public static void main(String[] args) {

		Graph g = new Graph();

		List<Node> nodeList = new ArrayList<Node>();

		Node firstNode = new Node(1);
		Node secondNode = new Node(2);
		Node thirdNode = new Node(3);
		Node fourthNode = new Node(4);
		Node fifthNode = new Node(5);
		nodeList.add(firstNode);
		nodeList.add(secondNode);
		nodeList.add(thirdNode);
		nodeList.add(fourthNode);
		nodeList.add(fifthNode);
		g.setVertices(nodeList);

		LinkedList<Node> firstNodeEdges = g.getEdges(firstNode);
		firstNodeEdges.add(thirdNode);
		firstNodeEdges.add(fourthNode);

		LinkedList<Node> secondNodeEdges = g.getEdges(secondNode);
		secondNodeEdges.add(thirdNode);
		secondNodeEdges.add(fourthNode);
		secondNodeEdges.add(fifthNode);

		LinkedList<Node> thirdNodeEdges = g.getEdges(thirdNode);
		thirdNodeEdges.add(firstNode);
		thirdNodeEdges.add(secondNode);

		LinkedList<Node> fourthNodeEdges = g.getEdges(fourthNode);
		fourthNodeEdges.add(firstNode);
		fourthNodeEdges.add(secondNode);

		LinkedList<Node> fifthNodeEdges = g.getEdges(fifthNode);
		fifthNodeEdges.add(secondNode);
		g.printAdjacencyList();

	}
}

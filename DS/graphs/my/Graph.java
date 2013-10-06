package graphs.my;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Graph.java
 * 
 * @author Git id: madan1988 (Madan Gopal)
 * 
 */
public class Graph {

	private Map<Node, LinkedList<Node>> adjList;

	/**
	 * Construct the Graph
	 */
	public Graph() {
		adjList = new HashMap<Node, LinkedList<Node>>();
	}

	/**
	 * Return the noce for the vertex. Mostly, should not be used. Node must be
	 * directly got from the map
	 * 
	 * @param vertex
	 * @return Node
	 */
	public Node getNode(final int vertex) {

		final Iterator<Node> it = adjList.keySet().iterator();
		while (it.hasNext()) {
			final Node n = it.next();
			if (n.getId() == vertex) {
				return n;
			}
		}
		return null;
	}

	/**
	 * Set the vertices
	 * 
	 * @param nodeList
	 */
	public void setVertices(final List<Node> nodeList) {
		final Iterator<Node> nodeListIterator = nodeList.iterator();
		while (nodeListIterator.hasNext()) {
			adjList.put(nodeListIterator.next(), new LinkedList<Node>());
		}
	}

	/**
	 * Print the Adjacency List
	 */
	public void printAdjacencyList() {
		final Iterator<Node> it = adjList.keySet().iterator();
		while (it.hasNext()) {
			final Node vertex = it.next();
			System.out.print(vertex + ": ");
			final LinkedList<Node> neighbours = adjList.get(vertex);
			final Iterator<Node> edgeIterator = neighbours.iterator();
			while (edgeIterator.hasNext()) {
				final Node edge = edgeIterator.next();
				System.out.print(" -> " + edge);
			}
			System.out.println();
		}
	}

	/**
	 * Return the Edges for a vertex
	 * 
	 * @param node
	 * @return LinkedList<Node>
	 */
	public LinkedList<Node> getEdges(final Node node) {
		return adjList.get(node);
	}

	/**
	 * Return the AdjacencyList map
	 * 
	 * @return adjList
	 */
	public Map<Node, LinkedList<Node>> getAdjacencyList() {
		return adjList;
	}

	/**
	 * Test using main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		final Graph g = new Graph();

		final List<Node> nodeList = new ArrayList<Node>();

		final Node firstNode = new Node(1);
		final Node secondNode = new Node(2);
		final Node thirdNode = new Node(3);
		final Node fourthNode = new Node(4);
		final Node fifthNode = new Node(5);
		nodeList.add(firstNode);
		nodeList.add(secondNode);
		nodeList.add(thirdNode);
		nodeList.add(fourthNode);
		nodeList.add(fifthNode);
		g.setVertices(nodeList);

		final LinkedList<Node> firstNodeEdges = g.getEdges(firstNode);
		firstNodeEdges.add(thirdNode);
		firstNodeEdges.add(fourthNode);

		final LinkedList<Node> secondNodeEdges = g.getEdges(secondNode);
		secondNodeEdges.add(thirdNode);
		secondNodeEdges.add(fourthNode);
		secondNodeEdges.add(fifthNode);

		final LinkedList<Node> thirdNodeEdges = g.getEdges(thirdNode);
		thirdNodeEdges.add(firstNode);
		thirdNodeEdges.add(secondNode);

		final LinkedList<Node> fourthNodeEdges = g.getEdges(fourthNode);
		fourthNodeEdges.add(firstNode);
		fourthNodeEdges.add(secondNode);

		final LinkedList<Node> fifthNodeEdges = g.getEdges(fifthNode);
		fifthNodeEdges.add(secondNode);
		g.printAdjacencyList();

	}
}

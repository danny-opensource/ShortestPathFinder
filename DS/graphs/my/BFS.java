package graphs.my;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * BFS.java
 * @author Git id: madan1988 (Madan Gopal)
 * 
 */
public class BFS {

	private Map<Node, LinkedList<Node>> adjList;
	Queue<Node> actingQ = new LinkedList<Node>();

	/**
	 * Perform BFS using this function. Pass the graph and the vertex (int
	 * variant)
	 * 
	 * @param g
	 * @param vertex
	 */
	public void performBFS(Graph g, int vertex) {
		final Node s = g.getNode(vertex);
		s.setColor(1);
		s.distance = 0;
		s.predecessor = null;

		actingQ.add(s);
		while (!actingQ.isEmpty()) {
			printQ();
			final Node u = actingQ.poll();
			u.setColor(1);
			System.out.println();
			System.out.println("u color is: " + u.getColor());
			final LinkedList<Node> adjNodes = adjList.get(u);
			final Iterator<Node> adjNodesIterator = adjNodes.iterator();
			while (adjNodesIterator.hasNext()) {
				final Node v = adjNodesIterator.next();
				System.out.println("v is: " + v);
				if (v.color == 0) {
					v.setColor(1);
					v.distance = u.distance + 1;
					v.predecessor = u;
					actingQ.add(v);
				}
			}
			u.setColor(2);
		}

	}

	/**
	 * Print the Active Queue at a point-in-time
	 */
	private void printQ() {
		System.out.println("Printing Q...");
		final Iterator<Node> it = actingQ.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.err.println();
	}

	/**
	 * Perform tests using main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		final BFS bfs = new BFS();
		final Graph g = new Graph();

		final List<Node> nodeList = new ArrayList<Node>();

		final Node firstNode = new Node(1);
		final Node secondNode = new Node(2);
		final Node thirdNode = new Node(3);
		final Node fourthNode = new Node(4);
		final Node fifthNode = new Node(5);
		final Node sixthNode = new Node(6);
		final Node seventhNode = new Node(7);
		final Node eigthNode = new Node(8);
		nodeList.add(firstNode);
		nodeList.add(secondNode);
		nodeList.add(thirdNode);
		nodeList.add(fourthNode);
		nodeList.add(fifthNode);
		nodeList.add(sixthNode);
		nodeList.add(seventhNode);
		nodeList.add(eigthNode);
		g.setVertices(nodeList);

		LinkedList<Node> nodeEdges = null;

		nodeEdges = g.getEdges(firstNode);
		nodeEdges.add(secondNode);
		nodeEdges.add(fifthNode);

		nodeEdges = g.getEdges(secondNode);
		nodeEdges.add(sixthNode);
		nodeEdges.add(firstNode);

		nodeEdges = g.getEdges(thirdNode);
		nodeEdges.add(sixthNode);
		nodeEdges.add(fourthNode);

		nodeEdges = g.getEdges(fourthNode);
		nodeEdges.add(thirdNode);
		nodeEdges.add(eigthNode);

		nodeEdges = g.getEdges(fifthNode);
		nodeEdges.add(firstNode);

		nodeEdges = g.getEdges(sixthNode);
		nodeEdges.add(secondNode);
		nodeEdges.add(thirdNode);
		nodeEdges.add(seventhNode);

		nodeEdges = g.getEdges(seventhNode);
		nodeEdges.add(sixthNode);
		nodeEdges.add(eigthNode);

		nodeEdges = g.getEdges(eigthNode);
		nodeEdges.add(fourthNode);
		nodeEdges.add(seventhNode);

		bfs.adjList = g.getAdjacencyList();
		bfs.performBFS(g, 2);

		final Iterator<Node> checkIt = bfs.adjList.keySet().iterator();
		while (checkIt.hasNext()) {
			final Node n = checkIt.next();
			System.out.println("Node: " + n.getId() + " -> Color: "
					+ n.getColor());
		}

	}

}

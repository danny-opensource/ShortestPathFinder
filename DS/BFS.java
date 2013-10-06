import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BFS {

	private Map<Node, LinkedList<Node>> adjList;
	Queue<Node> actingQ = new LinkedList<Node>();

	public void performBFS(Graph g, int vertex) {
		Node s = g.getNode(vertex);
		s.setColor(1);
		s.distance = 0;
		s.predecessor = null;

		actingQ.add(s);
		while (!actingQ.isEmpty()) {
			printQ();
			Node u = actingQ.poll();
			u.setColor(1);
			System.out.println();
			System.out.println("u color is: " + u.getColor());
			LinkedList<Node> adjNodes = adjList.get(u);
			Iterator adjNodesIterator = adjNodes.iterator();
			while (adjNodesIterator.hasNext()) {
				Node v = (Node) adjNodesIterator.next();
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

	private void printQ() {
		System.out.println("Printing Q...");
		Iterator it = actingQ.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.err.println();
	}

	public static void main(String[] args) {
		BFS bfs = new BFS();
		Graph g = new Graph();

		List<Node> nodeList = new ArrayList<Node>();

		Node firstNode = new Node(1);
		Node secondNode = new Node(2);
		Node thirdNode = new Node(3);
		Node fourthNode = new Node(4);
		Node fifthNode = new Node(5);
		Node sixthNode = new Node(6);
		Node seventhNode = new Node(7);
		Node eigthNode = new Node(8);
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
		
		Iterator checkIt = bfs.adjList.keySet().iterator();
		while(checkIt.hasNext())
		{
			Node n = (Node) checkIt.next();
			System.out.println("Node: " + n.getId() + " -> Color: " + n.getColor());
		}

	}

}

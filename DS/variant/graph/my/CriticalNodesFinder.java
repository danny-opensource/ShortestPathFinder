package variant.graph.my;

import graphs.my.Graph;
import graphs.my.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 
 * @author Git id: madan1988 (Madan Gopal)
 * 
 * @version $Revision: 1.0 $
 */
public class CriticalNodesFinder {
	/**
	 * Field adjList.
	 */
	private Map<Node, LinkedList<Node>> adjList;
	/**
	 * Field mainAdjList.
	 */
	private Map<Node, LinkedList<Node>> mainAdjList;
	/**
	 * Field actingQ.
	 */
	Queue<Node> actingQ = new LinkedList<Node>();

	/**
	 * Method performBFS.
	 * 
	 * @param g
	 *            Graph
	 * @param vertex
	 *            Node
	 */
	public synchronized void performBFS(Graph g, Node vertex) {
		Node s = vertex;
		s.setColor(1);
		s.setDistance(0);
		s.setPredecessor(null);
		actingQ.add(s);
		while (!actingQ.isEmpty()) {
			Node headQueueElement = actingQ.poll();
			final List<Node> adjNodes = adjList.get(headQueueElement);
			final Iterator<Node> it = adjNodes.iterator();
			while (it.hasNext()) {
				Node v = it.next();
				if (v.getColor() == 0) {
					v.setColor(1);
					v.setDistance(headQueueElement.getDistance() + 1);
					v.setPredecessor(headQueueElement);
					actingQ.add(v);
				}
			}
			headQueueElement.setColor(2);
		}
	}

	/**
	 * Method removeNodeFromGraph.
	 * 
	 * @param node
	 *            Node
	 */
	public synchronized void removeNodeFromGraph(Node node) {
		Iterator<Node> it = adjList.keySet().iterator();
		for (; it.hasNext();) {
			Node vertex = it.next();
			List<Node> edges = adjList.get(vertex);
			edges.remove(node);
		}
		adjList.remove(node);
	}

	/**
	 * Method printQ.
	 */
	private void printQ() {
		final Iterator<Node> it = actingQ.iterator();
		for (; it.hasNext();) {
			System.out.print(it.next() + "  ");
		}
	}

	/**
	 * Method isCriticalNode.
	 * 
	 * @param bfs
	 *            CriticalNodesFinder
	 * @param vertex
	 *            int
	 * @param uInt
	 *            int
	 * @return boolean
	 */
	public synchronized boolean isCriticalNode(CriticalNodesFinder bfs,
			int vertex, int uInt) {
		boolean check = false;
		Graph newGraph = bfs.createGraph();
		Node node = newGraph.getNode(vertex);
		Node defaultNode = newGraph.getNode(uInt);
		adjList = newGraph.getAdjacencyList();
		removeNodeFromGraph(node);
		performBFS(newGraph, defaultNode);

		final Iterator<Node> checkIt = adjList.keySet().iterator();
		for (; checkIt.hasNext();) {
			final Node checkNode = checkIt.next();
			if (checkNode.getColor() != 2) {
				check = true;
				return true;
			}
		}
		return false;
	}

	/**
	 * Method initLists.
	 * 
	 * @param g
	 *            Graph
	 */
	private void initLists(Graph g) {
		Map<Node, LinkedList<Node>> temp = g.getAdjacencyList();
		mainAdjList = new HashMap<Node, LinkedList<Node>>();
		mainAdjList.putAll(temp);
		adjList = mainAdjList;

		System.out.println("----- Lists are initialized.");
		Iterator<Node> it = adjList.keySet().iterator();
		for (; it.hasNext();) {
			System.out.print(it.next().getId() + "  Color: "
					+ it.next().getColor());
			System.out.println();
		}
		System.out.println();

	}

	/**
	 * Method createGraph.
	 * 
	 * @return Graph
	 */
	private Graph createGraph() {

		Node first = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);
		Node fifth = new Node(5);
		Node sixth = new Node(6);
		Node seventh = new Node(7);
		Node eigth = new Node(8);
		List<Node> vertices = new ArrayList<Node>();
		vertices.add(first);
		vertices.add(second);
		vertices.add(third);
		vertices.add(fourth);
		vertices.add(fifth);
		vertices.add(sixth);
		vertices.add(seventh);
		vertices.add(eigth);

		Graph newGraph = new Graph();
		newGraph.setVertices(vertices);

		List<Node> edges = null;

		edges = newGraph.getEdges(first);
		edges.add(fifth);
		edges.add(second);

		edges = newGraph.getEdges(second);
		edges.add(first);
		edges.add(sixth);

		edges = newGraph.getEdges(third);
		edges.add(sixth);
		edges.add(fourth);

		edges = newGraph.getEdges(fourth);
		edges.add(third);
		edges.add(eigth);

		edges = newGraph.getEdges(fifth);
		edges.add(first);

		edges = newGraph.getEdges(sixth);
		edges.add(second);
		edges.add(third);
		edges.add(seventh);

		edges = newGraph.getEdges(seventh);
		edges.add(sixth);
		edges.add(eigth);

		edges = newGraph.getEdges(eigth);
		edges.add(fourth);
		edges.add(seventh);
		return newGraph;
	}

	/**
	 * Method main.
	 * 
	 * @param args
	 *            String[]
	 */
	public static void main(String[] args) {

		boolean isCriticalNode = false;
		CriticalNodesFinder bfs = new CriticalNodesFinder();
		Graph newGraph = bfs.createGraph();
		bfs.adjList = newGraph.getAdjacencyList();

		for (int i = 0; i < newGraph.getVertices().size(); i++) {
			if (i == 1) {
				isCriticalNode = bfs.isCriticalNode(bfs, i + 1, 1);
			} else {
				isCriticalNode = bfs.isCriticalNode(bfs, i + 1, 2);
			}

			System.out.println("Node: " + (i + 1) + " Critical: "
					+ isCriticalNode);
		}
	}

	/**
	 * Method toString.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return super.toString();
	}

}

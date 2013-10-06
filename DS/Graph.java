import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class Graph {

	private Map<Integer, LinkedList> adjList;

	public Graph() {
		adjList = new HashMap<Integer, LinkedList>();
	}

	private void addVertex(int vertex) {
		if (adjList != null) {
			adjList.put(vertex, new LinkedList());
		}

	}

	private void addEdge(int vertex, int edge) {
		if (adjList != null) {
			adjList.get(vertex).add(edge);
		}
	}

	private void printAdjacencyList() {
		Iterator it = adjList.keySet().iterator();
		while (it.hasNext()) {
			int vertex = (Integer) it.next();
			System.out.print(vertex + ": ");
			LinkedList neighbours = adjList.get(vertex);
			Iterator edgeIterator = neighbours.iterator();
			while (edgeIterator.hasNext()) {
				System.out.print(" -> " + edgeIterator.next());
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

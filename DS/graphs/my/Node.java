package graphs.my;
/**
 * Node.java
 * 
 * @author Git id: madan1988 (Madan Gopal)
 * 
 */
public class Node {

	int id;
	int color; // 0-White, 1-Gray, 2-Black
	int distance = -1; // Assuming Infinity
	Node predecessor;

	/**
	 * Construct the Node
	 * 
	 * @param id
	 */
	public Node(int id) {
		this.id = id;
		this.color = 0;
		this.distance = -1;
		this.predecessor = null;
	}

	/**
	 * Set the color
	 * 
	 * @param color
	 */
	public void setColor(int color) {
		this.color = color;
	}

	/**
	 * Set the distance
	 * 
	 * @param distance
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}

	/**
	 * Set the predecessor for the graph
	 * 
	 * @param predecessor
	 */
	public void setPredecessor(Node predecessor) {
		this.predecessor = predecessor;
	}

	/**
	 * Get the color
	 * 
	 * @return color
	 */
	public int getColor() {
		return color;
	}

	/**
	 * Get the distance
	 * 
	 * @return distance
	 */
	public int getDistance() {
		return distance;
	}

	/**
	 * Get the predeccesor
	 * 
	 * @return
	 */
	public Node getPredeccesor() {
		return predecessor;
	}

	/**
	 * Get the id
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof Node) {
			Node objNode = (Node) obj;
			if (id == objNode.getId()) {
				return true;
			}
			return false;
		}

		return false;

	};

	@Override
	public String toString() {
		return id + "";
	};

	@Override
	public int hashCode() {
		return id;
	}
}

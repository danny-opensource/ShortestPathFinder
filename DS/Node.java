public class Node {

	int id;
	int color; // 0-White, 1-Gray, 2-Black
	int distance = -1; // Assuming Infinity
	Node predecessor;

	public Node(int id) {
		this.id = id;
		this.color = 0;
		this.distance = -1;
		this.predecessor = null;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public void setPredecessor(Node predecessor) {
		this.predecessor = predecessor;
	}

	public int getColor() {
		return color;
	}

	public int getDistance() {
		return distance;
	}

	public Node getPredeccor() {
		return predecessor;
	}

	public int getId() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Node) {
			Node objNode = (Node) obj;
			if (id == objNode.getId()) {
				return true;
			} else {
				return false;
			}
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

package lab4.task2;

import java.util.ArrayList;
import java.util.List;

public class Node implements Comparable<Node> {
	private String label;
	private Node parent;
	private double g;
	private double h;
	private List<Edge> children = new ArrayList<Edge>();

	public Node(String label, double h) {
		this.label = label;
		this.h = h;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public double getG() {
		return g;
	}

	public void setG(double g) {
		this.g = g;
	}

	public double getH() {
		return h;
	}

	public void setH(double h) {
		this.h = h;
	}

	public List<Edge> getChildren() {
		return children;
	}

	public void setChildren(List<Edge> children) {
		this.children = children;
	}

	public List<Node> getChildrenNodes() {
		List<Node> result = new ArrayList<Node>();
		for (Edge edge : this.children) {
			result.add(edge.getEnd());
		}
		return result;
	}

	// an edge is generated using this node and "that" with the given cost
	public void addEdge(Node that, double cost) {
		Edge edge = new Edge(this, that, cost);
		this.children.add(edge);
	}

	// an edge is generated using this node and "that" with the given cost
	public void addEdge(Node that) {
		Edge edge = new Edge(this, that);
		this.children.add(edge);
	}

	@Override
	public int compareTo(Node that) {
		Double g1 = this.g;
		Double g2 = this.g;
		int result = g1.compareTo(g2);
		if (result == 0) {
			return this.label.compareTo(that.label);
		} else {
			return result;
		}
	}

}

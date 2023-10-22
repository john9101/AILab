package lab2.task4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class UniformCostSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new Comparator<Node>() {

			@Override
			public int compare(Node n1, Node n2) {
				int result = Double.compare(n1.getPathCost(), n2.getPathCost());
				if(result == 0) {
					return n1.getLabel().compareTo(n2.getLabel());
				}else {
					return result;
				}
			}
			
		});
		List<Node> exploredSet = new ArrayList<Node>();
		frontier.offer(root);
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if(current.getLabel().equals(goal)) {
				return current;
			}else {
				exploredSet.add(current);
				List<Edge> children = current.getChildren();
				for (Edge child : children) {
					double newPathCost = current.getPathCost() + child.getWeight();
					Node n = child.getEnd();
					if(!exploredSet.contains(n) && !frontier.contains(n)) {
						frontier.add(n);
						n.setParent(current);
						n.setPathCost(newPathCost);
					}else if(frontier.contains(n) && n.getPathCost() > newPathCost) {
						n.setPathCost(newPathCost);
						n.setParent(current);
					}
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new Comparator<Node>() {

			@Override
			public int compare(Node n1, Node n2) {
				int result = Double.compare(n1.getPathCost(), n2.getPathCost());
				if(result == 0) {
					return n1.getLabel().compareTo(n2.getLabel());
				}else {
					return result;
				}
			}
			
		});
		List<Node> exploredSet = new ArrayList<Node>();
		boolean started = false;
		frontier.offer(root);
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if(current.getLabel().equals(start)) {
				frontier.clear();
				exploredSet.clear();
				current.setParent(null);
				started = true;
			}
			if(current.getLabel().equals(goal) && started == true) {
				return current;
			}else {
				exploredSet.add(current);
				List<Edge> children = current.getChildren();
				for (Edge child : children) {
					double newPathCost = current.getPathCost() + child.getWeight();
					Node n = child.getEnd();
					if(!exploredSet.contains(n) && !frontier.contains(n)) {
						frontier.add(n);
						n.setParent(current);
						n.setPathCost(newPathCost);
					}else if(frontier.contains(n) && n.getPathCost() > newPathCost) {
						n.setPathCost(newPathCost);
						n.setParent(current);
					}
				}
			}
		}
		return null;
	}

}

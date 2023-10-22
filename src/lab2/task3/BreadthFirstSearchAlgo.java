package lab2.task3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		Queue<Node> frontier = new LinkedList<Node>();
		frontier.offer(root);
		List<Node> listParrentGoal = new ArrayList<Node>();
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getLabel().equals(goal)) {
				current.setParent(listParrentGoal.getFirst());
				return current;
			}
			
			for (Node nodeChild : current.getChildrenNodes()) {
				frontier.offer(nodeChild);
				nodeChild.setParent(current);
				if(nodeChild.getLabel().equals(goal)) {
					listParrentGoal.add(current);
				}
			}
		}

		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		Queue<Node> frontier = new LinkedList<Node>();
		frontier.offer(root);
		boolean started = false;
		List<Node> listParrentGoal = new ArrayList<Node>();
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getLabel().equals(start) && started == false) {
				frontier.clear();
				current.setParent(null);
				frontier.offer(current);
				started = true;

			}

			if (current.getLabel().equals(goal) && started == true) {
				current.setParent(listParrentGoal.getFirst());
				return current;
			}
			
			for (Node nodeChild : current.getChildrenNodes()) {
				frontier.offer(nodeChild);
				nodeChild.setParent(current);
				if(nodeChild.getLabel().equals(goal)) {
					listParrentGoal.add(current);
				}
			}
		}

		return null;
	}

}

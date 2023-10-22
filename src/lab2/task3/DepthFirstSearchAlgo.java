package lab2.task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DepthFirstSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		Stack<Node> frontier = new Stack<Node>();
		frontier.push(root);
		List<Node> listParrentGoal = new ArrayList<Node>();
		while (!frontier.isEmpty()) {
			Node current = frontier.pop();
			if (current.getLabel().equals(goal)) {
				current.setParent(listParrentGoal.getFirst());
				return current;
			}
			
			List<Node> listChildrenNode = current.getChildrenNodes();
			Collections.reverse(listChildrenNode);
			for (Node nodeChild : listChildrenNode) {
				frontier.push(nodeChild);
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
		Stack<Node> frontier = new Stack<Node>();
		List<Node> listParrentGoal = new ArrayList<Node>();
		frontier.push(root);
		boolean started = false;
		while (!frontier.isEmpty()) {
			Node current = frontier.pop();
			if(current.getLabel().equals(start) && started == false) {
				frontier.clear();
				current.setParent(null);
				frontier.push(current);
				started = true;
			}
			
			if(current.getLabel().equals(goal) && started == true){
				current.setParent(listParrentGoal.getLast());
				return current;
			}
			
			List<Node> listChildrenNode = current.getChildrenNodes();
			Collections.reverse(listChildrenNode);
			for (Node nodeChild : listChildrenNode) {
				frontier.push(nodeChild);
				nodeChild.setParent(current);
				if(nodeChild.getLabel().equals(goal)) {
					listParrentGoal.add(current);
				}
			}
		}
		return null;
	}
}

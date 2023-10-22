package lab2.task1_2;

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
		List<Node> exploredSet = new ArrayList<Node>();
		frontier.push(root);
		while (!frontier.isEmpty()) {
			Node current = frontier.pop();
			if (current.getLabel().equals(goal)) {
				return current;
			}
			exploredSet.add(current);
			
			List<Node> listChildrenNode = current.getChildrenNodes();
			Collections.reverse(listChildrenNode);
			for (Node nodeChild : listChildrenNode) {
				if (!frontier.contains(nodeChild) && !exploredSet.contains(nodeChild)) {
					frontier.push(nodeChild);
					nodeChild.setParent(current);
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		Stack<Node> frontier = new Stack<Node>();
		List<Node> exploredSet = new ArrayList<Node>();
		frontier.push(root);
		boolean started = false;
		while (!frontier.isEmpty()) {
			Node current = frontier.pop();
			if(current.getLabel().equals(start) && started == false) {
				frontier.clear();
				exploredSet.clear();
				current.setParent(null);
				frontier.push(current);
				started = true;
			}
			
			if(current.getLabel().equals(goal) && started == true){
				return current;
			}
			
			exploredSet.add(current);
			
			List<Node> listChildrenNode = current.getChildrenNodes();
			Collections.reverse(listChildrenNode);
			for (Node nodeChild : listChildrenNode) {
				if (!frontier.contains(nodeChild) && !exploredSet.contains(nodeChild)) {
					frontier.push(nodeChild);
					nodeChild.setParent(current);
				}
			}
		}
		return null;
	}
}

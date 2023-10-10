package lab2.task1_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		Queue<Node> frontier = new LinkedList<Node>();
		List<Node> exploredSet = new ArrayList<Node>();
		frontier.offer(root);
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if(current.getLabel().equals(goal)) {
				return current;
			}
			exploredSet.add(current);
			for (Node nodeChild : current.getChildrenNodes()) {
				if(!frontier.contains(nodeChild) && !exploredSet.contains(nodeChild)) {
					frontier.offer(nodeChild);
					nodeChild.setParent(current);
				}	
			}
		}
		
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		return null;
	}

}

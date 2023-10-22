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
		Queue<Node> frontier = new LinkedList<Node>();
		List<Node> exploredSet = new ArrayList<Node>();
		frontier.offer(root);
		boolean started = false;
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if(current.getLabel().equals(start) && started == false) {
				frontier.clear();
				exploredSet.clear();
				current.setParent(null);
				frontier.offer(current);
				started = true;
				
			}
			
			if(current.getLabel().equals(goal) && started == true){
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

}

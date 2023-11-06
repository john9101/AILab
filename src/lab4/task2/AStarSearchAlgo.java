package lab4.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AStarSearchAlgo implements IInformedSearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>();
		List<Node> exploredSet = new ArrayList<Node>();
		frontier.offer(root);
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if(current.getLabel().equals(goal)) {
				return current;
			}
			
			exploredSet.add(current);
			List<Edge> children = current.getChildren();
			for (Edge e : children) {
				Node child = e.getEnd();
				if(!frontier.contains(child) && !exploredSet.contains(child)) {
					child.setParent(current);
					child.setG(current.getG() + e.getWeight());
					frontier.offer(child);
				}else if(frontier.contains(child) && child.getG() > current.getG() + e.getWeight()){
					frontier.remove(child);
					child.setG(current.getG() + e.getWeight());
					child.setParent(current);
					frontier.add(child);
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

}

package lab4.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class GreedyBestFirstSearchAlgo implements IInformedSearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>();
		List<Node> exploredSet = new ArrayList<Node>();
		frontier.offer(root);
		while (!frontier.isEmpty()) {
			System.out.println(frontier);
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

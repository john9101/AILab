package lab2.task6;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthLimitedSearch implements ISearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node execute(Node root, String goal, int limitedDepth) {
		Stack<Node> frontier = new Stack<Node>();
		List<Node> exploredSet = new ArrayList<Node>();
		frontier.push(root);
		while (!frontier.isEmpty()) {
			Node current = frontier.pop();
			if(current.getLabel().equals(goal)) {
				return current;
			}else {
				if(current.getDepth() < limitedDepth) {
					
				}
			}
		}
		return null;
	}

}

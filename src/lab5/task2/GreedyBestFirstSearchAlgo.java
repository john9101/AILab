package lab5.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class GreedyBestFirstSearchAlgo implements IPuzzleAlgo {

	@Override
	public Node execute(Puzzle model) {
		Node initialState = model.getInitialState();
		initialState.setH(model.computeH2(initialState));
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(PuzzleUtils.HeuristicComparatorByH);
		List<Node> exploredSet = new ArrayList<Node>();
		frontier.offer(initialState);
		while (!frontier.isEmpty()) {
			Node currentState = frontier.poll();
			
			if(currentState.equals(model.getGoalState())) {
				return currentState;
			}
			
			exploredSet.add(currentState);
			List<Node> childrenState = model.getSuccessors(currentState);
			for (Node childState : childrenState) {
				if(!frontier.contains(childState) && !exploredSet.contains(childState)) {
					childState.setParent(currentState);
					frontier.offer(childState);
				}
			}
		}
		return null;
	}
}

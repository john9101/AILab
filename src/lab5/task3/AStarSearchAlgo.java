package lab5.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


public class AStarSearchAlgo implements IPuzzleAlgo {

	@Override
	public Node execute(Puzzle model) {
		
		Node initialState = model.getInitialState();
		initialState.setG(0);
		initialState.setH(model.computeH2(initialState));
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(PuzzleUtils.HeuristicComparatorByF);
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
				int nextStep = currentState.getG() + 1;
				if(!frontier.contains(childState) && !exploredSet.contains(childState)) {
					childState.setParent(currentState);
					childState.setH(model.computeH2(currentState));
					childState.setG(currentState.getG() + 1);
					frontier.offer(childState);
				}else if(frontier.contains(childState) && childState.getG() > nextStep) {
					frontier.remove(childState);
					childState.setG(nextStep);
					childState.setH(model.computeH2(currentState));
					childState.setParent(currentState);
					frontier.offer(childState);
				}
			}
		}
		return null;
	}
	

}

package lab8.task2;

import java.util.Collections;
import java.util.List;

public class MiniMaxSearchAlgo implements ISearchAlgo {

	// function MINIMAX-DECISION(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
		// Enter your code here
		int bestValue = maxValue(node);
		for (Node child : node.getChildren()) {
			child.setValue(bestValue);
		}
	}

	// function MAX-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MIN_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s))
	// return v
	public int maxValue(Node node) {
		if (node.isTerminal()) {
			return node.getValue();
		}
		int maxValue = Integer.MIN_VALUE;
		for (Node child : node.getChildren()) {
			int childValue = minValue(child);
			maxValue = Math.max(childValue, maxValue);
		}
		return maxValue;
	}
	// function MIN-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s))
	// return v

	public int minValue(Node node) {
		if (node.isTerminal()) {
			return node.getValue();
		}
		int minValue = Integer.MAX_VALUE;
		for (Node child : node.getChildren()) {
			int childValue = maxValue(child);
			minValue = Math.min(childValue, minValue);
		}
		return minValue;
	}
}

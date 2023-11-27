package lab8.task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlphaBetaSearchAlgo implements ISearchAlgo {

	// function ALPHA-BETA-SEARCH(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state, Integer.MIN_VALUE , Integer.MAX_VALUE)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
		// Enter your code here
		int alpha = Integer.MIN_VALUE;
		int beta = Integer.MAX_VALUE;
		int bestValue = maxValue(node, alpha, beta);
		for (Node child : node.getChildren()) {
			if(child.getValue() == bestValue) {
				break;
			}
		}
	}

	// function MAX-VALUE(state, alpha, beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- MIN_VALUE;
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s, alpha, beta))
	// if v >= beta then return v
	// alpha <- MAX(alpha, v)
	// return v

	public int maxValue(Node node, int alpha, int beta) {
		// Enter your code here
		if (node.isTerminal()) {
			return node.getValue();
		}

		int maxValue = Integer.MIN_VALUE;
		for (Node child : node.getChildren()) {
			maxValue = Math.max(maxValue, minValue(child, alpha, beta));
			if (maxValue >= beta) {
				return maxValue;
			}
			alpha = Math.max(alpha, maxValue);
		}
		return maxValue;
	}
	// function MIN-VALUE(state, alpha , beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s, alpha , beta))
	// if v <= alpha then return v
	// beta <- MIN(beta ,v)
	// return v

	public int minValue(Node node, int alpha, int beta) {
		// Enter your code here
		if (node.isTerminal()) {
			return node.getValue();
		}

		int minValue = Integer.MAX_VALUE;
		for (Node child : node.getChildren()) {
			minValue = Math.min(minValue, maxValue(child, alpha, beta));
			if (minValue <= alpha) {
				return minValue;
			}
			beta = Math.min(beta, minValue);
		}
		return minValue;
	}
}

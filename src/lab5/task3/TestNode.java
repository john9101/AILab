package lab5.task3;

import java.util.Arrays;
import java.util.List;

public class TestNode {

	public static void main(String[] args) {
		Puzzle p = new Puzzle();
		p.readInput("src/lab5/txt/PuzzleMap.txt", "src/lab5/txt/PuzzleGoalState.txt");
		

		Node initialState = p.getInitialState();
		Node tmp = new Node(initialState);
		
		Node goalState = p.getGoalState();
		
		IPuzzleAlgo alog = new AStarSearchAlgo();
		
		Node result = alog.execute(p);
		System.out.println(NodeUtils.printPath(result));
	}
}

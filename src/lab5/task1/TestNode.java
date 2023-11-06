package lab5.task1;

import java.util.Arrays;
import java.util.List;

public class TestNode {

	public static void main(String[] args) {
		Puzzle p = new Puzzle();
		p.readInput("src/lab5/txt/PuzzleMap.txt", "src/lab5/txt/PuzzleGoalState.txt");
		

		Node initialState = p.getInitialState();
		Node tmp = new Node(initialState);
		
		Node goalState = p.getGoalState();
		
//		System.out.println(p.getInitialState());
//		System.out.println("H: "+initialState.getH());
//		System.out.println(Arrays.toString(initialState.getWhiteTilePosition()));
//		System.out.println(p.getGoalState());
		Node re = p.moveWhiteTile(initialState, 'r');
		re.setH(p.computeH1(re));
		System.out.println(re);
		System.out.println(p.getGoalState());
		System.out.println(re.getH());
		System.out.println(initialState);
		
//		System.out.println(Arrays.toString(re.getWhiteTilePosition()));
//		System.out.println(p.computeH(init, goal));

		// System.out.println(p.getInitialState());
		// System.out.println(p.getGoalState());
		//
		// List<Node> children = p.getSuccessors(initialState);
		// System.out.println("Size: "+children.size());
		// for (Node child : children) {
		// System.out.println(child.getH()+" "+p.computeH(child) );
		// }
	}
}

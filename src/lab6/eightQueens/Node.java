package lab6.eightQueens;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Node {
	public static final int N = 8;
	private Queen[] state;

	public Node() {
		// generateBoard();
		state = new Queen[N];
	}

	public Node(Queen[] state) {
		this.state = new Queen[N];
		for (int i = 0; i < state.length; i++) {
			this.state[i] = new Queen(state[i].getRow(), state[i].getColumn());
		}
	}

	public Node(Node n) {
		this.state = new Queen[N];
		for (int i = 0; i < N; i++) {
			Queen qi = n.state[i];
			this.state[i] = new Queen(qi.getRow(), qi.getColumn());
		}
	}

	public void generateBoard() {
		Random random = new Random();
		for (int i = 0; i < N; i++) {
			state[i] = new Queen(random.nextInt(N), i);
		}
	}

	public int getH() {
		int heuristic = 0;
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (state[i].isConflict(state[j])) {
					heuristic++;
				}
			}
		}
		return heuristic;
	}

	public List<Node> generateAllCandidates() {
		List<Node> result = new ArrayList<Node>();
		for (int i = 0; i < N; i++) {
			Node temp = new Node(this.state);
			temp.state[i].move();
			result.add(temp);
		}
		return result;
	}

	public Node selectNextRandomCandidate() {
		Node result = new Node(this.state);
		Random random = new Random();
		int i = random.nextInt(N);
		int row = random.nextInt(N);
		result.state[i].setRow(row);
		return result;
	}

	public void displayBoard() {
		int[][] board = new int[N][N];
		// set queen position on the board
		for (int i = 0; i < N; i++) {
			board[state[i].getRow()][state[i].getColumn()] = 1;
		}
		// print board
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 1) {
					System.out.print("Q" + " ");
				} else {
					System.out.print("-" + " ");
				}
			}
			System.out.println();
		}
	}
	
	public Node getBestCandidate() {
		List<Node> listCanlidate = generateAllCandidates();
		Node bestCandidate = listCanlidate.get(0);
		for(Node tempNode : generateAllCandidates()) {
			if(tempNode.getH() < bestCandidate.getH()) {
				bestCandidate = tempNode;
			}
		}
		return bestCandidate;
		
	}
	
	public Node execute(Node initialState) {
		Node current = initialState;
		Node neighbor = null;
		while(true) {
			neighbor = current.getBestCandidate();
			if(current.getH() > neighbor.getH()) {
				current = neighbor;
			}else {
				return current;
			}
		}
	}
	
}

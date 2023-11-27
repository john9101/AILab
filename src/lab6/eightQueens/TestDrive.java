package lab6.eightQueens;

public class TestDrive {
	public static void main(String[] args) {
		Queen q1 = new Queen(0, 1);
		Queen q2 = new Queen(2, 4);
		Queen q3 = new Queen(5, 7);
		Queen q4 = new Queen(3, 4);
		Queen q5 = new Queen(6, 2);
		Queen q6 = new Queen(5, 3);
		Queen q7 = new Queen(1, 5);
		Queen q8 = new Queen(7, 3);

		Queen[] eightQueens = { q1, q2, q3, q4, q5, q6, q7, q8 };
		Node initialNode = new Node(eightQueens);
		System.out.println(initialNode.getH());
	}
}

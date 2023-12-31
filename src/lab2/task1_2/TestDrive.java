package lab2.task1_2;

import java.util.Collections;
import java.util.List;

public class TestDrive {
	public static void main(String[] args) {
		Node nodeS = new Node("S");
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");
		Node nodeG = new Node("G");
		Node nodeH = new Node("H");

		nodeS.addEdge(nodeA, 5);
		nodeS.addEdge(nodeB, 2);
		nodeS.addEdge(nodeC, 4);
		nodeA.addEdge(nodeD, 9);
		nodeA.addEdge(nodeE, 4);
		nodeB.addEdge(nodeG, 6);
		nodeC.addEdge(nodeF, 2);
		nodeD.addEdge(nodeH, 7);
		nodeE.addEdge(nodeG, 6);
		nodeF.addEdge(nodeG, 1);
		
		//Task 1
		System.out.println("-- Task 1 --");
		ISearchAlgo algo1 = new BreadthFirstSearchAlgo();
		Node result1 = algo1.execute(nodeS, "G");
		System.out.println(NodeUtils.printPath(result1));

		ISearchAlgo algo2 = new DepthFirstSearchAlgo();
		Node result2 = algo2.execute(nodeS, "G");
		System.out.println(NodeUtils.printPath(result2));
		
		//Task 2
		System.out.println("-- Task 2 --");
		Node result3 = algo1.execute(nodeS,"A", "G");
		System.out.println(NodeUtils.printPath(result3));
		
		Node result4 = algo2.execute(nodeS, "C", "G");
		System.out.println(NodeUtils.printPath(result4));
	}
}

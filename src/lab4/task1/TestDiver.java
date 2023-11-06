package lab4.task1;

public class TestDiver {
	public static void main(String[] args) {
		Node nodeA = new Node("A", 4);
		Node nodeB = new Node("B", 4);
		Node nodeC = new Node("C", 4);
		Node nodeD = new Node("D", 3.5);
		Node nodeE = new Node("E", 1);
		Node nodeF = new Node("F", 1);
		Node nodeG = new Node("G", 0);
		Node nodeS = new Node("S", 6);
		
		nodeA.addEdge(nodeC, 3);
		nodeB.addEdge(nodeC, 1);
		nodeB.addEdge(nodeD, 3);
		nodeC.addEdge(nodeD, 1);
		nodeC.addEdge(nodeE, 3);
		nodeD.addEdge(nodeF, 2);
		nodeE.addEdge(nodeG, 2);
		nodeF.addEdge(nodeG, 1);
		nodeS.addEdge(nodeA, 2);
		nodeS.addEdge(nodeB, 3);
		
		IInformedSearchAlgo algo = new GreedyBestFirstSearchAlgo();
		Node result = algo.execute(nodeS, "G");
		System.out.println(NodeUtils.printPath(result));
	}
}

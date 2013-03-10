package com.ibm.crl.temp.maxiao.matrixgraph;

import com.ibm.crl.temp.maxiao.Graph;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = MatrixGraph.defaultGraph();
		graph.PrintGraph();
		Debug.LOG("BFSing!");
		graph.BFS();
		Debug.LOG("DFSing Recursive!");
		graph.DFS();
		Debug.LOG("DFSing Not Recursive!");
		graph.DFS_Not_Recursive();
		Debug.LOG("Djkstra!");
		graph.DjstraShortestPath("1");
		Debug.LOG("Bellman-Ford!");
		graph.BellmanFord("1");
		Debug.LOG("Floyd-Warshaling!");
		graph.Floyd_Warshall();
		Debug.LOG("TopologicalSorting!");
		graph.TopologicalSort();
		Debug.LOG("Kruskaling!");
		graph.Kruskal();
		Debug.LOG("Priming!");
		graph.Prim();
		Debug.LOG("Tarjaning Recursive!");
		graph.Tarjan_SCC();
		Debug.LOG("Tarjaning Not Recursive!");
		graph.Tarjan_SCC();
		Debug.LOG("Judge Circling!");
		graph.JudgeCircle();
		
	}

}

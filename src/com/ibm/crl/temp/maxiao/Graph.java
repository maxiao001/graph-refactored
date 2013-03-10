package com.ibm.crl.temp.maxiao;

public abstract class Graph {

	public abstract void BFS();

	public abstract void PrintGraph();

	public abstract void DFS();

	public abstract void DFS_Not_Recursive();

	public abstract void DjstraShortestPath(String nodeId);
	
	public abstract void TopologicalSort();
	
	public abstract void Kruskal();
	
	public abstract void Prim();
	
	public abstract void BellmanFord(String nodeId);
	
	public abstract void Floyd_Warshall();
	
	public abstract void Tarjan_SCC();
	
	public abstract void Tarjan_SCC_Not_Recursive();
	
	/**
	 * Color[i] have three values instead of true and false;
	 *  0，此节点没有被访问过

      -1，被访问过至少1次，其后代节点正在被访问中

        1，其后代节点都被访问过。
	 */
	public abstract void JudgeCircle();

}

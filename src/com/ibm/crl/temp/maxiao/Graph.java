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
	 *  0���˽ڵ�û�б����ʹ�

      -1�������ʹ�����1�Σ������ڵ����ڱ�������

        1�������ڵ㶼�����ʹ���
	 */
	public abstract void JudgeCircle();

}

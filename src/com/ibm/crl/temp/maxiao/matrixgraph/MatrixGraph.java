package com.ibm.crl.temp.maxiao.matrixgraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import com.ibm.crl.temp.maxiao.Graph;
import com.ibm.crl.temp.maxiao.matrixgraph.Debug;

class Node {
	private int nodeId;
	private Object nodeValue;
	private int inDegree;
	private int outDegree;

	public Node(int nodeId, Object nodeValue) {
		super();
		this.nodeId = nodeId;
		this.nodeValue = nodeValue;
	}

	public int getInDegree() {
		return inDegree;
	}

	public void setInDegree(int inDegree) {
		this.inDegree = inDegree;
	}

	public int getOutDegree() {
		return outDegree;
	}

	public void setOutDegree(int outDegree) {
		this.outDegree = outDegree;
	}

	public int getNodeId() {
		return nodeId;
	}

	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}

	public Object getNodeValue() {
		return nodeValue;
	}

	public void setNodeValue(Object nodeValue) {
		this.nodeValue = nodeValue;
	}

}

class NodeDistance implements Comparable<NodeDistance> {
	private int nodeId;
	private float distance;
	private int preNodeId;

	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}

	public int getPreNodeId() {
		return preNodeId;
	}

	public void setPreNodeId(int begin) {
		this.preNodeId = begin;
	}

	public int getNodeId() {
		return nodeId;
	}

	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}

	public NodeDistance(int nodeId, float distance, int preNodeId) {
		super();
		this.nodeId = nodeId;
		this.distance = distance;
		this.preNodeId = preNodeId;
	}

	public int compareTo(NodeDistance o) {
		return (int) (this.distance - this.distance);
	}
}

class Edge {
	private int srcId;
	private int desId;
	private float edgeLength;

	public Edge(int srcId, int desId, float edgeLength) {
		super();
		this.srcId = srcId;
		this.desId = desId;
		this.edgeLength = edgeLength;
	}

	public int getSrcId() {
		return srcId;
	}

	public void setSrcId(int srcId) {
		this.srcId = srcId;
	}

	public int getDesId() {
		return desId;
	}

	public void setDesId(int desId) {
		this.desId = desId;
	}

	public float getEdgeLength() {
		return edgeLength;
	}

	public void setEdgeLength(float edgeLength) {
		this.edgeLength = edgeLength;
	}

}

class MyInteger {
	private int value = 0;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int add(int i) {
		this.value += i;
		return this.value;
	}

	public MyInteger(int value) {
		super();
		this.value = value;
	}

}

class TarjanItem {
	/*
	 * Integer Bcnt = 0, Dindex = 0; int DFN[] = new int[this.size];
	 * 
	 * int LOW[] = new int[this.size]; boolean instack[] = new
	 * boolean[this.size];
	 * 
	 * int Belong[] = new int[this.size]; for (int i = 0; i < this.size; i++) {
	 * DFN[i] = 0; LOW[i] = 0; instack[i] = false; Belong[i] = 0; }
	 */
	public static int SetCount = 0;
	public static int Index = 0;
	private int DFN;
	private int LOW;
	private boolean instack;
	private int belong;

	public TarjanItem(int dFN, int lOW, boolean instack, int belong) {
		super();
		DFN = dFN;//the order that visited
		LOW = lOW;
		this.instack = instack;
		this.belong = belong;
	}

	public static int getSetCount() {
		return SetCount;
	}

	public static void setSetCount(int setCount) {
		SetCount = setCount;
	}

	public static int getIndex() {
		return Index;
	}

	public static void setIndex(int index) {
		Index = index;
	}

	public int getDFN() {
		return DFN;
	}

	public void setDFN(int dFN) {
		DFN = dFN;
	}

	public int getLOW() {
		return LOW;
	}

	public void setLOW(int lOW) {
		LOW = lOW;
	}

	public boolean isInstack() {
		return instack;
	}

	public void setInstack(boolean instack) {
		this.instack = instack;
	}

	public int getBelong() {
		return belong;
	}

	public void setBelong(int belong) {
		this.belong = belong;
	}

}

// Directed Graph
public class MatrixGraph extends Graph {

	private static int MAX_INT = (1 << 31) - 1;
	private static boolean ADD_TO_HEAD = false;
	private float matrix[][] = null;
	private Node nodes[] = null;
	private List<Edge> edges = null;

	private int size = 0;

	public MatrixGraph(int size) {
		this.size = size;
		this.nodes = new Node[size];
		this.edges = new ArrayList<Edge>();
		this.matrix = new float[size][size];
		for (int i = 0; i < this.size; i++) {
			this.nodes[i] = null;
		}
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				this.matrix[i][j] = MAX_INT;
			}
		}

	}

	public static MatrixGraph defaultGraph() {
		MatrixGraph newGraph = new MatrixGraph(10);

		newGraph.addNode(new Node(1, "I am No 1"));
		newGraph.addNode(new Node(2, "I am No 2"));
		newGraph.addNode(new Node(3, "I am No 3"));
		newGraph.addNode(new Node(4, "I am No 4"));
		newGraph.addNode(new Node(5, "I am No 5"));
		newGraph.addNode(new Node(6, "I am No 6"));
		newGraph.addNode(new Node(7, "I am No 7"));
		newGraph.addNode(new Node(8, "I am No 8"));
		newGraph.addNode(new Node(9, "I am No 9"));
		newGraph.addNode(new Node(0, "I am No 0"));

		newGraph.addEdge(new Edge(0, 3, 10.0f));
		newGraph.addEdge(new Edge(1, 2, 100.0f));
		newGraph.addEdge(new Edge(1, 3, 70.0f));
		newGraph.addEdge(new Edge(1, 5, 60.0f));
		newGraph.addEdge(new Edge(1, 4, 78.0f));
		newGraph.addEdge(new Edge(2, 4, 50.0f));
		newGraph.addEdge(new Edge(2, 6, 40.0f));
		newGraph.addEdge(new Edge(4, 5, 35.0f));
		newGraph.addEdge(new Edge(3, 2, 30.0f));
		newGraph.addEdge(new Edge(5, 3, 20.0f));

		newGraph.addEdge(new Edge(5, 6, 10.0f));
		newGraph.addEdge(new Edge(5, 8, 20.0f));
		newGraph.addEdge(new Edge(6, 8, 10.0f));

		newGraph.addEdge(new Edge(7, 6, 10.0f));

		return newGraph;
	}

	public void addNode(Node newNode) {
		if (!JudgeId(newNode.getNodeId())) {
			Debug.LOG("index out of range!");
			return;
		}
		if (this.nodes[newNode.getNodeId()] != null) {
			Debug.LOG("the position has been occupied!");
		}
		int tempNodeId = newNode.getNodeId();
		this.nodes[tempNodeId] = newNode;
		this.nodes[tempNodeId].setInDegree(0);
		this.nodes[tempNodeId].setOutDegree(0);
	}

	public void addEdge(Edge newEdge) {

		int srcId = newEdge.getSrcId();
		int desId = newEdge.getDesId();
		if (!JudgeId(srcId) || !JudgeId(desId)) {
			Debug.LOG("index out of range!");
			return;
		}
		this.edges.add(newEdge);
		this.matrix[srcId][desId] = newEdge.getEdgeLength();
		this.nodes[srcId].setOutDegree(this.nodes[srcId].getOutDegree() + 1);
		this.nodes[desId].setInDegree(this.nodes[desId].getInDegree() + 1);
	}

	private boolean JudgeId(int nodeId) {
		if (nodeId < 0 && nodeId > this.size - 1) {
			return false;
		}
		return true;
	}

	public void BFS() {
		Map<Integer, Boolean> visitedMap = new HashMap<Integer, Boolean>();
		for (int i = 0; i < this.size; i++) {
			visitedMap.put(i, false);
		}
		for (int i = 0; i < this.size; i++) {
			this.BFS(i, visitedMap);
		}
	}

	public void BFS(int begin, Map<Integer, Boolean> visitedMap) {

		if (visitedMap.get(begin))
			return;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(begin);
		visitedMap.put(begin, true);
		while (!queue.isEmpty()) {
			int head = queue.poll();
			System.out.println("my node value is "
					+ this.nodes[head].getNodeValue());
			for (int i = 0; i < this.size; i++) {
				if (this.matrix[head][i] != MAX_INT && !visitedMap.get(i)) {
					queue.offer(i);
					visitedMap.put(i, true);// because the visited order in the
											// queue is certain;
				}
			}
		}
	}

	public void PrintGraph() {
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				if (this.matrix[i][j] == MAX_INT) {
					System.out.print("  ++");
				} else {
					System.out.print("  " + this.matrix[i][j]);
				}
			}
			System.out.println();
		}
	}

	public void DFS() {

		Map<Integer, Boolean> visitedMap = new HashMap<Integer, Boolean>();
		for (int i = 0; i < this.size; i++) {
			visitedMap.put(i, false);
		}
		for (int i = 0; i < this.size; i++) {
			this.DFS(i, visitedMap);
		}
	}

	private void DFS(int begin, Map<Integer, Boolean> visitedMap) {
		if (!visitedMap.get(begin)) {// the current begin may be visited
										// already;
			visitedMap.put(begin, true);
			System.out.println(this.nodes[begin].getNodeValue());
		}
		for (int i = 0; i < this.size; i++) {
			if (this.matrix[begin][i] != MAX_INT && !visitedMap.get(i)) {
				this.DFS(i, visitedMap);
			}
		}
	}

	public void DFS_Not_Recursive() {
		Map<Integer, Boolean> visitedMap = new HashMap<Integer, Boolean>();
		for (int i = 0; i < this.size; i++) {
			visitedMap.put(i, false);
		}
		for (int i = 0; i < this.size; i++) {
			this.DFS_NOT_Recursive_Stack(i, visitedMap);
		}
	}

	private void DFS_NOT_Recursive_Stack(int begin,
			Map<Integer, Boolean> visitedMap) {
		if (visitedMap.get(begin))
			return;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(begin);
		while (!stack.isEmpty()) {
			int top = stack.pop();
			if (!visitedMap.get(top)) {
				visitedMap.put(top, true);
				System.out.println(this.nodes[top].getNodeValue());
				for (int i = 0; i < this.size; i++) {
					if (this.matrix[top][i] != MAX_INT && !visitedMap.get(i)) {
						stack.push(i);// why not put the visitedflag to true as
										// BFS:
										// because the visitedOrder in the stack
										// is
										// not certain.
					}
				}
			}
		}
	}

	public void JudgeCircle() {
		MyInteger myint = new MyInteger(0);
		int color[] = new int[this.size];
		int pre[] = new int[this.size];
		int post[] = new int[this.size];
		for (int i = 0; i < this.size; i++) {
			color[i] = 0;
			pre[i] = 0;
			post[i] = 0;
		}
		for (int i = 0; i < this.size; i++) {
			this.JudgeCircle(i, myint, color, pre, post);
		}
		for (int i = 1; i <= this.size; i++)
			Debug.LOG("顶点" + i + "的pre和post分别为：" + pre[i] + " " + post[i]);
	}

	private void JudgeCircle(int begin, MyInteger myint, int[] color,
			int[] pre, int[] post) {

		if (color[begin] != 0)
			return;
		pre[begin] = myint.add(1);
		color[begin] = -1;
		for (int i = 0; i < this.size; i++) {
			if (this.matrix[begin][i] != MAX_INT) {
				if (color[i] == -1) {
					System.out.println("there is a circle!");
				} else if (color[i] == 0) {
					this.JudgeCircle(i, myint, color, pre, post);
				}
			}
		}
		color[begin] = 1;
		post[begin] = myint.add(1);
	}

	/*
	 * public void JudgeCircle() { int color[] = new int[this.size]; boolean
	 * circle[] = new boolean[this.size]; for (int i = 0; i < this.size; i++) {
	 * color[i] = 0; circle[i] = false; }
	 * 
	 * for (int begin = 0; begin < this.size; begin++) { if (color[begin] != 0)
	 * continue; Stack<Integer> stack = new Stack<Integer>(); stack.push(begin);
	 * while (!stack.isEmpty()) { int top = stack.pop(); if (color[top] == 0) {
	 * color[top] = -1; // System.out.println(this.nodes[top].getNodeValue());
	 * for (int i = 0; i < this.size; i++) { if (this.matrix[top][i] != MAX_INT
	 * ) { if(color[i] == 0){ stack.push(i); // Debug.printList(stack); } else
	 * if(color[i] == -1){ boolean childNodesAllBeSearched = true; for(int j =
	 * 0;j < this.size;j++){ if(this.matrix[i][j] != MAX_INT && color[j] == 0){
	 * childNodesAllBeSearched = false; } } if(childNodesAllBeSearched){
	 * color[i] = 1; }else{ System.out.println("there is a circle!");
	 * circle[begin] = true; } } } } } } } for(int i = 0;i < this.size;i++){
	 * System.out.println(i+" "+circle[i]); } }
	 */
	public void DjstraShortestPath(String nodeIdString) {
		int begin = Integer.parseInt(nodeIdString);
		NodeDistance nodeDistance[] = new NodeDistance[this.size];
		Set<Integer> decidedSet = new HashSet<Integer>(this.size);
		for (int i = 0; i < this.size; i++) {
			nodeDistance[i] = new NodeDistance(i, MAX_INT, begin);
		}
		nodeDistance[begin].setDistance(0.0f);

		Queue<NodeDistance> queue = new PriorityQueue<NodeDistance>(10,
				new Comparator<NodeDistance>() {

					public int compare(NodeDistance o1, NodeDistance o2) {
						return (int) (o1.getDistance() - o2.getDistance());
					}
				});
		queue.offer(nodeDistance[begin]);
		float tempDistance = 0.0f;
		NodeDistance headNodeDistance = null;
		int head = 0;
		while (!queue.isEmpty()) {
			headNodeDistance = queue.poll();
			head = headNodeDistance.getNodeId();
			decidedSet.add(head);

			for (int i = 0; i < this.size; i++) {
				if (!decidedSet.contains(i) && this.matrix[head][i] != MAX_INT) {
					tempDistance = this.matrix[head][i]
							+ nodeDistance[head].getDistance();
					if (tempDistance < nodeDistance[i].getDistance()) {
						nodeDistance[i].setDistance(tempDistance);
						nodeDistance[i].setPreNodeId(head);
						queue.add(nodeDistance[i]);
					}
				}
			}
		}
		for (NodeDistance temp : nodeDistance) {
			System.out.println("id:" + temp.getNodeId() + " distance:"
					+ temp.getDistance() + " pre:" + temp.getPreNodeId());
		}

	}

	@Override
	public void BellmanFord(String nodeIdString) {

		int begin = Integer.parseInt(nodeIdString);
		NodeDistance nodeDistance[] = new NodeDistance[this.size];
		Set<Integer> decidedSet = new HashSet<Integer>(this.size);
		for (int i = 0; i < this.size; i++) {
			nodeDistance[i] = new NodeDistance(i, MAX_INT, begin);
		}
		nodeDistance[begin].setDistance(0.0f);
		float tempDistance = 0.0f;
		float currentDistance = 0.0f;
		for (int i = 0; i < this.size; i++) {
			for (Edge edge : this.edges) {
				int src = edge.getSrcId();
				int des = edge.getDesId();
				if (nodeDistance[src].getDistance() != MAX_INT
						&& this.matrix[src][des] != MAX_INT) {
					tempDistance = nodeDistance[src].getDistance()
							+ this.matrix[src][des];
					currentDistance = nodeDistance[des].getDistance();
					if (tempDistance < currentDistance) {
						nodeDistance[des].setDistance(tempDistance);
						nodeDistance[des].setPreNodeId(src);
					}
				}
			}
		}
		for (Edge edge : this.edges) {
			int src = edge.getSrcId();
			int des = edge.getDesId();
			if (nodeDistance[des].getDistance() > nodeDistance[src]
					.getDistance() + this.matrix[src][des]) {
				System.out.println("the current graph exists negative circle!");
				return;
			}
		}
		for (NodeDistance temp : nodeDistance) {
			System.out.println("id:" + temp.getNodeId() + " distance:"
					+ temp.getDistance() + " pre:" + temp.getPreNodeId());
		}
	}

	@Override
	public void TopologicalSort() {
		List<Node> list = new LinkedList<Node>();
		for (Node temp : this.nodes) {
			list.add(temp);
		}

		while (!list.isEmpty()) {
			int size = list.size();
			for (int index = 0; index < list.size(); index++) {
				Node singleNode = list.get(index);
				if (singleNode.getInDegree() == 0) {
					list.remove(singleNode);

					System.out.println(singleNode.getNodeValue());
					int nodeId = singleNode.getNodeId();
					for (int i = 0; i < this.size; i++) {
						if (this.matrix[nodeId][i] != MAX_INT) {
							this.nodes[nodeId].setOutDegree(this.nodes[nodeId]
									.getOutDegree() - 1);
							this.nodes[i].setInDegree(this.nodes[i]
									.getInDegree() - 1);
						}
					}
				}
			}
			int laterSize = list.size();
			if (size == laterSize) {
				System.out.println("there is a circle in current graph!");
				break;
			}
		}
	}

	@Override
	public void Kruskal() {
		Collections.sort(this.edges, new Comparator<Edge>() {
			public int compare(Edge e1, Edge e2) {
				return (e1.getEdgeLength() > e2.getEdgeLength()) ? 1 : 0;
			}
		});
		Set<Edge> edgeSet = new HashSet<Edge>();
		List<Set<Node>> setList = new ArrayList<Set<Node>>();
		for (Node node : this.nodes) {
			Set<Node> newSet = new HashSet<Node>();
			newSet.add(node);
			setList.add(newSet);
		}
		int edgeListSize = this.edges.size();

		for (int i = 0; i < edgeListSize; i++) {
			Edge edge = this.edges.get(i);
			Set<Node> set1 = null;
			Set<Node> set2 = null;
			set1 = FindSet(edge.getSrcId(), setList);
			set2 = FindSet(edge.getDesId(), setList);
			if (set1 != set2) {
				edgeSet.add(edge);
				set1.addAll(set2);
				setList.remove(set2);
			}
		}
		for (Edge edge : edgeSet) {
			System.out.println(edge.getSrcId() + " " + edge.getDesId() + " "
					+ edge.getEdgeLength());
		}
	}

	private Set<Node> FindSet(int srcId, List<Set<Node>> setList) {
		Node node = this.nodes[srcId];
		int size = setList.size();
		for (int i = 0; i < size; i++) {
			Set<Node> set = setList.get(i);
			if (set.contains(node)) {
				return set;
			}
		}
		return null;
	}

	@Override
	public void Prim() {
		int begin = 0;
		NodeDistance nodeDistance[] = new NodeDistance[this.size];
		for (int i = 0; i < this.size; i++) {
			nodeDistance[i] = new NodeDistance(i, MAX_INT, begin);
		}
		nodeDistance[begin] = new NodeDistance(begin, 0.0f, begin);

		Set<Integer> decidedSet = new HashSet<Integer>();
		Queue<NodeDistance> queue = new PriorityQueue<NodeDistance>(this.size,
				new Comparator<NodeDistance>() {
					public int compare(NodeDistance n1, NodeDistance n2) {
						return n1.getDistance() > n2.getDistance() ? 1 : 0;
					}
				});
		for (int i = 0; i < this.size; i++) {
			queue.add(nodeDistance[i]);
		}

		NodeDistance headNodeDistance = null;
		int head = 0;

		while (!queue.isEmpty()) {
			headNodeDistance = queue.poll();
			head = headNodeDistance.getNodeId();
			decidedSet.add(head);
			for (int i = 0; i < this.size; i++) {

				if (this.matrix[head][i] != MAX_INT && !decidedSet.contains(i)) {

					if (this.matrix[head][i] < nodeDistance[i].getDistance()) {
						nodeDistance[i].setDistance(this.matrix[head][i]);
						nodeDistance[i].setPreNodeId(head);
					}
				}
			}
		}

		for (NodeDistance distance : nodeDistance) {
			System.out.println(distance.getNodeId() + " "
					+ distance.getPreNodeId() + " " + distance.getDistance());
		}
	}

	@Override
	public void Floyd_Warshall() {
		float distance[][] = new float[this.size][this.size];
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				distance[i][j] = this.matrix[i][j];
			}
		}
		for (int k = 0; k < this.size; k++) {
			for (int i = 0; i < this.size; i++) {
				if (distance[i][k] != MAX_INT) {
					for (int j = 0; j < this.size; j++) {
						if (i != j
								&& (distance[i][k] + distance[k][j] < distance[i][j])) {
							distance[i][j] = distance[i][k] + distance[k][j];
						}
					}
				}
			}
		}
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				System.out.print(distance[i][j] + " ");
			}
			System.out.println();
		}
	}

	@Override
	public void Tarjan_SCC() {

		TarjanItem items[] = new TarjanItem[this.size];
		for (int i = 0; i < this.size; i++) {
			items[i] = new TarjanItem(0, 0, false, -1);
		}
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < this.size; i++) {
			if (items[i].getDFN() == 0) {
				tarjan(i, items, stack);
			}
		}
		for (int i = 0; i < this.size; i++) {
			System.out.println(i + ":" + items[i].getDFN() + " "
					+ items[i].getBelong());
		}
	}

	public void Tarjan_SCC_Not_Recursive() {
		TarjanItem items[] = new TarjanItem[this.size];
		for (int i = 0; i < this.size; i++) {
			items[i] = new TarjanItem(0, 0, false, -1);
		}
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < this.size; i++) {
			if (items[i].getDFN() == 0) {
				tarjan_Non_Recursive(i, items, stack);
			}
		}
		for (int i = 0; i < this.size; i++) {
			System.out.println(i + ":" + items[i].getDFN() + " "
					+ items[i].getBelong());
		}
	}

	private void tarjan_Non_Recursive(int begin, TarjanItem[] items,
			Stack<Integer> visitedStack) {

		Stack<Integer> dfsStack = new Stack<Integer>();
		dfsStack.push(begin);
		Stack<Integer> dfsResultStack = new Stack<Integer>();
		while (!dfsStack.empty()) {
			int dfsTop = dfsStack.pop();
			dfsResultStack.push(dfsTop);
			items[dfsTop].setDFN(TarjanItem.Index);
			items[dfsTop].setLOW(TarjanItem.Index);
			TarjanItem.Index++;
			visitedStack.push(dfsTop);
			for (int i = 0; i < this.size; i++) {
				if (this.matrix[dfsTop][i] != MAX_INT && items[i].getDFN() == 0) {
					dfsStack.push(i);
				}
			}
		}
		while (!dfsResultStack.empty()) {
			int dfsResultTop = dfsResultStack.pop();
			for (int i = 0; i < this.size; i++) {
				if (this.matrix[dfsResultTop][i] != MAX_INT
						&& items[i].getLOW() < items[dfsResultTop].getLOW()) {
					items[dfsResultTop].setLOW(items[i].getLOW());
				} else if (items[i].isInstack()
						&& items[i].getDFN() < items[dfsResultTop].getLOW()) {
					items[dfsResultTop].setLOW(items[i].getDFN());
				}
				if (items[dfsResultTop].getDFN() == items[dfsResultTop]
						.getLOW()) {
					TarjanItem.SetCount++;
					int top = 0;
					while ((top = visitedStack.peek()) != dfsResultTop) {
						top = visitedStack.pop();
						items[top].setInstack(false);
						items[top].setBelong(TarjanItem.SetCount);
					}
				}
			}
		}
	}

	private void tarjan(int current, TarjanItem[] items, Stack<Integer> stack) {

		items[current].setDFN(TarjanItem.Index);
		items[current].setLOW(TarjanItem.Index);
		TarjanItem.Index++;
		items[current].setInstack(true);
		stack.push(current);
		for (int i = 0; i < this.size; i++) {
			if (this.matrix[current][i] == MAX_INT)
				continue;
			if (items[i].getDFN() == 0) {
				tarjan(i, items, stack);
				if (items[i].getLOW() < items[current].getLOW()) {
					items[current].setLOW(items[i].getLOW());
				}
			} else if (items[i].isInstack()
					&& items[i].getDFN() < items[current].getLOW()) {
				items[current].setLOW(items[i].getDFN());
			}
			if (items[current].getDFN() == items[current].getLOW()) {
				TarjanItem.SetCount++;
				int top = 0;
				while ((top = stack.peek()) != current) {
					top = stack.pop();
					items[top].setInstack(false);
					items[top].setBelong(TarjanItem.SetCount);
				}
			}
		}

	}

}

package com.ibm.crl.temp.maxiao.listIdGraph;

import java.util.ArrayList;
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


class Node {
	private int nodeId;
	private Object nodeValue;
	private List<Edge> EdgeList;

	public Node(int nodeId, Object nodeValue, List<Edge> edgeList) {
		super();
		this.nodeId = nodeId;
		this.nodeValue = nodeValue;
		EdgeList = edgeList;
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

	public List<Edge> getEdgeList() {
		return EdgeList;
	}

	public void setEdgeList(List<Edge> edgeList) {
		EdgeList = edgeList;
	}

}

class NodeDistance implements Comparable<NodeDistance> {
	private Integer nodeId;
	private float distance;
	private Integer preNodeId;

	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}

	public Integer getPreNodeId() {
		return preNodeId;
	}

	public void setPreNodeId(Integer preNodeId) {
		this.preNodeId = preNodeId;
	}

	public Integer getNodeId() {
		return nodeId;
	}

	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}

	public NodeDistance(Integer tempNodeId, float distance, Integer nodeId2) {
		super();
		this.nodeId = tempNodeId;
		this.distance = distance;
		this.preNodeId = nodeId2;
	}

	public int compareTo(NodeDistance o) {
		return (int) (this.distance - this.distance);
	}
}

class Edge {
	private int nodeId;
	private float edgeLength;

	public Edge(int nodeId, float edgeLength) {
		super();
		this.nodeId = nodeId;
		this.edgeLength = edgeLength;
	}

	public int getNodeId() {
		return nodeId;
	}

	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}

	public float getEdgeLength() {
		return edgeLength;
	}

	public void setEdgeLength(float edgeLength) {
		this.edgeLength = edgeLength;
	}
}

// Directed Graph
public class  ListIntegerGraph extends Graph {

	private static int MAX_INT = (1 << 31) - 1;
	private static boolean ADD_TO_HEAD = false;
	private Map<Integer, Node> nodeMap = null;

	public ListIntegerGraph() {
		nodeMap = new HashMap<Integer, Node>();
	}

	public static ListIntegerGraph defaultGraph() {
		ListIntegerGraph newGraph = new ListIntegerGraph();

		newGraph.addNode(new Node(1, "I am No 1", null));
		newGraph.addNode(new Node(2, "I am No 2", null));
		newGraph.addNode(new Node(3, "I am No 3", null));
		newGraph.addNode(new Node(4, "I am No 4", null));
		newGraph.addNode(new Node(5, "I am No 5", null));
		newGraph.addNode(new Node(6, "I am No 6", null));
		newGraph.addNode(new Node(7, "I am No 7", null));
		newGraph.addNode(new Node(8, "I am No 8", null));
		newGraph.addNode(new Node(9, "I am No 9", null));
		newGraph.addNode(new Node(0, "I am No 0", null));

		newGraph.addEdge(0, new Edge(3,10.0f));
		newGraph.addEdge(1, new Edge(2, 100.0f));
		newGraph.addEdge(1, new Edge(3, 70.0f));
		newGraph.addEdge(1, new Edge(5, 60.0f));
		newGraph.addEdge(1, new Edge(4,78.0f));
		newGraph.addEdge(2, new Edge(4, 50.0f));
		newGraph.addEdge(2, new Edge(6, 40.0f));
		
		newGraph.addEdge(3, new Edge(2, 30.0f));
		newGraph.addEdge(3, new Edge(5, 20.0f));
		newGraph.addEdge(4, new Edge(5,35.0f));
		newGraph.addEdge(5, new Edge(6, 10.0f));
		newGraph.addEdge(5, new Edge(8, 20.0f));
		newGraph.addEdge(6, new Edge(8, 10.0f));

		newGraph.addEdge(7, new Edge(6, 10.0f));
		return newGraph;
	}

	public void addNode(Node newNode) {
		if (this.nodeMap.containsKey(newNode.getNodeId())) {
			Debug.LOG("Insert Node failed! the Node Already Exists!");
			return;
		}
		nodeMap.put(newNode.getNodeId(), newNode);
		List<Edge> list = new ArrayList<Edge>();// can be configured in file
		newNode.setEdgeList(list);
	}

	@SuppressWarnings("null")
	public void addEdge(int i, Edge newEdge) {
		Node currentNode = this.nodeMap.get(i);
		if (currentNode == null) {
			Debug.LOG("The Node not exists,Please check it carefully!");
			return;
		}
		List<Edge> list = currentNode.getEdgeList();
		list.add(newEdge);

	}

	public void BFS() {
		if (this.nodeMap.size() == 0) {
			Debug.LOG("the graph is empty!");
			return;
		}
		// setup flag map
		Object[] keyArray = this.nodeMap.keySet().toArray();

		Node currentNode = this.nodeMap.get(keyArray[0]);
		Map<Integer, Boolean> visitMap = new HashMap<Integer, Boolean>();
		for (Object temp : keyArray) {
			visitMap.put((Integer) temp, new Boolean(false));
		}

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(currentNode.getNodeId());
		visitMap.put(currentNode.getNodeId(), new Boolean(true));
		Integer currentNodeId = null;
		List<Edge> currentList = null;
		Edge currentEdge = null;
		while ((currentNodeId = queue.poll()) != null) {
			currentNode = this.nodeMap.get(currentNodeId);

			// debuging to console
			Debug.LOG((String) currentNode.getNodeValue());
			currentList = currentNode.getEdgeList();
			Iterator<Edge> iterator = currentList.iterator();
			while (iterator.hasNext()) {
				currentEdge = iterator.next();
				if (visitMap.get(currentEdge.getNodeId()).equals(
						new Boolean(false))) {
					queue.offer(currentEdge.getNodeId());
					visitMap.put(currentEdge.getNodeId(), new Boolean(true));
				}
			}
		}
	}

	public void PrintGraph() {
		Set<Integer> set = this.nodeMap.keySet();
		List<Edge> edgeList = null;
		for (Integer nodeId : set) {
			System.out.print(nodeId + " ");
			edgeList = this.nodeMap.get(nodeId).getEdgeList();
			Iterator<Edge> iterator = edgeList.iterator();
			while (iterator.hasNext()) {
				System.out.print("----" + iterator.next().getNodeId());
			}
			System.out.println();
		}
	}

	public void DFS() {
		Set<Integer> keys = this.nodeMap.keySet();
		Map<Integer, Boolean> visitedMap = new HashMap<Integer, Boolean>();
		for (Integer temp : keys) {
			visitedMap.put(temp, false);
		}
		for (Integer temp : keys) {
			DFS(temp, visitedMap);
		}
	}

	private void DFS(Integer nodeId, Map<Integer, Boolean> visitedMap) {

		if (visitedMap.get(nodeId).booleanValue() == false) {
			Debug.LOG((String) this.nodeMap.get(nodeId).getNodeValue());
			visitedMap.put(nodeId, true);

			List<Edge> edgeList = this.nodeMap.get(nodeId).getEdgeList();
			Iterator<Edge> iterator = edgeList.iterator();
			while (iterator.hasNext()) {
				this.DFS(iterator.next().getNodeId(), visitedMap);
			}
		}

	}
	public void DFS_Not_Recursive(){
		Set<Integer> keys = this.nodeMap.keySet();
		Map<Integer, Boolean> visitedMap = new HashMap<Integer, Boolean>();
		for (Integer temp : keys) {
			visitedMap.put(temp, false);
		}
		for (Integer temp : keys) {
			DFS_NOT_Recursive_Stack(temp, visitedMap);
		}
	}
	private void DFS_Not_Recursive_Queue(Integer nodeId, Map<Integer, Boolean> visitedMap) {

		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.addFirst(nodeId);
		Integer first = null;
		Integer temp = null;
		while(!queue.isEmpty()){
			first = queue.removeFirst();
			if(visitedMap.get(first) == false){
				Debug.LOG((String) this.nodeMap.get(first).getNodeValue());
				visitedMap.put(first, true);
			}
			
			List<Edge> edgeList = this.nodeMap.get(first).getEdgeList();
			Iterator<Edge> iterator = edgeList.iterator();
			while (iterator.hasNext()) {
				temp = iterator.next().getNodeId();
				if(visitedMap.get(temp) == false){
					queue.addFirst(temp);
				}
			}
		}
	}
	private void DFS_NOT_Recursive_Stack(Integer temp2,Map<Integer, Boolean> visitedMap){
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(temp2);
		Integer first = null;
		Integer temp = null;
		while(!stack.isEmpty()){
			first = stack.pop();
			if(visitedMap.get(first) == false){
				Debug.LOG((String) this.nodeMap.get(first).getNodeValue());
				visitedMap.put(first, true);
			}
			
			List<Edge> edgeList = this.nodeMap.get(first).getEdgeList();
			Iterator<Edge> iterator = edgeList.iterator();
			while (iterator.hasNext()) {
				temp = iterator.next().getNodeId();
				if(visitedMap.get(temp) == false){
					stack.push(temp);
				}
			}
		}
	}
	public void DjstraShortestPath(Integer nodeId) {
		System.out.println("ShortestPathing!");
		long start = System.currentTimeMillis();
		if (this.nodeMap.get(nodeId) == null) {
			Debug.LOG("the node not exists!");
			return;
		}
		Set<Integer> keys = this.nodeMap.keySet();// the initial complete set.
		HashMap<Integer, NodeDistance> distanceMap = new HashMap<Integer, NodeDistance>();
		for (Integer tempNodeId : keys) {
			distanceMap.put(tempNodeId, new NodeDistance(tempNodeId,
					(float) MAX_INT, nodeId));
		}
		distanceMap.put(nodeId, new NodeDistance(nodeId, 0.0f, nodeId));

		Queue<NodeDistance> queue = new PriorityQueue<NodeDistance>(10,
				new Comparator<NodeDistance>() {
					public int compare(NodeDistance o1, NodeDistance o2) {
						return (int) (o1.getDistance() - o2.getDistance());
					}
				});
		queue.offer(distanceMap.get(nodeId));
		Set<Integer> decidedSet = new HashSet<Integer>();

		NodeDistance currentNodeDistance = null;
		Integer currentNodeId = null;// current stack head nodeId

		List<Edge> edgeList = null;
		Edge currentEdge = null;// the next edge
		float currentDistance = 0.0f;// current calculated distance

		float tempDistance = 0.0f;// the prior distance
		Integer tempNodeId;// the next edge node
		while (!queue.isEmpty()) {
			currentNodeDistance = queue.poll();
			currentNodeId = currentNodeDistance.getNodeId();

			Debug.LOG(currentNodeId+"");

			decidedSet.add(currentNodeId);
			edgeList = this.nodeMap.get(currentNodeId).getEdgeList();
			Iterator<Edge> iterator = edgeList.iterator();
			while (iterator.hasNext()) {
				currentEdge = iterator.next();
				tempNodeId = currentEdge.getNodeId();

				if (!decidedSet.contains(tempNodeId)) {
					currentDistance = distanceMap.get(currentNodeId)
							.getDistance() + currentEdge.getEdgeLength();
					tempDistance = distanceMap.get(tempNodeId).getDistance();
					if (currentDistance < tempDistance) {
						System.out.println("----" + tempNodeId
								+ "---current distance:" + currentDistance
								+ " temp distance:" + tempDistance);
						distanceMap.get(tempNodeId)
								.setDistance(currentDistance);
						distanceMap.get(tempNodeId).setPreNodeId(currentNodeId);
						queue.add(distanceMap.get(tempNodeId));// means the temp
						// node is not
						// in queue
					}
					// else the temp node in queue ,so there is no need to add
					// it;
				}
			}
		}

		Set<Map.Entry<Integer, NodeDistance>> resultSet = distanceMap.entrySet();
		for (Map.Entry<Integer, NodeDistance> entry : resultSet) {
			System.out.println("id:" + entry.getKey() + " distance:"
					+ entry.getValue().getDistance() + " pre:"
					+ entry.getValue().getPreNodeId());
		}

		long end = System.currentTimeMillis();
		System.out.println("time cost: " + (end - start) + " ms");
	}

	@Override
	public void TopologicalSort() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Kruskal() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Prim() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void BellmanFord(String nodeId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Floyd_Warshall() {
		/*float distance[][] = new float[this.size][this.size];
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
		}	*/	
		
	}

	@Override
	public void Tarjan_SCC() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Tarjan_SCC_Not_Recursive() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void JudgeCircle() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DjstraShortestPath(String nodeId) {
		// TODO Auto-generated method stub
		
	}

}

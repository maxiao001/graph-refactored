package com.ibm.crl.temp.maxiao.matrixgraph;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

public class Debug {

	public static void LOG(String log){
		System.out.println("Log From MaXiao_Graph: "+log);
	}
	
	public static void print2dArray(int array[][],int m,int n){
		for(int i = 0;i < m;i++){
			for(int j = 0;j < n;j++){
				System.out.print(" "+array[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void printArray(int array[],int n){
		for(int i = 0;i < n;i++){
			System.out.print(" "+array[i]);
		}
		System.out.println();
	}
	
	public static void printMap(Map map){
		
		Set<Entry> entrySet = map.entrySet();
		for(Entry entry:entrySet){
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}
	public static void printSet(Set set){
		for(Object object:set){
			System.out.print(object+" ");
		}
		System.out.println();
	}
	
	public static void printList(List list){
		Iterator itr = list.iterator();
		while(itr.hasNext()){
			System.out.print(itr.next()+" ");
		}
		System.out.println();
	}

}

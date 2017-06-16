package com.science;
import java.util.*;
public class GraphAdjList extends Graph{
	private Map<Integer,ArrayList<Integer>> adjList;
	
	@Override
	public void implementAddEdge(int v,int w)
	{
		adjList.get(v).add(w);
	}
	
	@Override
	public void implementAddVertex()
	{
		int v=getNumOfVertex();
		ArrayList<Integer> neighbours=new ArrayList<Integer>();
		adjList.put(v, neighbours);
	}
	
	@Override
	public List<Integer> getNeighbors(int v)
	{
	List<Integer> neighbours=new ArrayList<Integer>(adjList.get(v));
	return neighbours;
	}
}

package com.science;

import java.util.*;
public abstract class Graph {
	private int numOfVertex;
	private int numOfEdges;
	public void AddVertex()
	{
		implementAddVertex();
		numOfVertex++;
	}
	public void AddEdge(int u,int v)
	{
		implementAddEdge(u,v);
		numOfEdges++;
	}
	public abstract void implementAddVertex();
	public abstract void implementAddEdge(int u, int v);
	public abstract List<Integer> getNeighbors(int v);
	public int getNumOfVertex() {
		return numOfVertex;
	}
	public void setNumOfVertex(int numOfVertex) {
		this.numOfVertex = numOfVertex;
	}
	public int getNumOfEdges() {
		return numOfEdges;
	}
	public void setNumOfEdges(int numOfEdges) {
		this.numOfEdges = numOfEdges;
	}

}

package com.science;

import java.util.*;
public class GraphAdjMatrix extends Graph {
	private int[][] adjMatrix ;
	
	@Override
	public void implementAddEdge(int u, int v)
	{
		adjMatrix[u][v]=1;
	}
	@Override
	public void implementAddVertex()
	{
		int v=getNumOfVertex();
		if(v>=adjMatrix.length)
		{
			int[][] newAdjMatrix=new int[v*2][v*2];
			for(int i=0;i<v;i++)
			{
				for(int j=0;j<v;i++)
				{
					newAdjMatrix[i][j]=adjMatrix[i][j];
				}
			}
			adjMatrix=newAdjMatrix;
		}
		else
			for(int i=0;i<v;i++)
				adjMatrix[v][i]=0;
	}
	
	@Override
	public List<Integer> getNeighbors(int v)
	{
		int n=getNumOfVertex();
		List<Integer> neighbours=new ArrayList<Integer>();
		for(int i=0;i<n;i++)
		{
			if(adjMatrix[i][v]==1)
				neighbours.add(i);
		}
		return neighbours;
	}
	

}

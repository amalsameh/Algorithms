package com.science;

import java.util.*;
public class Maze {
	MazeNode[][] nodes;
	
	public LinkedList<MazeNode> dfs(int startRow,int startCol,int endRow,int endCol)
	{
		LinkedList<MazeNode> pathNodes=new LinkedList<MazeNode>();
		HashMap<MazeNode,MazeNode> parentmap=new HashMap<MazeNode,MazeNode>();
		MazeNode start=nodes[startRow][startCol];
		MazeNode goal=nodes[endRow][endCol];
		if(start==null|| goal==null)
		{
			return pathNodes;
		}
		
		boolean found=searchDFS(start,goal,parentmap);
		if(!found)
			return pathNodes;
		
		return constructPath(start,goal,parentmap);
	}
	private boolean searchDFS(MazeNode start,MazeNode goal, HashMap<MazeNode,MazeNode> parentmap)
	{
		java.util.Stack<MazeNode> toExplore=new java.util.Stack<MazeNode>();
		HashSet<MazeNode> visited=new HashSet<MazeNode>();
		toExplore.push(start);
		boolean found=false;
		
		while(!toExplore.isEmpty())
		{
			MazeNode Curr=toExplore.pop();
			if(goal==Curr)
				return true;
			List<MazeNode> neighbors=Curr.getNeighbors();
			for(MazeNode n : neighbors)
			{
				if(!visited.contains(n))
				{
				toExplore.push(n);
				visited.add(n);
				parentmap.put(n, Curr);
				}
			}
		}
		
		return found;
	}

	private LinkedList<MazeNode> constructPath(MazeNode start,MazeNode goal,HashMap<MazeNode,MazeNode> parentmap)
	{
		LinkedList<MazeNode> path=new LinkedList<MazeNode>();
		path.AddFirst(goal);
		MazeNode curr=goal;
		while(curr!=start)
		{
			curr=parentmap.get(curr);
			path.AddFirst(curr);
		}
		return path;
	}

	public LinkedList<MazeNode> bfs(int startRow,int startCol,int endRow,int endCol)
	{
		LinkedList<MazeNode> pathNodes=new LinkedList<MazeNode>();
		HashMap<MazeNode,MazeNode> parentmap=new HashMap<MazeNode,MazeNode>();
		MazeNode start=nodes[startRow][startCol];
		MazeNode goal=nodes[endRow][endCol];
		if(start==null|| goal==null)
		{
			return pathNodes;
		}
		
		boolean found=searchBFS(start,goal,parentmap);
		if(!found)
			return pathNodes;
		
		return constructPath(start,goal,parentmap);
	}
	private boolean searchBFS(MazeNode start,MazeNode goal, HashMap<MazeNode,MazeNode> parentmap)
	{
		java.util.Queue<MazeNode> toExplore=new ArrayDeque<MazeNode>();
		HashSet<MazeNode> visited=new HashSet<MazeNode>();
		toExplore.add(start);
		boolean found=false;
		
		while(!toExplore.isEmpty())
		{
			MazeNode Curr=toExplore.remove();
			if(goal==Curr)
				return true;
			List<MazeNode> neighbors=Curr.getNeighbors();
			for(MazeNode n : neighbors)
			{
				if(!visited.contains(n))
				{
				toExplore.add(n);
				visited.add(n);
				parentmap.put(n, Curr);
				}
			}
		}
		return found;
	}

}

package com.science;

import java.util.*;
public class MazeNode {
	List<MazeNode> neighbors;
	public List<MazeNode> getNeighbors() {
		return neighbors;
	}
	public void setNeighbors(List<MazeNode> neighbors) {
		this.neighbors = neighbors;
	}
	char symbol;
	int row;
	int col;

	public char getSymbol() {
		return symbol;
	}
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	

}

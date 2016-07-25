package main.java.com.bitwise.GameOfLife;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Grid {
	private HashSet<Cell> aliveCells = new HashSet<Cell>();
	private HashSet<Cell> possibilityOfCellsToNextGeneration = new HashSet<Cell>();

	public int checkAliveCells() {
		return aliveCells.size();
	}

	public void addAliveCells(Cell cell) {
		cell.setCellAlive();
		aliveCells.add(cell);
	}

	public int countAliveNeighbours(Cell cell) {
		return aliveNeighbours(cell.getX(), cell.getY());
	}

	private int aliveNeighbours(int x_cell, int y_cell) {
		int neighbours = 0;
		for(int dx = x_cell-1; dx <= x_cell+1; dx++){
			for(int dy = y_cell-1; dy <= y_cell+1; dy++){
				if(isAnAliveCell(dx,dy) && isNotTheSameCell(dx,dy,x_cell,y_cell))
					neighbours++;
			}
		}
		return neighbours;
	}

	private boolean isNotTheSameCell(int dx, int dy,int x_cell,int y_cell) {
		return !(dx==x_cell && dy==y_cell);
	}

	boolean isAnAliveCell(int dx,int dy){
		for(Cell cell : aliveCells){
			if(cell.getX()==dx && cell.getY()==dy)
				return true;
		}
		return false;
	}

	public ArrayList<Cell> nextGenerationGrid() {
		ArrayList<Cell> nextGeneration = new ArrayList<Cell>();
		tickFunction(nextGeneration);
		return nextGeneration;
	}

	
	private void tickFunction(ArrayList<Cell> nextGeneration) {
		cellsThatCanBePassedToNextGeneration();
		for(Cell cell : aliveCells){
				if(countAliveNeighbours(cell)>3){
					cell.setCellDead();
				}
				else
					if(countAliveNeighbours(cell)<2){
						cell.setCellDead();
		            }
					else
					if(countAliveNeighbours(cell)==3||countAliveNeighbours(cell)==2){
						nextGeneration.add(cell);
					}
		}
		deadCell_WithExactlyThreeNeighbours_Lives(nextGeneration);
	}
	
	private void cellsThatCanBePassedToNextGeneration() {
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(!isAnAliveCell(i, j)) 
					possibilityOfCellsToNextGeneration.add(new Cell(i,j));
			}
		}
	}

	private void deadCell_WithExactlyThreeNeighbours_Lives(ArrayList<Cell> nextGeneration) {
		for(Cell cell : possibilityOfCellsToNextGeneration){
			if(countAliveNeighbours(cell)==3){
				nextGeneration.add(cell);
				nextGeneration.get(nextGeneration.size()-1).setCellAlive();
			}
		}
	}

}

package main.test.java.com.bitwise.GameOfLife;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.com.bitwise.GameOfLife.Cell;
import main.java.com.bitwise.GameOfLife.Grid;

public class GridTests {

	@Test
	public void ItShouldCheckAnEmptyGridWouldHave_Zero_AliveCells(){
		//given
		Grid grid = new Grid();
		//when
		int aliveCells = grid.checkAliveCells();
		//then
		assertEquals(0,aliveCells);
	}

	@Test
	public void ItShouldAddAliveCellsToGrid(){
		//given
		Grid grid = new Grid();
		Cell cell = new Cell(0,4);
		//when
		grid.addAliveCells(cell);
		int aliveCells = grid.checkAliveCells();
		//then
		assertEquals(1, aliveCells);
	}

	@Test 
	public void ItShouldCheckNumberOfAliveNeighboursOfACell(){
		//given
		Grid grid = new Grid();
		Cell cell1 = new Cell(0,1);
		Cell cell2 = new Cell(0,0);
		Cell cell3 = new Cell(0,2);
		Cell cell4 = new Cell(2,2);
		Cell cell5 = new Cell(3,3);
		//when
		grid.addAliveCells(cell1);
		grid.addAliveCells(cell2);
		grid.addAliveCells(cell3);
		grid.addAliveCells(cell4);
		grid.addAliveCells(cell5);
		int neighbours = grid.countAliveNeighbours(new Cell(1,1));
		//then
		assertEquals(4, neighbours);
	}

	@Test 
	public void ItShouldCheckNumberOfAliveNeighboursOfCornerCells(){
		//given
		Grid grid = new Grid();
		Cell cell1 = new Cell(1,0);
		Cell cell2 = new Cell(0,0);
		Cell cell3 = new Cell(1,1);
		Cell cell4 = new Cell(0,2);
		Cell cell5 = new Cell(3,3);
		//when
		grid.addAliveCells(cell1);
		grid.addAliveCells(cell2);
		grid.addAliveCells(cell3);
		grid.addAliveCells(cell4);
		grid.addAliveCells(cell5);
		int neighbours = grid.countAliveNeighbours(new Cell(0,2));
		//then
		assertEquals(1, neighbours);
	}

}

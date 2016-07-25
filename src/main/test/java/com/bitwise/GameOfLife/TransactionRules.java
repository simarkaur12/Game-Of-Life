package main.test.java.com.bitwise.GameOfLife;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;
import main.java.com.bitwise.GameOfLife.*;
public class TransactionRules {

	@Test
	public void aliveCellHavingLessThanTwoNeighbours_Dies(){
		//given
		Grid grid = new Grid();
		Cell cell1 = new Cell(1,0);
		Cell cell2 = new Cell(0,0);
		//when
		grid.addAliveCells(cell1);
		grid.addAliveCells(cell2);
		grid.nextGenerationGrid();
		//then
		assertEquals(true ,cell1.isDead());
		assertEquals(true ,cell2.isDead());
	}


	@Test
	public void aliveCellHavingMoreThanThreeNeighbours_Dies(){
		//given
		Grid grid = new Grid();
		Cell cell1 = new Cell(1,0);
		Cell cell2 = new Cell(0,0);
		Cell cell3 = new Cell(1,1);
		Cell cell4 = new Cell(0,1);
		Cell cell5 = new Cell(1,2);
		//when
		grid.addAliveCells(cell1);
		grid.addAliveCells(cell2);
		grid.addAliveCells(cell3);
		grid.addAliveCells(cell4);
		grid.addAliveCells(cell5);
		grid.nextGenerationGrid();
		//then
		assertEquals(false ,cell1.isDead());
		assertEquals(false ,cell2.isDead());
		assertEquals(true ,cell3.isDead());
		assertEquals(true ,cell4.isDead());
		assertEquals(false ,cell5.isDead());

	}


	@Test
	public void aliveCellHavingExactlyThreeNeighbours_Lives(){
		//given
		Grid grid = new Grid();
		Cell cell1 = new Cell(1,0);
		Cell cell2 = new Cell(0,0);
		Cell cell3 = new Cell(1,1);
		Cell cell4 = new Cell(0,1);
		Cell cell5 = new Cell(0,2);
		Cell cell6=  new Cell(1,2);
		//when
		grid.addAliveCells(cell1);
		grid.addAliveCells(cell2);
		grid.addAliveCells(cell3);
		grid.addAliveCells(cell4);
		grid.addAliveCells(cell5);
		ArrayList<Cell> nextGeneration = grid.nextGenerationGrid();
		//then

		Cell testCell = getTestCell(nextGeneration,1,2);
		assertEquals(true ,testCell.isAlive());
	}

	
	@Test
	public void aliveCellHavingTwoOrThreeNeighbours_Lives(){
		//given
		Grid grid = new Grid();
		Cell cell1 = new Cell(1,0);
		Cell cell2 = new Cell(0,0);
		Cell cell3 = new Cell(1,1);
		Cell cell4 = new Cell(0,1);
		//when
		grid.addAliveCells(cell1);
		grid.addAliveCells(cell2);
		grid.addAliveCells(cell3);
		ArrayList<Cell> nextGeneration = grid.nextGenerationGrid();
		//then
		Cell testCell = getTestCell(nextGeneration,0,1);
		assertEquals(true ,testCell.isAlive());
	}
	
	Cell getTestCell(ArrayList<Cell> nextGeneration,int test_x,int test_y){
		Iterator<Cell> it = nextGeneration.iterator();
		Cell c = null;
		while(it.hasNext()){
			c = it.next();
			if(c.getX()==test_x && c.getY()==test_y)
				return c;
		}
		return c;
	}


}

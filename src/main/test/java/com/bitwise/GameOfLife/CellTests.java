package main.test.java.com.bitwise.GameOfLife;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.com.bitwise.GameOfLife.Cell;

public class CellTests {

	@Test
	public void ItShouldCheckWhetherACellIsAlive(){
		//given
		Cell cell = new Cell(0,5);

		//when
		boolean actual = cell.isAlive();

		//then
		boolean expected  = false;
		assertEquals(expected, actual);
	}

	@Test
	public void ItShouldCheckWhetherACellIsDead(){
		//given
		Cell cell = new Cell(0,5);

		//when
		boolean actual = cell.isDead();

		//then
		boolean expected  = true;
		assertEquals(expected, actual);
	}

	@Test
	public void ItShouldMakeACellAlive(){
		//given
		Cell cell = new Cell(0,5);

		//when
		cell.setCellAlive();
		boolean actual = cell.isAlive();

		//then
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void ItShouldMakeACellDead(){
		//given
		Cell cell = new Cell(0,5);

		//when
		cell.setCellDead();
		boolean actual = cell.isDead();

		//then
		boolean expected = true;
		assertEquals(expected, actual);
	}

}

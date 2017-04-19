package main.java.com.bitwise.GameOfLife;

/**
 * @author Harsimar
 *
 */
public class Cell {
	private final int x;
	private final int y;
	private int state;
	private static final int ALIVE_CELL = 1;
	private static final int DEAD_CELL = 0;
	
	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public boolean isAlive() {
		return state==1;
	}
	public boolean isDead() {
		return state==0;
	}
	public void setCellAlive() {
		state = ALIVE_CELL;	
	}
    public void setCellDead() {
		state = DEAD_CELL;
	}
	public int getX() {
		return x;
	}
	public int getY(){
		return y;
	}
}

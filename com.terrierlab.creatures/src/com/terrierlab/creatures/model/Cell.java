package com.terrierlab.creatures.model;

import java.util.ArrayList;
import java.util.List;

public class Cell {

	/**
	 * Containing game board
	 */
	protected Board containingBoard;

	/**
	 * Adjacent cells within containing board<br>
	 * Computed at init time
	 */
	protected List<Cell> adjacentCells = new ArrayList<Cell>();

	/**
	 * x coordinate of the cell
	 */
	private int x;

	/**
	 * y coordinate of the cell
	 */
	private int y;

	/**
	 * Builds cell from coordinates
	 * 
	 * @param board containing board
	 * @param x     x coordinate
	 * @param y     y coordinate
	 */
	public Cell(Board board, int x, int y) {
		this.containingBoard = board;
		this.x = x;
		this.y = y;
	}

	/**
	 * Initialises cell within built board
	 */
	public void init() {
		// Compute adjacent cells
		computeAdjacentCells();
	}

	/**
	 * Gets the creature on the Cell, if any. Null otherwise (no creature on Cell)
	 */
	public Creature getCreature() {
		List<Creature> creatures = containingBoard.getCreatures();
		for (Creature creature : creatures) {
			if (creature.getActiveCell().equals(this)) {
				return creature;
			}
		}
		return null;
	}

	/**
	 * Computes adjacent cells
	 */
	private void computeAdjacentCells() {
		List<Cell> cells = containingBoard.getCells();
		for (Cell cell : cells) {
			if (Math.abs(cell.getX() - x) == 1 || Math.abs(cell.getY() - y) == 1) {
				adjacentCells.add(cell);
			}
		}
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the adjacentCells
	 */
	public List<Cell> getAdjacentCells() {
		return adjacentCells;
	}

	/**
	 * Serialize cell
	 */
	public String toString() {
		return "Case {" + x + ", " + y + "}";
	}

}

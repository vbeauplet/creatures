package com.terrierlab.creatures.model;

import java.util.List;

public class Creature {

	/**
	 * Containing game board
	 */
	protected Board containingBoard;

	/**
	 * Active cell
	 */
	protected Cell activeCell;

	/**
	 * Creature name
	 */
	protected String name;

	/**
	 * Creates a creature from the initial cell
	 * 
	 * @param board       board
	 * @param initialCell
	 * @param i           index of the creature
	 */
	public Creature(Board board, Cell initialCell, int i) {
		this.containingBoard = board;
		this.activeCell = initialCell;
		this.name = "Creature_" + i;
	}

	/**
	 * Moves to a random adjacent cell if no-one around. But if there is, eat
	 * 
	 * @return the eaten creature, if any. null otherwise
	 */
	public Creature move() {
		List<Cell> adjacentCells = activeCell.getAdjacentCells();
		for (Cell cell : adjacentCells) {
			Creature creature = cell.getCreature();
			if (creature != null) {
				// Move to creature and return true
				this.activeCell = creature.getActiveCell();
				return creature;
			}
		}

		// Nothing eaten today, move random
		int index = (int) (Math.random() * (adjacentCells.size() - 1));
		this.activeCell = adjacentCells.get(index);
		return null;
	}

	/**
	 * @return the activeCell
	 */
	public Cell getActiveCell() {
		return activeCell;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

}

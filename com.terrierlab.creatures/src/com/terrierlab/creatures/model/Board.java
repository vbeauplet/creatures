package com.terrierlab.creatures.model;

import java.util.ArrayList;
import java.util.List;

public class Board {

	/**
	 * Board cells
	 */
	protected List<Cell> cells = new ArrayList<Cell>();

	/**
	 * Board players
	 */
	protected List<Creature> creatures = new ArrayList<Creature>();

	/**
	 * Active creature
	 */
	protected Creature activeCreature;

	/**
	 * Builds a board game
	 * 
	 * @param xDimension
	 * @param yDimension
	 * @param numberOfCreatures
	 */
	public Board(int xDimension, int yDimension, int numberOfCreatures) {
		// Create cells
		this.initCells(xDimension, yDimension);

		// Create and initialize players position
		this.initCreatures(numberOfCreatures);
	}

	private void initCells(int xDimension, int yDimension) {

		// Build Cells
		for (int i = 1; i <= xDimension; i++) {
			for (int j = 1; j <= yDimension; j++) {

				// Create and add Cell for any board coordinates
				this.cells.add(new Cell(this, i, j));
			}
		}

		// Init Cells after they are all built
		for (Cell cell : cells) {
			cell.init();
		}

	}

	private void initCreatures(int numberOfCreatures) {

		// Create creatures
		for (int i = 0; i < numberOfCreatures; i++) {

			int index = (int) (Math.random() * (cells.size() - 1));
			Creature creature = new Creature(this, cells.get(index), i);
			this.creatures.add(creature);

			System.out.println("Put " + creature.getName() + " on " + creature.getActiveCell().toString());
		}

	}

	/**
	 * Play the game, move creatures until one eat
	 */
	public void play() {
		boolean eaten = false;
		int counter = 0;
		while (!eaten && counter < 100) {

			// Set active creature
			activeCreature = creatures.get(counter % creatures.size());

			// Move
			Creature eatenCreature = activeCreature.move();

			// If not eaten
			if (eatenCreature == null) {
				System.out.println(
						"Move " + activeCreature.getName() + " on " + activeCreature.getActiveCell().toString());
			}

			// If creature has eaten an other one
			else {
				System.out.println(activeCreature.getName() + " has eaten " + eatenCreature.getName() + " on "
						+ activeCreature.getActiveCell().toString());
				eaten = true;
			}

			counter++;
		}

		System.out.println("Party is over");
	}

	/**
	 * @return the cells
	 */
	public List<Cell> getCells() {
		return cells;
	}

	/**
	 * @param cells the cells to set
	 */
	public void setCells(List<Cell> cells) {
		this.cells = cells;
	}

	/**
	 * @return the creatures
	 */
	public List<Creature> getCreatures() {
		return creatures;
	}

	/**
	 * @param creatures the creatures to set
	 */
	public void setCreatures(List<Creature> creatures) {
		this.creatures = creatures;
	}
}

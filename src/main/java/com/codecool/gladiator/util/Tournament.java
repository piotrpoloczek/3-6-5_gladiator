package com.codecool.gladiator.util;

import com.codecool.gladiator.model.Combat;
import com.codecool.gladiator.model.Contestants;
import com.codecool.gladiator.model.gladiators.Gladiator;
import com.sun.tools.jconsole.JConsoleContext;
import com.sun.tools.jconsole.JConsolePlugin;

import java.util.List;

/**
 * Custom implementation of the binary tree data structure
 */
public class Tournament {

    private Contestants contestants;
    private Tournament leftBranch;
    private Tournament rightBranch;
    private int size;
    /**
     * A boolean value used for navigating between left and right branches when adding new values
     */
    private boolean left = true;

    /**
     * Constructor with initial value
     *
     * @param contestants the initial value to be added to the tree
     */
    public Tournament(Contestants contestants) {
        this.contestants = contestants;
        this.size = 1;
    }

    /**
     * Constructor with initial list of values
     *
     * @param values the list of values to be added to the tree
     */
    public Tournament(List<Contestants> values) {
        this.size = values.size();
        buildTournament(values);
    }

    /**
     * Builds the tournament tree recursively
     *
     * @param values the list of values to be added to the tree
     */
    private void buildTournament(List<Contestants> values) {
        if (values.size() == 1) {
            this.contestants = values.get(0);
            return;
        }

        int middle = values.size() / 2;
        List<Contestants> leftValue = values.subList(0, middle);
        List<Contestants> rightValue = values.subList(middle, values.size());

        leftBranch = new Tournament(leftValue);
        rightBranch = new Tournament(rightValue);
    }

    /**
     * Getter for the value (must be null if there are further branches)
     *
     * @return the value
     */
    public Contestants getContestants() {
        return contestants;
    }

    /**
     * Getter for the left branch
     *
     * @return the left branch
     */
    public Tournament getLeftBranch() {
        return leftBranch;
    }

    /**
     * Getter for the right branch
     *
     * @return the right branch
     */
    public Tournament getRightBranch() {
        return rightBranch;
    }

    /**
     * Setter for current contestants
     *
     * @param contestants contestants of the Tournament
     */
    public void setContestants(Contestants contestants) {
        this.contestants = contestants;
    }

    /**
     * Returns the number of values put in the tree
     *
     * @return the size of the tree
     */
    public int size() {
        return size;
    }

    /**
     * Adds a new value to the tree
     *
     * @param value the value to be added to the tree
     */
    public void add(Contestants value) {
        if (leftBranch == null) {
            leftBranch = new Tournament(contestants);
            rightBranch = new Tournament(value);
            contestants = null;
        } else {
            if (left) {
                leftBranch.add(value);
            } else {
                rightBranch.add(value);
            }
            left = !left;
        }
        size++;
    }

    /**
     * Adds multiple values to the tree
     *
     * @param values the list of values to be added to the tree
     */
    public void addAll(List<Contestants> values) {
        for (Contestants value : values) {
            add(value);
        }
    }

}

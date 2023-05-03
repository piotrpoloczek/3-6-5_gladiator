package com.codecool.gladiator.model.gladiators;

public abstract class Gladiator {

    private final String name;
    private final int baseHp;
    private final int baseSp;
    private final int baseDex;
    private int level;
    private int currentHp;

    /**
     * Constructor for Gladiators
     *
     * @param name the gladiator's name
     * @param baseHp the gladiator's base Health Points
     * @param baseSp the gladiator's base Strength Points
     * @param baseDex the gladiator's base Dexterity Points
     * @param level the gladiator's starting Level
     */
    public Gladiator(String name, int baseHp, int baseSp, int baseDex, int level) {
        this.name = name;
        this.baseHp = baseHp;
        this.currentHp = baseHp;
        this.baseSp = baseSp;
        this.baseDex = baseDex;
        this.level = level;
    }

    /**
     * @return HP multiplier of the gladiator subclass
     */
    protected abstract Multiplier getHpMultiplier();

    /**
     * @return SP multiplier of the gladiator subclass
     */
    protected abstract Multiplier getSpMultiplier();

    /**
     * @return DEX multiplier of the gladiator subclass
     */
    protected abstract Multiplier getDexMultiplier();

    /**
     * @return Gladiator's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the full name of the gladiator
     * assembled by the subtype and the name
     * (e.g. "Brutal Brutus" or "Archer Leo")
     *
     * @return the full name
     */
    public String getFullName() {
        return name;
    }

    public void levelUp() {
        this.level += 1;
    }

    public int getLevel() {
        return this.level;
    }

    public int getMaxHp() {
        return (int) (this.baseHp * this.getHpMultiplier().getValue() * getLevel());
    }

    public int getMaxSp() {
        return (int) (this.baseSp * this.getSpMultiplier().getValue() * getLevel());
    }

    public int getMaxDex() {
        return (int) (this.baseDex * this.getDexMultiplier().getValue() * getLevel());
    }

    public void decreaseHpBy(int damage) {
        this.currentHp -= damage;
    }

    public boolean isDead() {
        if (currentHp <= 0 ) {
            return true;
        }
        return false;
    }

    public void healUp() {
        this.currentHp = this.baseHp;
    }

    public int getHp() {
        return this.baseHp;
    }

    public int getSp() {
        return this.baseSp;
    }

    public int getDex() {
        return this.baseDex;
    }

    public int getCurrentHp() {
        return this.currentHp;
    }

    public enum Multiplier {
        Low(0.75),
        Medium(1.0),
        High(1.25);

        private final double value;

        Multiplier(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }
    }

}

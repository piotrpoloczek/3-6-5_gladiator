package com.codecool.gladiator.model;

import com.codecool.gladiator.model.gladiators.Gladiator;
import com.codecool.gladiator.util.RandomUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Combat class, used for simulating fights between pairs of gladiators
 */
public class Combat {

    private final Gladiator gladiator1;
    private final Gladiator gladiator2;

    private final List<String> combatLog;

    public Combat(Contestants contestants) {
        this.gladiator1 = contestants.gladiator1;
        this.gladiator2 = contestants.gladiator2;
        this.combatLog = new ArrayList<>();
    }

    /**
     * Simulates the combat and returns the winner.
     * If one of the opponents is null, the winner is the one that is not null
     * If both of the opponents are null, the return value is null
     *
     * @return winner of combat
     */
    public Gladiator simulate() {
        if (gladiator1 == null && gladiator2 == null) {
            return null;
        }
        if (gladiator1 == null) {
            return gladiator2;
        }
        if (gladiator2 == null) {
            return gladiator1;
        }

        Gladiator attacker = RandomUtils.getRandomBoolean() ? gladiator1 : gladiator2;
        Gladiator defender = attacker == gladiator1 ? gladiator2 : gladiator1;

        while (!attacker.isDead() && !defender.isDead()) {
            double dexterityDifference = Math.max(attacker.getDex() - defender.getDex(), 10);
            double hitChance = Math.min(dexterityDifference, 100) / 100.0;

            if (RandomUtils.getRandomDouble() < hitChance) {
                int damage = (int) (attacker.getSp() * RandomUtils.getRandomDouble(0.1, 0.5));
                defender.decreaseHpBy(damage);
                combatLog.add(String.format("%s deals %damage", attacker.getFullName(), damage));
            } else {
                combatLog.add(String.format("%s missed", attacker.getFullName()));
            }

            Gladiator temp = attacker;
            attacker = defender;
            defender = temp;
        }

        if (gladiator1.isDead()) {
            combatLog.add(String.format("%s has died, %s wins!", gladiator1.getFullName(), gladiator2.getFullName()));
            return gladiator2;
        } else {
            combatLog.add(String.format("%s has died, %s wins!", gladiator2.getFullName(), gladiator1.getFullName()));
            return gladiator1;
        }
    }

    public Gladiator getGladiator1() {
        return gladiator1;
    }

    public Gladiator getGladiator2() {
        return gladiator2;
    }

    public String getCombatLog(String separator) {
        return String.join(separator, combatLog);
    }

}

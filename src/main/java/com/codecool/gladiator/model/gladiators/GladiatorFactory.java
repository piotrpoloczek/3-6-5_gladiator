package com.codecool.gladiator.model.gladiators;

import com.codecool.gladiator.util.RandomUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class GladiatorFactory {

    private static final int MIN_STAT = 25;
    private static final int MAX_STAT = 100;
    private static final int MIN_LEVEL = 1;
    private static final int MAX_LEVEL = 5;

    private List<String> names;

    public int getNamesSize() {
        return names.size();
    }

    public GladiatorFactory(String fileOfNames) {
        try {
            File file = new File(getClass().getClassLoader().getResource(fileOfNames).getFile());
            names = Files.readAllLines(file.toPath());
        } catch (IOException|NullPointerException e) {
            System.out.println("Names file not found or corrupted!");
            System.exit(1);
        }
    }

    /**
     * Picks a random name from the file given in the constructor
     *
     * @return gladiator name
     */
    private String getRandomName() {
        int randomIndex = RandomUtils.getRandomInt(getNamesSize());
        return names.get(randomIndex);
    }

    /**
     * Instantiates a new gladiator with random name and type.
     * Creating an Archer, an Assassin, or a Brutal has the same chance,
     * while the chance of creating a Swordsman is the double of the chance of creating an Archer.
     * @return new Gladiator
     */
    public Gladiator generateRandomGladiator() {
        double randomGladiator = RandomUtils.getRandomDouble();
        String name = getRandomName();
        int hp = RandomUtils.getRandomInt(MIN_STAT, MAX_STAT);
        int sp = RandomUtils.getRandomInt(MIN_STAT, MAX_STAT);
        int dex = RandomUtils.getRandomInt(MIN_STAT, MAX_STAT);
        int level = RandomUtils.getRandomInt(MIN_LEVEL, MAX_LEVEL);

        if (randomGladiator < 0.4) {
            return new Swordsman(name, hp, sp, dex, level);
        } else if (randomGladiator < 0.6) {
            return new Archer(name, hp, sp, dex, level);
        } else if (randomGladiator < 0.8 ) {
            return new Assassin(name, hp, sp, dex, level);
        } else {
            return new Brutal(name, hp, sp, dex, level);
        }
    }
}

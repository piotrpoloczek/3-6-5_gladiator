package com.codecool.gladiator.model;

import com.codecool.gladiator.model.gladiators.Gladiator;

public class Contestants {

    public final Gladiator gladiator1;
    public final Gladiator gladiator2;

    public Contestants(Gladiator gladiator1, Gladiator gladiator2) {
        this.gladiator1 = gladiator1;
        this.gladiator2 = gladiator2;
    }

    public void printContenstant() {
        System.out.println(this.gladiator1);
        System.out.println(this.gladiator2);
    }

}

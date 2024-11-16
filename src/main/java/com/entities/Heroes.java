package com.entities;

import java.util.ArrayList;

public class Heroes {
    private String nombre;
    private ArrayList<Heroe> heroes;

    public Heroes(String nombre) {
        this.nombre = nombre;
        this.heroes = new ArrayList<>();
    }

    public ArrayList<Heroe> getHeroes() {
        return heroes;
    }

    public void setHeroes(ArrayList<Heroe> heroes) {
        this.heroes = heroes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //metodo para anadir heroes la lista de heroes
    public boolean addHeroe(Heroe heroe) {
        return this.heroes.add(heroe);
    }

    public Heroe remove(int index) {
        return heroes.remove(index);
    }
}

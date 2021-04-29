package com.tribbles.model;

import java.util.List;

/**
 * Lab model
 */
public class Lab {
    private int id;
    private String name;
    private String planet;

    public Lab(int id, String name, String planet) {
        this.id = id;
        this.name = name;
        this.planet = planet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    @Override
    public String toString() {
        return "Lab{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", planet='" + planet + '\'' +
                '}';
    }
}

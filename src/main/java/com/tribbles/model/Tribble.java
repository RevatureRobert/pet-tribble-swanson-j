package com.tribbles.model;

/**
 * Tribble Model
 */
public class Tribble {

    private int id;
    private String name;
    private String color;
    private Lab lab;

    public Tribble(int id, String name, String color, Lab lab) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.lab = lab;
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

    public Lab getLab() {
        return lab;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setLab(Lab lab) {
        this.lab = lab;
    }

    @Override
    public String toString() {
        return "Tribble{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", lab=" + lab +
                '}';
    }
}

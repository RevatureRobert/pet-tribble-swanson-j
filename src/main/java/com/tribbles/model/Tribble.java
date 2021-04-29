package com.tribbles.model;

/**
 * Tribble Model
 */
public class Tribble {

    private int id;
    private String name;
    private Lab lab;

    public Tribble(int id, String name, Lab lab) {
        this.id = id;
        this.name = name;
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

    public void setLab(Lab lab) {
        this.lab = lab;
    }
}

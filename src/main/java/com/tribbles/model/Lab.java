package com.tribbles.model;

import java.util.List;

/**
 * Lab model
 */
public class Lab {
    private int id;
    private List<Tribble> tribbles;

    public Lab(int id, List<Tribble> tribbles) {
        this.id = id;
        this.tribbles = tribbles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Tribble> getTribbles() {
        return tribbles;
    }

    public void setTribbles(List<Tribble> tribbles) {
        this.tribbles = tribbles;
    }
}

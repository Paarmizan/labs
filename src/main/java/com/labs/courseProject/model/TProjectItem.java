package com.labs.courseProject.model;

public abstract class TProjectItem {

    protected String name;

    public TProjectItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

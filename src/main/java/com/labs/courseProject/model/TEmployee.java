package com.labs.courseProject.model;

import java.time.LocalDate;

public class TEmployee extends TProjectItem {

    private LocalDate freeDate = LocalDate.now();

    public TEmployee(String name) {
        super(name);
    }

    public LocalDate getFreeDate() {
        return freeDate;
    }

    public void occupyUntil(LocalDate date) {
        if (date.isAfter(freeDate)) {
            freeDate = date;
        }
    }

    public void reset() {
        freeDate = LocalDate.now();
    }

    @Override
    public String toString() {
        return name;
    }
}

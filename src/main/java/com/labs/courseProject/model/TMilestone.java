package com.labs.courseProject.model;

import java.time.LocalDate;
import java.util.List;

public class TMilestone extends TProjectItem {

    private List<TTask> tasks;

    public TMilestone(String name, List<TTask> tasks) {
        super(name);
        this.tasks = tasks;
    }
}

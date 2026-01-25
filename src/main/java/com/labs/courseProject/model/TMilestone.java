package com.labs.courseProject.model;

import java.time.LocalDate;
import java.util.List;

public class TMilestone extends TProjectItem {

    private List<TTask> tasks;

    public TMilestone(String name, List<TTask> tasks) {
        super(name);
        this.tasks = tasks;
    }

    public LocalDate getExpectedDate() {
        return tasks.stream()
                .map(TTask::calculateFinishDate)
                .max(LocalDate::compareTo)
                .orElse(LocalDate.now());
    }
}

package com.labs.courseProject.model;

import java.util.ArrayList;
import java.util.List;

public class TEmployee extends TProjectItem {

    private List<TTask> tasks = new ArrayList<>();

    public TEmployee(String name) {
        super(name);
    }

    public void assignTask(TTask task) {
        tasks.add(task);
    }

    // загрузка сотрудника в часах
    public int getTotalWorkload() {
        return tasks.stream()
                .mapToInt(TTask::getWorkHours)
                .sum();
    }

    @Override
    public String toString() {
        return name;
    }
}

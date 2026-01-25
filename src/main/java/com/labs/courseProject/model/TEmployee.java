package com.labs.courseProject.model;

import java.time.LocalDate;
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

    public void removeTask(TTask task) {
        tasks.remove(task);
    }

    // загрузка сотрудника в часах
    public int getTotalWorkload() {
        return tasks.stream()
                .mapToInt(TTask::getWorkHours)
                .sum();
    }

    public LocalDate getAvailableDateExcluding(TTask currentTask) {

        int hours = tasks.stream()
                .filter(t -> t != currentTask)
                .mapToInt(TTask::getWorkHours)
                .sum();

        int days = (int) Math.ceil(hours / 8.0);
        return LocalDate.now().plusDays(days);
    }



    @Override
    public String toString() {
        return name;
    }
}

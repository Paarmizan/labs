package com.labs.courseProject.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TTask extends TProjectItem {

    public enum Status {
        TODO, IN_PROGRESS, DONE
    }

    private int workHours;
    private Status status;
    private LocalDate deadline;

    private List<TEmployee> employees = new ArrayList<>();
    private List<TTask> dependencies = new ArrayList<>();

    private LocalDate startDate;
    private LocalDate finishDate;

    public TTask(String name, int workHours, LocalDate deadline) {
        super(name);
        this.workHours = workHours;
        this.deadline = deadline;
        this.status = Status.TODO;
    }

    public int getWorkHours() {
        return workHours;
    }

    public int getDurationDays() {
        return (int) Math.ceil(workHours / 8.0);
    }

    public Status getStatus() {
        return status;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public List<TEmployee> getEmployees() {
        return employees;
    }

    public List<TTask> getDependencies() {
        return dependencies;
    }

    public void addEmployee(TEmployee employee) {
        employees.add(employee);
    }

    public void addDependency(TTask task) {
        dependencies.add(task);
    }

    public void setSchedule(LocalDate startDate) {
        this.startDate = startDate;
        this.finishDate = startDate.plusDays(getDurationDays());
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    @Override
    public String toString() {
        return name;
    }
}

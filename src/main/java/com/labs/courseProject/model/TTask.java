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

    public TTask(String name, int workHours, LocalDate deadline) {
        super(name);
        this.workHours = workHours;
        this.deadline = deadline;
        this.status = Status.TODO;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void addEmployee(TEmployee employee) {
        employees.add(employee);
        employee.assignTask(this);
    }

    public void addDependency(TTask task) {
        dependencies.add(task);
    }

    public List<TTask> getDependencies() {
        return dependencies;
    }

    public List<TEmployee> getEmployees() {
        return employees;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public LocalDate calculateFinishDate() {

        // 1️⃣ старт после зависимостей
        LocalDate startDate = LocalDate.now();

        for (TTask dependency : dependencies) {
            LocalDate depFinish = dependency.calculateFinishDate();
            if (depFinish.isAfter(startDate)) {
                startDate = depFinish;
            }
        }

// 2️⃣ старт после освобождения сотрудников (БЕЗ текущей задачи)
        for (TEmployee employee : employees) {
            LocalDate freeDate = employee.getAvailableDateExcluding(this);
            if (freeDate.isAfter(startDate)) {
                startDate = freeDate;
            }
        }

// 3️⃣ длительность только этой задачи
        int days = (int) Math.ceil(workHours / 8.0);
        return startDate.plusDays(days);

    }


    @Override
    public String toString() {
        return name;
    }
}

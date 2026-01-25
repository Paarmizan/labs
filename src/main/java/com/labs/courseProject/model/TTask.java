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

        // 1️⃣ сначала завершаются зависимости
        LocalDate startDate = LocalDate.now();

        for (TTask dependency : dependencies) {
            LocalDate depFinish = dependency.calculateFinishDate();
            if (depFinish.isAfter(startDate)) {
                startDate = depFinish;
            }
        }

        // 2️⃣ учитываем загрузку сотрудников
        int maxWorkload = employees.stream()
                .mapToInt(TEmployee::getTotalWorkload)
                .max()
                .orElse(workHours);

        int effectiveHours = Math.max(workHours, maxWorkload);

        // 3️⃣ переводим часы в дни (8 часов = 1 день)
        int days = (int) Math.ceil(effectiveHours / 8.0);

        return startDate.plusDays(days);
    }
}

package com.labs.courseProject.model;

import java.time.LocalDate;
import java.util.*;

public class ProjectScheduler {

    public static LocalDate calculateProjectFinish(List<TTask> tasks) {

        Set<TEmployee> employees = new HashSet<>();
        for (TTask t : tasks) {
            employees.addAll(t.getEmployees());
        }
        employees.forEach(TEmployee::reset);

        // сортируем задачи по зависимостям
        List<TTask> orderedTasks = topologicalSort(tasks);

        // планируем задачи
        for (TTask task : orderedTasks) {

            LocalDate startDate = LocalDate.now();

            // зависимости
            for (TTask dep : task.getDependencies()) {
                if (dep.getFinishDate() != null &&
                        dep.getFinishDate().isAfter(startDate)) {
                    startDate = dep.getFinishDate();
                }
            }

            // доступность сотрудников
            for (TEmployee employee : task.getEmployees()) {
                if (employee.getFreeDate().isAfter(startDate)) {
                    startDate = employee.getFreeDate();
                }
            }

            // назначаем даты
            task.setSchedule(startDate);

            // занимаем сотрудников
            for (TEmployee employee : task.getEmployees()) {
                employee.occupyUntil(task.getFinishDate());
            }
        }

        // дата завершения проекта
        return orderedTasks.stream()
                .map(TTask::getFinishDate)
                .max(LocalDate::compareTo)
                .orElse(LocalDate.now());
    }

    // топологическая сортировка
    private static List<TTask> topologicalSort(List<TTask> tasks) {
        List<TTask> result = new ArrayList<>();
        Set<TTask> visited = new HashSet<>();

        for (TTask task : tasks) {
            dfs(task, visited, result);
        }

        return result;
    }

    private static void dfs(TTask task, Set<TTask> visited, List<TTask> result) {
        if (visited.contains(task)) return;

        visited.add(task);
        for (TTask dep : task.getDependencies()) {
            dfs(dep, visited, result);
        }
        result.add(task);
    }
}

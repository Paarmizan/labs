package com.labs.courseProject.controller;

import com.labs.courseProject.model.*;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class ProjectController implements Initializable {

    public TableView<TTask> taskTable;
    public TableColumn<TTask, String> nameCol;
    public TableColumn<TTask, Integer> hoursCol;
    public TableColumn<TTask, TTask.Status> statusCol;
    public TableColumn<TTask, LocalDate> deadlineCol;

    public ListView<TEmployee> employeeList;
    public Label resultLabel;

    private List<TTask> tasks;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // колонки
        nameCol.setCellValueFactory(d ->
                new javafx.beans.property.SimpleStringProperty(d.getValue().getName()));
        hoursCol.setCellValueFactory(d ->
                new javafx.beans.property.SimpleObjectProperty<>(d.getValue().getWorkHours()));
        statusCol.setCellValueFactory(d ->
                new javafx.beans.property.SimpleObjectProperty<>(d.getValue().getStatus()));
        deadlineCol.setCellValueFactory(d ->
                new javafx.beans.property.SimpleObjectProperty<>(d.getValue().getDeadline()));

        // тестовые данные
        TEmployee e1 = new TEmployee("Иван");
        TEmployee e2 = new TEmployee("Анна");

        TTask t1 = new TTask("Проектирование", 16, LocalDate.now().plusDays(5));
        TTask t2 = new TTask("Реализация", 32, LocalDate.now().plusDays(10));
        t2.addDependency(t1);

        t1.addEmployee(e1);
        t2.addEmployee(e1);
        t2.addEmployee(e2);

        tasks = List.of(t1, t2);

        taskTable.setItems(FXCollections.observableArrayList(tasks));
        employeeList.setItems(FXCollections.observableArrayList(e1, e2));
    }

    public void calculateProject() {

        LocalDate finishDate = tasks.stream()
                .map(TTask::calculateFinishDate)
                .max(LocalDate::compareTo)
                .orElse(LocalDate.now());

        resultLabel.setText("Дата завершения проекта: " + finishDate);
    }
}
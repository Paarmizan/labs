package com.labs.courseProject.controller;

import com.labs.courseProject.model.*;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ProjectController implements Initializable {

    public TableView<TTask> taskTable;
    public TableColumn<TTask, String> nameCol;
    public TableColumn<TTask, Integer> hoursCol;
    public TableColumn<TTask, TTask.Status> statusCol;
    public TableColumn<TTask, LocalDate> deadlineCol;
    public TableColumn<TTask, String> employeesCol;
    public TableColumn<TTask, String> depsCol;

    public TextField nameField;
    public TextField hoursField;
    public DatePicker deadlinePicker;

    public ListView<TEmployee> employeeSelectList;
    public ListView<TTask> dependencyList;

    public ListView<TEmployee> employeeList;
    public Label resultLabel;

    private javafx.collections.ObservableList<TTask> tasks;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        nameCol.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getName()));
        hoursCol.setCellValueFactory(d -> new javafx.beans.property.SimpleObjectProperty<>(d.getValue().getWorkHours()));
        statusCol.setCellValueFactory(d -> new javafx.beans.property.SimpleObjectProperty<>(d.getValue().getStatus()));
        deadlineCol.setCellValueFactory(d -> new javafx.beans.property.SimpleObjectProperty<>(d.getValue().getDeadline()));

        employeesCol.setCellValueFactory(d ->
                new javafx.beans.property.SimpleStringProperty(
                        d.getValue().getEmployees().stream()
                                .map(TEmployee::getName)
                                .reduce((a, b) -> a + ", " + b)
                                .orElse("—")
                ));

        depsCol.setCellValueFactory(d ->
                new javafx.beans.property.SimpleStringProperty(
                        d.getValue().getDependencies().stream()
                                .map(TTask::getName)
                                .reduce((a, b) -> a + ", " + b)
                                .orElse("—")
                ));

        // тестовые данные
        TEmployee e1 = new TEmployee("Иван");
        TEmployee e2 = new TEmployee("Анна");

        TTask t1 = new TTask("Проектирование", 16, LocalDate.now().plusDays(5));
        TTask t2 = new TTask("Реализация", 32, LocalDate.now().plusDays(10));
        t2.addDependency(t1);

        t1.addEmployee(e1);
        t2.addEmployee(e1);
        t2.addEmployee(e2);

        tasks = FXCollections.observableArrayList(t1, t2);

        taskTable.setItems(tasks);
        employeeList.setItems(FXCollections.observableArrayList(e1, e2));

        employeeSelectList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        dependencyList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        employeeSelectList.setItems(employeeList.getItems());
        dependencyList.setItems(tasks);
    }

    public void calculateProject() {
        LocalDate finish = ProjectScheduler.calculateProjectFinish(tasks);
        resultLabel.setText("Дата завершения проекта: " + finish);
    }

    public void addTask() {

        String name = nameField.getText();
        String hoursText = hoursField.getText();
        LocalDate deadline = deadlinePicker.getValue();

        if (name.isBlank() || hoursText.isBlank() || deadline == null) return;

        int hours;
        try {
            hours = Integer.parseInt(hoursText);
        } catch (NumberFormatException e) {
            return;
        }

        TTask task = new TTask(name, hours, deadline);

        task.getEmployees().addAll(employeeSelectList.getSelectionModel().getSelectedItems());
        task.getDependencies().addAll(dependencyList.getSelectionModel().getSelectedItems());

        tasks.add(task);

        nameField.clear();
        hoursField.clear();
        deadlinePicker.setValue(null);
        employeeSelectList.getSelectionModel().clearSelection();
        dependencyList.getSelectionModel().clearSelection();
    }

    public void removeTask() {
        TTask selected = taskTable.getSelectionModel().getSelectedItem();
        if (selected == null) return;

        tasks.forEach(t -> t.getDependencies().remove(selected));
        tasks.remove(selected);
    }
}
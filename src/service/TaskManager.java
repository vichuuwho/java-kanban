package service;

import model.Epic;
import model.Status;
import model.SubTask;
import model.Task;

import java.util.ArrayList;
import java.util.HashMap;

public class TaskManager {
    private final HashMap<Integer, Task> tasks = new HashMap<>();
    private final HashMap<Integer, SubTask> subtasks = new HashMap<>();
    private final HashMap<Integer, Epic> epics = new HashMap<>();
    private Integer number = 1;

    public Task addTask(Task task) {
        //number = setNumber(number);
        task.setNumber(number++);
        tasks.put(number, task);
        return task;
    }


    public SubTask addSubTask(SubTask subtask) {
        //number = setNumber(number);
        subtask.setNumber(number++);
        subtasks.put(subtask.getNumber(), subtask);
        whichStatus(epics.get(subtask.getEpicNumber()));
        return subtask;
    }

    public Epic addEpic(Epic epic) {
        //number = setNumber(number);
        epic.setNumber(number++);
        epics.put(epic.getNumber(), epic);
        return epic;
    }

    public ArrayList<Epic> getEpics() {
        if (epics != null) {
            return new ArrayList<>(epics.values());
        }
        return null;
    }

    public ArrayList<Task> getTasks() {
        if (tasks != null) {
            return new ArrayList<>(tasks.values());
        } else {
            return null;
        }
    }

    public ArrayList<SubTask> getSubTasks() {
        if (subtasks != null) {
            return new ArrayList<>(subtasks.values());
        } else {
            return null;
        }
    }

    public void removeAllTasks() {
        tasks.clear();
    }

    public void removeAllSubTasks() {
        subtasks.clear();
        for (Epic epic : epics.values()) {
            epic.getSubTasks().clear();
            updateTask(epic);
        }
    }

    public void removeAllEpics() {
        epics.clear();
        subtasks.clear();
    }


    public Task getByIndex(int number) {
        if (tasks.containsKey(number)) {
            return tasks.get(number);
        } else if (subtasks.containsKey(number)) {
            return subtasks.get(number);
        } else if (epics.containsKey(number)) {
            return epics.get(number);
        } else {
            return null;
        }
    }

    /*private int setNumber(int number) {
        return ++number;
    }*/

    public void updateTask(Task task) {
        tasks.put(task.getNumber(), task);
    }


    public void updateEpic(Epic epic) {
        Epic saved = epics.get(epic.getNumber());
        if (saved == null) {
            return;
        }
        saved.setName(epic.getName());
        saved.setDescription(epic.getName());
    }

    public void updateSubTask(SubTask subTask) {
        Epic epic = epics.get(subTask.getEpicNumber());
        if (epic == null) {
            return;
        }
        subtasks.put(subTask.getNumber(), subTask);
        whichStatus(epic);
    }

    private void whichStatus(Epic epic) { //Обновление статуса
        if (epic.getSubTasks().isEmpty()) {
            epic.setStatus(Status.NEW);
            return;
        }
        int isNew = 0;
        int isDone = 0;
        ArrayList<SubTask> sabList = new ArrayList<>();
        for (Integer id : epic.getSubTasks()) {
            sabList.add(subtasks.get(id));
        }
        for (SubTask subTask : sabList) {
            if (subTask.getStatus() == Status.NEW) {
                isNew++;
            } else if (subTask.getStatus() == Status.DONE) {
                isDone++;
            }
        }
        if (subtasks.isEmpty() || isNew == subtasks.size()) {
            epic.setStatus(Status.NEW);
        } else if (isDone == subtasks.size()) {
            epic.setStatus(Status.DONE);
        } else {
            epic.setStatus(Status.IN_PROGRESS);
        }
    }


    public Object removeTask(int number) {
        if (tasks.containsKey(number)) {
            return tasks.remove(number);
        } else if (subtasks.containsKey(number)) {
            return subtasks.remove(number);
        } else if (epics.containsKey(number)) {
            for (Integer subTask : epics.get(number).getSubTasks()) {
                epics.remove(subTask);
            }
            return epics.remove(number);
        } else {
            return null;
        }
    }
}

package model;

import java.util.ArrayList;

public class Epic extends Task {


    private ArrayList<Integer> subTasks = new ArrayList<>();


    public Epic(String name, String description) {
        super(name, description, Status.NEW);
    }

    public void addSubTasks(int subTask) {
        subTasks.add(subTask);
    }

    public ArrayList<Integer> getSubTasks() {
        return subTasks;
    }
}

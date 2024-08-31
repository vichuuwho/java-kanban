package model;

public class SubTask extends Task {
    int epicNumber;

    public SubTask(String name, String description, Status status, int epicNumber) {
        super(name, description, status);
        this.epicNumber = epicNumber;
    }

    public int getEpicNumber() {
        return epicNumber;
    }
}

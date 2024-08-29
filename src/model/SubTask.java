package model;

public class SubTask extends Task {
    private int number;
    Epic epic;

    public SubTask(String name, String description, Status status) {
        super(name, description, status);
    }

    public void setId(int number) {
        this.number = number;
    }


    public Epic getEpic() {
        return epic;
    }
}

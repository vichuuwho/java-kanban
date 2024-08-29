public class SubTask extends Task {
    private int number;

    public SubTask(String name, String description, Status status, int number) {
        super(name, description, status);
        this.number = number;
    }

}

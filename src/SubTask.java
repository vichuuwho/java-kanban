public class SubTask extends Task {

    private String name;
    private String description;
    private Status status;

    public SubTask(String name, String description, Status status) {
        super(name, description, status);
    }

    @Override
    public String toString() {
        return "Subtask{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}

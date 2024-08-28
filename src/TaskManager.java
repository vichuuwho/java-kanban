import java.util.HashMap;

public class TaskManager {
    static HashMap<Integer, Task> tasks = new HashMap<>();
    static HashMap<Integer, SubTask> subtasks = new HashMap<>();
    static HashMap<Integer, Epic> epics = new HashMap<>();
    private static Integer number = 0;

    public static void addTask(Task task) { // добавить задачи
        number = setNumber(number);
        tasks.put(number, task);
    }

    public static void addSubtask(SubTask subTask) {
        number = setNumber(number);
        subtasks.put(number, subTask);
    }

    public static void addEpic(Epic epic) {
        number = setNumber(number);
        epics.put(number, epic);
    }

    public static void printTasks() { // Вывести все задачи

        if (tasks != null) {
            System.out.println(tasks);
        }
        if (subtasks != null) {
            System.out.println(subtasks);
        }
        if (epics != null) {
            System.out.println(epics);
        }
    }

    public static void removeAllTasks() {
        tasks.clear();
        subtasks.clear();
        epics.clear();
    }

    public static Object getByIndex(int number) {
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

    public static int setNumber(int number) {
        return ++number;
    }

    public static void updateTask(Task task) {

        if (task.getClass() == Task.class) {
            tasks.put(task.getNumber(), task);
        } else if (task.getClass().equals(SubTask.class)) {
            subtasks.put(task.getNumber(), (SubTask) task);
        } else if (task.getClass().equals(Epic.class)) {
            boolean isNew = false;
            boolean isDone = false;
            epics.put(task.getNumber(), (Epic) task);
            for (SubTask subTask : ((Epic) task).getSubTasks()) {
                if (subTask.getStatus() != Status.NEW) {
                    isNew = false;
                } else {
                    isNew = true;
                }
            }
            for (SubTask subTask : ((Epic) task).getSubTasks()) {
                if (subTask.getStatus() != Status.DONE) {
                    isDone = false;
                } else {
                    isDone = true;
                }
            }
            if (isNew || epics.get(task.getNumber()) == null) {
                epics.get(task.getNumber()).setStatus(Status.NEW);
            } else if (isDone) {
                epics.get(task.getNumber()).setStatus(Status.DONE);
            } else {
                epics.get(task.getNumber()).setStatus(Status.IN_PROGRESS);
            }
        }
    }

    public int getNumber() {
        return number;
    }

    public Object removeTask(int number) { // удалить все задачи
        if (tasks.containsKey(number)) {
            return tasks.remove(number);
        } else if (subtasks.containsKey(number)) {
            return subtasks.remove(number);
        } else if (epics.containsKey(number)) {
            return epics.remove(number);
        } else {
            return null;
        }
    }
}

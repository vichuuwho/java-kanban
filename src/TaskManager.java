import java.util.HashMap;

public class TaskManager {
    private HashMap<Integer, Task> tasks = new HashMap<>();
    private HashMap<Integer, SubTask> subtasks = new HashMap<>();
    private HashMap<Integer, Epic> epics = new HashMap<>();
    private static Integer number = 0;

    public void addTask(Task task) {
        number = setNumber(number);
        tasks.put(number, task);
    }

    public void addSubtask(SubTask subTask) {
        number = setNumber(number);
        subtasks.put(number, subTask);
        epics.put(subTask.getNumber(), epics.addSubTasks(number));
    }

    public void addEpic(Epic epic) {
        number = setNumber(number);
        epics.put(number, epic);
    }

    public Object printTasks() {
        if (tasks != null) {
            return tasks;
        }
        if (subtasks != null) {
            return subtasks;
        }
        if (epics != null) {
            return epics;
        }
        return null;
    }

    public void removeAllTasks() {
        tasks.clear();
    }

    public void removeAllSubTasks() {
        subtasks.clear();
    }

    public void removeAllEpics() {
        epics.clear();
        subtasks.clear();
    }


    public Object getByIndex(int number) {
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

    public void updateTask(Task task) {

        if (task.getClass() == Task.class) {
            tasks.put(task.getNumber(), task);
        } else if (task.getClass().equals(SubTask.class)) {
            subtasks.put(task.getNumber(), (SubTask) task);
            if (isNew(epics.get(task)) || epics.get(task.getNumber()) == null) {
                epics.get(task.getNumber()).setStatus(Status.NEW);
            } else if (isDone(epics.get(task))) {
                epics.get(task.getNumber()).setStatus(Status.DONE);
            } else {
                epics.get(task.getNumber()).setStatus(Status.IN_PROGRESS);
            }
        } else if (task.getClass().equals(Epic.class)) {
            epics.put(task.getNumber(), (Epic) task);
            if (isNew(epics.get(task)) || epics.get(task.getNumber()) == null) {
                epics.get(task.getNumber()).setStatus(Status.NEW);
            } else if (isDone(epics.get(task))) {
                epics.get(task.getNumber()).setStatus(Status.DONE);
            } else {
                epics.get(task.getNumber()).setStatus(Status.IN_PROGRESS);
            }
        }
    }

    public boolean isNew(Epic epic) {
        boolean isNew = false;
        for (Integer subTask : epic.getSubTasks()) {
            if (epics.get(subTask).getStatus() != Status.NEW) {
                return isNew = false;
            } else {
                return isNew = true;
            }
        }
        return isNew;
    }

    public boolean isDone(Epic epic) {
        boolean isDone = false;
        for (Integer subTask : epic.getSubTasks()) {
            if (epics.get(subTask).getStatus() != Status.DONE) {
                return isDone = false;
            } else {
                return isDone = true;
            }
        }
        return isDone;
    }

    public int getNumber() {
        return number;
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

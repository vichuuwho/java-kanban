import model.Epic;
import model.SubTask;
import model.Task;
import service.TaskManager;

import static model.Status.IN_PROGRESS;
import static model.Status.NEW;

public class Main {

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        System.out.println("Поехали!");


        Task t1 = new Task("Погладить кота", "почесать за ушком", NEW);
        Task t2 = new Task("похавать", "найти еду", NEW);
        taskManager.addTask(t1);
        taskManager.addTask(t2);
        taskManager.getTasks();
        //🥴🥴🥴🥴

        Epic e11 = taskManager.addEpic(new Epic("Эпик", "описание эпика"));

        SubTask s1 = taskManager.addSubTask(new SubTask("1234", "qwerty", NEW, e11.getNumber()));
        SubTask s2 = taskManager.addSubTask(new SubTask("Что-то", "еще что-то", NEW, e11.getNumber()));
        e11.addSubTasks(s1.getNumber());
        e11.addSubTasks(s2.getNumber());

        taskManager.getEpics();
        taskManager.getSubTasks();

        SubTask s500 = taskManager.addSubTask(new SubTask("dwdw", "wewe", IN_PROGRESS, e11.getNumber()));
        System.out.println();
        System.out.println("Обновление: ");
        taskManager.getSubTasks();
        System.out.println();


        taskManager.removeTask(6);
        System.out.println();
        System.out.println("Должны остатся 2 задачи ");
        taskManager.getSubTasks();

        System.out.println();
        System.out.println("вывод обновленных епиков - " + taskManager.getEpics());

        System.out.println();
        System.out.println("вывод обновленных сабтасков - " + taskManager.getSubTasks());


        System.out.println();
        System.out.println("поиск по id: " + taskManager.getByIndex(2));
        System.out.println();


        taskManager.removeAllTasks();
        taskManager.removeAllEpics();
        System.out.println("Task  - " + taskManager.getTasks());
        System.out.println("Epic  - " + taskManager.getEpics());
        System.out.println("SubTask  - " + taskManager.getSubTasks());


    }
}



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

        Epic e11 = taskManager.addEpic(new Epic("Концерт", "Научится кидать артистов на бабки."));

        SubTask s1 = taskManager.addSubTask(new SubTask("Найти актеров", "Кинуть актеров", NEW, e11.getNumber()));
        SubTask s2 = taskManager.addSubTask(new SubTask("Собрать деньги", "Забрать все себе", NEW, e11.getNumber()));
        e11.addSubTasks(s1.getNumber());
        e11.addSubTasks(s2.getNumber());

        taskManager.getEpics();
        taskManager.getSubTasks();
        // ඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞ ОБНОВЛЕНИЕ ඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞ

        SubTask s500 = taskManager.addSubTask(new SubTask("Продавать", "Кукурузу", IN_PROGRESS, e11.getNumber()));
        System.out.println();
        System.out.println("Обновление: ");
        taskManager.getSubTasks();
        System.out.println();

        // ඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞ УДАЛИТЬ САБТАКС ඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞ

        taskManager.removeTask(6);
        System.out.println();
        System.out.println("Должны остатся 2 задачи ");
        taskManager.getSubTasks();
        // ඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞ УДАЛИТЬ САБТАКС ඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞ

        System.out.println();
        System.out.println("вывод обновленных епиков - " + taskManager.getEpics());

        System.out.println();
        System.out.println("вывод обновленных сабтасков - " + taskManager.getSubTasks());

        // ඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞ общий метод по поиску ID ඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞ

        System.out.println();
        System.out.println("поиск по айди: " + taskManager.getByIndex(2));
        System.out.println();

        // ඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞ Проверка удаления ඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞ

        taskManager.removeAllTasks();
        taskManager.removeAllEpics();
        System.out.println("Task говорит - " + taskManager.getTasks());
        System.out.println("Epic говорит - " + taskManager.getEpics());
        System.out.println("СабТаск говорит - " + taskManager.getSubTasks());
        // ඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞ Проверка удаления ඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞඞ


    }
}



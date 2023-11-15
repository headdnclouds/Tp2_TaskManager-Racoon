package info;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class TaskManager {
    @Getter
    List<Task> tasks = new ArrayList<Task>();

    public static void main(String[] args)
    {
        System.out.println("Tasks Manager");

        TaskManager taskManager = new TaskManager();

        Scanner sc = new Scanner(System.in);
        while (true){
            String input = sc.nextLine();
            if (input.charAt(0) == 'q')
                return;
            taskManager.process(input.charAt(0),input.substring(2));
        }
    }

    public void process(char command, String data){
        switch (command){
            case '+':
                addTask(new Task(data));
                break;
            case '-':
                removeTask(Integer.parseInt(data));
                break;
            case 'x':
                setDone(Integer.parseInt(data));
                break;
            case 'o':
                setTodo(Integer.parseInt(data));
                break;
        }
    }

    // Add a task
    public void addTask(Task task){
        tasks.add(task);
    }

    // Remove the task matching the given id
    public void removeTask(int id){
         tasks = tasks.stream().filter(e-> e.getId()!=id).collect(Collectors.toList());
    }

    // Set the status of the task matching the id to "done".
    public void setDone(int id){
        tasks.stream().filter(e-> e.getId()==id).forEach(Task::done);
    }

    // Set the status of the task matching the id to "to do".
    public void setTodo(int id){
        tasks.stream().filter(e-> e.getId()==id).forEach(Task::todo);
    }
}

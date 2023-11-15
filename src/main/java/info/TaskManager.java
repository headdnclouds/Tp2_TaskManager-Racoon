package info;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class TaskManager {
    @Getter
    List<Task> tasks = new ArrayList<Task>();

    public static void main(String[] args)
    {
        System.out.println("Hello world");
    }

    // Add a task
    public void addTask(Task task){
        tasks.add(task);
    }

    // Set Task Done
    public void setDone(int id){
        tasks.stream().filter(e-> e.getId()==id).forEach(Task::done);
    }

    // Remove the task matching the given id
    public void removeTask(int id){
         tasks = tasks.stream().filter(e-> e.getId()!=id).collect(Collectors.toList());
    }
}

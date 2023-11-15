package info;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


public class TaskManager {
    @Getter
    List<Task> tasks = new ArrayList<Task>();

    public static void main(String[] args)
    {
        System.out.println("Hello world");
    }

    // + <description> Add a task
    public void addTask(Task task){
        tasks.add(task);
    }

}

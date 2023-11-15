package info;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerTest {

    @Test
    public void when_add_task_should_increase_tasks_list_size(){
        //Initialization
        String description = "description";
        Task task = new Task(description);
        TaskManager taskManager = new TaskManager();
        int tasksLength = taskManager.getTasks().size();

        //Treatment
        taskManager.addTask(task);

        //Verification
        assertEquals(tasksLength+1 ,taskManager.getTasks().size(),"The task is not added to the list of tasks");
        assertEquals(task, taskManager.getTasks().get(0),"The task added is not equal to the initial task");
    }
}

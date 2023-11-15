package info;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerTest {

    private TaskManager taskManager;

    @BeforeEach
    void setUp() {
        taskManager = new TaskManager();
    }

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

    @Test
    public void when_add_task_should_decrease_tasks_list_size(){
        //Initialization
        String description = "description";
        Task task = new Task(description);
        taskManager.addTask(task);
        int tasksLength = taskManager.getTasks().size();

        //Treatment
        taskManager.removeTask(task.getId());

        //Verification
        assertEquals(tasksLength - 1 ,taskManager.getTasks().size(),"The task is not added to the list of tasks");
    }
    @Test
    public void when_set_status_done_task_set_done(){

        //Initialization
        String description = "description";
        Task task = new Task(description);
        taskManager.addTask(task);

        //Treatment
        taskManager.setDone(task.getId());

        //Verification
        assertEquals("done",task.getStatus());
    }

    @Test
    public void when_set_status_todo_task_set_todo(){

        //Initialization
        String description = "description";
        Task task = new Task(description);
        taskManager.addTask(task);
        taskManager.setDone(task.getId());

        //Treatment
        taskManager.setTodo(task.getId());

        //Verification
        assertEquals("to do",task.getStatus());
    }

}

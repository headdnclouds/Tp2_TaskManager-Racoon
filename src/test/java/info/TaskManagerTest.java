package info;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    public void when_user_add_task_should_add_task(){

        //Initialization
        String description = "description";
        char command = '+';

        //Treatment
        taskManager.process(command,description);

        //Verification
        assertEquals(1,taskManager.tasks.size(), "The task is not added.");
    }

    @Test
    public void when_user_remove_task_should_remove_task(){

        //Initialization
        Task task = new Task("description");
        taskManager.addTask(task);
        String data = String.valueOf(task.getId());
        char command = '-';

        //Treatment
        taskManager.process(command,data);

        //Verification
        assertEquals(0,taskManager.tasks.size(), "The task is not removed.");
    }

    @Test
    public void when_user_set_done_task_should_switch_to_done(){

        //Initialization
        Task task = new Task("description");
        taskManager.addTask(task);
        String data = String.valueOf(task.getId());
        char command = 'x';

        //Treatment
        taskManager.process(command,data);

        //Verification
        assertEquals("done",task.getStatus(), "The task status is not updated to done.");
    }

    @Test
    public void when_user_set_todo_task_should_switch_to_todo(){

        //Initialization
        Task task = new Task("description");
        task.done();
        taskManager.addTask(task);
        String data = String.valueOf(task.getId());
        char command = 'o';

        //Treatment
        taskManager.process(command,data);

        //Verification
        assertEquals("to do",task.getStatus(), "The task status is not updated to todo.");
    }

}

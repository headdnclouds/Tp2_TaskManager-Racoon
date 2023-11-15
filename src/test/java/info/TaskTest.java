package info;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void when_creating_task_should_have_todo_status(){
        //init - param
        String description = "description";

        //treatment - create object task
        Task task = new Task(description);

        //verify
        assertEquals("to do", task.getStatus());
    }

    @Test
    public void task_id_should_be_unique(){
        //init - param
        String description = "description";

        //treatment - create object task
        Task task1 = new Task(description);
        Task task2 = new Task(description);

        //verify
        assertNotEquals(task1.getId(),task2.getId());
    }

    @Test
    public void when_set_status_done_task_set_done(){

        //Initialization
        String description = "description";
        Task task = new Task(description);

        //Treatment
        task.done();

        //Verification
        assertEquals("done",task.getStatus());
    }

    @Test
    public void when_set_status_todo_task_set_todo(){

        //Initialization
        String description = "description";
        Task task = new Task(description);
        task.done();

        //Treatment
        task.todo();

        //Verification
        assertEquals("to do",task.getStatus());
    }
}

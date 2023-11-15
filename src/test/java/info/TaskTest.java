package info;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void when_creating_task_should_return_task_object(){
        //init - param
        String description = "description";
        int id = 1;
        String status = "done";

        //treatment - create object task
        Task task = new Task(description,id,status);

        //verify
        assertNotNull(task);
        assertEquals(description,task.getDescription(), "The description is not properly set.");
        assertEquals(id,task.getId(), "The id is not properly set.");
        assertEquals(status,task.getStatus(), "The status is not properly set.");
    }
}

package info;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void when_creating_task_should_have_todo_status(){
        //init - param
        String description = "description";
        int id = 1;

        //treatment - create object task
        Task task = new Task(description,id);

        //verify
        assertEquals("to do", task.getStatus());
    }
}

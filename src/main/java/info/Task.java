package info;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Objects;

@Getter
@EqualsAndHashCode
public class Task {
    private static int previousId = 0;
    private String description;
    private int id;
    private String status;

    public Task(String description) {
        this.description = description;
        this.id = previousId++;
        this.status = "to do";
    }

    public void done(){
        this.status = "done";
    }

    public void todo(){
        this.status = "to do";
    }

    @Override
    public String toString() {
        return new StringBuilder(String.valueOf(id)).append(" [").append(Objects.equals(status, "to do") ? " " : "x").append("] ").append(description).toString();
    }
}

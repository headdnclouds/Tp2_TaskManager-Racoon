package info;

import lombok.Getter;
import lombok.Setter;

public class Task {
    @Getter
    private String description;
    @Getter
    private int id;
    @Getter
    private String status;

    public Task(String description, int id) {
        this.description = description;
        this.id = id;
        this.status = "to do";
    }
}

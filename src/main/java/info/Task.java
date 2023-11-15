package info;

import lombok.Getter;

public class Task {
    @Getter
    private String description;
    @Getter
    private int id;
    @Getter
    private String status;

    public Task(String description, int id, String status) {
        this.description = description;
        this.id = id;
        this.status = status;
    }
}

package info;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class Task {
    private static int previousId = 0;
    @Getter
    private String description;
    @Getter
    private int id;
    @Getter
    private String status;

    public Task(String description) {
        this.description = description;
        this.id = previousId++;
        this.status = "to do";
    }

    public void done(){
        this.status = "done";
    }
}

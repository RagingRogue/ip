public class Task {
    private boolean finished;
    private String taskDescription;

    public Task(String description) {
        this.finished = false;
        this.taskDescription = description;
    }

    public void done() {
        this.finished = true;
    }

    public void notDone() {
        this.finished = false;
    }

    @Override
    public String toString() {
        return (this.finished == true ? "[X] " : "[ ] ") + taskDescription;
    }
}

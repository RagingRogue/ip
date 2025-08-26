abstract class Task {
    private boolean finished;
    private String taskDescription;
    public abstract String toFileFormat();

    public Task(String description) {
        this.finished = false;
        this.taskDescription = description;
    }

    public String getTaskDescription() {
        return this.taskDescription;
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

    public String getStatusIcon() {
        return (finished ? "1" : "0");
    }
}

package abang.task;

/**
 * Represents a generic task with a description and completion status.
 * <p>
 */
public abstract class Task {
    /** Whether the task is finished (true) or not (false). */
    private boolean finished;

    /** The description of the task. */
    private String taskDescription;

    /**
     * Converts the task into a format suitable for file saving.
     *
     * @return the string representation of the task in file format
     */
    public abstract String toFileFormat();


    /**
     * Constructs a task with the given description.
     * By default, the task is marked as not done.
     *
     * @param description the description of the task
     */
    public Task(String description) {
        this.finished = false;
        this.taskDescription = description;
    }

    public boolean contain(String word) {
        String[] words = taskDescription.split(" ");
        boolean found = false;
        for (String key : words) {
            if (key.equals(word)) {
                found = true;
                break;
            }
        }
        return found;
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

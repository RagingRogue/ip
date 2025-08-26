public class Event extends Task {
    String start;
    String end;

    public Event(String description, String start, String end) {
        super(description);
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + String.format("(from: %s to: %s)", start, end);
    }

    @Override
    public String toFileFormat() {
        return "E | " + getStatusIcon() + " | " + getTaskDescription() + " | " + String.format("(from: %s to: %s)", start, end) ;
    }

}
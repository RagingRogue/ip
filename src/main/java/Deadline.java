import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task {
    String detail;
    LocalDate deadline;
    LocalDateTime deadlineTime;

    public Deadline(String description, String detail) {
        super(description);
        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("d/M/yyyy");
            this.deadline = LocalDate.parse(detail, format);
            return;
        } catch (DateTimeParseException e) {
        }
        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
            this.deadlineTime = LocalDateTime.parse(detail, format);
            return;
        } catch (DateTimeParseException e) {
        }
        this.detail = detail;
    }

    @Override
    public String toString() {
        if (deadline != null) {
            return "[D]" + super.toString() +
                    " (by: " + deadline.format(DateTimeFormatter.ofPattern("MMM dd yyyy")) + ")";
        }
        if (deadlineTime != null) {
            return "[D]" + super.toString() +
                    " (by: " + deadlineTime.format(DateTimeFormatter.ofPattern("MMM dd yyyy HHmm")) + ")";
        } else {
            return "[D]" + super.toString() + " (by: " + detail + ")";
        }
    }

    @Override
    public String toFileFormat() {
        if (deadline != null) {
            return "D | " + getStatusIcon() + " | " + getTaskDescription() + " | " + deadline;
        }
        if (deadlineTime != null) {
            return "D | " + getStatusIcon() + " | " + getTaskDescription() + " | " + deadlineTime;
        }
        else {
            return "D | " + getStatusIcon() + " | " + getTaskDescription() + " | " + detail;
        }
    }
}

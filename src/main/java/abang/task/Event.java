package abang.task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Event extends Task {
    String start;
    String end;
    LocalDate startdate;
    LocalDate enddate;
    LocalDateTime startTime;
    LocalDateTime endTime;

    DateTimeFormatter fmtDate = DateTimeFormatter.ofPattern("MMM dd yyyy");
    DateTimeFormatter fmtDateTime = DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm");

    private static final DateTimeFormatter PARSE_DATE = DateTimeFormatter.ofPattern("d/M/yyyy");
    private static final DateTimeFormatter PARSE_DATETIME = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");


    public Event(String description, String start, String end) {
        super(description);

        try {
            this.startdate = LocalDate.parse(start, PARSE_DATE);
        } catch (DateTimeParseException e) {
            try {
                this.startTime = LocalDateTime.parse(start, PARSE_DATETIME);
            } catch (DateTimeParseException e2) {
                this.start = start;
            }
        }

        try {
            this.enddate = LocalDate.parse(end, PARSE_DATE);
        } catch (DateTimeParseException e) {
            try {
                this.endTime = LocalDateTime.parse(end, PARSE_DATETIME);
            } catch (DateTimeParseException e2) {
                this.end = end;
            }
        }
    }

    @Override
    public String toString() {
        String startStr;
        if (startTime != null) {
            startStr = startTime.format(fmtDateTime);
        } else if (startdate != null) {
            startStr = startdate.format(fmtDate);
        } else {
            startStr = start;
        }

        String endStr;
        if (endTime != null) {
            endStr = endTime.format(fmtDateTime);
        } else if (enddate != null) {
            endStr = enddate.format(fmtDate);
        } else {
            endStr = end;
        }

        return "[E]" + super.toString() +
                String.format(" (from: %s to: %s)", startStr, endStr);
    }

    @Override
    public String toFileFormat() {

        String startStr;
        if (startTime != null) {
            startStr = startTime.format(fmtDateTime);
        } else if (startdate != null) {
            startStr = startdate.format(fmtDate);
        } else {
            startStr = start;
        }

        String endStr;
        if (endTime != null) {
            endStr = endTime.format(fmtDateTime);
        } else if (enddate != null) {
            endStr = enddate.format(fmtDate);
        } else {
            endStr = end;
        }

        return "E | " + getStatusIcon() + " | " + getTaskDescription() +
                " | from: " + startStr + " to: " + endStr;
    }

}
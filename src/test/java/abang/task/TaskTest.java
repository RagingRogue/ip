package abang.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TaskTest {


    static class DummyTask extends Task {
        public DummyTask(String description) {
            super(description);
        }

        @Override
        public String toFileFormat() {
            return "dummy|" + getTaskDescription();
        }
    }

    @Test
    public void constructor_setsDescriptionCorrectly() {
        Task task = new DummyTask("read book");
        assertEquals("read book", task.getTaskDescription());
        assertEquals("[ ] read book", task.toString());
        assertEquals("0", task.getStatusIcon());
    }

    @Test
    public void done_marksTaskAsFinished() {
        Task task = new DummyTask("write code");
        task.done();
        assertTrue(task.toString().contains("[X]"));
        assertEquals("1", task.getStatusIcon());
    }

    @Test
    public void notDone_marksTaskAsUnfinished() {
        Task task = new DummyTask("test app");
        task.done();
        task.notDone();
        assertFalse(task.toString().contains("[X]"));
        assertEquals("0", task.getStatusIcon());
    }
}

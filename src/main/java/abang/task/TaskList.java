package abang.task;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> list = new ArrayList<>();

    public void add(Task input) {
        list.add(input);
    }

    public void remove(int index) {
        list.remove(index -1);
    }

    public Task getTask(int i) {
        return list.get(i - 1);
    }

    public int numTask() {
        return list.size();
    }

    public void mark(int index) {
        Task task = list.get(index -1);
        task.done();
    }

    public void clear() {
        list.clear();
    }

    public void unmark(int index) {
        Task task = list.get(index -1);
        task.notDone();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int len = list.size();
        for (int i = 0; i < len; i++) {
            sb.append(i + 1).append(". ").append(list.get(i)).append("\n");
        }
        return sb.toString();
    }

    public ArrayList<String> toFileLines() {
        ArrayList<String> fileLines = new ArrayList<String>();
        for (Task t: list) {
            fileLines.add(t.toFileFormat());
        }
        return fileLines;
    }

    public static TaskList fromFileLines(ArrayList<String> fileLines) {
        TaskList taskList = new TaskList();
        for (String line : fileLines) {
                String[] parts = line.split(" \\| ");
                String type = parts[0];
                boolean isDone = parts[1].equals("1");
                String description = parts[2];
                Task task;
                switch (type) {
                    case "T":
                        task = new ToDo(description);
                        break;
                    case "D":
                        task = new Deadline(description, parts[3]);
                        break;
                    case "E":
                        String text = parts[3];
                        text = text.replace("(", "").replace(")", "");
                        String[] components = text.split("to:");
                        String start = components[0].replace("from:", "").trim();
                        String end = components[1].trim();
                        task = new Event(description, start, end);
                        break;
                    default:
                        continue;
                }
                if (isDone) {
                    task.done();
                }
                taskList.add(task);
        }
        return taskList;
    }


}

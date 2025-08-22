import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> list = new ArrayList<>();

    public void add(Task input) {
        list.add(input);
    }

    public void remove(int index) {
        list.remove(index);
    }

    public Task getTask(int i) {
        return list.get(i - 1);
    }

    public int numTask() {
        return list.size();
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


}

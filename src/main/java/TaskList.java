import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> list = new ArrayList<>();

    public void add(Task input) {
        list.add(input);
    }

    public Task getTask(int i) {
        return list.get(i - 1);
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

import java.util.ArrayList;

public class DisplayList {
    ArrayList<String> list = new ArrayList<>();

    public void add(String input) {
        list.add(input);
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

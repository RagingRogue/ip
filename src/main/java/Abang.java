import java.util.Scanner;

public class Abang {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Abang!");
        System.out.println("What can I do for you?");

        Scanner sc = new Scanner(System.in);
        TaskList tasklist = new TaskList();

        while(true) {
            String input = sc.nextLine();

            if(input.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon.");
                break;
            }

            if(input.equals("list")) {
                System.out.println(tasklist);
                continue;
            }

            String word1 = input.split(" ")[0];
            String word2 = input.split(" ")[1];

            if (word1.equals("mark")) {
                if(tasklist.getTask(Integer.parseInt(word2)) != null) {
                    Task task = tasklist.getTask(Integer.parseInt(word2));
                    task.done();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("  " + task);
                    continue;
                }
            }

            if (word1.equals("unmark")) {
                if(tasklist.getTask(Integer.parseInt(word2)) != null) {
                    Task task = tasklist.getTask(Integer.parseInt(word2));
                    task.notDone();
                    System.out.println("OK, I've marked this task as not done yet:");
                    System.out.println("  " + task);
                    continue;
                }
            }

            tasklist.add(new Task(input));
            System.out.println("added: " + input);

        }
    }
}

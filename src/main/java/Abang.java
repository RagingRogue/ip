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
                System.out.println("Here are the tasks in your list:");
                System.out.println(tasklist);
                continue;
            }

            String word1 = input.split(" ", 2)[0];
            String description= input.split(" ", 2)[1];

            if (word1.equals("mark")) {
                String word2 = input.split(" ", 2)[1];
                if(tasklist.getTask(Integer.parseInt(word2)) != null) {
                    Task task = tasklist.getTask(Integer.parseInt(word2));
                    task.done();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("  " + task);
                    continue;
                }
            }

            if (word1.equals("unmark")) {
                String word2 = input.split(" ", 2)[1];
                if(tasklist.getTask(Integer.parseInt(word2)) != null) {
                    Task task = tasklist.getTask(Integer.parseInt(word2));
                    task.notDone();
                    System.out.println("OK, I've marked this task as not done yet:");
                    System.out.println("  " + task);
                    continue;
                }
            }

            if(word1.equals("todo")) {
                Task task = new ToDo(description);
                tasklist.add(task);
                int numTask = tasklist.numTask();
                System.out.println("Got it. I've added this task:");
                System.out.println(task);
                System.out.println(String.format("Now you have %d tasks in the list.", numTask));
            }

            String[] details = description.split("/", 10);

            if(word1.equals("deadline")) {
                String name = details[0];
                String deadline = (details[1].split(" ", 2))[1];
                Task task = new Deadline(name, deadline);
                tasklist.add(task);
                int numTask = tasklist.numTask();
                System.out.println("Got it. I've added this task:");
                System.out.println(task);
                System.out.println(String.format("Now you have %d tasks in the list.", numTask));
            }


            if(word1.equals("event")) {
                String name = details[0];
                String start = (details[1].split(" ", 2))[1];
                String end = (details[2].split(" ", 2))[1];
                Task task = new Event(name, start, end);
                tasklist.add(task);
                int numTask = tasklist.numTask();
                System.out.println("Got it. I've added this task:");
                System.out.println(task);
                System.out.println(String.format("Now you have %d tasks in the list.", numTask));
            }
        }
    }
}

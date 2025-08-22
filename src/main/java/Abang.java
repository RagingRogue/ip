import java.util.Scanner;

public class Abang {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Abang!");
        System.out.println("What can I do for you?");

        Scanner sc = new Scanner(System.in);
        TaskList tasklist = new TaskList();

        while (true) {
            String input = sc.nextLine();

            if (input.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon.");
                break;
            }

            if (input.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                System.out.println(tasklist);
                continue;
            }

            if (input.isEmpty()) {
                System.out.println("Hey! You typed nothing. Please enter a command.");
                continue;
            }

            try {
                String[] inputArray = input.split(" ", 2);
                String word1 = inputArray[0];

                if (word1.equals("mark")) {
                    if (inputArray.length < 2) {
                        throw new AbangException("Please provide a task number to mark");
                    }
                    String number = input.split(" ", 2)[1];
                    int index = Integer.parseInt(number);
                    if (index > tasklist.numTask()) {
                        throw new AbangException("Please key in a valid number");
                    }
                    Task task = tasklist.getTask(index);
                    task.done();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("  " + task);
                    continue;
                }


                if (word1.equals("unmark")) {
                    if (inputArray.length < 2) {
                        throw new AbangException("Please provide a task number to mark");
                    }
                    String number = input.split(" ", 2)[1];
                    int index = Integer.parseInt(number);
                    if (index > tasklist.numTask()) {
                        throw new AbangException("Please key in a valid number");
                    }
                    Task task = tasklist.getTask(index);
                    task.notDone();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("  " + task);
                    continue;
                }

                if (word1.equals("todo")) {
                    if (inputArray.length < 2) {
                        throw new AbangException("OOPS!!! The description of a todo cannot be empty.");
                    }
                    String description = inputArray[1];
                    Task task = new ToDo(description);
                    tasklist.add(task);
                    int numTask = tasklist.numTask();
                    System.out.println("Got it. I've added this task:");
                    System.out.println(task);
                    System.out.println(String.format("Now you have %d tasks in the list.", numTask));
                    continue;
                }

                if (word1.equals("deadline")) {
                    String description = inputArray[1];
                    String[] details = description.split("/");
                    if(details.length != 2) {
                        throw new AbangException("Please key in valid Deadline Task description");
                    }
                    String name = details[0];
                    String deadline = (details[1].split(" ", 2))[1];
                    Task task = new Deadline(name, deadline);
                    tasklist.add(task);
                    int numTask = tasklist.numTask();
                    System.out.println("Got it. I've added this task:");
                    System.out.println(task);
                    System.out.println(String.format("Now you have %d tasks in the list.", numTask));
                    continue;
                }

                if (word1.equals("event")) {
                    String description = inputArray[1];
                    String[] details = description.split("/");
                    if(details.length != 3) {
                        throw new AbangException("Please key in valid Deadline Task description");
                    }
                    String name = details[0];
                    String start = (details[1].split(" ", 2))[1];
                    String end = (details[2].split(" ", 2))[1];
                    Task task = new Event(name, start, end);
                    tasklist.add(task);
                    int numTask = tasklist.numTask();
                    System.out.println("Got it. I've added this task:");
                    System.out.println(task);
                    System.out.println(String.format("Now you have %d tasks in the list.", numTask));
                } else {
                    throw new AbangException("OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            }  catch (AbangException e) {
                System.out.println("Error: " + e.getMessage());
                continue;
            }
        }
    }
}

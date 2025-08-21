import java.util.Scanner;

public class Abang {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Abang!");
        System.out.println("What can I do for you?");

        Scanner sc = new Scanner(System.in);
        DisplayList list = new DisplayList();

        while(true) {
            String input = sc.nextLine();

            if(input.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon.");
                break;
            }

            if(input.equals("list")) {
                System.out.println(list);
                continue;
            }

            list.add(input);
            System.out.println("added: " + input);

        }
    }
}

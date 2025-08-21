import java.util.Scanner;

public class Abang {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Abang!");
        System.out.println("What can I do for you?");

        Scanner sc = new Scanner(System.in);

        while(true) {
            String input = sc.nextLine();

            if(input.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon.");
                break;
            }

            System.out.println(input);

        }
    }
}

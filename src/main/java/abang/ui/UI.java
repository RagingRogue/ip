package abang.ui;

import java.util.Scanner;

public class UI {
    private Scanner sc;

    public UI (){
        this.sc = new Scanner(System.in);
    }

    public void showWelcome() {
        System.out.println("Hello! I'm Abang!");
        System.out.println("What can I do for you?");
    }

    public void showFarewell() {
        System.out.println("Bye. Hope to see you again soon.");
    }

    public String readCommand() {
        return sc.nextLine();
    }

    public String showError(String error) {
        return "Error: " + error;
    }
}

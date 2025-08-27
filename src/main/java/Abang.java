import java.io.IOException;

public class Abang {
    private Storage storage;
    private TaskList taskList;
    private UI ui;

    public Abang(String filePath) {
        ui = new UI();
        storage = new Storage();
        try {
            taskList = storage.load();
        } catch (Exception e) {
            taskList = new TaskList();
        }
    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String Command = ui.readCommand();
                Command c = Parser.parse(Command);
                c.execute(taskList, ui, storage);
                isExit = c.isExit();
            } catch (AbangException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Abang("data/tasks.txt").run();
    }
}
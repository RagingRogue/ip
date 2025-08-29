package abang.command;

import abang.exception.AbangException;
import abang.storage.Storage;
import abang.task.TaskList;
import abang.ui.UI;

public class FindCommand extends Command {
    private String[] inputArray;

    public FindCommand(String[] inputArray) {
        this.inputArray = inputArray;
    }

    public void execute(TaskList taskList, UI ui, Storage storage) throws AbangException {
        String keyWord = inputArray[1];
        TaskList foundList = taskList.find(keyWord);
        if (foundList.isEmpty()) {
            System.out.println("Unable to find");
        } else {
            System.out.println(foundList);
        }
    }
}

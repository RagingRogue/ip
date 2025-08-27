package abang.command;

import abang.task.TaskList;
import abang.ui.UI;
import abang.storage.Storage;
import abang.exception.AbangException;


public class ExitCommand extends Command {
    public void execute(TaskList taskList, UI ui, Storage storage) throws AbangException{
        System.out.println("Thank you and have a good day!");
    }
    public boolean isExit() {
        return true;
    }
}

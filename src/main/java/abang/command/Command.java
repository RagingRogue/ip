package abang.command;

import abang.task.TaskList;
import abang.ui.UI;
import abang.storage.Storage;
import abang.exception.AbangException;


public abstract class Command {
    public boolean isExit() {
        return false;
    }
    public abstract void execute(TaskList taskList, UI ui, Storage storage) throws AbangException;
}

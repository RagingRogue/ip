package abang.command;

import abang.task.TaskList;
import abang.ui.UI;
import abang.storage.Storage;
import abang.exception.AbangException;


public class ListCommand extends Command {

    public void execute(TaskList taskList, UI ui, Storage storage) throws AbangException{
        System.out.println("Here are the tasks in your list:");
        System.out.println(taskList);
    }
}

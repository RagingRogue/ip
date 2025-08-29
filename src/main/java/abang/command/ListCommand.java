package abang.command;

import abang.task.TaskList;
import abang.ui.UI;
import abang.storage.Storage;
import abang.exception.AbangException;

/**
 * Represents a command to list all tasks in the task list.
 */
public class ListCommand extends Command {

    /**
     * Executes the list command by printing all tasks in the task list.
     *
     * @param taskList the current task list
     * @param ui       the UI object for interaction
     * @param storage  the storage object for saving tasks
     */
    @Override
    public void execute(TaskList taskList, UI ui, Storage storage) throws AbangException{
        System.out.println("Here are the tasks in your list:");
        System.out.println(taskList);
    }
}

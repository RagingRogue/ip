package abang.command;

import abang.task.TaskList;
import abang.ui.UI;
import abang.storage.Storage;
import abang.exception.AbangException;


public class ClearCommand extends Command{

    @Override
    public String execute(TaskList taskList, UI ui, Storage storage) throws AbangException {
        StringBuilder sb = new StringBuilder();
        sb.append("Cleared all tasks\n");
        taskList.clear();
        sb.append(taskList);
        storage.save(taskList.toFileLines());
        return sb.toString();
    }

}

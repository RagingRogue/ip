package abang.command;

import abang.task.TaskList;
import abang.task.Task;
import abang.ui.UI;
import abang.storage.Storage;
import abang.exception.AbangException;


public class AddCommand extends Command {
    Task task;
    public AddCommand(Task task){
        this.task = task;
    }

    @Override
    public void execute(TaskList taskList, UI ui, Storage storage) throws AbangException{
        taskList.add(this.task);
        int numTask = taskList.numTask();
        System.out.println("Got it. I've added this task:");
        System.out.println(task);
        System.out.println(String.format("Now you have %d tasks in the list.", numTask));
        storage.save(taskList.toFileLines());
    }
}

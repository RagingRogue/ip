public class ClearCommand extends Command{

    public void execute(TaskList taskList, UI ui, Storage storage) throws AbangException{
        System.out.println("Cleared all tasks");
        taskList.clear();
        System.out.println(taskList);
        storage.save(taskList.toFileLines());
    }
}

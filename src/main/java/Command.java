abstract class Command {
    public boolean isExit() {
        return false;
    }
    abstract void execute(TaskList taskList, UI ui, Storage storage) throws AbangException;
}

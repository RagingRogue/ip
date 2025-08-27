public class UnmarkCommand extends Command {
    private String[] inputArray;

    public UnmarkCommand(String[] inputArray) {
        this.inputArray = inputArray;
    }

    public void execute(TaskList taskList, UI ui, Storage storage) throws AbangException{
        if (inputArray.length < 2) {
            throw new AbangException("Please provide a task number to mark");
        }
        String number = inputArray[1];
        int index = Integer.parseInt(number);
        if (index < 1 || index > taskList.numTask()) {
            throw new AbangException("Please key in a valid number");
        }
        taskList.unmark(index);
        System.out.println("Nice! I've unmarked this task as not done:");
        System.out.println("  " + taskList.getTask(index));
        storage.save(taskList.toFileLines());
    }
}

public class DeleteCommand extends Command {
    private String[] inputArray;

    public DeleteCommand(String[] inputArray) {
        this.inputArray = inputArray;
    }

    public void execute(TaskList taskList, UI ui, Storage storage) throws AbangException {
        int index = Integer.parseInt(inputArray[1]);
        if (index < 1 || index > taskList.numTask()) {
            throw new AbangException("Please key in valid number");
        }
        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + taskList.getTask(index));
        taskList.remove(index);
        int numTask = taskList.numTask();
        System.out.println(String.format("Now you have %d tasks in the list.", numTask));
        storage.save(taskList.toFileLines());
    }
}

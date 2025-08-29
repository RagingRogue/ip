package abang.parser;

import abang.command.*;
import abang.exception.AbangException;
import abang.task.*;


public class Parser {

    /**
    * Parses the given input string and returns the corresponding {@link Command}.
    */
    public static Command parse(String input) throws AbangException {

        if (input.equals("clear")) {
            return new ClearCommand();
        }

        if (input.equals("bye")) {
            return new ExitCommand();
        }

        if (input.equals("list")) {
            return new ListCommand();
        }

        if (input.isEmpty()) {
            throw new AbangException("Hey! You typed nothing. Please enter a command.");
        }

        String[] inputArray = input.split(" ", 2);
        String word1 = inputArray[0];

        if (word1.equals("delete")) {
            return new DeleteCommand(inputArray);
        }

        if (word1.equals("mark")) {
            return new MarkCommand(inputArray);
        }

        if (word1.equals("unmark")) {
            return new UnmarkCommand(inputArray);
        }

        if (word1.equals("find")) {
            return new FindCommand(inputArray);
        }

        if (word1.equals("todo")) {
            if (inputArray.length < 2) {
                throw new AbangException("OOPS!!! The description of a todo cannot be empty.");
            }
            String description = inputArray[1];
            Task task = new ToDo(description);
            return new AddCommand(task);
        }

        if (word1.equals("deadline")) {
            String description = inputArray[1];
            String[] details = description.split("/", 2);
            if (details.length != 2) {
                throw new AbangException("Please key in valid Deadline Task description");
            }
            String name = details[0];
            String deadline = (details[1].split(" ", 2))[1];
            Task task = new Deadline(name, deadline);
            return new AddCommand(task);
        }

        if (word1.equals("event")) {
            String description = inputArray[1];
            String[] details = description.split("/from");
            String name = details[0].trim();
            String[] timing = details[1].split("/to");
            String start = (timing[0].split(" ", 2))[1].trim();
            String end = (timing[1].split(" ", 2))[1].trim();
            Task task = new Event(name, start, end);
            return new AddCommand(task);
        }  else {
            throw new AbangException("OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
    }
}

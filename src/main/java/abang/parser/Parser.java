package abang.parser;

import abang.command.*;
import abang.exception.AbangException;
import abang.task.*;


public class Parser {

    /**
    * Parses the given input string and returns the corresponding {@link Command}.
    */
    public static Command parse(String input) throws AbangException {
        assert input != null : "input must not be null";

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
        assert inputArray.length >= 1 : "split must produce at least one token";

        if (inputArray.length < 2) {
            throw new AbangException("Please key in valid command description");
        }

        String word1 = inputArray[0];
        assert word1 != null && !word1.isBlank() : "command word must be non-blank";

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

        if (word1.equals("tag")) {
            return new TagCommand(inputArray);
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
            if (inputArray.length < 2 || inputArray[1].trim().isEmpty()) {
                throw new AbangException("Please key in valid Deadline Task description");
            }

            String description = inputArray[1];

            String[] details = description.split("/by", 2);
            if (details.length != 2) {
                throw new AbangException("Please key in valid Deadline Task description (use '/by <time>')");
            }
            if (details[0].trim().isEmpty()) {
                throw new AbangException("Deadline name cannot be empty");
            }
            if (details[1].trim().isEmpty()) {
                throw new AbangException("Deadline time cannot be empty");
            }

            String name = details[0].trim();
            String deadline = details[1].trim();

            Task task = new Deadline(name, deadline);
            return new AddCommand(task);
        }

        if (word1.equals("event")) {
            if (inputArray.length < 2 || inputArray[1].trim().isEmpty()) {
                throw new AbangException("Please key in valid Event Task description");
            }

            String description = inputArray[1];

            String[] details = description.split("/from", 2);
            if (details.length != 2) {
                throw new AbangException("Please key in valid Event Task description (use '/from <start> /to <end>')");
            }
            if (details[0].trim().isEmpty() || details[1].trim().isEmpty()) {
                throw new AbangException("Please key in valid Event Task description");
            }

            String name = details[0].trim();

            String[] timing = details[1].split("/to", 2);
            if (timing.length != 2) {
                throw new AbangException("Please key in valid Event timings (missing '/to <end>')");
            }
            if (timing[0].trim().isEmpty() || timing[1].trim().isEmpty()) {
                throw new AbangException("Please key in valid Event timings");
            }

            String start = timing[0].trim();
            String end = timing[1].trim();

            Task task = new Event(name, start, end);
            return new AddCommand(task);
        }  else {
            throw new AbangException("OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
    }
}

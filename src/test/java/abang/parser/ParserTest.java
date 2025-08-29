package abang.parser;

import abang.command.*;
import abang.exception.AbangException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {

    @Test
    public void parse_clear_returnsClearCommand() throws Exception {
        Command cmd = Parser.parse("clear");
        assertTrue(cmd instanceof ClearCommand);
    }

    @Test
    public void parse_emptyInput_throwsAbangException() {
        assertThrows(AbangException.class, () -> Parser.parse(""));
    }

    @Test
    public void parse_unknownCommand_throwsAbangException() {
        assertThrows(AbangException.class, () -> Parser.parse("blah blah"));
    }

    @Test
    public void parse_todoWithoutDescription_throwsAbangException() {
        assertThrows(AbangException.class, () -> Parser.parse("todo"));
    }

    @Test
    public void parse_todoWithDescription_returnsAddCommand() throws Exception {
        Command cmd = Parser.parse("todo read book");
        assertTrue(cmd instanceof AddCommand);
    }

    @Test
    public void parse_deadlineWithoutSlash_throwsAbangException() {
        assertThrows(AbangException.class, () -> Parser.parse("deadline finish homework"));
    }

    @Test
    public void parse_deadlineWithValidInput_returnsAddCommand() throws Exception {
        Command cmd = Parser.parse("deadline return book /by 2025-01-01");
        assertTrue(cmd instanceof AddCommand);
    }

    @Test
    public void parse_eventWithValidInput_returnsAddCommand() throws Exception {
        Command cmd = Parser.parse("event meeting /from 2pm /to 4pm");
        assertTrue(cmd instanceof AddCommand);
    }
}

package seedu.address.logic.parser;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.ResumePreviewCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new ResumePreviewCommand object
 */
public class ResumePreviewCommandParser implements Parser<ResumePreviewCommand> {
    @Override
    public ResumePreviewCommand parse(String userInput) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(userInput);

        if (argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(ResumePreviewCommand.MESSAGE_USAGE);
        }

        Index index = ParserUtil.parseIndex(argMultimap.getPreamble());

        return new ResumePreviewCommand(index);
    }
}

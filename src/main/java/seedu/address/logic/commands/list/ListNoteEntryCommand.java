package seedu.address.logic.commands.list;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_ENTRIES;

import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;

public class ListNoteEntryCommand extends ListCommand {

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredNoteEntryList(PREDICATE_SHOW_ALL_ENTRIES);
        return new CommandResult("", String.format(MESSAGE_SUCCESS, "Internship", true));
    }
}
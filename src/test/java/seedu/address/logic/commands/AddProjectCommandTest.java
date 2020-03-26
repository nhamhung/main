package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.add.AddProjectCommand;
import seedu.address.logic.commands.exceptions.CommandException;

import seedu.address.model.item.Project;
import seedu.address.testutil.ProjectBuilder;

public class AddProjectCommandTest extends AddCommandTest {
    @Test
    public void constructor_nullProject_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AddProjectCommand(null));
    }

    @Test
    public void execute_ProjectAcceptedByModel_addSuccessful() throws Exception {
        ModelStubAcceptingProjectAdded modelStub = new ModelStubAcceptingProjectAdded();
        Project validItem = new ProjectBuilder().build();

        CommandResult commandResult = new AddProjectCommand(validItem).execute(modelStub);

        assertEquals(String.format(AddProjectCommand.MESSAGE_SUCCESS, validItem.getType().getFullType()),
                commandResult.getFeedbackToUser());
        assertEquals(Arrays.asList(validItem), modelStub.Projects);
    }

    @Test
    public void execute_duplicateProject_throwsCommandException() {
        Project validItem = new ProjectBuilder().build();
        AddProjectCommand addCommand = new AddProjectCommand(validItem);
        ModelStub modelStub = new ModelStubWithProject(validItem);

        assertThrows(CommandException.class,
                AddProjectCommand.MESSAGE_DUPLICATE_PERSON, () -> addCommand.execute(modelStub));
    }

    @Test
    public void equals() {
        Project itemA = new ProjectBuilder().withName("NameA").build();
        Project itemB = new ProjectBuilder().withName("NameB").build();
        AddProjectCommand addACommand = new AddProjectCommand(itemA);
        AddProjectCommand addBCommand = new AddProjectCommand(itemB);

        // same object -> returns true
        assertTrue(addACommand.equals(addACommand));

        // same values -> returns true
        AddProjectCommand addACommandCopy = new AddProjectCommand(itemA);
        assertTrue(addACommand.equals(addACommandCopy));

        // different types -> returns false
        assertFalse(addACommand.equals(1));

        // null -> returns false
        assertFalse(addACommand.equals(null));

        // different project -> returns false
        assertFalse(addACommand.equals(addBCommand));
    }

    /**
     * A Model stub that contains a single Project.
     */
    private class ModelStubWithProject extends ModelStub {
        private final Project item;

        ModelStubWithProject(Project item) {
            requireNonNull(item);
            this.item = item;
        }

        @Override
        public boolean hasProject(Project item) {
            requireNonNull(item);
            return this.item.isSame(item);
        }
    }
    /**
     * A Model stub that always accept the Project being added.
     */
    private class ModelStubAcceptingProjectAdded extends ModelStub {
        final ArrayList<Project> Projects = new ArrayList<>();

        @Override
        public void addProject(Project Project) {
            Projects.add(Project);
        }
    }

}

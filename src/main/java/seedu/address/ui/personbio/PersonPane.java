package seedu.address.ui.personbio;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import seedu.address.MainApp;
import seedu.address.ui.UiPart;

/**
 * The entire portion that displays user's personal details
 */
public class PersonPane extends UiPart<Region> {
    private static final String FXML = "PersonPane.fxml";
    private static String filePath = "/images/person.png";

    private Profile profile;
    private Image profilePic;
    private String profilePicPath;
    private PersonDetailPane studentProfile;

    @FXML
    private HBox profilePlaceholder;

    @FXML
    private VBox personDetailsPlaceholder;

    /**
     * Constructs the entire person pane with profile and personal details table.
     */
    public PersonPane() {
        super(FXML);
        profilePic = new Image(MainApp.class.getResourceAsStream(filePath));
        Profile profile = new Profile(profilePic, "Nham Hung",
                "What if Newton discovered gravity from a durian?");
        profilePlaceholder.getChildren().add(profile.getRoot());
        studentProfile = new PersonDetailPane("Nham Hung", "91608840", "nhamhung.gttn@gmail.com",
                "nhamhung", "NUS", "CS", "2018", "2022", "5.0",
                "lowerthan5");
        personDetailsPlaceholder.getChildren().add(studentProfile.getRoot());
    }
}

package abang;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

public class MainWindow {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Abang abang;
    private Image userImage;
    private Image abangImage;

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        userImage = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
        abangImage = new Image(this.getClass().getResourceAsStream("/images/DaAbang.png"));
    }

    public void setAbang(Abang a) {
        this.abang = a;
    }


    /**
     * Creates two dialog boxes, one echoing user input and the other containing Abang's reply and then appends them to the dialog container.
     * Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = abang.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getAbangDialog(response, abangImage)
        );
        userInput.clear();
    }
}

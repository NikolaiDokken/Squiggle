import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SignUp{

    //Scene
    private GridPane gp;
    private Scene sc;

    //UI
    private TextField nameField;
    private TextField emailField;
    private PasswordField passwordField;
    private PasswordField rePasswordField;

    private Button submitButton;
    private Button optionButton;
    private Button backButton;

    public SignUp(double width, double height) {
        gp = createRegistrationFormPane();
        addUIControls(gp);
        sc = new Scene(gp, width, height);
    }

    public Scene getSc() {
        return sc;
    }

    public String getName(){
        return nameField.getText();
    }

    public String getMail(){
        return emailField.getText();
    }

    public String getPassword(){
        if(passwordField.getText().equals(rePasswordField.getText())){
            return passwordField.getText();
        }else throw new IllegalArgumentException("Password don't match");
    }



    private GridPane createRegistrationFormPane() {
        // Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        gridPane.setHgap(10);

        // Set the vertical gap between rows
        gridPane.setVgap(10);


        // Add Column Constraints

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }
    private void addUIControls(GridPane gridPane) {

        double prefHeight = 40;
        // Add Header
        Label headerLabel = new Label("Registration Form");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

        // Add Name Label
        Label nameLabel = new Label("Username : ");
        gridPane.add(nameLabel, 0,1);

        // Add Name Text Field
        nameField = new TextField();
        nameField.setPrefHeight(prefHeight);
        nameField.setPromptText("Ola Nordmann");
        gridPane.add(nameField, 1,1);


        // Add Email Label
        Label emailLabel = new Label("Email : ");
        gridPane.add(emailLabel, 0, 2);

        // Add Email Text Field
        emailField = new TextField();
        emailField.setPrefHeight(prefHeight);
        emailField.setPromptText("party@myhouse.tonight");
        gridPane.add(emailField, 1, 2);

        // Add Password Label
        Label passwordLabel = new Label("Password : ");
        gridPane.add(passwordLabel, 0, 3);

        // Add Password Field
        passwordField = new PasswordField();
        passwordField.setPrefHeight(prefHeight);
        passwordField.setPromptText("password");
        gridPane.add(passwordField, 1, 3);

        // Add RePassword Label
        Label rePasswordLabel = new Label("Password : ");
        gridPane.add(rePasswordLabel, 0, 4);

        // Add RePassword Field
        rePasswordField = new PasswordField();
        rePasswordField.setPrefHeight(prefHeight);
        rePasswordField.setPromptText("re-enter password");
        gridPane.add(rePasswordField, 1, 4);

        // Add Submit Button
        submitButton = new Button("Submit");
        submitButton.setPrefHeight(prefHeight);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(submitButton, 0, 5, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setValignment(submitButton, VPos.CENTER);

        // Add option button
        optionButton = new Button("Options");
        optionButton.setOnAction(e -> Options.opneBoxer());
        gridPane.add(optionButton, 5, 14);


        // Go back button
        backButton = new Button("Go Back");
        backButton.setOnAction(e -> Main.setScene2(Main.li.getSc()));

        backButton.setPrefHeight(prefHeight);
        backButton.setDefaultButton(true);
        backButton.setPrefWidth(100);
        gridPane.add(backButton, 0, 5, 1, 2);
        GridPane.setHalignment(backButton, HPos.CENTER);
        GridPane.setValignment(backButton, VPos.CENTER);
    }

}

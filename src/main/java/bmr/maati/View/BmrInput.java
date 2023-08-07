package bmr.maati.View;

import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 * The class represent the left side of the program that is a Gridpane on the left,inside a hbox
 * extend gridpane
 */
public class BmrInput extends GridPane {

    private TextField tailleF = new TextField();
    private TextField poidsF = new TextField();
    private TextField ageF = new TextField();
    private ChoiceBox cb = new ChoiceBox(FXCollections.observableArrayList(
            "Sedentary", "Lightly active", "Moderately active", "Very active", "Super active"));
    private ToggleGroup sexe = new ToggleGroup();
    private RadioButton f = new RadioButton("Female");
    private RadioButton h = new RadioButton("Male");

    /**
     * Constructor for the gridpane when an instance is created all of it's "component" are being putting inside
     * all the texfield, choice box, radio button and all are being put inside.
     */
    public BmrInput() {
        this.setHgap(3);
        this.setVgap(3);
        f.setToggleGroup(sexe);
        h.setToggleGroup(sexe);
        this.setPadding(new Insets(0, 10, 0, 10));
        this.add(new Label("Data :"), 0, 0);
        this.add(new Text("Height (cm) :"), 0, 2);
        this.add(tailleF, 1, 2);
        this.add(new Label("Weight (kg) :"), 0, 4);
        this.add(poidsF, 1, 4);
        this.add(new Label("Age (year) :"), 0, 6);
        this.add(ageF, 1, 6);
        this.add(new Text("Gender :"), 0, 8);
        this.add(f, 1, 8);
        this.add(h, 1, 8);
        this.setMaxHeight(Double.MAX_VALUE);
        this.setMaxWidth(Double.MAX_VALUE);
        GridPane.setMargin(h, new Insets(0, 0, 0, 100));
        this.add(cb, 1, 10);
        filter(ageF);
        filter(poidsF);
        filter(tailleF);
        sexe.selectToggle(f);
        cb.setValue("Sedentary");
    }

    /**
     * Getter for the height
     *
     * @return -1 if empty and the height as int if not
     */
    public int getTailleF() {
        if (tailleF.getText() != "") {
            return Integer.parseInt(tailleF.getText());
        }
        return -1;
    }

    /**
     * Getter for the weight
     *
     * @return -1 if empty and the weight as int if not
     */
    public int getPoidsF() {
        if (poidsF.getText() != "") {
            return Integer.parseInt(poidsF.getText());
        }
        return -1;
    }

    /**
     * Getter for the age
     *
     * @return -1 if empty and the age as int if not
     */
    public int getAgeF() {
        if (ageF.getText() != "") {
            return Integer.parseInt(ageF.getText());
        }
        return -1;
    }

    /**
     * Getter for the choiceBox
     *
     * @return the string of the activity selected
     */
    public String getCb() {
        return cb.getSelectionModel().getSelectedItem().toString();
    }

    /**
     * Getter for the sexe selected
     *
     * @return the string of the radiobutton checked
     */
    public String getSexe() {

        return ((RadioButton) sexe.getSelectedToggle()).getText();
    }

    /**
     * Clear method to empty all the textfield
     */
    public void clear() {
        tailleF.setText("");
        ageF.setText("");
        poidsF.setText("");

    }

    /**
     * Filter method to check if the character typed is a number
     *
     * @param field the textfield to always consume the character if it is not a number
     */
    public static void filter(TextField field) {

        field.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                String character = event.getCharacter();
                if (!checkNumeric(character))
                    event.consume();
            }
        });
    }

    /**
     * Method to check if every chatacter of a string is a number
     *
     * @param value the string value of the text in textfield
     * @return true if the ascii value of the char is not between the min and max value of the asciis values of numbers
     */
    public static boolean checkNumeric(String value) {
        String number = value.replaceAll("\\s+", "");
        for (int j = 0; j < number.length(); j++) {
            if (!(((int) number.charAt(j) > 47 && (int) number.charAt(j) <= 57))) {
                return false;
            }
        }
        return true;
    }

}

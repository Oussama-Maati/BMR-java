package bmr.maati.View;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 * The class represent the right side of the program that is a Gridpane on the right,inside a hbox
 * extend gridpane
 */
public class BmrOutput extends GridPane {

    private TextField bmrF = new TextField();
    private TextField caloriesF = new TextField();


    /**
     * Constructor for the gridpane when an instance is created all of it's "component" are being putting inside
     * all the texfield are being put inside.
     */
    public BmrOutput() {
        Label bmr = new Label("BMR : ");
        Label Calories = new Label("Calories : ");
        Text result = new Text("Results : ");
        result.setUnderline(true);

        this.add(result, 0, 5);
        this.add(bmr, 0, 10);
        this.add(bmrF, 5, 10);
        this.add(Calories, 0, 15);
        this.add(caloriesF, 5, 15);
        this.setHgap(1);
        this.setVgap(1);

    }

    /**
     * Method to set the textfield depending of the param and also change the color depending of
     * if it is the right calcul or error
     *
     * @param bmrF the textfield to set the calcul or "failed" from the person inside the textfield of the rigth
     *             gridpane
     */
    public void setBmrF(TextField bmrF) {
        this.bmrF.setText(bmrF.getText());
        if (bmrF.getText().equals("Failed !")) {
            this.bmrF.setStyle("-fx-text-fill: red;");
            caloriesF.setStyle("-fx-text-fill: red;");
        } else {
            this.bmrF.setStyle("-fx-text-fill: black;");
            caloriesF.setStyle("-fx-text-fill: black;");
        }
    }


    /**
     * Method to set the textfield depending of the param and also change the color depending of
     *      * if it is the right calories or error
     * @param caloriesF the textfield to set the calories or "failed" from the person inside the textfield of the rigth
     *             gridpane
     */
    public void setCaloriesF(TextField caloriesF) {
        this.caloriesF.setText(caloriesF.getText());
    }


    /**
     * Method to clear all the textfield when the button will be clicked
     */
    public void clear() {
        bmrF.setText("");
        caloriesF.setText("");
    }

}

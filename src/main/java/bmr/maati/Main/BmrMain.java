package bmr.maati.Main;


import bmr.maati.Model.Person;
import bmr.maati.View.BmrInput;
import bmr.maati.View.BmrOutput;
import bmr.maati.util.Observer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class BmrMain
        extends Application implements Observer {

    private BorderPane root = new BorderPane();
    private VBox vbox = new VBox(10);
    private HBox hbox = new HBox(10);
    private BmrInput left = new BmrInput();
    private BmrOutput right = new BmrOutput();
    private Button calcul = new Button("Calculation of BMR");
    private Button clear = new Button("Clear");
    private Person person = new Person();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        person.addObserver(this);

        Menu menu = new Menu("File"); //Menu file to put the exit button
        MenuBar menuBar = new MenuBar();
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(e -> {
            primaryStage.close();
        });
        menu.getItems().add(exit);
        menuBar.getMenus().add(menu);
        vbox.getChildren().add(menuBar);
        menuBar.setMaxHeight(Double.MAX_VALUE);


        hbox.getChildren().add(left);
        hbox.getChildren().add(right);
        vbox.getChildren().add(hbox);


        vbox.getChildren().add(calcul);
        calcul.setMaxWidth(Double.MAX_VALUE);
        calcul.setMaxWidth(400);

        vbox.getChildren().add(clear);
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setMaxHeight(Double.MAX_VALUE);
        clear.setMaxWidth(400);

        root.setCenter(vbox);

        calcul.setOnAction(e -> { // Calcul button on action to :
            if (isErrorNoInput(left)){ // check if empty and put failed
                TextField fail = new TextField("Failed !");
                right.setCaloriesF(fail);
                right.setBmrF(fail);
            } else if (isErrorZero(left)){ // check if 0 to put the alert
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid inputs");
                alert.setContentText("The values cannt be equals to 0");
                alert.showAndWait();
            } else  { // if none of the previous the calcul will be made
                person.set(left.getTailleF(), left.getPoidsF(), left.getAgeF(),
                        left.getSexe(), left.getCb());

            }
        });

        clear.setOnAction(e -> {         // Clear button to clear the left and right gridpane
            left.clear();
            right.clear();
        });


        primaryStage.setTitle("BMR");
        Scene scene = new Scene(root, 550, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Method to check if the textfield are empty to then put the bmr and calories to ""failed""
     * @param input the bmrinput to get all of it's textfield
     * @return true if one of the textfield is empty
     */
    public static boolean isErrorNoInput(BmrInput input) {
        return (input.getTailleF()==-1 || input.getPoidsF()==-1
                || input.getAgeF()==-1 );
    }

    /**
     * Method to check if there is a "0 error" to then will throw an alert to the user
     * @param input the bmrinput to get all the textfield
     * @return true if at least one of the textfield have a 0
     */
    public static boolean isErrorZero(BmrInput input) {
        return (input.getTailleF()==0|| input.getPoidsF()==0
                || input.getAgeF()==0 );
    }


    @Override
    public void update(Person p) {
        right.setBmrF(new TextField(person.getBmr()));
        right.setCaloriesF(new TextField(person.getCalories()));
    }
}

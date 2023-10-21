import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javax.swing.text.Position;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
//• Spelplanen ska märkas i y-led med A-J och i x-led med 0-9, det vill säga att övre vänstra hörnet
//benämns med A0 och nedre högra hörnet med J9.


    // Ska ha en HBox och en VBox med bostäver/Siffror i

    @Override
    public void start(Stage primaryStage) throws Exception {
        Board battelBoard = new Board();




        battelBoard.start(new Stage());



    }
}
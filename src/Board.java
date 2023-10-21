import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Button;

import java.awt.*;

public class Board extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {


        primaryStage.setTitle("Battleships");
        primaryStage.setHeight(1000);
        primaryStage.setWidth(1000);

        GridPane pane = new GridPane();
        Button[][] buttons = new Button[10][10];

        int count = 0;

        for (int i = 0; i < 10; i++) {
            count++;
            for (int j = 0; j < 10; j++) {
                Rectangle rectangle = new Rectangle(50, 50);
                GameButton.fireButton();
                buttons[i][j] = GameButton.fireButton();
                if (count % 2 == 0) {
                    rectangle.setFill(Color.DARKBLUE);
                } else {
                    rectangle.setFill(Color.BLUE);
                }
                pane.add(rectangle, j, i);
                pane.add(GameButton.fireButton(), j, i);
                count++;
            }
        }


        //skriver ut buttons listan för att se om den är rätt
//        for (int row = 0; row < 10; row++) {
//            System.out.println("");
//            for (int col = 0; col < 10; col++) {
//                System.out.print(buttons[row][col].getText() + " ");
//            }
//        }

        HBox hbox = new HBox();
        hbox.setSpacing(0);
        Label emptyLabel = new Label();
        emptyLabel.setPrefSize(50, 50);
        hbox.getChildren().add(emptyLabel);
        for (int i = 0; i < 10; i++) {
            String place = "";

            Label l = new Label();
            l.setAlignment(Pos.CENTER_LEFT);
            l.setPrefSize(50, 50);
            l.setText(place + i);
            l.setAlignment(Pos.BASELINE_CENTER);
            l.setTextFill(Color.BROWN);
//            Rectangle r = new Rectangle(50, 50);
//            r.setFill(Color.CADETBLUE);
            hbox.getChildren().addAll(l);
        }


        VBox vbox = new VBox();
        vbox.setSpacing(0);
        for (int i = 0; i < 10; i++) {
            char ascii= (char) (65+i);
            Label l = new Label();
            l.setAlignment(Pos.CENTER_LEFT);
            l.setPrefSize(50, 50);
            l.setText(String.valueOf(ascii));
            l.setAlignment(Pos.BASELINE_CENTER);
            l.setTextFill(Color.BROWN);
            //  Rectangle r = new Rectangle(50, 50);
            //r.setFill(Color.CADETBLUE);
            vbox.getChildren().add(l);
        }


        BorderPane borderPane = new BorderPane();
        borderPane.setTop(hbox);
        borderPane.setLeft(vbox);
        borderPane.setCenter(pane);

        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class Board extends Application {

    private ButtonStandard[][] buttons = new ButtonStandard[10][10];


    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Battleships");
        primaryStage.setHeight(1000);
        primaryStage.setWidth(1000);

        //Gridpane som placeras i mitten av fönstret med själva spelplanen
        GridPane pane = new GridPane();
        int count = 0;
        char idChar;
        int idNumber;
        String buttonId;

        for (int i = 0; i < 10; i++) {
            count++;
            for (int j = 0; j < 10; j++) {

                //id för varje button
                idChar = (char) (65 + j);
                idNumber = i;
                buttonId = String.valueOf(idChar) + idNumber;


                //spelplan med rutor
                Rectangle rectangle = new Rectangle(50, 50);
                rectangle.setStroke(Color.BLACK);
                if (count % 2 == 0) {
                    rectangle.setFill(Color.ROYALBLUE);
                } else {
                    rectangle.setFill(Color.BLUE);
                }
                pane.add(rectangle, i, j);

                // skapar och lägger till knapp
                buttons[i][j] = new ButtonStandard(buttonId);
                pane.add(buttons[i][j].getButton(), i, j);
                count++;

                //Skriver ut id för varje knapp
                //System.out.println(buttons[i][j].getId());
            }

        }
        //skriver ut buttons listan för att se om den är rätt
//        for (int row = 0; row < 10; row++) {
//            System.out.println("");
//            for (int col = 0; col < 10; col++) {
//                System.out.print(buttons[row][col].getText() + " ");
//            }
//        }


        //_______________________________________
        //TESTAR MED ATT LÄGGA TILL SKEPP
        // kan lägga till skepp men inga krav på hur den placeras
        // inget som hindrar den från att placeras på ett annat skepp
        // har fått så de alltid placeras innan för spelplanen och inte försöker gå utanför

        placeShip(5);
        placeShip(4);
        placeShip(4);
//        placeShip(3);
//        placeShip(3);
//        placeShip(3);
//        placeShip(2);
//        placeShip(2);
//        placeShip(2);
//        placeShip(2);


        randomShoot();

        //_______________________________________


        //En hBox som läggs högst upp i fönstret (med position 0123... )
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

        //En vBox som läggs längst till vänster i fönstret (med position ABC...)
        VBox vbox = new VBox();
        vbox.setSpacing(0);
        for (int i = 0; i < 10; i++) {
            char ascii = (char) (65 + i);
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


        //Skapar en borderpane och placerar in vår Gridpane, V&HBox
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(hbox);
        borderPane.setLeft(vbox);
        borderPane.setCenter(pane);

        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    private void placeShip(int shipSize) {
        Ship ship = new Ship(shipSize);
        System.out.println(ship.getShipName());
        Random random = new Random();


        boolean directionRandom = random.nextBoolean();
        // directionRandom om true så ligger skeppen horisontellt

        int rowRandom;
        int colRandom;

        //avgränsar hur långt randomInt kan gå så att skeppen inte
        //riskeras att placeras utan för spelbrädet
        if (directionRandom) {
            rowRandom = random.nextInt(10);
            colRandom = random.nextInt(10 - shipSize);
        } else {
            rowRandom = random.nextInt(10 - shipSize);
            colRandom = random.nextInt(10);
        }


        //Ökar row/col för att placera ut nästa del av skeppet
        for (int i = 0; i < shipSize; i++) {
            if (directionRandom) {
                rowRandom = rowRandom;
                colRandom = colRandom + 1;
            } else {
                colRandom = colRandom;
                rowRandom = rowRandom + 1;
            }

            System.out.println("Ship placed at: " + buttons[rowRandom][colRandom].getButtonIdKanpp());
            buttons[rowRandom][colRandom].setIsShip(true);


            //sätter så alla hörnen i närheten är X
            try {
                buttons[rowRandom + 1][colRandom + 1].setCloseToShipNotShip(true);
            } catch (Exception e) {
                System.out.println("Utanför spelplan");
            }
            try {
                buttons[rowRandom - 1][colRandom + 1].setCloseToShipNotShip(true);
            } catch (Exception e) {
                System.out.println("Utanför spelplan");
            }
            try {
                buttons[rowRandom + 1][colRandom - 1].setCloseToShipNotShip(true);
            } catch (Exception e) {
                System.out.println("Utanför spelplan");
            }
            try {
                buttons[rowRandom - 1][colRandom - 1].setCloseToShipNotShip(true);
            } catch (Exception e) {
                System.out.println("Utanför spelplan");
            }
        }
    }


    public void randomShoot() {
        Random random = new Random();
        //testar med 15 skott nu, ska ju vara krav att fortsätter tills alla skepp
        //är träffade
        for (int i = 0; i < 15; i++) {
            int rowRandom = random.nextInt(10);
            int colRandom = random.nextInt(10);

            System.out.println("Shoot at: " + buttons[rowRandom][colRandom].getButtonIdKanpp());
            //om den inte ät tryckt på redan så trycker vi på knappen (och ser om det
            // är ett skepp eller inte).
            if (!buttons[rowRandom][colRandom].getPressed()) {
                buttons[rowRandom][colRandom].setPressed(true);

                //är det ett skepp sätts alla 4 hörnen runt skeppet ut som x och
                // blir disable och kan inte tryckas på igen
                if (buttons[rowRandom][colRandom].getIsShip()) {

                    try {
                        buttons[rowRandom + 1][colRandom + 1].setCloseToFoundSHip(true);
                        System.out.println("X vid: " + buttons[rowRandom + 1][colRandom + 1].getButtonIdKanpp());
                    } catch (Exception e) {
                        System.out.println("x Utanför spelplan");
                    }
                    try {
                        buttons[rowRandom - 1][colRandom + 1].setCloseToFoundSHip(true);
                        System.out.println("X vid: " + buttons[rowRandom - 1][colRandom + 1].getButtonIdKanpp());
                    } catch (Exception e) {
                        System.out.println("x Utanför spelplan");
                    }
                    try {
                        buttons[rowRandom + 1][colRandom - 1].setCloseToFoundSHip(true);
                        System.out.println("X vid: " + buttons[rowRandom + 1][colRandom - 1].getButtonIdKanpp());
                    } catch (Exception e) {
                        System.out.println("x Utanför spelplan");
                    }
                    try {
                        buttons[rowRandom - 1][colRandom - 1].setCloseToFoundSHip(true);
                        System.out.println("X vid: " + buttons[rowRandom - 1][colRandom - 1].getButtonIdKanpp());
                    } catch (Exception e) {
                        System.out.println("x Utanför spelplan");
                    }
                    //try/catch är att förhindra att den kraschar om den försöker sätta ett "x" på ex ruta [-1][0]

                }
            } else {
                i--;
                System.out.println("Try Shooting at: " + buttons[rowRandom][colRandom].getButtonIdKanpp());
            }


        }
    }

}

import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.Button;

import java.awt.*;

public class Ship {

    private int shipSize;
    private String shipName;
    private Button[] ship = new Button[shipSize];


    //konstruktorer
    public Ship() {
    }

    public Ship(int shipSize) {
        this.shipSize = shipSize;
    }


//getters och setters
    public int getShipSize() {
        return shipSize;
    }

    public void setShipSize(int shipSize) {
        this.shipSize = shipSize;
    }

    public String getShipName() {
        if (shipSize == 5) {
            shipName = "Hangarfartyg";
        } else if (shipSize == 4) {
            shipName = "Slagskepp";
        } else if (shipSize == 3) {
            shipName = "Kryssare";
        } else {
            shipName = "Ubåt";
        }
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public Button[] getShip() {
        return ship;
    }

    public void setShip(Button[] ship) {
        this.ship = ship;
    }
}

import java.awt.*;

public class Ship {

    //sk man ha skeppet som en 2DArray alltså [bredd][längd]
    //bredd jämt 1 men kan var åt olika håll då....

    private int shipSize;
    private String shipName;
    private Button[] ship = new Button[shipSize];


    //konstuktorer


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

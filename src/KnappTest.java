import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.Button;

public class KnappTest {

    private String buttonIdKanpp;
    private boolean isShip;
    private boolean closeToShipNotShip;
    private Button buttonTest = new Button("🌊");

    private String buttonText;
     private Button[][] buttonList= new Button[10][10];

    public KnappTest() {
    }

    public KnappTest(String buttonId, boolean isShip) {
        this.buttonIdKanpp = buttonId;
        this.isShip = isShip;
        this.buttonTest = buttonTest;

        buttonTest.setId(buttonId);
        buttonTest.setPrefSize(40, 40);
        buttonTest.setScaleX(2);
        buttonTest.setScaleY(2);
        buttonTest.setOpacity(0.8);
        buttonTest.setAlignment(Pos.CENTER);
        buttonTest.setShape(new Circle());
        buttonTest.setTextFill(Color.LIGHTSKYBLUE);


        buttonTest.setOnMouseEntered(e -> {
            buttonTest.setOpacity(0);
        });
        buttonTest.setOnMouseExited(e -> {
            buttonTest.setOpacity(0.8);
        });



        buttonTest.setOnAction(e -> {
            if(getIsShip()){
                buttonTest.setText("⛵");

                //när man klickar och det är ett skepp ska de andra knapparna markeras som x
            }else {
                buttonTest.setText("😱");
            }

            buttonTest.setOpacity(0.8);
            buttonTest.setOnMouseEntered(f -> {
                        buttonTest.setOpacity(0.8);
                    }
            );
        });
//--------------------
        //testa med att lägga till x på de rutor som inte kan vara skepp



    }



    public void inteSKeppKnappar() {

//            buttonTest.setDisable(true);
//            buttonTest.setText("X");


        if (getCloseToShipNotShip()){
            buttonTest.setDisable(true);
            buttonTest.setText("x");
        }
        }


    //-------------------
    public String getButtonIdKanpp() {
        return buttonIdKanpp;
    }

    public void setButtonIdKanpp(String buttonIdKanpp) {
        this.buttonIdKanpp = buttonIdKanpp;
    }

    public boolean getIsShip() {
        return isShip;
    }

    public void setIsShip(boolean ship) {
        isShip = ship;
    }

    public Button getButtonTest() {
        return buttonTest;
    }

    public void setButtonTest(Button buttonTest) {
        this.buttonTest = buttonTest;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public boolean getCloseToShipNotShip() {
        return closeToShipNotShip;
    }

    public void setCloseToShipNotShip(boolean closeToShipNotShip) {
        this.closeToShipNotShip = closeToShipNotShip;
    }
}

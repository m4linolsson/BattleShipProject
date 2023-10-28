import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.Button;

public class ButtonStandard {

    private String buttonIdKanpp;
    private boolean isShip;
    private boolean closeToShipNotShip;
    private Button button = new Button("🌊");
    private String buttonText;

    private boolean pressed;

    private boolean closeToFoundSHip;
    private boolean disableButton;

    //Konstruktorer
    public ButtonStandard() {
    }

    public ButtonStandard(String buttonId) {
        this.buttonIdKanpp = buttonId;

        button.setId(buttonId);
        button.setPrefSize(40, 40);
        button.setScaleX(2);
        button.setScaleY(2);
        button.setOpacity(0.8);
        button.setAlignment(Pos.CENTER);
        button.setShape(new Circle());
        button.setTextFill(Color.LIGHTSKYBLUE);


        //Utan de här är spelet "självspelande"
        //man kan inte trycka på nå knappar och se vad som händer
        //det behövs ju som sagt inte till det färdiga spelet
//        button.setOnMouseEntered(e -> {
//            button.setOpacity(0.0);
//        });
//
//        button.setOnMouseExited(e -> {
//            button.setOpacity(0.8);
//        });
//
//        button.setOnAction(e -> {
//                    if (getIsShip()) {
//                        button.setText("⛵");
//                    } else if (closeToShipNotShip) {
//                        //när man klickar och det är ett skepp ska de andra knapparna markeras som x
//                        //Just nu måste man klicka på knappen för att den ska markera "X" och att
//                        //det inte kan vara ett skepp där
//                        closeToShipX();
//                    } else {
//                        button.setText("😱");
//                    }
//                    button.setDisable(true);
//                }
//        );

    }


    //Metoder
    public void closeToShipX() {
        button.setDisable(true);
        button.setText("x");
    }


    //Getter/setters
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

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public boolean getCloseToShipNotShip() {
        if(closeToShipNotShip){
            button.setText("X");
            button.setDisable(true);
        }

        return closeToShipNotShip;
    }

    public void setCloseToShipNotShip(boolean closeToShipNotShip) {
        this.closeToShipNotShip = closeToShipNotShip;
    }


    public boolean getPressed() {
        return pressed;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;

        if (isShip){
        button.setText("⛵");}
        else { button.setText("😱");
        }
        button.setDisable(true);
    }

    public boolean getCloseToFoundSHip() {
        return closeToFoundSHip;
    }

    public void setCloseToFoundSHip(boolean closeToFoundSHip) {
        this.closeToFoundSHip = closeToFoundSHip;

        if (getCloseToShipNotShip()){
            button.setDisable(true);
            button.setText("X");
        }
    }

    public boolean getDisableButton() {
        return disableButton;
    }

    public void setDisableButton(boolean disableButton) {
        this.disableButton = disableButton;
        button.setDisable(true);
    }
}


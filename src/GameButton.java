import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

//public class GameButton {
//    private String buttonId;
//    private boolean isShip;
//
//
//
//
//    public static Button fireButton(String buttonId, boolean isShip) {
//
//
//
//
////"♒" 🌊 😱
//        // https://www.surfa.de/ovrigt/symboler-och-emojis/
//
//
//        Button buttonFire = new Button("🌊");
//        buttonFire.setId(buttonId);
//        buttonFire.setPrefSize(40, 40);
//        buttonFire.setScaleX(2);
//        buttonFire.setScaleY(2);
//        buttonFire.setOpacity(0.8);
//        buttonFire.setAlignment(Pos.CENTER);
//        // buttonFire.setTextAlignment();
//        buttonFire.setShape(new Circle());
//
//        buttonFire.setTextFill(Color.LIGHTSKYBLUE);
//
//        buttonFire.setOnMouseEntered(e -> {
//            buttonFire.setOpacity(0);
//        });
//        buttonFire.setOnMouseExited(e -> {
//            buttonFire.setOpacity(0.8);
//        });
//        buttonFire.setOnAction(e -> {
//            buttonFire.setText("😱");
//            buttonFire.setOpacity(0.8);
//            buttonFire.setOnMouseEntered(f -> {
//                        buttonFire.setOpacity(0.8);
//                    }
//
//            );
//            //bara testar om det funkar
//            System.out.println("----id");
//        });
//
//
//        return buttonFire;
//    }
//
//
//
//    public String getButtonId() {
//        return buttonId;
//    }
//
//    public void setButtonId(String buttonId) {
//        this.buttonId = buttonId;
//    }
//
//    public boolean isShip() {
//        return isShip;
//    }
//
//    public void setShip(boolean ship) {
//        isShip = ship;
//    }
//}
package app.spacerunner;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    @FXML
    private AnchorPane panelGame;

    @FXML
    private ImageView ship;

    @FXML
    private Label poinLabel;

    private int point;
    private int angle;
    private AnimationTimer timer;

    public void addPoint() {
        point++;
        poinLabel.setText("Poin: " + point);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        panelGame.setOnMouseDragged(event -> {
            double posisiX = ship.getLayoutX();
            if (event.getX() > 0 && event.getX() < 450) {
                ship.setLayoutX(event.getX());
            }
            timer = new AnimationTimer() {
                @Override
                public void handle(long l) {
                    if (posisiX > event.getX()) {
                        if (angle > -30) {
                            angle -= 5;
                        }
                        ship.setRotate(angle);
                    }
                    if (posisiX < event.getX()) {
                        if (angle < 30) {
                            angle += 5;
                        }
                        ship.setRotate(angle);
                    }
                    if (posisiX == event.getX()) {
                        if (angle < 0) {
                            angle += 5;
                        } else if (angle > 0) {
                            angle -= 5;
                        }
                        ship.setRotate(angle);
                    }
                }
            };
            timer.start();
        });
    }
}

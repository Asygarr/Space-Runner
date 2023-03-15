package app.spacerunner;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    @FXML
    private ImageView ship;

    @FXML
    private Label poinLabel;

    private int point = 0;

    public void addPoint() {
        point++;
        poinLabel.setText("Poin: " + point);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ship.setOnMouseDragged(mouseEvent -> {
            ship.setX(mouseEvent.getX());
            ship.setY(mouseEvent.getY());
        });
    }
}

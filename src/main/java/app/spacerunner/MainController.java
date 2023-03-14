package app.spacerunner;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Button play, skor, bantuan, kredit, keluar;

    @FXML
    private AnchorPane panelSkor;

    private boolean isHidden = true;

    public void skorOnAction(ActionEvent event) {
        TranslateTransition transisi = new TranslateTransition();
        transisi.setDuration(Duration.seconds(0.3));
        transisi.setNode(this.panelSkor);

        if (isHidden) {
            transisi.setToX(-767);
            isHidden = false;
        } else {
            transisi.setToX(0);
            isHidden = true;
        }
        transisi.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        play.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                play.setEffect(new javafx.scene.effect.DropShadow());
            }
        });

        play.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                play.setEffect(null);
            }
        });

        skor.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                skor.setEffect(new javafx.scene.effect.DropShadow());
            }
        });

        skor.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                skor.setEffect(null);
            }
        });

        bantuan.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                bantuan.setEffect(new javafx.scene.effect.DropShadow());
            }
        });

        bantuan.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                bantuan.setEffect(null);
            }
        });

        kredit.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                kredit.setEffect(new javafx.scene.effect.DropShadow());
            }
        });

        kredit.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                kredit.setEffect(null);
            }
        });

        keluar.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                keluar.setEffect(new javafx.scene.effect.DropShadow());
            }
        });

        keluar.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                keluar.setEffect(null);
            }
        });
    }
}
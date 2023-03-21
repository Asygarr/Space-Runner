package app.spacerunner;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Button play, skor, bantuan, kredit, keluar;

    @FXML
    private Label skorTertinggi;

    @FXML
    private AnchorPane panelSkor, panelBantuan, panelKredit, scaneSembunyi;

    private Stage stage;
    private boolean isHidden = true;

    private void pindahScene(AnchorPane panel) {
        TranslateTransition transisi = new TranslateTransition();
        transisi.setDuration(Duration.seconds(0.3));
        transisi.setNode(panel);

        if (isHidden) {
            transisi.setToX(-767);
            isHidden = false;
        } else {
            transisi.setToX(0);
            isHidden = true;
        }
        transisi.play();
    }

    private void munculkanScene(AnchorPane panel) {
        if (scaneSembunyi != null) {
            pindahScene(scaneSembunyi);
        }
        pindahScene(panel);
        scaneSembunyi = panel;
    }

    public void playOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("game.fxml")));
        stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setY(10);
        stage.show();
    }

    public void getPoint(int poin) {
        skorTertinggi.setText("Point Tertinggi : " + poin);
    }

    public void keluarOnAction() {
        stage = (Stage) keluar.getScene().getWindow();
        stage.close();
    }

    public void skorOnAction() {
        munculkanScene(panelSkor);
    }

    public void bantuanOnAction() {
        munculkanScene(panelBantuan);
    }

    public void kreditOnAction() {
        munculkanScene(panelKredit);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        play.setOnMouseEntered(mouseEvent -> play.setEffect(new javafx.scene.effect.DropShadow()));

        play.setOnMouseExited(mouseEvent -> play.setEffect(null));

        skor.setOnMouseEntered(mouseEvent -> skor.setEffect(new javafx.scene.effect.DropShadow()));

        skor.setOnMouseExited(mouseEvent -> skor.setEffect(null));

        bantuan.setOnMouseEntered(mouseEvent -> bantuan.setEffect(new javafx.scene.effect.DropShadow()));

        bantuan.setOnMouseExited(mouseEvent -> bantuan.setEffect(null));

        kredit.setOnMouseEntered(mouseEvent -> kredit.setEffect(new javafx.scene.effect.DropShadow()));

        kredit.setOnMouseExited(mouseEvent -> kredit.setEffect(null));

        keluar.setOnMouseEntered(mouseEvent -> keluar.setEffect(new javafx.scene.effect.DropShadow()));

        keluar.setOnMouseExited(mouseEvent -> keluar.setEffect(null));
    }
}
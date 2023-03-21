package app.spacerunner;

import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class myController implements Initializable {

    @FXML
    private Button play, skor, bantuan, kredit, keluar;
    @FXML
    private Label skorTertinggi;
    @FXML
    private AnchorPane panelSkor, panelBantuan, panelKredit, scaneSembunyi;
    @FXML
    private AnchorPane mainPane, gamePane, bgGame1, bgGame2, gameOverPanel;
    @FXML
    private ImageView ship;
    @FXML
    private ImageView meteorGrey1, meteorGrey2, meteorGrey3, meteorGrey4;
    @FXML
    private ImageView meteorBrown1, meteorBrown2, meteorBrown3, meteorBrown4;
    @FXML
    private ImageView starGold1, starGold2;
    @FXML
    private Label poinLabel, poin;

    private boolean isHidden = true;

    // Game
    private int point;
    private int angle;
    private double eventShip;
    private double posisiShip;
    private boolean gameStart = true;
    private AnimationTimer timer;

    Random randomPosisiMeteor = new Random();

    public myController() {
        this.point = 0;
        this.angle = 0;
        this.eventShip = 0;
        this.posisiShip = 0;
    }

    // Main
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
        AnchorPane pane = FXMLLoader.load(getClass().getResource("game.fxml"));
        gamePane.setClip(pane);
    }

    public void keluarOnAction() {
        // Main
        Stage stage = (Stage) keluar.getScene().getWindow();
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


    // Game
    public void kembaliOnAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("main.fxml"));
        mainPane.setClip(pane);
    }

    private void setPoint() {
        point += 1;
        poinLabel.setText("Poin : " + point);
    }

    private void setRandomPosisi (ImageView meteor) {
        meteor.setLayoutX(randomPosisiMeteor.nextInt(450));
        meteor.setLayoutY(-(randomPosisiMeteor.nextInt(3300)+600));
    }

    private void panelGameOver() {
        poin.setText("Poin Kamu: " + point);
        gameOverPanel.setLayoutX(27);
    }

    private void setStop(ImageView ship, ImageView meteor, AnimationTimer timer) {
        if (ship.getLayoutX() < meteor.getLayoutX() + 50 &&
                ship.getLayoutX() + 50 > meteor.getLayoutX() &&
                ship.getLayoutY() < meteor.getLayoutY() + 50 &&
                ship.getLayoutY() + 50 > meteor.getLayoutY()) {
            timer.stop();
            panelGameOver();
            skorTertinggi.setText("Skor Tertinggi : " + point);
            gameStart = false;
        }
    }

    private void addPoin(ImageView ship, ImageView star) {
        if (ship.getLayoutX() < star.getLayoutX() + 50 &&
                ship.getLayoutX() + 50 > star.getLayoutX() &&
                ship.getLayoutY() < star.getLayoutY() + 50 &&
                ship.getLayoutY() + 50 > star.getLayoutY()) {
            setRandomPosisi(star);
            setPoint();
        }
    }

    private void animasiEvent() {
        meteorGrey1.setLayoutY(meteorGrey1.getLayoutY() + 10);
        meteorGrey2.setLayoutY(meteorGrey2.getLayoutY() + 10);
        meteorGrey3.setLayoutY(meteorGrey3.getLayoutY() + 10);
        meteorGrey4.setLayoutY(meteorGrey4.getLayoutY() + 10);

        meteorBrown1.setLayoutY(meteorBrown1.getLayoutY() + 10);
        meteorBrown2.setLayoutY(meteorBrown2.getLayoutY() + 10);
        meteorBrown3.setLayoutY(meteorBrown3.getLayoutY() + 10);
        meteorBrown4.setLayoutY(meteorBrown4.getLayoutY() + 10);

        starGold1.setLayoutY(starGold1.getLayoutY() + 10);
        starGold2.setLayoutY(starGold2.getLayoutY() + 10);

        if (starGold1.getLayoutY() >= 700) {
            setRandomPosisi(starGold1);
        }
        if (starGold2.getLayoutY() >= 700) {
            setRandomPosisi(starGold2);
        }

        if (meteorGrey1.getLayoutY() >= 700) {
            setRandomPosisi(meteorGrey1);
        }
        if (meteorGrey2.getLayoutY() >= 700) {
            setRandomPosisi(meteorGrey2);
        }
        if (meteorGrey3.getLayoutY() >= 700) {
            setRandomPosisi(meteorGrey3);
        }
        if (meteorGrey4.getLayoutX() >= 700) {
            setRandomPosisi(meteorGrey4);
        }

        if (meteorBrown1.getLayoutY() >= 700) {
            setRandomPosisi(meteorBrown1);
        }
        if (meteorBrown2.getLayoutY() >= 700) {
            setRandomPosisi(meteorBrown2);
        }
        if (meteorBrown3.getLayoutY() >= 700) {
            setRandomPosisi(meteorBrown3);
        }
        if (meteorBrown4.getLayoutX() >= 700) {
            setRandomPosisi(meteorBrown4);
        }
    }

    private void animasiBg() {
        bgGame1.setLayoutY(bgGame1.getLayoutY() + 5);
        bgGame2.setLayoutY(bgGame2.getLayoutY() + 5);

        if (bgGame1.getLayoutY() >= 700) {
            bgGame1.setLayoutY(-700);
        }

        if (bgGame2.getLayoutY() >= 700) {
            bgGame2.setLayoutY(-700);
        }
    }

    private void animasiShip() {
        if (posisiShip > eventShip) {
            if (angle > -30) {
                angle -= 5;
            }
            ship.setRotate(angle);
        }
        if (posisiShip < eventShip) {
            if (angle < 30) {
                angle += 5;
            }
            ship.setRotate(angle);
        }
        if (posisiShip == eventShip) {
            if (angle < 0) {
                angle += 5;
            } else if (angle > 0) {
                angle -= 5;
            }
            ship.setRotate(angle);
        }

        setStop(ship, meteorGrey1, timer);
        setStop(ship, meteorGrey2, timer);
        setStop(ship, meteorGrey3, timer);
        setStop(ship, meteorGrey4, timer);

        setStop(ship, meteorBrown1, timer);
        setStop(ship, meteorBrown2, timer);
        setStop(ship, meteorBrown3, timer);
        setStop(ship, meteorBrown4, timer);

        addPoin(ship, starGold1);
        addPoin(ship, starGold2);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        setRandomPosisi(meteorGrey1);
        setRandomPosisi(meteorGrey2);
        setRandomPosisi(meteorGrey3);
        setRandomPosisi(meteorGrey4);

        setRandomPosisi(meteorBrown1);
        setRandomPosisi(meteorBrown2);
        setRandomPosisi(meteorBrown3);
        setRandomPosisi(meteorBrown4);

        setRandomPosisi(starGold1);
        setRandomPosisi(starGold2);

        timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                animasiEvent();
                animasiBg();
                animasiShip();
            }
        };
        timer.start();

        if (gameStart) {
            gamePane.setOnMouseDragged(event -> {
                posisiShip = ship.getLayoutX();
                eventShip = event.getX();
                if (event.getX() > 0 && eventShip < 450) {
                    ship.setLayoutX(event.getX());
                }
            });
        }

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

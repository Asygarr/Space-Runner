package app.spacerunner;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    @FXML
    private AnchorPane panelGame, bgGame1, bgGame2;
    @FXML
    private ImageView ship;
    @FXML
    private ImageView meteorGrey1, meteorGrey2, meteorGrey3, meteorGrey4;
    @FXML
    private ImageView meteorBrown1, meteorBrown2, meteorBrown3, meteorBrown4;
    @FXML
    private ImageView starGold1, starGold2;

    @FXML
    private Label poinLabel;

    private int point;
    private int angle;
    private AnimationTimer timer;

    Random randomPosisiMeteor = new Random();

    public void addPoint() {
        point++;
        poinLabel.setText("Poin: " + point);
    }

    public void setRandomPosisi (ImageView meteor) {
        meteor.setLayoutX(randomPosisiMeteor.nextInt(450));
        meteor.setLayoutY(-(randomPosisiMeteor.nextInt(1300)+600));
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
                meteorGrey1.setLayoutY(meteorGrey1.getLayoutY() + 5);
                meteorGrey2.setLayoutY(meteorGrey2.getLayoutY() + 5);
                meteorGrey3.setLayoutY(meteorGrey3.getLayoutY() + 5);
                meteorGrey4.setLayoutY(meteorGrey4.getLayoutY() + 5);

                meteorBrown1.setLayoutY(meteorBrown1.getLayoutY() + 5);
                meteorBrown2.setLayoutY(meteorBrown2.getLayoutY() + 5);
                meteorBrown3.setLayoutY(meteorBrown3.getLayoutY() + 5);
                meteorBrown4.setLayoutY(meteorBrown4.getLayoutY() + 5);

                starGold1.setLayoutY(starGold1.getLayoutY() + 5);
                starGold2.setLayoutY(starGold2.getLayoutY() + 5);

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
        };
        timer.start();


        timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                bgGame1.setLayoutY(bgGame1.getLayoutY() + 1);
                bgGame2.setLayoutY(bgGame2.getLayoutY() + 1);

                if (bgGame1.getLayoutY() >= 700) {
                    bgGame1.setLayoutY(-700);
                }

                if (bgGame2.getLayoutY() >= 700) {
                    bgGame2.setLayoutY(-700);
                }
            }
        };
        timer.start();

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

            if (starGold1.getLayoutX() == ship.getLayoutX() && starGold1.getLayoutY() == 605) {
                setRandomPosisi(starGold1);
                addPoint();
            }
            if (starGold2.getLayoutX() == ship.getLayoutX() && starGold1.getLayoutY() == 605) {
                setRandomPosisi(starGold2);
                addPoint();
            }

            if (meteorGrey1.getLayoutX() == ship.getLayoutX() && meteorGrey1.getLayoutY() == 605) {

            }
        });

        panelGame.setOnMouseReleased(event -> {
            timer = new AnimationTimer() {
                @Override
                public void handle(long l) {
                    if (angle < 0) {
                        angle += 10;
                    } else if (angle > 0) {
                        angle -= 10;
                    }
                    ship.setRotate(angle);
                }
            };
            timer.start();
        });
    }
}

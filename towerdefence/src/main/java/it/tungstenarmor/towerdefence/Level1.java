package it.tungstenarmor.towerdefence;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class Level1 extends Application {

    @Override
    public void start(Stage stage) {

        Pane root = new Pane();
        root.setStyle("-fx-background-color: #1e1e1e;");

        // Torre prototipo (rettangolo)
        Rectangle tower = new Rectangle(50, 50, Color.CYAN);
        tower.setX(150);
        tower.setY(300);

        // Santuario (rettangolo grande)
        Rectangle sanctuary = new Rectangle(80, 200, Color.LIGHTGREEN);
        sanctuary.setX(1100);
        sanctuary.setY(250);

        // Lista nemici (Corrotti Minori)
        List<Polygon> enemies = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Polygon enemy = new Polygon(
                    0.0, 0.0,
                    25.0, 12.5,
                    0.0, 25.0
            );
            enemy.setFill(Color.RED);
            enemy.setLayoutX(-50 * i); // partono sfalsati
            enemy.setLayoutY(310);
            enemies.add(enemy);
        }

        // Bottone Start Wave
        Button startWave = new Button("Start Wave");
        startWave.setLayoutX(20);
        startWave.setLayoutY(20);

        root.getChildren().addAll(tower, sanctuary);
        root.getChildren().add(startWave);
        root.getChildren().addAll(enemies);

        // Movimento lineare dei nemici
        Timeline movement = new Timeline(
                new KeyFrame(Duration.millis(16), e -> {
                    for (Polygon enemy : enemies) {
                        enemy.setLayoutX(enemy.getLayoutX() + 1.5);

                        // Collisione con il Santuario
                        if (enemy.getBoundsInParent().intersects(sanctuary.getBoundsInParent())) {
                            enemy.setFill(Color.GRAY); // morto
                        }
                    }
                })
        );
        movement.setCycleCount(Timeline.INDEFINITE);

        startWave.setOnAction(e -> movement.play());

        Scene scene = new Scene(root, 1280, 720);
        stage.setScene(scene);
        stage.setTitle("Tungsten Armor TD - Capitolo 1 Livello 1");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

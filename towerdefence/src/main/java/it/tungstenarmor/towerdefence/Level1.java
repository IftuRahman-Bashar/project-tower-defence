package it.tungstenarmor.towerdefence;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Level1 extends Application {

    @Override
    public void start(Stage stage) {

        Pane root = new Pane();

        // Terreno verde menta
        root.setStyle("-fx-background-color: #ccd5ae;");

        Random rnd = new Random();
        List<Rectangle> towers = new ArrayList<>();

        // Genera 10 torri sparse senza sovrapposizioni
        for (int i = 0; i < 10; i++) {

            Rectangle tower = new Rectangle(60, 60, Color.web("8a817c"));

            boolean placed = false;

            while (!placed) {
                double x = rnd.nextDouble() * (1280 * 0.70); // 70% della mappa a sinistra
                double y = rnd.nextDouble() * 720;

                tower.setX(x);
                tower.setY(y);

                boolean overlaps = false;

                for (Rectangle other : towers) {
                    if (tower.getBoundsInParent().intersects(other.getBoundsInParent())) {
                        overlaps = true;
                        break;
                    }
                }

                if (!overlaps) {
                    placed = true;
                    towers.add(tower);
                    root.getChildren().add(tower);
                }
            }
        }

        // Postazioni Pleiades (posizioni fisse)
        Rectangle p1 = new Rectangle(30, 30, Color.LIGHTGRAY);
        p1.setX(250); p1.setY(200);

        Rectangle p2 = new Rectangle(30, 30, Color.LIGHTGRAY);
        p2.setX(350); p2.setY(300);

        Rectangle p3 = new Rectangle(30, 30, Color.LIGHTGRAY);
        p3.setX(200); p3.setY(400);

        // Mura del santuario (altezza completa)
        Rectangle wall = new Rectangle(100, 10000, Color.LIGHTGRAY);
        wall.setX(1000);
        wall.setY(0);

        // Santuario (lavanda) spostato più a destra
        Rectangle sanctuary = new Rectangle(200, 200, Color.web("#cfbaf0"));
        sanctuary.setX(1120);
        sanctuary.setY(260);


        root.getChildren().addAll(p1, p2, p3, wall, sanctuary);

        Scene scene = new Scene(root, 1280, 720);
        stage.setScene(scene);
        stage.setTitle("Tungsten Armor TD - Capitolo 1 Livello 1 (Mappa prototipo)");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

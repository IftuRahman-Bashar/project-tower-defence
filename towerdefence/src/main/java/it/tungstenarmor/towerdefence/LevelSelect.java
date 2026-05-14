package it.tungstenarmor.towerdefence;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LevelSelect {

    public void start(Stage stage) {

        Button level1 = new Button("LIVELLO 1");
        Button back = new Button("INDIETRO");

        level1.setPrefSize(300, 80);
        back.setPrefSize(300, 80);

        level1.setStyle("-fx-font-size: 32px; -fx-background-color: #f5f3f4; -fx-text-fill: black;");
        back.setStyle("-fx-font-size: 32px; -fx-background-color: #e63946; -fx-text-fill: white;");

        level1.setOnAction(e -> {
            Level1 level = new Level1();
            try {
                level.start(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        back.setOnAction(e -> {
            ChapterSelect chapterSelect = new ChapterSelect();
            chapterSelect.start(stage);
        });

        VBox layout = new VBox(40, level1, back);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #003049;");

        Scene scene = new Scene(layout, 1280, 720);
        stage.setScene(scene);
        stage.setTitle("Seleziona Livello");
        stage.show();
    }
}

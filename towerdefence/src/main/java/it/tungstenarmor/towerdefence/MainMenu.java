package it.tungstenarmor.towerdefence;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenu extends Application {

    @Override
    public void start(Stage stage) {

        Button playButton = new Button("GIOCA");
        Button exitButton = new Button("ESCI");

        playButton.setPrefSize(300, 80);
        exitButton.setPrefSize(300, 80);

        playButton.setStyle("-fx-font-size: 32px; -fx-background-color: #619b8a; -fx-text-fill: white;");
        exitButton.setStyle("-fx-font-size: 32px; -fx-background-color: #e63946; -fx-text-fill: white;");

        playButton.setOnAction(e -> {
            ChapterSelect chapterSelect = new ChapterSelect();
            try {
                chapterSelect.start(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        exitButton.setOnAction(e -> stage.close());

        VBox layout = new VBox(40, playButton, exitButton);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #003049;");

        Scene scene = new Scene(layout, 1280, 720);
        stage.setScene(scene);
        stage.setTitle("Tungsten Armor TD - Menu");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

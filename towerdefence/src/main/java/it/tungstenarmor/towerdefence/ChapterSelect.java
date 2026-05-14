package it.tungstenarmor.towerdefence;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChapterSelect {

    public void start(Stage stage) {

        Button capitolo1 = new Button("CAPITOLO 1");
        Button capitolo2 = new Button("CAPITOLO 2");
        Button back = new Button("INDIETRO");

        capitolo1.setPrefSize(300, 80);
        capitolo2.setPrefSize(300, 80);
        back.setPrefSize(300, 80);

        capitolo1.setStyle("-fx-font-size: 32px; -fx-background-color: #f5f3f4; -fx-text-fill: black;");
        capitolo2.setStyle("-fx-font-size: 32px; -fx-background-color: #b0c4b1; -fx-text-fill: black;");
        back.setStyle("-fx-font-size: 32px; -fx-background-color: #e63946; -fx-text-fill: white;");

        capitolo1.setOnAction(e -> {
            LevelSelect levelSelect = new LevelSelect();
            levelSelect.start(stage);
        });

        // Capitolo 2 NON collegato a nulla
        capitolo2.setOnAction(e -> {
            System.out.println("Capitolo 2 non ancora disponibile.");
        });

        back.setOnAction(e -> {
            MainMenu menu = new MainMenu();
            try {
                menu.start(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        VBox layout = new VBox(40, capitolo1, capitolo2, back);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #003049;");

        Scene scene = new Scene(layout, 1280, 720);
        stage.setScene(scene);
        stage.setTitle("Seleziona Capitolo");
        stage.show();
    }
}

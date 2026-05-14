package it.tungstenarmor.towerdefence;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChapterSelect {

    public void start(Stage stage) {

        Button atto1 = new Button("ATTO 1");
        Button atto2 = new Button("ATTO 2");
        Button atto3 = new Button("ATTO 3");
        Button atto4 = new Button("ATTO 4");
        Button back = new Button("INDIETRO");

        atto1.setPrefSize(300, 80);
        atto2.setPrefSize(300, 80);
        atto3.setPrefSize(300,80);
        atto4. setPrefSize(300,80);
        back.setPrefSize(300, 80);

        atto1.setStyle("-fx-font-size: 32px; -fx-background-color: #f5f3f4; -fx-text-fill: black;");
        atto2.setStyle("-fx-font-size: 32px; -fx-background-color: #003049; -fx-text-fill: white;");
        atto3.setStyle("-fx-font-size: 32px; -fx-background-color: #f5f3f4; -fx-text-fill: black;");
        atto4.setStyle("-fx-font-size: 32px; -fx-background-color: #003049; -fx-text-fill: white;");
        back.setStyle("-fx-font-size: 32px; -fx-background-color: #e63946; -fx-text-fill: white;");

        atto1.setOnAction(e -> {
            LevelSelect levelSelect = new LevelSelect();
            levelSelect.start(stage);
        });

        // gli altri NON sono collegati a nulla
        atto2.setOnAction(e -> {
            System.out.println("non disponibile");
        });

        atto3.setOnAction(e -> {
            System.out.println("non disponibile");
        });

        atto4.setOnAction(e -> {
            System.out.println("non disponibile");
        });

        back.setOnAction(e -> {
            MainMenu menu = new MainMenu();
            try {
                menu.start(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        VBox layout = new VBox(40, atto1, atto2, atto3, atto4, back);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #e5e5e5;");

        // #003049 da provare

        Scene scene = new Scene(layout, 1280, 720);
        stage.setScene(scene);
        stage.setTitle("Seleziona Capitolo");
        stage.show();
    }
}

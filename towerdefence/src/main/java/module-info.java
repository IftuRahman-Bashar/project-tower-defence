module it.tungstenarmor.towerdefence {
    requires javafx.controls;
    requires javafx.fxml;


    opens it.tungstenarmor.towerdefence to javafx.fxml;
    exports it.tungstenarmor.towerdefence;
}
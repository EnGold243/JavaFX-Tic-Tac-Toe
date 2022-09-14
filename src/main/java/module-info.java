module tictactoe {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;

    exports gold.corp.tictactoe;
    opens gold.corp.tictactoe to javafx.base, javafx.controls, javafx.fxml, javafx.graphics;
}
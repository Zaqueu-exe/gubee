module com.teste.teste {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.teste.teste to javafx.fxml;
    exports com.teste.teste;
    exports com.teste.teste.gui;
    opens com.teste.teste.gui to javafx.fxml;
}
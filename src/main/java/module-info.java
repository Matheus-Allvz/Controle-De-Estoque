module org {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.model to javafx.base;

    opens org.controler to javafx.fxml;
    exports org.controler to javafx.fxml;
    exports org.principal;
}
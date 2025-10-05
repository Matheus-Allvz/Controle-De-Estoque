package org.principal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.utils.PathFXML;
import java.io.IOException;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws IOException {

        java.net.URL fileLocation = PathFXML.getPath("TelaPrincipal.fxml");
        System.out.println("Se der null é pq ainda tá dando pau: " + fileLocation);

        Parent root = FXMLLoader.load(fileLocation);

        Scene scene = new Scene(root, 600, 400);

        primaryStage.setTitle("Controle de Estoque");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
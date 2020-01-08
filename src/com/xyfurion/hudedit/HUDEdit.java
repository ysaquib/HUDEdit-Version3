package com.xyfurion.hudedit;

import javafx.application.Application;
import javafx.css.CssMetaData;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HUDEdit extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("resolutionUI.fxml"));
        primaryStage.setTitle("HUDEdit Version 3.0.0");
        primaryStage.setScene(new Scene(root, 400, 235));
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.getScene().getStylesheets().add(getClass().getResource("resolutionUI.css").toExternalForm());
    }
}

package com.xyfurion.hudedit;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;

/**
 * The purpose of this class is to hold the code for the events, declaration, and initialisation of the FXML file: resolutionUI.fxml
 * @author Xyfurion
 * @version %I%, %G%
 */

public class resolutionController {
    static int resolutionX = 1280;
    static int resolutionY = 720;

    private String currentRatio = "0:0";

    private Stage stage = new Stage();
    private Parent root = null;

    public Button okayButton;
    public Button autoDetectButton;
    public CheckBox useAsDefaultCheckbox;
    public JFXComboBox<String> resolutionDropdown;
    public JFXComboBox<String> ratioDropdown;

    private ObservableList<String> four_three = FXCollections.observableArrayList("800 x 600", "1024 x 768", "1152 x 864", "1280 x 960", "1600 x 1200");
    private ObservableList<String> five_three = FXCollections.observableArrayList("1280 x 768");
    private ObservableList<String> five_four = FXCollections.observableArrayList("720 x 560", "1280 x 1024");
    private ObservableList<String> sixteen_nine = FXCollections.observableArrayList("1280 x 720", "1360 x 768", "1366 x 768", "1536 x 864",
            "1600 x 900", "1920 x 1080", "2560 x 1440", "3840 x 2160");
    private ObservableList<String> sixteen_ten = FXCollections.observableArrayList("1280 x 800", "1440 x 900", "1680 x 1050", "1920 x 1200", "2560 x 1600");
    private ObservableList<String> twentyone_nine = FXCollections.observableArrayList("2560 x 1080", "3440 x 1440", "5120 x 2160", "10240 x 4320");


    public void okayClicked() {
        String[] resolutionXY = resolutionDropdown.getValue().split(" x ", 2);
        resolutionX = Integer.parseInt(resolutionXY[0]);
        resolutionY = Integer.parseInt(resolutionXY[1]);
        openMainWindow();
    }

    public void autoDetectClicked() {
        resolutionY = (int) Screen.getPrimary().getBounds().getHeight();
        resolutionX = (int) Screen.getPrimary().getBounds().getWidth();
        openMainWindow();
    }

    public void ratioBoxAction() {
        currentRatio = ratioDropdown.getValue();
        resolutionDropdown.setDisable(false);
        checkRatioBox();
    }

    public void resolutionBoxAction() {
        okayButton.setDisable(false);
    }

    private void checkRatioBox() {
        //change value of resolutionDropdown based on ratio selected
        switch (currentRatio) {
            case "4:3":
                resolutionDropdown.setItems(four_three);
                break;
            case "5:3":
                resolutionDropdown.setItems(five_three);
                break;
            case "5:4":
                resolutionDropdown.setItems(five_four);
                break;
            case "16:9":
                resolutionDropdown.setItems(sixteen_nine);
                break;
            case "16:10":
                resolutionDropdown.setItems(sixteen_ten);
                break;
            case "21:9":
                resolutionDropdown.setItems(twentyone_nine);
                break;
            default:
                break;
        }

    }

    private void openMainWindow() {
        //Open the main HUDEdit window
        try {
            root = FXMLLoader.load(getClass().getResource("mainUI.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle("HUDEdit Version 3.0.0");
        stage.setScene(new Scene(root, resolutionX, resolutionY));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
        stage.getScene().getStylesheets().add(getClass().getResource("mainUI.css").toExternalForm());

        //Close the resolution window
        Stage currentStage = (Stage) okayButton.getScene().getWindow();
        currentStage.close();
    }
}

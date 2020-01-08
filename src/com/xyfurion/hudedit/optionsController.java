package com.xyfurion.hudedit;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * The purpose of this class is to hold the code for the events, declaration, and initialisation of the FXML file: optionsUI.fxml
 * @author Xyfurion
 * @version %I%, %G%
 */

public class optionsController {

    public RadioButton al_RT;
    public RadioButton al_CT;
    public RadioButton al_LT;
    public RadioButton al_RC;
    public RadioButton al_CC;
    public RadioButton al_LC;
    public RadioButton al_RB;
    public RadioButton al_CB;
    public RadioButton al_LB;

    public RadioButton at_RT;
    public RadioButton at_CT;
    public RadioButton at_LT;
    public RadioButton at_RC;
    public RadioButton at_CC;
    public RadioButton at_LC;
    public RadioButton at_RB;
    public RadioButton at_CB;
    public RadioButton at_LB;

    public TextField pos_horizontal;
    public TextField pos_vertical;

    private String TOP = Controller.TOP;
    private String CENTER = Controller.CENTER;
    private String BOTTOM = Controller.BOTTOM;
    private String LEFT = Controller.LEFT;
    private String RIGHT = Controller.RIGHT;

    private final ReadOnlyObjectWrapper<String> alignmentHorizontal = new ReadOnlyObjectWrapper<>();
    private final ReadOnlyObjectWrapper<String> alignmentVertical = new ReadOnlyObjectWrapper<>();
    private final ReadOnlyObjectWrapper<String> attachmentHorizontal = new ReadOnlyObjectWrapper<>();
    private final ReadOnlyObjectWrapper<String> attachmentVertical = new ReadOnlyObjectWrapper<>();

    private final ReadOnlyObjectWrapper<Double> pixOffsetX = new ReadOnlyObjectWrapper<>();
    private final ReadOnlyObjectWrapper<Double> pixOffsetY = new ReadOnlyObjectWrapper<>();

    public ReadOnlyObjectProperty<String> horizontalAlignment() {
        return alignmentHorizontal.getReadOnlyProperty() ;
    }
    public ReadOnlyObjectProperty<String> verticalAlignment() {
        return alignmentVertical.getReadOnlyProperty() ;
    }
    public ReadOnlyObjectProperty<String> horizontalAttachment() {
        return attachmentHorizontal.getReadOnlyProperty() ;
    }
    public ReadOnlyObjectProperty<String> verticalAttachment() {return attachmentVertical.getReadOnlyProperty() ;}
    public ReadOnlyObjectProperty<Double> pixelOffsetX() {return pixOffsetX.getReadOnlyProperty() ;}
    public ReadOnlyObjectProperty<Double> pixelOffsetY() {
        return pixOffsetY.getReadOnlyProperty() ;
    }

    public final String getAlignmentHorizontal() {return horizontalAlignment().get();}
    public final String getAlignmentVertical() {
        return verticalAlignment().get();
    }
    public final String getAttachmentHorizontal() {
        return horizontalAttachment().get();
    }
    public final String getAttachmentVertical() {
        return verticalAttachment().get();
    }
    public final Double getPixOffsetX() {
        return pixelOffsetX().get();
    }
    public final Double getPixOffsetY() {
        return pixelOffsetY().get();
    }



    public Rectangle dragBar;
    public double iniX;
    public double iniY;

    public Label assetLabel;

    //initialization
    public void initialize() {
        // Add listener to radio buttons to get properties in main Controller
        al_LT.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {if (isNowSelected) {alignmentHorizontal.set(LEFT); alignmentVertical.set(TOP);}});
        al_LC.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {if (isNowSelected) {alignmentHorizontal.set(LEFT); alignmentVertical.set(CENTER);}});
        al_LB.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {if (isNowSelected) {alignmentHorizontal.set(LEFT); alignmentVertical.set(BOTTOM);}});
        al_CT.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {if (isNowSelected) {alignmentHorizontal.set(CENTER); alignmentVertical.set(TOP);}});
        al_CC.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {if (isNowSelected) {alignmentHorizontal.set(CENTER); alignmentVertical.set(CENTER);}});
        al_CB.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {if (isNowSelected) {alignmentHorizontal.set(CENTER); alignmentVertical.set(BOTTOM);}});
        al_RT.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {if (isNowSelected) {alignmentHorizontal.set(RIGHT); alignmentVertical.set(TOP);}});
        al_RC.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {if (isNowSelected) {alignmentHorizontal.set(RIGHT); alignmentVertical.set(CENTER);}});
        al_RB.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {if (isNowSelected) {alignmentHorizontal.set(RIGHT); alignmentVertical.set(BOTTOM);}});

        at_LT.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {if (isNowSelected) {attachmentHorizontal.set(LEFT); attachmentVertical.set(TOP);}});
        at_LC.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {if (isNowSelected) {attachmentHorizontal.set(LEFT); attachmentVertical.set(CENTER);}});
        at_LB.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {if (isNowSelected) {attachmentHorizontal.set(LEFT); attachmentVertical.set(BOTTOM);}});
        at_CT.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {if (isNowSelected) {attachmentHorizontal.set(CENTER); attachmentVertical.set(TOP);}});
        at_CC.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {if (isNowSelected) {attachmentHorizontal.set(CENTER); attachmentVertical.set(CENTER);}});
        at_CB.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {if (isNowSelected) {attachmentHorizontal.set(CENTER); attachmentVertical.set(BOTTOM);}});
        at_RT.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {if (isNowSelected) {attachmentHorizontal.set(RIGHT); attachmentVertical.set(TOP);}});
        at_RC.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {if (isNowSelected) {attachmentHorizontal.set(RIGHT); attachmentVertical.set(CENTER);}});
        at_RB.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {if (isNowSelected) {attachmentHorizontal.set(RIGHT); attachmentVertical.set(BOTTOM);}});


        pos_horizontal.textProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue.equals(null) || newValue.equals("-") || newValue.equals(".") || newValue.equals("")){
                pixOffsetX.set(0.0);
            } else if (!Objects.equals(newValue, oldValue)) {
                pixOffsetX.set(Double.parseDouble(newValue)); 
            }
        });
        pos_vertical.textProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue.equals(null) || newValue.equals("-") || newValue.equals(".") || newValue.equals("")){
                pixOffsetY.set(0.0);
            } else if (!Objects.equals(newValue, oldValue)) {
                pixOffsetY.set(Double.parseDouble(newValue)); 
            }
        });

    }

    public void dragBarMousePressed(MouseEvent event){
        Stage stage;
        stage = (Stage)(dragBar.getScene().getWindow());
        iniX = event.getScreenX() - stage.getX();
        iniY = event.getScreenY() - stage.getY();
    }
    public void dragBarDragged(MouseEvent event){
        Stage stage;
        stage = (Stage) (dragBar.getScene().getWindow());
        stage.setX(event.getScreenX()-iniX);
        stage.setY(event.getScreenY()-iniY);
    }

    public void handleKeyTyped(KeyEvent event){
        TextField textField = (TextField) event.getSource();
        if(textField.getText().length() > 5) {
            event.consume();
        }
        if(event.getCharacter().matches("[.0123456789-]")){
            if (textField.getText().length() == 0 && event.getCharacter().matches("[.]")) {
                event.consume();
            } else if (textField.getText().length() == 0 && event.getCharacter().matches("[-]")){
                event.consume();
            }
        } else {
            event.consume();
        }
    }

    public void handleMouseExit(){
        if (pos_horizontal.getText().equals("") || pos_horizontal.getText().equals("-") || pos_horizontal.getText().equals(".")){
            pos_horizontal.setText("0.0");
        }
        if (pos_vertical.getText().equals("") || pos_vertical.getText().equals("-") || pos_vertical.getText().equals(".")){
            pos_vertical.setText("0.0");
        }
    }
}

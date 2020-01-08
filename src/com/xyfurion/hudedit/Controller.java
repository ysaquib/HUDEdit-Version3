package com.xyfurion.hudedit;

import com.jfoenix.controls.JFXComboBox;
import javafx.animation.FillTransition;
import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;

public class Controller {

    static final String TOP = "HA_TOP";
    static final String CENTER = "HA_CENTER";
    static final String BOTTOM = "HA_BOTTOM";
    static final String RIGHT = "HA_RIGHT";
    static final String LEFT = "HA_LEFT";
    static double resolutionWidth = resolutionController.resolutionX;
    static double resolutionHeight = resolutionController.resolutionY;
    public HUDButton btn_abilityCooldown = new HUDButton();
    public HUDButton btn_playerHealth = new HUDButton();
    public HUDButton btn_weaponAmmo = new HUDButton();
    public HUDButton btn_actionMenu = new HUDButton();
    public HUDButton btn_actionMenuSpec = new HUDButton();
    public HUDButton btn_phantomShield = new HUDButton();
    public HUDButton btn_badgeNotification = new HUDButton();
    public HUDButton btn_characterSelect = new HUDButton();
    public HUDButton btn_chatInput = new HUDButton();
    public HUDButton btn_chatInputSpec = new HUDButton();
    public HUDButton btn_messageLog = new HUDButton();
    public HUDButton btn_messageLogSpec = new HUDButton();
    public HUDButton btn_obituaryLog = new HUDButton();
    //public HUDButton btn_obituaryLogSpec = new HUDButton();
    public HUDButton btn_objective = new HUDButton();
    public HUDButton btn_objectiveSpec = new HUDButton();
    public HUDButton btn_objectiveNotification = new HUDButton();
    public HUDButton btn_detected = new HUDButton();
    public HUDButton btn_debilitated = new HUDButton();
    public HUDButton btn_exeGameStatus = new HUDButton();
    public HUDButton btn_readyUp = new HUDButton();
    public HUDButton btn_subtitles = new HUDButton();
    public HUDButton btn_xpCounter = new HUDButton();
    public HUDButton btn_gamewave = new HUDButton();
    public HUDButton btn_gamewaveSpec = new HUDButton();
    public HUDButton btn_spectatorCard = new HUDButton();
    public HUDButton btn_minimap = new HUDButton();
    public ImageView image_abilityCooldown = new ImageView();
    public ImageView backgroundImage;
    public JFXComboBox<String> modeBox;
    public Label modeLabel;
    public Rectangle rec_close;
    public Rectangle rec_screen;
    public Rectangle rec_minimize;
    public AnchorPane menuBar;
    public HUDButton currentButton;
    public Asset currentAsset;
    public MenuItem menuItem_save = new MenuItem();
    //Creating the HUD Assets and Defining Properties
    public Asset abilityCooldown = new Asset(20, 113, RIGHT, BOTTOM, RIGHT, BOTTOM,
            "AbilityCooldownPosition", "Ability Cooldown", 220, 185);
    public Asset playerHealth = new Asset(20, 12, RIGHT, BOTTOM, RIGHT, BOTTOM,
            "PlayerHealthPosition", "Player Health", 200, 45);
    public Asset weaponAmmo = new Asset(20, 57, RIGHT, BOTTOM, RIGHT, BOTTOM,
            "WeaponAmmoPosition", "Weapon Ammo", 180, 55);
    public Asset actionMenu = new Asset(10, 10, LEFT, TOP, LEFT, TOP,
            "ActionMenuPosition", "Action Menu", 526, 137);
    public Asset actionMenuSpectator = new Asset(10, 10, LEFT, TOP, LEFT, TOP,
            "SpectatorActionMenuPosition", "Spectator Action Menu", 526, 137);
    public Asset phantomShield = new Asset(0, 100, CENTER, BOTTOM, CENTER, BOTTOM,
            "ShieldBarPosition", "Phantom Shield Bar", 453, 82);
    public Asset badgeNotification = new Asset(0, 0, CENTER, TOP, CENTER, TOP,
            "BadgeNotificationPosition", "Badge Notification", 250, 250);
    public Asset characterSelect = new Asset(0, 0, CENTER, BOTTOM, CENTER, BOTTOM,
            "CharacterSelectionPosition", "Merc Selection", 782, 327);
    public Asset chatInput = new Asset(39, 180, LEFT, BOTTOM, LEFT, BOTTOM,
            "ChatInputPosition", "Chat Input", 400, 20);
    public Asset chatInputSpectator = new Asset(39, 185, LEFT, TOP, LEFT, TOP,
            "SpectatorChatInputPosition", "Spectator Chat Input", 400, 20);
    public Asset messageLog = new Asset(39, 200, LEFT, BOTTOM, LEFT, BOTTOM,
            "ConsoleMessageLogPosition", "Chat Log", 400, 150);
    public Asset messageLogSpectator = new Asset(39, 35, LEFT, TOP, LEFT, TOP,
            "SpectatorConsoleMessageLog", "Spectator Chat Log", 400, 150);
    public Asset obituaryLog = new Asset(20, 60, RIGHT, TOP, RIGHT, TOP,
            "ObituaryMessageLogPosition", "Killfeed", 400, 150);
    public Asset objective = new Asset(40, 105, LEFT, TOP, LEFT, TOP,
            "ObjectivePosition", "Objective", 272, 36);
    public Asset objectiveSpectator = new Asset(0, 60, CENTER, TOP, CENTER, TOP,
            "SpectatorObjectivePosition", "Spectator Objective", 272, 36);
    public Asset objectiveNotification = new Asset(0, 150, CENTER, TOP, CENTER, TOP,
            "ObjectiveNotificationPosition=", "Objective Notification", 700, 70);
    public Asset detectedNotification = new Asset(0, 100, CENTER, CENTER, CENTER, BOTTOM,
            "DetectedNotificationPosition", "Detected Notification", 160, 30);
    public Asset debilitatedNotification = new Asset(0, 120, CENTER, CENTER, CENTER, BOTTOM,
            "DebilitatedNotificationPosition", "Debilitated Notification", 228, 30);
    public Asset gameStatus = new Asset(0, 0, CENTER, TOP, CENTER, TOP,
            "ExecutionGameStatusPosition", "Team Overlay", 1056, 120);
    public Asset readyUp = new Asset(0, 0, CENTER, TOP, CENTER, TOP,
            "ReadyUpPosition", "Ready Up", 218, 105);
    public Asset subtitles = new Asset(0, 122, CENTER, CENTER, CENTER, TOP,
            "SubtitlesPosition", "Subtitles", 300, 35);
    public Asset xpCounter = new Asset(0, 200, CENTER, CENTER, CENTER, CENTER,
            "ExpCounterPosition", "EXP Counter", 220, 80);
    public Asset gamewave = new Asset(40, 60, LEFT, TOP, LEFT, TOP,
            "GameWaveTimerPosition", "Timer", 160, 35);
    public Asset gamewaveSpectator = new Asset(0, 60, CENTER, TOP, CENTER, TOP,
            "SpectatorGameWaveTimerPosition", "Spectator Timer", 573, 35);
    public Asset spectatorCard = new Asset(0, 0, CENTER, BOTTOM, CENTER, BOTTOM,
            "SpectatorCardPosition", "Spectator Card", 416, 121);
    public Asset minimap = new Asset(39, 13, LEFT, BOTTOM, LEFT, BOTTOM,
            "MinimapPosition", "Minimap", 240, 165);
    private ArrayList<HUDButton> assetButtonArrayList = new ArrayList<>();
    private ArrayList<Asset> assetArrayList = new ArrayList<>();
    private ArrayList<HUDButton> modeInGame = new ArrayList<>();
    private ArrayList<HUDButton> modeSpectator = new ArrayList<>();
    private ArrayList<HUDButton> modeWarmUp = new ArrayList<>();
    private boolean assetIsSelected = false;
    private boolean alreadyExecuted = false;
    private boolean initialSetupRun = false;
    private boolean isFullScreen = false;
    private Stage stage = new Stage();
    private Stage stageControls = new Stage();
    private Parent root = null;
    private double initialX = 0;
    private double initialY = 0;
    private double assetInitialX = 0;
    private double assetInitialY = 0;
    private HUDFile hudFile = new HUDFile();

    //Event Handlers for basic functions
    public void closeMouseEnter() {
        rec_close.setOpacity(1);
    }

    public void closeMouseExit() {
        rec_close.setOpacity(0);
    }

    public void screenMouseEnter() {
        rec_screen.setOpacity(1);
    }

    public void screenMouseExit() {
        rec_screen.setOpacity(0);
    }

    public void minimizeMouseEnter() {
        rec_minimize.setOpacity(1);
    }

    public void minimizeMouseExit() {
        rec_minimize.setOpacity(0);
    }

    public void closeMouseClicked() {
        System.exit(0);
    }

    public void screenMouseClicked() {
        stageControls = (Stage) (rec_screen.getScene().getWindow());
        if (!isFullScreen) {
            stageControls.setFullScreen(true);
            stageControls.setAlwaysOnTop(true);
            isFullScreen = true;
        } else {
            stageControls.setFullScreen(false);
            stageControls.setAlwaysOnTop(false);
            isFullScreen = false;
        }
    }

    public void minimizeMouseClicked() {
        stageControls = (Stage) (rec_minimize.getScene().getWindow());
        stageControls.setIconified(true);

    }

    //Menubar handlers to move window
    public void menuBarMousePressed(MouseEvent event) {
        stageControls = (Stage) (menuBar.getScene().getWindow());
        initialX = event.getScreenX() - stageControls.getX();
        initialY = event.getScreenY() - stageControls.getY();
    }

    public void menuBarDragged(MouseEvent event) {
        stageControls = (Stage) (menuBar.getScene().getWindow());
        stageControls.setX(event.getScreenX() - initialX);
        stageControls.setY(event.getScreenY() - initialY);

    }

    public void menuBarEntered() {
        menuBar.setStyle("-fx-background-color: #663399");
        modeBox.setStyle("-fx-background-color: #663399");
    }

    public void menuBarExited() {
        menuBar.setStyle("-fx-background-color: rgba(0,0,0,0)");
        modeBox.setStyle("-fx-background-color: rgba(0,0,0,0)");
    }

    public void paneMouseEntered() {
        backgroundImage.setFitWidth(resolutionWidth);
        backgroundImage.setFitHeight(resolutionHeight);
        if (initialSetupRun) {
            return;
        }
        setButtonAssets();
        for (HUDButton button : assetButtonArrayList) {
            setAssetLocations(button);
        }

        hudFile.readHUDFile();
        setMenuEventListeners();

        //set Mode to InGame
        modeBox.setValue("In Game");

        //Make only InGame assets Visible
        for (HUDButton button : assetButtonArrayList)
            button.setVisible(false);
        for (HUDButton button : modeInGame)
            button.setVisible(true);
        initialSetupRun = true;
    }

    //Set Menu Handlers
    private void setMenuEventListeners() {
        menuItem_save.setOnAction(onMenuClicked());
        modeBox.setOnAction(onComboBoxClicked());
    }

    private EventHandler<ActionEvent> onMenuClicked() {
        return event -> {
            MenuItem mItem = (MenuItem) event.getSource();
            String option = mItem.getText();
            if (option.equals("Save"))
                hudFile.writeHUDFile();
        };
    }

    private EventHandler<ActionEvent> onComboBoxClicked() {
        return event -> {
            JFXComboBox comboBox = (JFXComboBox) event.getSource();
            String selectedItem = (String) comboBox.getValue();
            if (selectedItem.equals("In Game"))
                changeMode("InGame");
            else if (selectedItem.equals("Spectator"))
                changeMode("Spectator");
            else if (selectedItem.equals("Warm Up"))
                changeMode("WarmUp");
            else if (selectedItem.equals("All"))
                changeMode("All");
        };
    }


    //Set HUDButtons' Assets
    private void setButtonAssets() {
        assetArrayList.addAll(Arrays.asList(messageLog, messageLogSpectator, chatInput, chatInputSpectator, minimap, obituaryLog, xpCounter, subtitles,
                objectiveNotification, detectedNotification, debilitatedNotification, weaponAmmo, abilityCooldown, playerHealth, phantomShield, readyUp,
                badgeNotification, gamewaveSpectator, gamewave, objective, objectiveSpectator, actionMenu, actionMenuSpectator, characterSelect, spectatorCard, gameStatus));

        assetButtonArrayList.addAll(Arrays.asList(btn_messageLog, btn_messageLogSpec, btn_chatInput, btn_chatInputSpec, btn_minimap, btn_obituaryLog, btn_xpCounter, btn_subtitles,
                btn_objectiveNotification, btn_detected, btn_debilitated, btn_weaponAmmo, btn_abilityCooldown, btn_playerHealth, btn_phantomShield, btn_readyUp,
                btn_badgeNotification, btn_gamewaveSpec, btn_gamewave, btn_objective, btn_objectiveSpec, btn_actionMenu, btn_actionMenuSpec, btn_characterSelect, btn_spectatorCard, btn_exeGameStatus));

        modeInGame.addAll(Arrays.asList(btn_messageLog, btn_chatInput, btn_minimap, btn_obituaryLog, btn_xpCounter,
                btn_objectiveNotification, btn_detected, btn_debilitated, btn_weaponAmmo, btn_abilityCooldown, btn_playerHealth, btn_phantomShield,
                btn_badgeNotification, btn_gamewave, btn_objective, btn_actionMenu, btn_characterSelect, btn_exeGameStatus));

        modeSpectator.addAll(Arrays.asList(btn_messageLogSpec, btn_chatInputSpec, btn_minimap, btn_obituaryLog, btn_xpCounter,
                btn_objectiveNotification, btn_detected, btn_debilitated, btn_weaponAmmo, btn_abilityCooldown, btn_playerHealth, btn_phantomShield,
                btn_badgeNotification, btn_gamewaveSpec, btn_objectiveSpec, btn_actionMenuSpec, btn_spectatorCard, btn_exeGameStatus));

        modeWarmUp.addAll(Arrays.asList(btn_subtitles, btn_readyUp));

        for (int i = 0; i < assetArrayList.size(); i++) {
            assetButtonArrayList.get(i).setAsset(assetArrayList.get(i));
        }

    }

    //Asset Enter Exit Handlers
    public void assetEntered(MouseEvent event) {
        //Get the source of Handler
        HUDButton button = (HUDButton) event.getSource();
        if (!assetIsSelected) {
            button.setStyle("-fx-background-color: rgba(255,255,255,0.3); -fx-background-radius: 0; -fx-border-color: rgba(255,255,255,1); " +
                    "-fx-border-width: 2; -fx-border-radius: 0; -fx-border-style: solid inside; -fx-padding: 0;");
        }
    }

    public void assetExited(MouseEvent event) {
        //Get the source of Handler
        HUDButton button = (HUDButton) event.getSource();
        if (!assetIsSelected) {
            button.setStyle("-fx-background-color: rgba(255,255,255,0); -fx-background-radius: 0; -fx-border-color: rgba(255,255,255,0); " +
                    "-fx-border-width: 0; -fx-border-radius: 0; -fx-border-style: solid inside; -fx-padding: 0;");
        }
    }

    private double getAssetAlignX(HUDButton button) {
        double assetImageWidth = 0.0;
        switch (button.getAsset().getAlignH()) {
            case LEFT:
                assetImageWidth = 0.0;
                break;
            case CENTER:
                assetImageWidth = button.getAsset().getImageWidth() / 2;
                break;
            case RIGHT:
                assetImageWidth = button.getAsset().getImageWidth();
                break;
        }
        return assetImageWidth;
    }

    private double getAssetAlignY(HUDButton button) {
        double assetImageHeight = 0.0;
        switch (button.getAsset().getAlignV()) {
            case TOP:
                assetImageHeight = 0.0;
                break;
            case CENTER:
                assetImageHeight = button.getAsset().getImageHeight() / 2;
                break;
            case BOTTOM:
                assetImageHeight = button.getAsset().getImageHeight();
                break;
        }
        return assetImageHeight;
    }

    private double setAssetPixelOffsetX(HUDButton button) {
        double buttonPositionX = button.getLayoutX();
        double imageWidth = getAssetAlignX(button);
        double pixelOffsetX = 0.0;
        switch (button.getAsset().getAttachH()) {
            case LEFT:
                pixelOffsetX = buttonPositionX + imageWidth;
                break;
            case CENTER:
                pixelOffsetX = buttonPositionX + imageWidth - resolutionWidth / 2;
                break;
            case RIGHT:
                pixelOffsetX = resolutionWidth - buttonPositionX - imageWidth;
                break;
        }
        return pixelOffsetX;
    }

    private double setAssetPixelOffsetY(HUDButton button) {
        double buttonPositionY = button.getLayoutY();
        double imageHeight = getAssetAlignY(button);
        double pixelOffsetY = 0.0;
        switch (button.getAsset().getAttachV()) {
            case TOP:
                pixelOffsetY = buttonPositionY + imageHeight;
                break;
            case CENTER:
                pixelOffsetY = buttonPositionY + imageHeight - resolutionHeight / 2;
                break;
            case BOTTOM:
                pixelOffsetY = resolutionHeight - buttonPositionY - imageHeight;
                break;
        }
        return pixelOffsetY;
    }

    public void assetDragReleased(MouseEvent event) {
        HUDButton button = (HUDButton) event.getSource();
        button.getAsset().setPixelOffsetX(setAssetPixelOffsetX(button));
        button.getAsset().setPixelOffsetY(setAssetPixelOffsetY(button));
        System.out.println(setAssetPixelOffsetX(button));
        System.out.println(setAssetPixelOffsetY(button));
    }

    //Asset Click Handler
    public void assetPressed(MouseEvent event) {
        //Get the source of Handler
        HUDButton button = (HUDButton) event.getSource();
        assetInitialX = event.getX();
        assetInitialY = event.getY();
        //Check if an asset is already selected
        if (!assetIsSelected) {
            assetIsSelected = true;
            //Asset Identification and modification
            button.setStyle("-fx-background-color: rgba(255,255,255,0.3); -fx-background-radius: 0; -fx-border-color: rgba(255,200,20,1); " +
                    "-fx-border-width: 2; -fx-border-radius: 0; -fx-border-style: solid inside; -fx-padding: 0;");
            currentButton = button;
            currentAsset = button.getAsset();
            assetDragReleased(event);
            //Open stage
            openStage(currentAsset);

        } else {
            //if the current asset selected and the new asset clicked are the same
            if (button.getId().equals(currentButton.getId())) {
                button.setStyle("-fx-background-color: rgba(255,255,255,0); -fx-background-radius: 0; -fx-border-color: rgba(255,0,0,0); " +
                        "-fx-border-width: 0; -fx-border-radius: 0;  -fx-border-style: solid inside; -fx-padding: 0;");
                closeStage();
            }
            //if the current asset selected and the new asset clicked are different
            else {
                currentButton.setStyle("-fx-background-color: rgba(255,255,255,0); -fx-background-radius: 0; -fx-border-color: rgba(255,0,0,0); " +
                        "-fx-border-width: 0; -fx-border-radius: 0;  -fx-border-style: solid inside; -fx-padding: 0;");
                closeStage();
                currentButton = button;
                currentAsset = button.getAsset();
                currentButton.setStyle("-fx-background-color: rgba(255,255,255,0.3); -fx-background-radius: 0; -fx-border-color: rgba(255,200,20,1); " +
                        "-fx-border-width: 2; -fx-border-radius: 0; -fx-border-style: solid inside; -fx-padding: 0;");
                assetIsSelected = true;
                assetDragReleased(event);
                openStage(currentAsset);
            }
        }
    }

    /**
     * Set the location of buttons based off of asset properties
     *
     * @param button the {@code HUDButton} to set location of
     */
    public void setAssetLocations(HUDButton button) {
        double alignHeight = 0;
        double alignWidth = 0;
        switch (button.getAsset().getAlignH()) {
            case LEFT:
                switch (button.getAsset().getAlignV()) {
                    case TOP:
                        alignHeight = 0;
                        alignWidth = 0;
                        break;
                    case CENTER:
                        alignHeight = button.getAsset().getImageHeight() / 2;
                        alignWidth = 0;
                        break;
                    case BOTTOM:
                        alignHeight = button.getAsset().getImageHeight();
                        alignWidth = 0;
                        break;
                }
                break;
            case CENTER:
                switch (button.getAsset().getAlignV()) {
                    case TOP:
                        alignHeight = 0;
                        alignWidth = button.getAsset().getImageWidth() / 2;
                        break;
                    case CENTER:
                        alignHeight = button.getAsset().getImageHeight() / 2;
                        alignWidth = button.getAsset().getImageWidth() / 2;
                        break;
                    case BOTTOM:
                        alignHeight = button.getAsset().getImageHeight();
                        alignWidth = button.getAsset().getImageWidth() / 2;
                        break;
                }
                break;
            case RIGHT:
                switch (button.getAsset().getAlignV()) {
                    case TOP:
                        alignHeight = 0;
                        alignWidth = button.getAsset().getImageWidth();
                        break;
                    case CENTER:
                        alignHeight = button.getAsset().getImageHeight() / 2;
                        alignWidth = button.getAsset().getImageWidth();
                        break;
                    case BOTTOM:
                        alignHeight = button.getAsset().getImageHeight();
                        alignWidth = button.getAsset().getImageWidth();
                        break;
                }
                break;
        }
        //Attach
        switch (button.getAsset().getAttachH()) {
            case LEFT:
                switch (button.getAsset().getAttachV()) {
                    case TOP:
                        button.setLayoutX(button.getAsset().getPixelOffsetX() - alignWidth);
                        button.setLayoutY(button.getAsset().getPixelOffsetY() - alignHeight);
                        break;
                    case CENTER:
                        button.setLayoutX(button.getAsset().getPixelOffsetX() - alignWidth);
                        button.setLayoutY(resolutionHeight / 2 - alignHeight + button.getAsset().getPixelOffsetY());
                        break;
                    case BOTTOM:
                        button.setLayoutX(button.getAsset().getPixelOffsetX() - alignWidth);
                        button.setLayoutY(resolutionHeight - alignHeight - button.getAsset().getPixelOffsetY());
                        break;
                }
                break;
            case CENTER:
                switch (button.getAsset().getAttachV()) {
                    case TOP:
                        button.setLayoutX(resolutionWidth / 2 - alignWidth + button.getAsset().getPixelOffsetX());
                        button.setLayoutY(button.getAsset().getPixelOffsetY() - alignHeight);
                        break;
                    case CENTER:
                        button.setLayoutX(resolutionWidth / 2 - alignWidth + button.getAsset().getPixelOffsetX());
                        button.setLayoutY(resolutionHeight / 2 - alignHeight + button.getAsset().getPixelOffsetY());
                        break;
                    case BOTTOM:
                        button.setLayoutX(resolutionWidth / 2 - alignWidth + button.getAsset().getPixelOffsetX());
                        button.setLayoutY(resolutionHeight - alignHeight - button.getAsset().getPixelOffsetY());
                        break;
                }
                break;
            case RIGHT:
                switch (button.getAsset().getAttachV()) {
                    case TOP:
                        button.setLayoutX(resolutionWidth - alignWidth - button.getAsset().getPixelOffsetX());
                        button.setLayoutY(button.getAsset().getPixelOffsetY() - alignHeight);
                        break;
                    case CENTER:
                        button.setLayoutX(resolutionWidth - alignWidth - button.getAsset().getPixelOffsetX());
                        button.setLayoutY(resolutionHeight / 2 - alignHeight + button.getAsset().getPixelOffsetY());
                        break;
                    case BOTTOM:
                        button.setLayoutX(resolutionWidth - alignWidth - button.getAsset().getPixelOffsetX());
                        button.setLayoutY(resolutionHeight - alignHeight - button.getAsset().getPixelOffsetY());
                        break;
                }
                break;
        }
    }

    /**
     * @param asset the {@code Asset} to display the properties of
     */
    private void openStage(Asset asset) {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("optionsUI.fxml"));

        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        optionsController controller = fxmlLoader.getController();

        Scene scene = new Scene(root, 300, 365);
        stage.setScene(scene);
        if (!alreadyExecuted) {
            stage.initStyle(StageStyle.UNDECORATED);
            stage.initOwner(stageControls); //Making the mainUI the owner of the optionsUI
            stage.setTitle("HUDEdit Version 3.0.0");
            alreadyExecuted = true;
        }

        //link asset to options menu
        controller.assetLabel.setText(asset.getVisibleName());
        controller.pos_horizontal.setText(Double.toString(asset.getPixelOffsetX()));
        controller.pos_vertical.setText(Double.toString(asset.getPixelOffsetY()));

        //Check values to set radio buttons
        //Align
        setAlignValues(currentAsset, controller);
        //Attach
        setAttachValues(currentAsset, controller);
        // Add listener to radioboxes to change Asset properties
        listenToOptionControls(currentButton, controller);
        //Add listener to Current Button to change Pixel Offset X and Y


        stage.show();
    }

    private void setAlignValues(Asset asset, optionsController controller) {
        switch (asset.getAlignH()) {
            case LEFT:
                switch (asset.getAlignV()) {
                    case TOP:
                        controller.al_LT.setSelected(true);
                        break;
                    case CENTER:
                        controller.al_LC.setSelected(true);
                        break;
                    case BOTTOM:
                        controller.al_LB.setSelected(true);
                        break;
                }
                break;
            case RIGHT:
                switch (asset.getAlignV()) {
                    case TOP:
                        controller.al_RT.setSelected(true);
                        break;
                    case CENTER:
                        controller.al_RC.setSelected(true);
                        break;
                    case BOTTOM:
                        controller.al_RB.setSelected(true);
                        break;
                }
                break;
            case CENTER:
                switch (asset.getAlignV()) {
                    case TOP:
                        controller.al_CT.setSelected(true);
                        break;
                    case CENTER:
                        controller.al_CC.setSelected(true);
                        break;
                    case BOTTOM:
                        controller.al_CB.setSelected(true);
                        break;
                }
                break;
        }
    }

    private void setAttachValues(Asset asset, optionsController controller) {
        switch (asset.getAttachH()) {
            case LEFT:
                switch (asset.getAttachV()) {
                    case TOP:
                        controller.at_LT.setSelected(true);
                        break;
                    case CENTER:
                        controller.at_LC.setSelected(true);
                        break;
                    case BOTTOM:
                        controller.at_LB.setSelected(true);
                        break;
                }
                break;
            case RIGHT:
                switch (asset.getAttachV()) {
                    case TOP:
                        controller.at_RT.setSelected(true);
                        break;
                    case CENTER:
                        controller.at_RC.setSelected(true);
                        break;
                    case BOTTOM:
                        controller.at_RB.setSelected(true);
                        break;
                }
                break;
            case CENTER:
                switch (asset.getAttachV()) {
                    case TOP:
                        controller.at_CT.setSelected(true);
                        break;
                    case CENTER:
                        controller.at_CC.setSelected(true);
                        break;
                    case BOTTOM:
                        controller.at_CB.setSelected(true);
                        break;
                }
                break;
        }
    }

    private void listenToOptionControls(HUDButton button, optionsController controller) {
        controller.horizontalAlignment().addListener((obs, oldSelection, newSelection) -> {
            button.getAsset().setAlignH(controller.getAlignmentHorizontal());
            setAssetLocations(button);
        });
        controller.verticalAlignment().addListener((obs, oldSelection, newSelection) -> {
            button.getAsset().setAlignV(controller.getAlignmentVertical());
            setAssetLocations(button);
        });
        controller.horizontalAttachment().addListener((obs, oldSelection, newSelection) -> {
            button.getAsset().setAttachH(controller.getAttachmentHorizontal());
            setAssetLocations(button);
        });
        controller.verticalAttachment().addListener((obs, oldSelection, newSelection) -> {
            button.getAsset().setAttachV(controller.getAttachmentVertical());
            setAssetLocations(button);
        });
        controller.pixelOffsetX().addListener((obs, oldValue, newValue) -> {
            button.getAsset().setPixelOffsetX(controller.getPixOffsetX());
            setAssetLocations(button);
        });
        controller.pixelOffsetY().addListener((obs, oldValue, newValue) -> {
            button.getAsset().setPixelOffsetY(controller.getPixOffsetY());
            setAssetLocations(button);
        });
    }

    private void closeStage() {
        currentButton = null;
        currentAsset = null;
        assetIsSelected = false;
        //close Stage
        stage.hide();
    }

    public void assetDragged(MouseEvent event) {
        HUDButton button = (HUDButton) event.getSource();
        /*if (button.getLayoutX() <= -4 || button.getLayoutX() + button.getAsset().getImageWidth() >= resolutionWidth+4 ||
                button.getLayoutY() <= -4 || button.getLayoutY() + button.getAsset().getImageHeight() >= resolutionHeight+4 ){
            event.consume();
        } else {*/
            button.setLayoutX(button.getLayoutX() + event.getX() - assetInitialX);
            button.setLayoutY(button.getLayoutY() + event.getY() - assetInitialY);
        //}
    }

    /**
     * @param mode the mode selected
     */
    public void changeMode(String mode) {
        switch (mode) {
            case "InGame":
                for (HUDButton button : assetButtonArrayList)
                    button.setVisible(false);
                for (HUDButton button : modeInGame)
                    button.setVisible(true);
                break;
            case "WarmUp":
                for (HUDButton button : assetButtonArrayList)
                    button.setVisible(false);
                for (HUDButton button : modeWarmUp)
                    button.setVisible(true);
                break;
            case "Spectator":
                for (HUDButton button : assetButtonArrayList)
                    button.setVisible(false);
                for (HUDButton button : modeSpectator)
                    button.setVisible(true);
                break;
            case "All":
                for (HUDButton button : assetButtonArrayList)
                    button.setVisible(true);
                break;
        }
    }

    public class HUDFile {
        File shooterUIFile = new File("./src/com/xyfurion/hudedit/bin/resources/ShooterUI.ini");
        ArrayList<String> shooterUIRead = new ArrayList<>();
        ArrayList<String> shooterUIWrote = new ArrayList<>();

        void readHUDFile() {
            try {
                FileReader fileReader = new FileReader(shooterUIFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String line = bufferedReader.readLine();
                while (line != null) {
                    shooterUIRead.add(line);
                    line = bufferedReader.readLine();
                }

                bufferedReader.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Unable to open file '" + shooterUIFile + "'");
                ex.printStackTrace();
            } catch (IOException ex) {
                System.out.println("Error reading file '" + shooterUIFile + "'");
                ex.printStackTrace();
            }
        }

        //write to a file
        void writeHUDFile() {
            int j = 0;
            for (int i = 0; i < shooterUIRead.size(); i++) {
                System.out.println(j + "||" + i);
                if (shooterUIRead.get(i).startsWith(assetArrayList.get(j).getReferenceName()) && j < assetArrayList.size()) {
                    shooterUIWrote.add(i, assetArrayList.get(j).getSaveValues());
                    System.out.println(j + "--" + i);
                    if (j != 25)
                        j++;
                } else {
                    shooterUIWrote.add(shooterUIRead.get(i));
                }
            }
            for (String aShooterUIWrote : shooterUIWrote) System.out.println(aShooterUIWrote);

            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save HUD");
            fileChooser.setInitialFileName("ShooterUI.ini");
            File savedShooterUIFile = fileChooser.showSaveDialog(stage);

            if (savedShooterUIFile != null) {
                try {
                    Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(savedShooterUIFile), "UTF-8"));
                    for (String aShooterUIWrote : shooterUIWrote) writer.write(aShooterUIWrote + "\n");
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

        void loadHUDFile() {
            //read a file inputted by user
        }
    }
}


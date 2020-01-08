package com.xyfurion.hudedit;

import javafx.scene.control.Button;

/**
 * The purpose of this class is to create a custom JavaFX Button component
 * @author Xyfurion
 * @version 3.0.0
 */

public class HUDButton extends Button {
    public Asset asset;
    public void setAsset(Asset hudAsset){
        asset = hudAsset;
    }

    public Asset getAsset(){
        return asset;
    }
}

package com.xyfurion.hudedit;

/**
 * The purpose of this class is declare a object class {@code Asset}
 * @author Xyfurion
 * @version %I%, %G%
 */

class Asset {
    public double pixelOffsetX;
    public double pixelOffsetY;
    private String referenceName;
    private String visibleName;
    private String attachH;
    private String attachV;
    private String alignH;
    private String alignV;
    private double assetRatio = 720.0/Controller.resolutionHeight;

    private final double imageWidth;
    private final double imageHeight;


    Asset(double assetPixelOffsetX, double assetPixelOffsetY, String assetAlignH, String assetAlignV,
          String assetAttachH, String assetAttachV, String assetReferenceName, String assetVisibleName, double assetImageWidth, double assetImageHeight){
        pixelOffsetX = assetPixelOffsetX;
        pixelOffsetY = assetPixelOffsetY;
        referenceName = assetReferenceName;
        visibleName = assetVisibleName;
        attachH = assetAttachH;
        attachV = assetAttachV;
        alignH = assetAlignH;
        alignV = assetAlignV;
        imageWidth = assetImageWidth;
        imageHeight = assetImageHeight;
    }
    String getReferenceName(){
        return referenceName;
    }

    String getVisibleName(){
        return visibleName;
    }

    double getPixelOffsetX() {
        return pixelOffsetX;
    }

    double getPixelOffsetY() {
        return pixelOffsetY;
    }

    String getAlignH() {
        return alignH;
    }

    String getAlignV() {
        return alignV;
    }

    String getAttachH() {
        return attachH;
    }

    String getAttachV() {
        return attachV;
    }

    double getImageHeight() { return imageHeight; }

    double getImageWidth() { return imageWidth; }

    void setPixelOffsetX(double posX) {
        pixelOffsetX = posX;
    }

    void setPixelOffsetY(double posY) {
        pixelOffsetY = posY;
    }

    void setAlignH(String alignHorizontal) {
        alignH = alignHorizontal;
    }

    void setAlignV(String alignVertical) {
        alignV = alignVertical;
    }

    void setAttachH(String attachHorizontal) {
        attachH = attachHorizontal;
    }

    void setAttachV(String attachVertical) {
        attachV = attachVertical;
    }

    String getSaveValues() {
        return (referenceName + "=(Align=(H=" + alignH + ", V=" + alignV + "), Attach=(H=" + attachH + ", V=" + attachV + "), PixelOffset=(X=" + pixelOffsetX*assetRatio + ", Y=" + pixelOffsetY*assetRatio + "))");
    }

}

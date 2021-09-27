module Jfx.game.shop {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    /*
        requires rt;
        requires jfxrt;
     */
    //requires kotlin.stdlib;

    opens ui;
    opens dataStructures;
    opens model;
}
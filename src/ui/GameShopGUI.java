package ui;


import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameShopGUI {

    // ------------------------------------------------------------ INITIAL CONDITIONS CODE ------------------------------------------------------------



    
    // ------------------------------------------------------------ MENU CODE ------------------------------------------------------------




    // ------------------------------------------------------------ SHELVES CODE ------------------------------------------------------------




    // ------------------------------------------------------------ SHOW WINDOWS CODE ------------------------------------------------------------

    Stage mainStage = new Stage();
    Stage popupStage = new Stage();

    private void showInitialConditions() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InitialConditions.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        Scene e = new Scene(root);
        mainStage.setScene(e);
        popupStage.hide();
        mainStage.show();

    }

    private void showMenu() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        Scene e = new Scene(root);
        mainStage.setScene(e);
        popupStage.hide();
        mainStage.show();

    }

    private void showShelves() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Shelves.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        Scene e = new Scene(root);
        popupStage.setScene(e);
        mainStage.hide();
        popupStage.show();

    }
}

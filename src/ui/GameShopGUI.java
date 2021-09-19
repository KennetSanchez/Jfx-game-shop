package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameShopGUI {
    private BufferedReader br;

    public GameShopGUI() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String simulation() throws IOException {
        System.out.println("Enter the number of test cases");
        int cases = br.read();
        return "";
    }

    public String singleCase() throws IOException {
        System.out.println("Enter the number of cashiers available");
        int cashiers = br.read();

        System.out.println("Enter the number of shelves");
        int shelves = br.read();

        for (int i = 0; i < shelves; i++) {

        }
        return "";
    }
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

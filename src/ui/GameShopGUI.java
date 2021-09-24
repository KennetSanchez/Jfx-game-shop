package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import dataStructures.NearestPrimeFinder;
import dataStructures.Shelf;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Game;
import model.GameShop;

public class GameShopGUI {
    private BufferedReader br;
    private GameShop gs;

    public GameShopGUI() {
        br = new BufferedReader(new InputStreamReader(System.in));
        gs=new GameShop();
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
            System.out.println("Enter the shelf identifier and the number of different games on it. Example: A 5");
            String[] parts = br.readLine().split(" ");
            String identifier = parts[0];
            int differentGames = Integer.parseInt(parts[1]);
            Shelf<String,Game> shelf = new Shelf<>(identifier,differentGames,gs.getPrimeF());
            for(int j=0;j<differentGames;j++){
                System.out.println("Enter the code, the price and the quantity of copies. Example: 173 25000 5");
                String[] pts = br.readLine().split(" ");
                String code = pts[0];
                Game game = new Game(code,Double.parseDouble(pts[1]));
                shelf.insert(code,game,Integer.parseInt(pts[2]));
            }
            gs.addShelf(shelf);
        }
        System.out.println("Enter the number of customers entering the store");
        int c = br.read();
        for(int i=0;i<c;i++){
            System.out.println("Enter the customer's ID and the list of codes for the games he wants to buy. Example: 1627 287 612");
            String [] aux = br.readLine().split(" ");

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

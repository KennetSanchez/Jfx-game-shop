package ui;


import dataStructures.Shelf;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Client;
import model.Game;
import model.GameShop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameShopGUI<CLIENTS_tcName> {

    Stage mainStage;
    Stage popupStage;
    BufferedReader br;
    GameShop gs;

    public GameShopGUI() {
        br = new BufferedReader(new InputStreamReader(System.in));
        gs = new GameShop();

        mainStage = new Stage();
        popupStage = new Stage();
    }

    
    private void missingInfo(){
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Error!");
        alert.setHeaderText("Missing information");
        alert.setContentText("Fill all the camps and try again");
        alert.show();
    }

    private void wrongFormat(){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error!");
        alert.setHeaderText("Wrong format");
        alert.setContentText("Please write only integers");
        alert.show();
    }
    // ------------------------------------------------------------ INITIAL CONDITIONS CODE ------------------------------------------------------------

    @FXML
    private TextField INITIALCONDITIONS_txtTestCases;

    @FXML
    private TextField INITIALCONDITIONS_txtCashiers;

    @FXML
    private TextField INITIALCONDITIONS_txtShelves;

    @FXML
    void INITIALCONDITIONS_cancel(ActionEvent event) throws IOException {
        showMenu();
    }

    @FXML
    void INITIALCONDITIONS_done(ActionEvent event) throws IOException {
        int testCases = 0;
        int cashiers = 0;
        int shelves = 0;

        try{
            testCases = Integer.parseInt(INITIALCONDITIONS_txtTestCases.getText());
            cashiers = Integer.parseInt(INITIALCONDITIONS_txtCashiers.getText());
            shelves = Integer.parseInt(INITIALCONDITIONS_txtShelves.getText());    
            
            if(testCases == 0 || cashiers == 0 || shelves == 0 ){
                missingInfo();
            }else{
                showShelves();
            }
        }catch(Exception e){
            wrongFormat();
        }
        
        
    }   
    
    // ------------------------------------------------------------ MENU CODE ------------------------------------------------------------

    @FXML
    void MENU_close(ActionEvent event) {

    }

    @FXML
    void MENU_setConditions(ActionEvent event) throws IOException {
    showInitialConditions();
    }

    @FXML
    void MENU_start(ActionEvent event) {

    }


    // ------------------------------------------------------------ SHELVES CODE ------------------------------------------------------------
    Shelf  selectedShelf;

    @FXML
    private TextField SHELVES_txtShelveId;

    @FXML
    private TextField SHELVES_txtGameId;

    @FXML
    private TableView<Shelf<String, Game>> SHELVES_tvShelves;

    @FXML
    private TableColumn<Shelf, String> SHELVES_tcShelve;

    @FXML
    private TableColumn<Shelf, Integer> SHELVES_tcSpace;

    @FXML
    private TableView<Game> SHELVES_tvGames;

    @FXML
    private TableColumn<Game, String> SHELVES_tcGameId;

    @FXML
    private TableColumn<Game, Double> SHELVES_tcGamePrice;

    @FXML
    private TableColumn<Game, Integer> SHELVES_tcGameAmount;

    @FXML
    private TextField SHELVES_txtGameSpace;

    @FXML
    private TextField SHELVES_txtGamePrice;

    @FXML
    private TextField SHELVES_txtGameAmount;

    @FXML
    void SHELVES_Menu(ActionEvent event) throws IOException {
        showMenu();
    }

    @FXML
    void SHELVES_addGame(ActionEvent event) {
        String code = SHELVES_txtGameId.getText();
        String sPrice = SHELVES_txtGamePrice.getText();
        String sAmount = SHELVES_txtGameAmount.getText();

        try{
            double price = Double.parseDouble(sPrice);
            int gameAmount = Integer.parseInt(sAmount);
            selectedShelf = gs.getShelvesAL().get(0);

            if(!code.equals("") && !sPrice.equals("") && !sAmount.equals("") && selectedShelf != null){
                gs.addGame(selectedShelf, code, price, gameAmount);
                SHELVES_txtGameAmount.setText("");
                SHELVES_txtGameId.setText("");
                SHELVES_txtGamePrice.setText("");
            }else{
                missingInfo();
            }
        }catch(Exception e){
            wrongFormat();
        }


    }

    @FXML
    void SHELVES_addShelve(ActionEvent event) throws IOException {
        String id = SHELVES_txtShelveId.getText();
        int size = 0;
        try{
            size = Integer.parseInt(SHELVES_txtGameSpace.getText());
        }catch(Exception e){
            wrongFormat();
        }

        if(size != 0 && !id.equals("")){
            gs.addShelf(id, size);
            SHELVES_txtGameSpace.setText("");
            SHELVES_txtShelveId.setText("");
            refreshShelves();
        }else{
            missingInfo();
        }
    }

    @FXML
    void SHELVES_pickAShelf(MouseEvent event) {
        if(event.getClickCount() == 2){
            if(SHELVES_tvShelves.getSelectionModel().getSelectedItem() != null) {
                selectedShelf = SHELVES_tvShelves.getSelectionModel().getSelectedItem();
                System.out.print(selectedShelf.getIdentifier());
            }else{
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error!");
                alert.setHeaderText("Null element");
                alert.setContentText("Please select a valid element, and try again");
                alert.show();
            }
        }

    }

    // ------------------------------------------------------------ COSTUMERS CODE ------------------------------------------------------------

    @FXML
    private TableView<Client> CLIENTS_tvClients;

    @FXML
    private TableColumn<Client, String> CLIENTS_tcId;

    @FXML
    private TableColumn<Client, String> CLIENTS_tcGames;

    @FXML
    private TextArea CLIENTS_txtGames;

    @FXML
    private TextField CLIENTS_txtId;

    @FXML
    void addCostumer(ActionEvent event) {
        String id = CLIENTS_txtId.getText();
        String games = CLIENTS_txtGames.getText();

        if((!id.equals("") && (!games.equals("")))){
            gs.addCostumer(id, games);
        }else{
            missingInfo();
        }
    }

    @FXML
    void goMenu(ActionEvent event) throws IOException {
        showMenu();
    }


    // ------------------------------------------------------------ SHOW WINDOWS CODE ------------------------------------------------------------

    

    public void showInitialConditions() throws IOException {
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
        refreshShelves();

    }

    private void refreshShelves() throws IOException{
        if(gs.getShelvesAL() != null) {
            ObservableList<Shelf<String, Game>> shelves = FXCollections.observableList(gs.getShelvesAL());
            SHELVES_tvShelves.setItems(shelves);
        }

        SHELVES_tcShelve.setCellValueFactory(new PropertyValueFactory<Shelf,String>("identifier"));
        SHELVES_tcSpace.setCellValueFactory(new PropertyValueFactory<Shelf, Integer>("size"));
    }

    private void refreshGames() throws IOException{
        //if(selectedShelf.getGames() != null) {
            //ObservableList<Game> games = FXCollections.observableList(selectedShelf.getGames());
            //SHELVES_tvGames.setItems(games);
        //}

        SHELVES_tcGameId.setCellValueFactory(new PropertyValueFactory<Game,String>("code"));
        SHELVES_tcGameAmount.setCellValueFactory(new PropertyValueFactory<Game, Integer>("amount"));
        SHELVES_tcGamePrice.setCellValueFactory(new PropertyValueFactory<Game, Double>("price"));
    }

    private void showCostumers() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Costumers.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        Scene e = new Scene(root);
        popupStage.setScene(e);
        mainStage.hide();
        popupStage.show();
    }
}

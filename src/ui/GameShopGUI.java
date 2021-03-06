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

import java.io.IOException;

public class GameShopGUI{

    Stage mainStage;
    Stage popupStage;

    GameShop gs;

    public GameShopGUI() {
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

    int cashiers = 0;



    @FXML
    private TextField INITIALCONDITIONS_txtCashiers;



    @FXML
    void INITIALCONDITIONS_cancel(ActionEvent event) throws IOException {
        showMenu();
    }

    @FXML
    void INITIALCONDITIONS_done(ActionEvent event) throws IOException {


        try{
            cashiers = Integer.parseInt(INITIALCONDITIONS_txtCashiers.getText());

            gs.addCashiers(cashiers);
            if(cashiers == 0 ){
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
        mainStage.close();
        popupStage.close();
        System.exit(0);
    }

    @FXML
    void MENU_setConditions(ActionEvent event) throws IOException {
        showInitialConditions();
    }

    @FXML
    void MENU_start(ActionEvent event) throws IOException {
        gs.clientsGetGames();
        gs.createQueue();
        gs.serveClients();
        showResults();
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
    void SHELVES_addGame(ActionEvent event) throws IOException {
        String code = SHELVES_txtGameId.getText();
        String sPrice = SHELVES_txtGamePrice.getText();
        String sAmount = SHELVES_txtGameAmount.getText();

        try{
            double price = Double.parseDouble(sPrice);
            int gameAmount = Integer.parseInt(sAmount);

            if(!code.equals("") && !sPrice.equals("") && !sAmount.equals("") && selectedShelf != null){
                gs.addGame(selectedShelf, code, price, gameAmount);
                SHELVES_txtGameAmount.setText("");
                SHELVES_txtGameId.setText("");
                SHELVES_txtGamePrice.setText("");
                refreshGames();
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
    void SHELVES_pickAShelf(MouseEvent event) throws IOException {
        if(event.getClickCount() == 2){
            if(SHELVES_tvShelves.getSelectionModel().getSelectedItem() != null) {
                selectedShelf = SHELVES_tvShelves.getSelectionModel().getSelectedItem();
                refreshGames();
            }else{
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error!");
                alert.setHeaderText("Null element");
                alert.setContentText("Please select a valid element, and try again");
                alert.show();
            }
        }

    }

    @FXML
    void SHELVES_addCostumers(ActionEvent event) throws IOException {
            showCostumers();
    }

    // ------------------------------------------------------------ COSTUMERS CODE ------------------------------------------------------------

    int selectedAlgorithm = 0;

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
    private CheckBox CLIENTS_cb_insertionSort;

    @FXML
    private CheckBox CLIENTS_cb_bubbleSort;

    @FXML
    private TableColumn<Client, String> CLIENTS_tcSort;

    @FXML
    void CLIENTS_bubbleSort(ActionEvent event) {
        CLIENTS_cb_insertionSort.setSelected(false);
        selectedAlgorithm = 2;
    }

    @FXML
    void CLIENT_insertionSort(ActionEvent event) {
        CLIENTS_cb_bubbleSort.setSelected(false);
        selectedAlgorithm = 1;
    }


    @FXML
    void addCostumer(ActionEvent event) throws IOException {
        String id = CLIENTS_txtId.getText();
        String games = CLIENTS_txtGames.getText();
        String parsedGames = games.replaceAll("\n", " ");

        if((!id.equals("") && (!games.equals("") ) && selectedAlgorithm != 0)){
            String info = id+ " " + parsedGames;
            switch (selectedAlgorithm){
                case 1:
                    gs.insertionSortGames(info);
                    break;
                case 2:
                    gs.bubbleSortGames(info);
                    break;
            }
            refreshCostumers();
            CLIENTS_txtId.setText("");
            CLIENTS_txtGames.setText("");
            selectedAlgorithm = 0;
            CLIENTS_cb_insertionSort.setSelected(false);
            CLIENTS_cb_bubbleSort.setSelected(false);
        }else{
            missingInfo();
        }
    }

    @FXML
    void goMenu(ActionEvent event) throws IOException {
        showMenu();
    }

    // ------------------------------------------------------------  RESULTS CODE ------------------------------------------------------------


    @FXML
    private TableView<Client> RESULTS_tvCostumer;

    @FXML
    private TableColumn<Client, String> RESULTS_tcId;

    @FXML
    private TableColumn<Client, Integer> RESULTS_tcPaid;

    @FXML
    private TableColumn<Client, String> RESULTS_tcGamesBuyed;

    // ------------------------------------------------------------ SHOW WINDOWS CODE ------------------------------------------------------------

    

    public void showInitialConditions() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InitialConditions.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        Scene e = new Scene(root);
        mainStage.setScene(e);
        popupStage.hide();
        mainStage.show();

        if(cashiers != 0){
            INITIALCONDITIONS_txtCashiers.setText(cashiers + "");
        }


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
        ObservableList<Game> games = FXCollections.observableList(gs.getGamesAL(selectedShelf));
        SHELVES_tvGames.setItems(games);

        SHELVES_tcGameId.setCellValueFactory(new PropertyValueFactory<Game,String>("code"));
        SHELVES_tcGameAmount.setCellValueFactory(new PropertyValueFactory<Game, Integer>("quantity"));
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
        refreshCostumers();
    }

    private void refreshCostumers() throws IOException{
        if(gs.getCostumers().size() > 0) {
            ObservableList<Client> costumers = FXCollections.observableList(gs.getCostumers());
            CLIENTS_tvClients.setItems(costumers);
        }

        CLIENTS_tcId.setCellValueFactory(new PropertyValueFactory<Client, String>("id"));
        CLIENTS_tcGames.setCellValueFactory(new PropertyValueFactory<Client, String>("gameListString"));
        CLIENTS_tcSort.setCellValueFactory(new PropertyValueFactory<Client, String>("sa"));
    }

    private void showResults() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Results.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        Scene e = new Scene(root);
        popupStage.setScene(e);
        mainStage.hide();
        popupStage.show();
        refreshResults();
    }

    private void refreshResults()throws IOException{

        if(gs.getCostumers().size() > 0) {
            ObservableList<Client> costumers = FXCollections.observableList(gs.getCostumers());
            RESULTS_tvCostumer.setItems(costumers);
        }

        RESULTS_tcId.setCellValueFactory(new PropertyValueFactory<Client, String>("id"));
        RESULTS_tcPaid.setCellValueFactory(new PropertyValueFactory<Client, Integer>("priceToPay"));
        RESULTS_tcGamesBuyed.setCellValueFactory(new PropertyValueFactory<Client, String>("gameListString"));
    }
}

package ui;

import dataStructures.Shelf;
import model.Game;
import model.GameShop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleImplementation {
    private BufferedReader br;
    private GameShop gs;

    public ConsoleImplementation() {
        br = new BufferedReader(new InputStreamReader(System.in));
        gs=new GameShop();
    }

    public String simulation() throws IOException {
        System.out.println("Enter the number of test cases");
        int cases = Integer.parseInt(br.readLine());
        String info = "";
        for(int i=0;i<cases;i++){
            info+=singleCase();
        }
        return info;
    }

    public String singleCase() throws IOException {
        System.out.println("Enter the number of cashiers available");
        int cashiers = Integer.parseInt(br.readLine());
        gs.addCashiers(cashiers);
        System.out.println("Enter the number of shelves");
        int shelves = Integer.parseInt(br.readLine());

        for (int i = 0; i < shelves; i++) {
            System.out.println("Enter the shelf identifier and the number of different games on it. Example: A 5");
            String[] parts = br.readLine().split(" ");
            System.out.println("a ver "+parts[0]);
            String identifier = parts[0];
            int differentGames = Integer.parseInt(parts[1]);
            Shelf<String, Game> shelf = new Shelf<>(identifier,differentGames,gs.getPrimeF());
            for(int j=0;j<differentGames;j++){
                System.out.println("Enter the code, the price and the quantity of copies. Example: 173 25000 5");
                String[] pts = br.readLine().split(" ");
                String code = pts[0];
                Game game = new Game(code,Integer.parseInt(pts[1]));
                shelf.insert(code,game,Integer.parseInt(pts[2]));
            }
            gs.addShelf(shelf);
        }
        System.out.println("Enter the number of customers entering the store");
        int c = Integer.parseInt(br.readLine());
        int random = 0;
        for(int i=0;i<c;i++){
            System.out.println("Enter the customer's ID and the list of codes for the games he wants to buy. Example: 1627 287 612");
            String [] aux = br.readLine().split(" ");
            random = (int)Math.random()*(2-2)+1;
            switch (random){
                case 1:
                    gs.bubbleSortGames(aux);
                    break;
                case 2:
                    gs.insertionSortGames(aux);
                    break;
            }
        }
        gs.clientsGetGames();
        System.out.println("GetGames done");
        gs.createQueue();
        System.out.println("Createqueue done");
        gs.serveClients();
        System.out.println("serveclient done");
        return gs.showClientsResult();
    }
}

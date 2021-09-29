package model;

import dataStructures.NearestPrimeFinder;
import dataStructures.Shelf;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GameShopTest {
    GameShop gameShopTest;
    private NearestPrimeFinder primeF;
    Shelf<String, Game> testShelf;
    Game aux = new Game("abc", 2000.1);

    public void gameShopTestScenary1() {
        gameShopTest = new GameShop();
        primeF = new NearestPrimeFinder();
        testShelf = new Shelf<String, Game>("0", 1, primeF);
        gameShopTest.addShelf(testShelf);
    }

    public void gameShopTestScenary2() {
        gameShopTest = new GameShop();
        primeF = new NearestPrimeFinder();
        testShelf = new Shelf<String, Game>("0", 1, primeF);
        Game gameTest = new Game("331", 30);
        testShelf.insert(gameTest.getCode(), gameTest, 2);
        gameShopTest.addShelf(testShelf);
    }
    public void gameShopTestScenary3(){
        gameShopTest = new GameShop();
        primeF = new NearestPrimeFinder();
    }

    public void gameShopTestScenary4(){
        gameShopTest = new GameShop();
        primeF = new NearestPrimeFinder();
        String[]z= {"a"};
        Client a=new Client("1234",z,2);
        Client b=new Client("5678",z,3);
        Client c=new Client("9101",z,1);
        gameShopTest.getCostumers().add(a);
        gameShopTest.getCostumers().add(b);
        gameShopTest.getCostumers().add(c);
    }

    public void gameShopTestScenary5(){
        gameShopTest = new GameShop();
        primeF = new NearestPrimeFinder();
        String[]z= {"123","456"};
        Game game1=new Game("123",200);
        Game game2=new Game("456",200);
        Game game3=new Game("789",200);

        Shelf shelf1=new Shelf("1",1,primeF);
        Shelf shelf2=new Shelf("2",1,primeF);
        Shelf shelf3=new Shelf("3",1,primeF);
        shelf1.insert(game1.getCode(),game1.getPrice(),5);
        shelf2.insert(game2.getCode(),game2.getPrice(),5);
        shelf3.insert(game3.getCode(),game3.getPrice(),5);
        gameShopTest.addShelf(shelf1);
        gameShopTest.addShelf(shelf2);
        gameShopTest.addShelf(shelf3);
        Client a=new Client("1234",z,2);
        Client b=new Client("5678",z,3);
        Client c=new Client("9101",z,1);
        gameShopTest.getCostumers().add(a);
        gameShopTest.getCostumers().add(b);
        gameShopTest.getCostumers().add(c);
        gameShopTest.createQueue();
    }


    @Test
    void checkAddShelf() {
        gameShopTestScenary1();
        assertTrue(!gameShopTest.getShelvesAL().isEmpty());
    }

    @Test
    void checkAddCashiers() {
        gameShopTestScenary1();
        gameShopTest.addCashiers(2);
        assertEquals(2, gameShopTest.getCashiers().length);
    }

    @Test
    void checkWhichShelf() {
        gameShopTestScenary2();
        String code = "331";
        assertTrue(gameShopTest.whichShelf(code) == 0);
    }

    @Test
    void checkInsertionSortGames(){
        gameShopTestScenary3();
        String gameToCompare="123";
        Game game1=new Game("123",200);
        Game game2=new Game("456",200);
        Game game3=new Game("789",200);

        Shelf shelf1=new Shelf("1",1,primeF);
        Shelf shelf2=new Shelf("2",1,primeF);
        Shelf shelf3=new Shelf("3",1,primeF);
        shelf1.insert(game1.getCode(),game1.getPrice(),1);
        shelf2.insert(game2.getCode(),game2.getPrice(),1);
        shelf3.insert(game3.getCode(),game3.getPrice(),1);
        gameShopTest.addShelf(shelf1);
        gameShopTest.addShelf(shelf2);
        gameShopTest.addShelf(shelf3);
        String a="1627 789 123";
        gameShopTest.insertionSortGames(a);
        String b=gameShopTest.getCostumers().get(0).getGameList()[0];
        String[] c=b.split(" ");
        assertEquals(c[0],gameToCompare);
    }

    @Test
    void checkBubbleSortGames(){
        gameShopTestScenary3();
        String gameToCompare="123";
        Game game1=new Game("123",200);
        Game game2=new Game("456",200);
        Game game3=new Game("789",200);

        Shelf shelf1=new Shelf("1",1,primeF);
        Shelf shelf2=new Shelf("2",1,primeF);
        Shelf shelf3=new Shelf("3",1,primeF);
        shelf1.insert(game1.getCode(),game1.getPrice(),1);
        shelf2.insert(game2.getCode(),game2.getPrice(),1);
        shelf3.insert(game3.getCode(),game3.getPrice(),1);
        gameShopTest.addShelf(shelf1);
        gameShopTest.addShelf(shelf2);
        gameShopTest.addShelf(shelf3);
        String a="1627 789 123";
        gameShopTest.bubbleSortGames(a);
        String b=gameShopTest.getCostumers().get(0).getGameList()[0];
        String[] c=b.split(" ");
        assertEquals(c[0],gameToCompare);
    }



    @Test
    void checkSortClientsByMinutes(){
        gameShopTestScenary4();
        ArrayList<Client> c=gameShopTest.getCostumers();
        Client clientTemp=gameShopTest.getCostumers().get(0);
        gameShopTest.sortClientsByMinutes();
        assertTrue(clientTemp.getId()!=gameShopTest.getCostumers().get(0).getId());
    }

    @Test
    void checkCreateQueue(){
        gameShopTestScenary4();
        Client clientTemp=gameShopTest.getCostumers().get(2);
        gameShopTest.createQueue();
        assertSame(gameShopTest.getClientsQueue().getFirstClient().getElement().getId(), clientTemp.getId());
    }


}
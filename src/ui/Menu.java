package ui;

import java.util.Scanner;

public class Menu {
    private Scanner sc;
    public Menu(){
        sc=new Scanner(System.in);
    }

    public String simulation(){
        System.out.println("Enter the number of test cases");
        int cases = sc.nextInt();
        return "";
    }

    public String singleCase(){
        System.out.println("Enter the number of cashiers available");
        int cashiers = sc.nextInt();
        System.out.println("Enter the number of shelves");
        int shelves = sc.nextInt();
        for(int i=0;i<shelves;i++){

        }
        return "";
    }
}

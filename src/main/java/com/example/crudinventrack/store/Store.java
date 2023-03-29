package com.example.crudinventrack.store;
import com.example.crudinventrack.dao.BookDAO;
import com.example.crudinventrack.entity.Book;
import com.example.crudinventrack.inventorymanagement.util.InventoryItem;
import com.example.crudinventrack.inventorymanagement.util.InventoryWareHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class Store{
    private static InventoryWareHouse inventoryWareHouse;
    @Autowired
    public void setInventoryWareHouse(InventoryWareHouse inventoryWareHouse){
        this.inventoryWareHouse = inventoryWareHouse;
    }
    public void testing2(){
        System.out.println("hi from store");
    }
    public void printMenu(){
        //init
        int choice;
        //User menu
        Scanner sc = new Scanner(System.in);
        do{
            //when purchasing the product the person should get the entire product details
            System.out.println("Welcome to the Roshan's Store");
            System.out.println("1. Purchase the product");
            System.out.println("2. Get Specific Product Details");
            System.out.println("3. Make Changes in the WareHouse");
            System.out.println();
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
        }while(choice<0);
        switch(choice){
            case 1:
                inventoryWareHouse.purchaseTheProduct();
                break;
            case 2:
                /*inventoryWareHouse.getSpecificProductDetails2(inventoryItem);
                break;*/
            case 3:
                //only for the employees
                /*inventoryWareHouse.makeAnyChangesInWareHouse(inventoryItem);
                break;*/
            case 4:
                //make changes the product information in ware-house
                break;
        }
        //redisplay this menu unless the user wants to quit
        if(choice!=8){ //1:10:16
//            StoreInventory.printUserMenu(currentUser, sc);
        }
    }
    public static void checkOut(int productId){

    }
    public static void createBookObject(BookDAO bookDAO){
        //creating the book object
        System.out.println("Creating the book object...");
        Book book = new Book("Java 122", 23.00, 5, "James Gosling",
                "Michael jackson", 23283923);

        //save the book object to the database
        System.out.println("Saving the book to the database...");
        bookDAO.saveBook(book);

        //display the id of the saved student
        System.out.println("Saved Book. specId: " + book.getIsbn());

    }
    public static void testing(){


    }


}

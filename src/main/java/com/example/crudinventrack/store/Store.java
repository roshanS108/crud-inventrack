package com.example.crudinventrack.store;
import com.example.crudinventrack.entity.Book;
import com.example.crudinventrack.inventorymanagement.util.InventoryItem;
import com.example.crudinventrack.inventorymanagement.util.InventoryWareHouse;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Store{
    private static InventoryWareHouse inventoryWareHouse;

    public static void main(String[] args) {

        //it will have different copy

//        ServiceInventory serviceInventory = new InventoryWareHouse();
        /*book1.addProduct(book1);
        book1.getBookDetails(book1.getAuthor(), book1.getName());
        System.out.println(inventoryWareHouse.calculateTotalNumberOfProduct());
        printMenu(book1);
*/
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Book book1 = context.getBean("book", Book.class);
        book1.testing();


    }
    public static void printMenu(InventoryItem inventoryItem){
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
                inventoryWareHouse.purchaseTheProduct(inventoryItem);
                break;
            case 2:
                inventoryWareHouse.getSpecificProductDetails2(inventoryItem);
            case 3:
                //only for the employees
                inventoryWareHouse.makeAnyChangesInWareHouse(inventoryItem);
                break;
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
}

package com.example.crudinventrack.entity;
import com.example.crudinventrack.inventorymanagement.util.InventoryItem;
import com.example.crudinventrack.inventorymanagement.util.InventoryWareHouse;
import com.example.crudinventrack.inventorymanagement.util.Product;
import com.example.crudinventrack.inventorymanagement.util.ServiceInventory;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;
@Entity
@Table(name = "Book")
public class Book extends InventoryItem<Book> implements Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBook")
    private int id;

    @Column(name = "author_name")
    private String author;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "book_isbn")
    private int isbn;
    //injecting the dependencies

    private InventoryWareHouse inventoryWareHouse = new InventoryWareHouse();

    private ServiceInventory inventoryService;
    public Book(){

    }
    public Book(String name, double price, int quantity, int specId, String author,
                String publisher, int isbn) {
        super(name, price, quantity, specId);
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;

    }

    @Autowired
    public void setBook(ServiceInventory inventoryService){
        this.inventoryService = inventoryService;
    }

    public Book(
          int id, ServiceInventory serviceInventory){
        System.out.println("constructor with two argument with id");
        this.id = id;
        this.inventoryService = serviceInventory;
    }
    public Book( String authorName,
                ServiceInventory inventoryService){
        System.out.println("constructor with two argument with author name");
        this.author = authorName;
        this.inventoryService = inventoryService;
    }

   /* @Autowired
    public void setBook(
            @Qualifier("inventoryWareHouse") ServiceInventory serviceInventory){
        this.inventoryService = serviceInventory;
        System.out.println("Setter method is being called");
    }
    @Autowired
    public void setBook2(String author, @Qualifier("inventoryWareHouse2") ServiceInventory serviceInventory){
        this.author = author;
        this.inventoryService = serviceInventory;
        System.out.println("Setter method is being called from setbook2");
    }*/
    public void testing(){
        if(inventoryService == null){
            System.out.println("yes it is null");
        }else{
            System.out.println("Not it's not null");
            System.out.println("The id is: " + this.id);
            System.out.println("The author is: " + this.getName());
        }
    }
    public void setIsbn(int isbn) {
        this.isbn = isbn;
        System.out.println("The isbn is: " + this.isbn);
    }


    public String getAuthor(){
        return this.author;
    }
    //make this loose-coupling
    public void getBookCollection(){
        System.out.println( inventoryWareHouse.getBookCollection());

    }
    public String getPublisher(){
        return publisher;
    }
    public int getIsbn(){
        return isbn;
    }
    @Override
    public void removeProduct(int isbn) {
        System.out.println("removing the book class-->using dependency injection");
        this.inventoryService.removeBook(isbn);
    }
    //calling this method through help of dependencies
    public void getBookDetails(String bookName, String authorName) {
        inventoryService.getBookDetails(bookName,authorName);
    }
    @Override
    public void addProduct(Book theBook) {
        System.out.println("Adding books to the warehouse");
        inventoryWareHouse.addBookProduct(theBook);
    }
    /*public void addBooks2(Book theBook){
        System.out.println("Adding book " + getName() + " to specific shelf");
        //if the specId and isbn number doesn't match then there is no duplicate there so accept it.
        if(checkIfISBNExist(theBook.getIsbn())){
            inventoryWareHouse.addBooksToWareHouse(theBook);
            inventoryWareHouse.addProductsToWareHouse(theBook);
        }else{
            System.out.println("Sorry there is already a duplicate value, your id and isbn should be unique");
        }
        System.out.println("Adding books in the Book Class dsa");
    }*/
    @Override
    public int updateQuantity(int newQuantity) {
        return 0;
    }
    public void searchBookByAuthorName(String name){
        this.inventoryWareHouse.searchByAuthorName(name);
    }
    public String toString() {
        return "Book{" + "Name: " + this.getName() + "\n" +
                "price: " + this.getPrice() + "\n" +
                "author='" + this.author + "\n" +
                ", publisher='" + publisher + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
    //get total number of books from the inventory warehouse
    public void getTotalNumberOfBooks(){
        this.inventoryWareHouse.calculateTotalNumberOfBooks();
    }
    public List<Book> getBooksItems(){
        return null;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void totalNumberOfBooks(){

    }
}

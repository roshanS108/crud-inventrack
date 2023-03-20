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
@Component("book")
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
    private InventoryWareHouse inventoryWareHouse;
    private ServiceInventory inventoryService;
    public Book(){

    }
    //injecting the dependencies
//    @Autowired
    public Book(String name, double price, int quantity, int specId, String author,
                String publisher, int isbn, ServiceInventory inventoryService) {
        super(name, price, quantity, specId);
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.inventoryService = inventoryService;
    }

    @Autowired
    public Book(
            int id, ServiceInventory serviceInventory){
        System.out.println("constructor with one argument");
        this.id = id;
        this.inventoryService = serviceInventory;
    }

    public void setBook(ServiceInventory serviceInventory){
        this.inventoryService = serviceInventory;
        System.out.println("Setter method is being called");
    }
    public void testing(){
        if(inventoryService == null){
            System.out.println("yes it is null");
        }else{
            System.out.println("Not it's not null");
            System.out.println("The isbn is: " + this.isbn);
            System.out.println("The author is: " + this.author);
        }
    }
    public void setIsbn(int isbn) {
        this.isbn = isbn;
        System.out.println("The isbn is: " + this.isbn);
    }


    public String getAuthor(){
        return this.author;
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

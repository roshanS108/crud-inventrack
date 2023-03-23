package com.example.crudinventrack.entity;
import com.example.crudinventrack.inventorymanagement.util.*;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
@Entity
@Table(name = "book")
public class Book extends InventoryItem{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_isbn")
    private int isbn;

    @Column(name = "author_name")
    private String author;

    @Column(name = "publisher")
    private String publisher;

    public Book(){

    }
    public Book(String name, double price, int quantity, String author,
                String publisher, int isbn) {
        super(name, price, quantity);
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;

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
    public String toString() {
        return "Book{" + "Name: " + this.getName() + "\n" +
                "price: " + this.getPrice() + "\n" +
                "author='" + this.author + "\n" +
                ", publisher='" + publisher + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
    public void setAuthor(String author) {
        this.author = author;
    }


}

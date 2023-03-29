package com.example.crudinventrack.inventorymanagement.util;
import com.example.crudinventrack.dao.BookDAO;
import com.example.crudinventrack.entity.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
@Component
public class BookManagement implements ServiceBookInventory, Product{
    private static List<InventoryItem> inventoryItemList = new ArrayList<>();
    private static List<InventoryItem> bookList = new ArrayList<>();
    private ServiceBookInventory bookInventoryManagement;

    @Override
    //calling this method through help of dependencies-->ServiceBookInventory
    public String getBookDetails(String bookName, String authorName) {
        List<InventoryItem> listOfBooks = bookList;
        for(InventoryItem theBook: listOfBooks){
            if(theBook instanceof Book){
                Book theBook2 = (Book) theBook;
                if(theBook2.getName().equals(bookName) && theBook2.getAuthor().equals(authorName)){
                    System.out.println("Found the details");
                    System.out.println("--------------------------------");
                    return "Book{" + "Name: " + theBook2.getName() + "\n" +
                            "price: " + theBook2.getPrice() + "\n" +
                            "author='" + theBook2.getAuthor() + "\n" +
                            ", publisher='" + theBook2.getPublisher() + '\'' +
                            ", isbn='" + theBook2.getIsbn() + '\'' +
                            '}';
                }
            }
        }
        return "found nothing";
    }

    @Override
    public void removeBook() {

    }


  /*  @Override
    public void removeBook() {
        List<InventoryItem> listOfBooks = bookList;
        ListIterator<InventoryItem> bookIterator = (ListIterator<InventoryItem>) listOfBooks.listIterator();
        while(bookIterator.hasNext()){
            InventoryItem book = bookIterator.next();
            if(book instanceof Book){
                Book theBook = (Book)book;
                if(theBook.getIsbn() == isbn){
                    bookIterator.remove();
                    break;
                }else{
                    System.out.println("Sorry couldn't find the book isbn number: ");
                }
            }
        }
        List<InventoryItem> listOfInventoryList = inventoryItemList;
        ListIterator<InventoryItem> inventoryIterator = (ListIterator<InventoryItem>) listOfInventoryList.listIterator();
        while(inventoryIterator.hasNext()){
            InventoryItem item = inventoryIterator.next();
            *//*if(item.getSpecId() == isbn){
                inventoryIterator.remove();
                break;
            }else{
                System.out.println("Sorry couldn't find the book isbn number: ");
            }*//*
        }
        System.out.println("After deleting: " + bookList.toString());
    }*/
//    @Override
   /* public void removeProduct(int isbn) {
        System.out.println("removing the book class-->using dependency injection");
        this.bookInventoryManagement.removeBook(isbn);
    }*/

    @Override
    public List<Book> getBookCollection() {
        return null;
    }


    @Override
    public String getName() {
        return null;
    }

//    @Override
    public void addProduct(Book objects) {

    }
    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public int getQuantity() {
        return 0;
    }

    @Override
    public int updateQuantity(int newQuantity) {
        return 0;
    }
    public void totalNumberOfBooks(){

    }

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
//    public void searchBookByAuthorName(String name){
//        this.inventoryWareHouse.searchByAuthorName(name);
//    }
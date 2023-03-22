package com.example.crudinventrack.inventorymanagement.util;
import com.example.crudinventrack.entity.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
public class BookManagement implements ServiceBookInventory{
    private static List<InventoryItem> inventoryItemList = new ArrayList<>();
    private static List<InventoryItem> bookList = new ArrayList<>();
    @Override
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
    public void removeBook(int isbn) {
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
            if(item.getSpecId() == isbn){
                inventoryIterator.remove();
                break;
            }else{
                System.out.println("Sorry couldn't find the book isbn number: ");
            }
        }
        System.out.println("After deleting: " + bookList.toString());
    }
}

package com.example.crudinventrack;
import com.example.crudinventrack.Service.BookService;
import com.example.crudinventrack.dao.BookDAO;
import com.example.crudinventrack.entity.Book;
import com.example.crudinventrack.inventorymanagement.util.InventoryWareHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import java.util.List;

@SpringBootApplication
public class CrudinventrackApplication {

	public static void main(String[] args) {
		ApplicationContext context =
				SpringApplication.run(CrudinventrackApplication.class, args);

		InventoryWareHouse inventoryWareHouse = context.getBean(InventoryWareHouse.class);
		inventoryWareHouse.testing();



	}
	@Bean
	public CommandLineRunner applicationStartupRunner(BookService bookDAO) {
		return runner ->{
			getBook(bookDAO);
		};
	}

	public void getBook(BookService bookService){
		System.out.println(bookService.getBooks());
	}
	public void createBookObject(BookDAO bookDAO){
		//creating the book object
		System.out.println("Creating the book object...");
		Book book = new Book("Java 122", 23.00, 5, "James Gosling",
				"Michael jackson", 23283923);
		Book book2 = new Book("WARA 122", 223.23, 56, "Gosling",
				"jackson", 2328393);
		System.out.println("Saving the book to the database...");
		bookDAO.saveBook(book2);

		//display the id of the saved book
		System.out.println("Saved Book. book ISBN: " + book2.getIsbn());
	}
	private void readBookDAta(BookDAO bookDAO){
		//create book object
		System.out.println("Creating new bok object");
		Book book2 = new Book("asdf 122", 223.23, 56, "asdf2323a",
				"jackson", 233);
		//save the book
		 bookDAO.saveBook(book2);

		 //display the id of the saved book
		int theId = book2.getIsbn();
		System.out.println("Saved book isbn. Generated isbn: " + theId);
		//retrieving student based on the id: primary key
		Book theBook = bookDAO.readBookData(theId);
		//display the book
		System.out.println("Found the book with the isbn: " + theBook);

	}


	private void getAllTheBooks(BookDAO bookDAO){

		//get a list of books
		List<Book> theBooks = bookDAO.getAllBook();

		//display all those books
		for(Book tempBooks: theBooks){
			System.out.println("All those books are: " + tempBooks);
		}
	}

}

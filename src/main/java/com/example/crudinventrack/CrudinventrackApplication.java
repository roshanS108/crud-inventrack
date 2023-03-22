package com.example.crudinventrack;
import com.example.crudinventrack.dao.BookDAO;
import com.example.crudinventrack.entity.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class CrudinventrackApplication {
	public static void main(String[] args) {
		SpringApplication.run(CrudinventrackApplication.class, args);
	}

	@Bean
	public CommandLineRunner applicationStartupRunner() {

		return null;
	}

	public void createBookObject(BookDAO bookDAO){
		//creating the book object
		System.out.println("Creating the book object...");
		Book book = new Book("Java 122", 23.00, 5, 123, "James Gosling",
				"Michael jackson", 23283923);

		//save the book object to the database
		System.out.println("Saving the book to the database...");
		bookDAO.saveBook(book);

		//display the id of the saved student
		System.out.println("Saved Book. specId: " + book.getSpecId());

	}

}

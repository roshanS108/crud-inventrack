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
	public CommandLineRunner applicationStartupRunner(BookDAO bookDAO) {

		return runner ->{
			createBookObject(bookDAO);
		};
	}

	public void createBookObject(BookDAO bookDAO){
		//creating the book object
		System.out.println("Creating the book object...");
		Book book = new Book("Java 122", 23.00, 5, "James Gosling",
				"Michael jackson", 23283923);
		Book book2 = new Book("WARA 122", 223.23, 56, "Gosling",
				"jackson", 2328393);

		//save the book object to the database
		System.out.println("Saving the book to the database...");
		bookDAO.saveBook(book2);

		//display the id of the saved student
		System.out.println("Saved Book. book ISBN: " + book2.getIsbn());

	}

}

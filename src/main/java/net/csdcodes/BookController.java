package net.csdcodes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author csdcodes.net
 */
@RestController
public class BookController {

    //Code section for Spring Data MongoRepository
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/addBook")
    private Book addNew(@RequestParam("title") String title, @RequestParam("price") Double price, @RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("gender") char gender){
        Author author = new Author(name, email, gender);
        Book book = new Book(title, author, price);

        return bookRepository.save(book);
    }

    @GetMapping("/getBook")
    private Book getBookById(@RequestParam("id") String id){
        Optional<Book> optional = bookRepository.findById(id);
        Book book = null;
        if(optional.isPresent()){
            book = optional.get();
        }
        return book;
    }

    @GetMapping("/getAll")
    private List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @GetMapping("/editPrice")
    private Book editBook(@RequestParam("id") String id, @RequestParam("price") Double price){
        Optional<Book> bookOptional = bookRepository.findById(id);
        Book book = null;
        if(bookOptional.isPresent()){
            book = bookOptional.get();
            book.setPrice(price);
        }

        return bookRepository.save(book);
    }


}
